package com.app.mysmslistener;

import java.util.Locale;

class RegexTest {
    public static void main(String[] args) {
        String s = "Xin chao OMT".toLowerCase();
        if(s.matches("a-b[m-p]]")){
            System.out.println("abc");
        }
    }
}
