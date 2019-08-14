package com.chen.test;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author :  chen weijie
 * @Date: 2019-07-16 19:07
 */
public class CompareTest {


    public static void main(String[] args) {

        System.out.println(getIfShowStudyPlan("4.1.9","CS_APP_IOS"));

        System.out.println(getIfShowStudyPlan("4.2.0.3","CS_APP_ANDROID"));



    }


    private static boolean getIfShowStudyPlan(String appVersion, String channelCode) {

        if (StringUtils.isBlank(appVersion) || StringUtils.isBlank(channelCode)) {
            return false;
        }

        // 由于app端兼容性问题，ios的版本小于等于4.1.8的不展示学习打卡的活动页。安卓的版本小于4.2.0.1
        if (Objects.equals(channelCode, "CS_APP_IOS") && appVersion.compareTo("4.1.8") <= 0) {
            return false;
        }

        if (Objects.equals(channelCode, "CS_APP_ANDROID") && appVersion.compareTo("4.2.0.1") <= 0) {
            return false;
        }

        return true;
    }


}
