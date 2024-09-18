package com.main.java.MyLittleToyOS.os;
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
                times(0);
                division(0);
                subtract(0);
                add(0);
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
            exception = false;
            double_numbers = new ArrayList<Double>(numbers.size());
            for (int i = 0; i < numbers.size(); i++) {
                double_numbers.add(i, Double.parseDouble(numbers.get(i)));
            }
        } catch (NumberFormatException e){
            exception = true;
            System.err.println("You must to type number.");
        }
    }
    private double times(double result){
        for(int i = 0; i < sings.size(); i++){
            if(sings.get(i).equals("*")){
                sings.remove(i);
                Double num1 = double_numbers.get(i);
                Double num2 = double_numbers.get(i + 1);
                double_numbers.remove(i + 1);
                result = num1 * num2;
                double_numbers.set(i, result);
                break;
            }
        }
        return result;
    }
    private double division(double result){
        for(int i = 0; i < sings.size(); i++){
            if(sings.get(i).equals("/")){
                sings.remove(i);
                Double num1 = double_numbers.get(i);
                Double num2 = double_numbers.get(i + 1);
                double_numbers.remove(i + 1);
                result = num1 / num2;
                double_numbers.set(i, result);
                break;
            }
        }
        return result;
    }
    private double add(double result){
        for(int i = 0; i < sings.size(); i++){
            if(sings.get(i).equals("+")){
                sings.remove(i);
                Double num1 = double_numbers.get(i);
                Double num2 = double_numbers.get(i + 1);
                double_numbers.remove(i + 1);
                result = num1 + num2;
                double_numbers.set(i, result);
                break;
            }
        }
        return result;
    }
    private double subtract(double result){
        for(int i = 0; i < sings.size(); i++){
            if(sings.get(i).equals("-")){
                sings.remove(i);
                Double num1 = double_numbers.get(i);
                Double num2 = double_numbers.get(i + 1);
                double_numbers.remove(i + 1);
                result = num1 - num2;
                double_numbers.set(i, result);
                break;
            }
        }
        return result;
    }


}