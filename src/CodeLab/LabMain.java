package CodeLab;

import java.util.*;

public class LabMain {

     public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(){{add('a');add('e');add('i');add('o');add('u');}};
        char a = '*',b = '*';
        char[] cs = s.toCharArray();
        String ret = "";
        //寻找
        for(char c: cs){
            char cc = c >= 'A' && c <= 'Z' ? (char)(c -32): c;
            if(set.contains(cc)){
                if(a == '*'){
                    a = cc ;
                }else if(b == '*'){
                    b = cc;
                }
            }
        }
        //替换
        for(char c: cs){
            char choose = c;
            if(c == a){
                choose = b;
            }else if(c == a - 32){
                choose = (char)(b -32);
            }else if(c == b){
                choose = a;
            }else if(c == b - 32){
                choose = (char)(a -32);
            }
            ret += choose;
        }
        //返回
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));

    }
}
