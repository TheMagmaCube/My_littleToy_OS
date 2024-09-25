package com.main.java.MyLittleToyOS.os;
import java.math.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;

public class calculator {
    private Scanner scanner = new Scanner(System.in);
    private String[] ingredients_of_action;
    private ArrayList<String> numbers = new ArrayList<>();
    private ArrayList<Double> double_numbers;
    private ArrayList<String> sings = new ArrayList<>();
    private boolean exception = false;
    private String choice;
    private boolean number;

    public void Menu() {
        while (true) {
            exception = false;
            number = true;
            choice = scanner.nextLine();
            ingredients_of_action = choice.split(" ");
            for (int i = 0; i < ingredients_of_action.length; i++) {
                if (number) {
                    numbers.add(ingredients_of_action[i]);
                    number = false;
                } else if (!number) {
                    sings.add(ingredients_of_action[i]);
                    number = true;
                }
            }
            calculate();
        }
    }
    private void calculate(){
        convert();
        if(exception != true) {
            while (!sings.isEmpty()) {
                element();
                times();
                division();
                subtract();
                add();
            }
            System.out.println(double_numbers.get(0));
            clear();
        }else{
            clear();
        }
    }
    private void clear(){
        double_numbers.clear();
        numbers.clear();
        sings.clear();
    }
    private void convert(){
        try {
            double_numbers = new ArrayList<Double>(numbers.size());
            for (int i = 0; i < numbers.size(); i++) {
                String string = numbers.get(i);
                double_numbers.add(i, Double.parseDouble(numbers.get(i)));
            }
        } catch (NumberFormatException e){
            exception = true;
            System.err.println("You must to type number.");
        }
        for(int i = 0; i < sings.size(); i++){
            String string = sings.get(i);
            if(string.length() > 1){
                exception = true;
                System.err.println("You must always paste space between characters of mathematical operators.");
            }
        }
    }
    private void times(){
        for(int i = 0; i < sings.size(); i++){
            if(sings.get(i).equals("*")){
                sings.remove(i);
                Double num1 = double_numbers.get(i);
                Double num2 = double_numbers.get(i + 1);
                double_numbers.remove(i + 1);
                double result = num1 * num2;
                double_numbers.set(i, result);
                i--;
            }
        }
    }
    private void division(){
        for(int i = 0; i < sings.size(); i++){
            if(sings.get(i).equals("/")){
                sings.remove(i);
                Double num1 = double_numbers.get(i);
                Double num2 = double_numbers.get(i + 1);
                double_numbers.remove(i + 1);
                double result = num1 / num2;
                double_numbers.set(i, result);
                i--;
            }
        }
    }
    private void add(){
        for(int i = 0; i < sings.size(); i++){
            if(sings.get(i).equals("+")){
                sings.remove(i);
                Double num1 = double_numbers.get(i);
                Double num2 = double_numbers.get(i + 1);
                double_numbers.remove(i + 1);
                double result = num1 + num2;
                double_numbers.set(i, result);
                i--;
            }
        }
    }
    private void subtract(){
        for(int i = 0; i < sings.size(); i++){
            if(sings.get(i).equals("-")){
                sings.remove(i);
                Double num1 = double_numbers.get(i);
                Double num2 = double_numbers.get(i + 1);
                double_numbers.remove(i + 1);
                double result = num1 - num2;
                double_numbers.set(i, result);
                i--;
            }
        }
    }
    private void element(){
        for(int i = 0; i < sings.size(); i++){
            if(sings.get(i).equals("//")){
                sings.remove(i);
                Double num1 = double_numbers.get(i);
                double result = Math.sqrt(num1);
                double_numbers.set(i, result);
                i--;
            }
        }
    }
}