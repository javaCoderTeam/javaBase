package com.chen.splitFile;

import java.io.*;

/**
 * @author :  chen weijie
 * @Date: 2018-12-13 6:40 PM
 */
public class SplitFIle {


    /**
     *  拆sql 不拆文件
     * @throws IOException
     */
    private static void handleSql() throws IOException {

            String path = "/Users/zhuningning/Desktop/new/sql";
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }

            FileReader read = new FileReader("/Users/zhuningning/Desktop/origin/origin.sql");
            BufferedReader br = new BufferedReader(read);
            String lineContent;
            int lineNum = 1;
            int fileNo = 1;
            FileWriter fw = new FileWriter(path + "_" + fileNo + ".sql");
            while ((lineContent = br.readLine()) != null) {
                if (lineNum != 1) {
                    lineContent = lineContent.replace("INSERT INTO `stu_user_info` ( stu_id, `name`, nickname, phone, pass_word, im_user_id, image_url ) VALUES ", " ");
                }
                lineNum++;
                if (lineNum == 100000) {

//                    lineContent.replace("),",") ON DUPLICATE KEY UPDATE `name` = VALUES( NAME ),nickname = VALUES( nickname ),phone =VALUES( phone ),pass_word =VALUES( pass_word ),im_user_id =VALUES( im_user_id ),image_url = VALUES( image_url );");
//                    lineContent = lineContent.substring(0, lineContent.length() - 1);
//                    lineContent = lineContent + ";";
                    fw.append("ON DUPLICATE KEY UPDATE `name` = VALUES( NAME ),nickname = VALUES( nickname ),phone =VALUES( phone ),pass_word =VALUES( pass_word ),im_user_id =VALUES( im_user_id ),image_url = VALUES( image_url );");
                    fileNo++;
                    fw.flush();
                    System.out.println("拆分完成：_" + fileNo);
                    lineNum = 1;
                    fw = new FileWriter(path + "_" + fileNo + ".sql");
                } else {
                    fw.append(lineContent + "\r\n");
                }
            }
            fw.close();
            System.out.println("lineNum=" + lineNum + ";fileNo=" + fileNo);


    }

    public static void main(String[] args) throws IOException {
        handleSql();
    }

}
