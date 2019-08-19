package com.example.demo.practice;

/**
 * @author gaozijian
 * @date 2019/8/16 9:37
 */
public class test3 {
    /**
     * 5. 替换空格
     */
    private String replaceSpace(StringBuffer str) {
        int p1 = str.length() - 1;
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        System.out.println(str);
        int p2 = str.length() - 1;
        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
                System.out.println(str);
            }
        }
        return str.toString();
    }

    public void run() {
        StringBuffer stringBuffer = new StringBuffer("a b c");
        System.out.println(replaceSpace(stringBuffer));
    }
}
