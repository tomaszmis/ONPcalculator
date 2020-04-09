package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorONP {

    static String inputLine;
    static Double result = 0.0;

    public static void main(String[] args) {
        System.out.println("Enter ONP");
       getInput();
       try{
           result = calculate(prepareItems());
           System.out.println(inputLine + " = " + result);

       }catch(Exception e){
            System.out.println(e.getMessage());

       }

    }

    static void getInput(){
        Scanner scan = new Scanner(System.in);
        inputLine = scan.nextLine();
        scan.close();
    }

    static boolean isPermissiveChar(char c){
        return Character.isWhitespace(c) || isSymbol(c) || Character.isDigit(c);
    }



    static List<String> prepareItems() throws Exception {
        if(inputLine == null) throw new Exception("Empty input");
        List<String> items = new ArrayList<String>();
        StringBuilder sB = new StringBuilder();
        inputLine = inputLine.trim();
        char single;
        for(int i = 0; i < inputLine.length() ; i++) {
            single = inputLine.toCharArray()[i];
            if (isPermissiveChar(single)) {
                if (single != ' ') {
                    if (isSymbol(single) || Character.isDigit(single)) {
                        sB.append(single);
                    }
                } else if (Character.isWhitespace(single)) {
                    items.add(sB.toString());
                    sB.setLength(0);
                    sB = new StringBuilder();

                }
            } else throw new Exception("Invalid input line.");
        }
        items.add(sB.toString());
        return items;
    }

    static boolean isSymbol(String item){
        if(item.equals("+") || item.equals("-") || item.equals("−") || item.equals("*") || item.equals("/") || item.equals("^"))
            return true;
        else return false;
    }
    static boolean isSymbol(char c){
        if(c == '+' || c == '-' || c == '−' || c == '*' || c == '/' || c == '^')
            return true;
        else return false;
    }


    static double sum(double a, double b){
        return  a + b;
    }

    static double subtract(double a, double b){
        return  a - b;
    }

    static double multiply(double a, double b){
        return  a * b;
    }

    static double division(double a, double b){
        return a / b;
    }

    static double exp(double a, double b){
        return Math.pow(a,b);
    }

    static String count(String symbol, String a, String b){
        double aD = Double.parseDouble(a);
        double bD = Double.parseDouble(b);

        if(symbol.equals("+")) {
            return  Double.toString(sum(bD,aD));
        }
        if(symbol.equals("-") || symbol.equals("−")) {
            return  Double.toString(subtract(bD,aD));
        }
        if(symbol.equals("*")) {
            return  Double.toString(multiply(bD,aD));
        }
        if(symbol.equals("/")) {
            return  Double.toString(division(bD,aD));
        }
        else {
            return  Double.toString(exp(bD,aD));
        }
    }


    static double calculate(List<String> items) throws Exception{
        Stos stack = new Stos();
        for(String s : items){
            if(!isSymbol(s)){
                stack.push(s);
            }else{
                try {
                    stack.push(count(s, stack.pop(), stack.pop()));
                }
                catch(Exception e){
                   throw new Exception("Wrong equation, This is not ONP!");
                }
            }
        }
        return Double.parseDouble(stack.pop());
    }


}
