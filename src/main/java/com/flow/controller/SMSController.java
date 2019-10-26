package com.flow.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.flow.domain.BaseResponse;
import com.flow.sms.Sms;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jerry
 * @date 2019/10/25 11:34
 */
@RestController
@RequestMapping("api/sms")
public class SMSController extends BaseController {

    /**
     * 获取报警信息
     *
     * @return
     */
    @RequestMapping(value = "/sendSms", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse checkUpdates(@RequestBody JsonNode jsonNode) {
        List<String> phones = new ArrayList<>();
        jsonNode.get("phones").elements().forEachRemaining(e -> phones.add(e.asText()));
        String msg = jsonNode.get("msg").asText();
        String result=Sms.sendMsg(phones,msg);
        return returnOk(result);
    }


}
