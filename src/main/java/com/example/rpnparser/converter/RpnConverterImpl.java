package com.example.rpnparser.converter;

import java.util.Stack;

public class RpnConverterImpl implements Converter<String, String> {

    @Override
    public String convert(String expression) {
        
        char[] in = expression.toCharArray();
        
        Stack<Character> stack = new Stack<>();
        
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < in.length; i++) {
            switch (in[i]) {
                case '+':
                case '*':
                case '^':
                case '-':
                    out.append(' ');
                    stack.push(in[i]);
                    break;
                case ' ':
                case '(':
                    break;
                case ')':
                    out.append(' ');
                    out.append(stack.pop());
                    break;
                default:
                    out.append(in[i]);
                    break;
            }
        }

        while (!stack.isEmpty()) {
            out.append(' ');
            out.append(stack.pop());
        }
        return out.toString();
    }
}
