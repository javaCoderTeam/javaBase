package com.chen.api.util.regex;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 *
 * @author chenweijie
 */
public class RegexTest2 {

    /**
     * 匹配图片地址中的src中的内容
     */
    private static Pattern SRC_PATTERN = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)");

    /**
     * 图片中url包含的？特殊字符
     */
    private static String QUESTION_MARK = "?";


    @Test
    public void test1() {

        Pattern pattern =Pattern.compile("//(//d{3}//)//s//d{3}-//d{4}");
        try {
            try (BufferedReader  in = new BufferedReader(new FileReader("\testPatter.txt"))) {
                String s ;
                while ((s=in.readLine())!=null){

                    Matcher matcher =pattern.matcher(s);
                    if (matcher.find()){
                        System.out.println(matcher.group());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 解析html数据 匹配上的返回处理后的数据，匹配不上的返回 null
     *
     * @param text html数据
     * @param id   主键id
     * @return 处理完的html数据
     */
    private String resolveHtml(String text, Integer id) {

        String img;
        Pattern pImage;
        Matcher mImage;
        //图片链接地址
        String regExImg = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        pImage = Pattern.compile(regExImg, Pattern.CASE_INSENSITIVE);
        mImage = pImage.matcher(text);
        while (mImage.find()) {
            // 得到<img />数据
            img = mImage.group();
            // 匹配<img>中的src数据
            Matcher m = SRC_PATTERN.matcher(img);
            while (m.find()) {
                //取出图片的地址
                String imgUlr = m.group(1);
                //处理图片地址加上长宽参数
                String newUrl = replaceImg(imgUlr, id);
                //替换原内容中的标签
                if (newUrl != null) {
                    text = text.replace(imgUlr, newUrl);
                } else {
                    return null;
                }
            }

            return text;
        }
        return null;
    }


    /**
     * 处理某一张图片的格式
     *
     * @param imageUrl 原图片的url
     * @param id       图片对应的id
     */
    private String replaceImg(String imageUrl, Integer id) {

        BufferedImage image = getBufferedImage(id, imageUrl);
        String mewImgURL = null;
        if (image != null) {
            int height = image.getHeight();
            int width = image.getWidth();

            if (imageUrl.contains(QUESTION_MARK)) {
                mewImgURL = imageUrl + "&width=" + width + "&height=" + height;
            } else {
                mewImgURL = imageUrl + "?width=" + width + "&height=" + height;
            }
        }
        return mewImgURL;
    }

    /**
     * 根据imgUrl获取BufferedImage对象
     *
     * @param id     id
     * @param imgUrl 图片地址
     * @return BufferedImage对象
     */
    private static BufferedImage getBufferedImage(Integer id, String imgUrl) {
        URL url;
        InputStream is = null;
        BufferedImage img = null;
        try {
            url = new URL(imgUrl);
            is = url.openStream();
            img = ImageIO.read(is);
        } catch (IOException e) {
            System.out.println("handleAnalysisPicture failed");
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }


}
