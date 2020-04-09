package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stos {

    List<String> stack = new ArrayList<String>();

    void push(String item){
        stack.add(item);
    }

    boolean isEmpty(){
        return stack.isEmpty();
    }

    String top() throws Exception{
        if(stack.isEmpty()) throw new Exception("Stack is empty");
        else {
            return stack.get(lastIndex());
        }
    }

    String pop() throws Exception {
        if(stack.isEmpty()) throw new Exception("Stack is empty");
        else {
            String popItem = stack.get(lastIndex());
            stack.remove(lastIndex());
            return popItem;
        }
    }

    int lastIndex(){
        return stack.size() - 1;
    }
}
