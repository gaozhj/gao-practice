package com.example.demo.practice;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author gaozijian
 * @date 2019/8/19 10:59
 * 9. 用两个栈实现队列
 */
public class test6 {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();
    public void push(int node){
        in.push(node);
    }

    public int pop() throws Exception{
        if (out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        if (out.isEmpty()){
            throw new Exception("queue is empty");
        }
        return out.pop();
    }

    public static void main(String[] args) throws Exception {
        test6 test6 = new test6();
        test6.push(1);
        test6.push(2);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (test6.in.size() > 0 || test6.out.size() > 0){
            arrayList.add(test6.pop());
        }
        for (int pops : arrayList){
            System.out.println(pops);
        }

    }
}
