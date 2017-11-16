package com.chen.regex;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class TestImg {


    public static void main(String[] args) {


//假设
        String str = "<img src=\" 1. jpg \" height=\" 10 \" width=\" 20 \" alt=\" lazyload \"><img src=\" 2. jpg \" width=\" 740"+
        "\" /><img src=\" 3. jpg \" height=\" 10 \" /><img src=\" 3. jpg \" height=\" 10 \"><img src=\" 3. jpg \" height=\" 10"+
        "></img>";
//现在的正则表达式如下
        String regImg =  "(?is)<img\\s*((?<key>[^=]+)=\"(?<value>[^\"]+)\")+?\\s*/?>";



    }


}
