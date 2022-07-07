package com.example.interviewproject.practisetask;

import org.springframework.util.StopWatch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(reverseString(string));
        System.out.println("=-----------------=");
        StopWatch watch = new StopWatch();
        for (int j = 3; j < 6; j++) {
            watch.start();
            for (int i = 0; i < Math.pow(10, j); i++) {
                reverseString(string);
            }
            watch.stop();
            System.out.printf("%d repeats: %d ms \n", (int) Math.pow(10, j), watch.getTotalTimeMillis());
        }
    }

    public static String reverseString(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            res.insert(0, str.charAt(i));
        }
        return res.toString();
    }

}
