package com.flow.controller.task;

import com.flow.domain.alarm.Alarm;
import com.flow.domain.alarm.AlarmMsg;
import com.flow.service.alarm.AlarmService;
import com.flow.sms.Sms;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jerry
 * @date 2019/11/17 9:41
 */
@Slf4j
@Component
public class SMSTask implements ApplicationRunner {

    @Autowired
    private AlarmService alarmService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("开启自动报警短信task");
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            sendSMS();
        }, 0, 5 * 1000 * 60, TimeUnit.MILLISECONDS);

    }


    private void sendSMS() {
        //获取需要发送的短信列表
        List<AlarmMsg> alarmMsgList = alarmService.alarmMsg();
        if (alarmMsgList == null || alarmMsgList.size() < 1) {
            log.info("没有需要发送的报警信息");
            return;
        }
        alarmMsgList.forEach(alarmMsg -> {
            //发送短信：
            AlarmMsg back = alarmMsg;
            int code = Sms.send(Collections.singletonList(alarmMsg.getPhone()), alarmMsg.getAlarmContent());
            back.setSendResult(code);
            alarmService.updateAlarmMsg(back);
            log.info("发送报警短信到" + alarmMsg.getPhone() + "执行成功！结果为" + code);
        });
    }
}
