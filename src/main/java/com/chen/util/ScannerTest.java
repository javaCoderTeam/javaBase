package com.chen.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author :  chen weijie
 * @Date: 2019-06-12 00:06
 */
public class ScannerTest {


    public static void main(String[] args) {

        // scanner
        Scanner input = new Scanner(System.in);
        String inputStr = input.nextLine();
        System.out.println("inputStr==" + inputStr);

        // BufferedReader

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = bufferedReader.readLine();
            System.out.println("line==" + line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
