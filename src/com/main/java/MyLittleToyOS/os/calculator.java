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


    public void Menu() {
        while (true) {
            boolean number = true;
            String choice = scanner.nextLine();
            ingredients_of_action = choice.split(" ");
            for (int i = 0; i < ingredients_of_action.length; i++) {
                numbers.add(ingredients_of_action[i]);
                try{
                    sings.add(ingredients_of_action[i + 1]);
                }catch (Exception e){

                };
        calculate();

            }
        }
    }
    private void calculate(){
        convert();
        /*while(!sings.isEmpty()){
        times(0);
        division(0);
        add(0);
        subtract(0);
        System.out.println(double_numbers);
        }*/

    }
    private void convert(){
        double_numbers = new ArrayList<Double>(numbers.size());
        for(int i = 0; i < numbers.size(); i++){
            double_numbers.add(i, Double.parseDouble(numbers.get(i)));
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