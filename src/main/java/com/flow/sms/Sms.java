package com.flow.sms;

import java.util.List;
import java.util.UUID;

import com.mascloud.sdkclient.Client;


public class Sms {
    private static Client client;

    public Sms() {
        client = Client.getInstance();
        client.login("http://mas.ecloud.10086.cn/app/sdk/login", "yasslj", "bymq*266", "雅安市水务局");
    }

    public static Integer send(List<String> phones, String msg) {
        try {
            if (client == null) {
                client = Client.getInstance();
                client.login("http://mas.ecloud.10086.cn/app/sdk/login", "yasslj", "bymq*266", "雅安市水务局");
            }
            String[] phone = new String[phones.size()];
            for (int i = 0; i < phones.size(); i++) {
                phone[i] = phones.get(i);
            }
            int resultCode = client.sendDSMS(phone, msg, "", 1, "UUihrPij", UUID.randomUUID().toString(), true);
            return resultCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }


    public static String sendMsg(List<String> phones, String msg) {
        int resultCode = send(phones, msg);
        switch (resultCode) {
            case 1: {
                return "短信发送成功";
            }
            case 101: {
                return "短信发送失败，短信内容为空";
            }
            case 102: {
                return "短信发送失败，号码数组为空";
            }
            case 103: {
                return "短信发送失败，号码数组为空数组";
            }
            case 104: {
                return "短信发送失败，有非法号码";
            }
            case 105: {
                return "短信发送失败，登录失败";
            }
            case 106: {
                return "短信发送失败，网关签名为空";
            }
            case 107: {
                return "短信发送失败，其他错误";
            }
            case 108: {
                return "短信发送失败，网络异常";
            }
            case 109:
            case 110:
                return "短信发送失败，网络异常";
            case 111: {
                return "短信发送失败，扩展码错误";
            }
            case 112: {
                return "短信发送失败，签名错误";
            }
            default: {
                return "异常错误";
            }
        }
    }


    public static void main(String[] args) {
        final Client client = Client.getInstance();
        // 正式环境IP，登录验证URL，用户名，密码，集团客户名称
        // 测试环境IP
        int sendResult = client.sendDSMS(new String[]{"18408226899", "19949408219"},
                "sdk短信发送内容测试", "", 1, "UUihrPij", UUID.randomUUID().toString(), true);
        System.out.println("推送结果: " + sendResult);
    }
}