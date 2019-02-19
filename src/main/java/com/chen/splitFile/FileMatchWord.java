package com.chen.splitFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author :  chen weijie
 * @Date: 2019-01-09 6:06 PM
 */
public class FileMatchWord {


    public static void main(String[] args) {


        try {
            FileReader read = new FileReader("/Users/zhuningning/Documents/sv.access_20190108.log");
            BufferedReader br = new BufferedReader(read);
            Set<String> set = new HashSet<>();
            Set<String> set2 = new HashSet<>();

            String lineContent;
            while ((lineContent = br.readLine()) != null) {
                if (getMethod(lineContent)){
                    System.out.println("retrieveProtocolHtmlAndProvincesByPackageId====="+lineContent);
                    set.add(getIp(lineContent));
                }

                if (lineContent.contains("retrieveProtocolHtmlAndProvincesByPackageIdForPortal")){
                    set2.add(getIp(lineContent));
                }

            }
            System.out.println(set);
            System.out.println(set2);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /**
     * 匹配字符串中的ip
     *
     * @param content
     * @return
     */
    private static String getIp(String content) {

        String regEx = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(content);

        while (m.find()) {
            String result = m.group();
            System.out.println(result);
            return result;

        }
        return null;
    }



    /**
     * 匹配字符串中的ip
     *
     * @param content
     * @return
     */
    private static boolean getMethod(String content) {

        String regEx = "retrieveProtocolHtmlAndProvincesByPackageId\\s";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(content);

        while (m.find()) {
            String result = m.group();
            System.out.println(result);
            return true;

        }
        return false;
    }
}
