package com.main.java.MyLittleToyOS.os;
import java.util.Scanner;

public class calculator {
    Scanner scannner = new Scanner(System.in);
    String choice;


    public void Menu(){
        while(true){
            String choice = scannner.next();
            switch (choice) {
                case "+" :
                    double result1 = add();
                    System.out.println(result1);
                    break;
                case "-" :
                    double result2 = steal();
                    System.out.println(result2);
                    break;
                case "*" :
                    double result3 = multiple();
                    System.out.println(result3);
                    break;
                case "^" :
                    double result4 = exponentiation();
                    System.out.println(result4);
                    break;
                case "//":
                    double result5 = elementalization();
                    System.out.println(result5);
                    break;
                case "cos":
                    double result6 = cos();
                    System.out.println(result6);
                    break;
                case "sin":
                    double result7 = sin();
                    System.out.println(result7);
                    break;
                case "/":
                    double result8 = division();
                    System.out.println(result8);
                    break;
                case "log":
                    double result9 = log();
                    System.out.println(result9);
                    break;
                case "exit":
                    System.exit(0);
                default:
                    break;
            }

        }
    }

    private double add(){
        double number1 = scannner.nextDouble();
        double number2 = scannner.nextDouble();
        double result = number1 + number2;
        return result;
    }
    private double steal(){
        double number1 = scannner.nextDouble();
        double number2 = scannner.nextDouble();
        double result = number1 - number2;
        return result;
    }
    private double multiple(){
        double number1 = scannner.nextDouble();
        double number2 = scannner.nextDouble();
        double result = number1 * number2;
        return result;
    }
    private double elementalization(){
        double number1 = scannner.nextDouble();
        double result = Math.sqrt(number1);
        return result;
    }
    private double exponentiation(){
        double number1 = scannner.nextDouble();
        double result = Math.exp(number1);
        return result;
    }
    private double division(){
        double number1 = scannner.nextDouble();
        double number2 = scannner.nextDouble();
        double result = number1 / number2;
        return result;
    }
    private double cos(){
        double number1 = scannner.nextDouble();
        double result = Math.cos(number1);
        return result;
    }
    private double sin(){
        double number1 = scannner.nextDouble();
        double result = Math.sin(number1);
        return result;
    }
    private double log(){
        double number1 = scannner.nextDouble();
        double result = Math.log(number1);
        return result;
    }
}
