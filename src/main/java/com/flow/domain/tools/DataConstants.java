package com.flow.domain.tools;

import com.flow.domain.scale.Scale;

/**
 * @author jerry
 * @date 2019-10-08
 * @apiNote 全局常量
 */
public class DataConstants {

    public static final String RESPONSE_OK = "OK";
    public static final String RESPONSE_ERROR = "服务器异常";
    public static final String RESPONSE_PARAM_ERROR = "参数错误";
    public static final String LOGIN_NAME1 = "admin";
    public static final String LOGIN_NAME2 = "XSLJ";
    //汉源
//    public static final String LOGIN_PASSWORD1 = "admin";
//    public static final String LOGIN_PASSWORD2 = "XSLJ";
    //石棉
    public static final String LOGIN_PASSWORD1 = "pass@0rd!";
    public static final String LOGIN_PASSWORD2 = "xslj511824";

//    public static final String LOGIN_PASSWORD1 = "pass@0rd!";
//    public static final String LOGIN_PASSWORD2 = "msxslj511803";

//    /**
//     * 图片地址-汉源
//     */
//    public static final String BASE_IMAGE_IP = "http://182.132.151.242:9090/img";
//    /**
//     * 图片地址-汉源
//     */
//    public static final String BASE_ICON_IP = "http://182.132.151.242:9090/icon";
    /**
     * 图片地址-石棉
     */
    public static final String BASE_IMAGE_IP = "http://182.132.138.230:9090/img";
    public static final String BASE_ICON_IP = "http://182.132.138.230:9090/icon";

    /**
     * 传递参数常量-行政区划号
     */
    public static final String MONI_STATION_ADDVCD = "addvcd";
    /**
     * 传递参数常量-测站类别
     */
    public static final String STATION_STATUS_TYPE = "sttp";
    /**
     * 传递参数常量-类型
     */
    public static final String REQUEST_PARAMS_TYPE = "type";
    /**
     * 传递参数常量-规模
     */
    public static final String REQUEST_PARAMS_SCALE = "scale";
    /**
     * 传递参数常量-关键字
     */
    public static final String REQUEST_PARAMS_KEYS = "key";
    /**
     * 传递参数常量-测站编码
     */
    public static final String REQUEST_PARAMS_STCD = "stcd";
    /**
     * 传递参数常量-监测指标
     */
    public static final String REQUEST_PARAMS_MONITOR_PARA = "monitorPara";
    /**
     * 返回参数常量-数据集
     */
    public static final String RESPONSE_PARAMS_DATA = "data";
    /**
     * 传递参数常量 - 报警值
     */
    public static final String REQUEST_PARAMS_ALARM_VALUE = "alarmValue";
    /**
     * 传递参数常量 - 开始时间
     */
    public static final String REQUEST_PARAMS_START = "startTime";
    /**
     * 传递参数常量 - 结束时间
     */
    public static final String REQUEST_PARAMS_END = "endTime";
    /**
     * 传递参数常量 - 时间类别   对应为全部=0 ，八小时=8 ，整点=0
     */
    public static final String REQUEST_PARAMS_TIME_SCALE = "timeScale";
    /**
     * 传递参数常量  -  报警级别 对应为 全部=0，达标=2，不达标=1
     */
    public static final String REQUEST_PARAMS_ALARM_LEVEL = "alarmLevel";
    /**
     * 传递参数常量 - 每页数据量
     */
    public static final String REQUEST_PARAMS_PAGE_COUNT = "count";
    /**
     * 传递参数常量，- 获取页码
     */
    public static final String REQUEST_PARAMS_PAGE_INDEX = "index";

    /**
     * 传递参数常量-分组ID
     */
    public static final String REQUEST_PARAMS_GROUP_ID = "groupId";
    /**
     * 传递参数常量
     */
    public static final String REQUEST_PARAMS_TIME_TYPE = "timeType";
    /**
     * 水质等级
     */
    public static final String REQUEST_PARAMS_QUALITY_LEVEL = "qualityLevel";
    /**
     * 监测方式
     */
    public static final String REQUEST_PARAMS_MONITOR_TYPE = "monitorType";
    /**
     * 监测方式
     */
    public static final String REQUEST_PARAMS_ALARM_INTERVAL = "alarmInterval";
    /**
     * 报警关联方式 0-未关联 1-已关联 2/null-全部
     */
    public static final String REQUEST_PARAMS_SELECT_TYPE = "selectType";
    /**
     * 组织ID
     */
    public static final String REQUEST_PARAMS_BEFORE_ORGANIZATION_ID = "beforeOrganizationId";
    /**
     * 组织ID
     */
    public static final String REQUEST_PARAMS_ORGANIZATION_ID = "organizationId";
    /**
     * 通讯录ID
     */
    public static final String REQUEST_PARAMS_ADDRESS_BOOK_ID = "addressbookId";

    /**
     * b
     * 修改前的报警指标
     */
    public static final String REQUEST_PARAMS_BEFORE_ALARM_PARA = "beforeMonitorPara";

    /**
     * 修改前的报警时段
     */
    public static final String REQUEST_PARAMS_BEFORE_ALARM_INTERVAL = "beforeAlarmInterval";

    /**
     * 报警比较方式
     */
    public static final String REQUEST_PARAMS_BEFORE_ALARM_COMPARE_METHOD = "compareType";
    /**
     * 一级阈值
     */
    public static final String REQUEST_PARAMS_ONE_LEVEL_ALARM = "oneLevelAlarmValue";
    /**
     * 二级阈值
     */
    public static final String REQUEST_PARAMS_TWO_LEVEL_ALARM = "twoLevelAlarmValue";
    /**
     * 报警方式
     */
    public static final String REQUEST_PARAMS_ALARM_METHOD = "alarmMethod";
    /**
     * 报警格式
     */
    public static final String REQUEST_PARAMS_ALARM_FORM = "alarmForm";
    /**
     * 报警时间
     */
    public static final String REQUEST_PARAMS_TIME = "time";


}
