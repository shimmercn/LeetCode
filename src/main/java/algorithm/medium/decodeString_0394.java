package algorithm.medium;

import java.util.Stack;

/**
 * Created by shimmer on 08/21/2019
 */
/*
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例:

s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class decodeString_0394 {
    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {//遇到左括号
                numStack.push(num);//把左括号左边的值入栈
                strStack.push(res.toString());//把前面的结果先入栈
                num = 0;//入栈后num和结果都重置
                res = new StringBuilder();
            } else if (s.charAt(i) == ']') {//遇到右括号
                //把这一层括号中的进行展开
                StringBuilder temp = new StringBuilder();
                int lastNum = numStack.pop();
                for (int j = 0; j < lastNum; j++) {
                    temp.append(res);
                }
                //这一层展开后加到上一层括号中字符串的后面
                res = new StringBuilder(strStack.pop() + temp);
            } else if (isNum(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';//数字有可能大于9
            } else {//如果既不是'[',也不是']',也不是数字
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    private static boolean isNum(char c) {
        return c - '0' >= 0 && c - '9' <= 0;
    }

}
