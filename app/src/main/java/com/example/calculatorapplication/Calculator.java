package com.example.calculatorapplication;


import android.util.Log;

import java.util.Stack;

public class Calculator {
    public static double calculateString(String str) {
        Stack<Double> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int i = 0;
        while (i < str.length()) {
            if (Character.isDigit(str.charAt(i))) {
                int j = i + 1;
                while (j < str.length() && Character.isDigit(str.charAt(j))) {
                    j++;
                }
                double num = Double.parseDouble(str.substring(i, j));
                nums.push(num);
                i = j;
            } else if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                while (!ops.isEmpty()) {
                    char op = ops.peek();
                    if (op == '+' || op == '-' || op == '*' || op == '/' || op == '%') {
                        double num2 = nums.pop();
                        double num1 = nums.pop();
                        ops.pop();
                        double result = applyOp(num1, num2, op);
                        nums.push(result);
                    } else {
                        break;
                    }
                }
                ops.push(str.charAt(i));
                i++;
            } else if (str.charAt(i) == '*' || str.charAt(i) == '/') {
                while (!ops.isEmpty()) {
                    char op = ops.peek();
                    if (op == '*' || op == '/' || op == '%') {
                        double num2 = nums.pop();
                        double num1 = nums.pop();
                        ops.pop();
                        double result = applyOp(num1, num2, op);
                        nums.push(result);
                    } else {
                        break;
                    }
                }
                ops.push(str.charAt(i));
                i++;
            } else if (str.charAt(i) == '%') {
                while (!ops.isEmpty()) {
                    char op = ops.peek();
                    if (op == '%' || op == '*' || op == '/' || op == '+' || op == '-') {
                        double num2 = nums.pop();
                        double num1 = nums.pop();
                        ops.pop();
                        double result = applyOp(num1, num2, op);
                        nums.push(result);
                    } else {
                        break;
                    }
                }
                ops.push(str.charAt(i));
                i++;
            } else if (str.charAt(i) == '^') {
                while (!ops.isEmpty()) {
                    char op = ops.peek();
                    if (op == '^') {
                        double num2 = nums.pop();
                        double num1 = nums.pop();
                        ops.pop();
                        double result = Math.pow(num1, num2);
                        nums.push(result);
                    } else {
                        break;
                    }
                }
                ops.push(str.charAt(i));
                i++;
            }
            else {
                i++;
            }
        }
        while (!ops.isEmpty()) {
            char op = ops.pop();
            double num2 = nums.pop();
            double num1 = nums.pop();
            double result = applyOp(num1, num2, op);
            nums.push(result);
        }
        return nums.pop();
    }

    public static double applyOp(double num1, double num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return num1 / num2;
            case '%':
                return num1 % num2;
            case '^':
                return Math.pow(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }



}
