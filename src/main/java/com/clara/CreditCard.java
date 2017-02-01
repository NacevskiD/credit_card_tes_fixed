package com.clara;

import java.util.Scanner;

/**
 * Created by we4954cp on 8/31/2016.
 */
public class CreditCard {

    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Ask user for credit card number. store number as a String.
        System.out.println("Please enter the credit card number, digits only:");
        String ccNumber = stringScanner.nextLine();
        boolean isValid = isValidCreditCard(ccNumber);

        if (isValid) {
            System.out.println("This seems to be a valid credit card number");
        } else {
            System.out.println("This is **not** a valid credit card number.");
        }

        stringScanner.close();
    }

    public static boolean isValidCreditCard(String cc) {

       int acumulator = 0;
        int[] doubleDigits = new int[8];
        int[] creditCard = new int[cc.length()];
        int[] seperateDigits = new int[8];
        // checking if there are 16 numbers
        if (cc.length() != 16) {
            return false;
        }
        for (int count = 0;count < cc.length();count++) {
            // converting the string to an individual char, then string, then int and adding it to the credit card array
            int number = Integer.parseInt(Character.toString(cc.charAt(count)));
            creditCard[count] = number;
        }
        // checking if the credit card starts with 4
        if (creditCard[0] != 4){
            return false;
        }
        int ddCounter = 0;
        //multiplying every second number by 2 and adding it to the doubleDigits array
        for (int count = 0; count < cc.length();count+=2){
            doubleDigits[ddCounter] = creditCard[count] * 2;
            ddCounter++;
        }
        ddCounter = 0;
        //adding all the individual number to the acumulator
        for (int count = 1; count < cc.length();count+=2){
            // checking if there is a remainder, if there is adding both numbers, if there isn't adding only the first number
            int digit1 = doubleDigits[ddCounter] / 10;
            int digit2 = doubleDigits[ddCounter] % 10;
            if (digit1 == 0){
                acumulator+=doubleDigits[ddCounter];
            }
            else {
                acumulator+= digit1 + digit2;
            }
            ddCounter++;
            acumulator+= creditCard[count];
        }
        //checking if there is a remainder in the acumulator, if there is it fails , if there isn't it passes.
        int check = acumulator % 10;
        if (check != 0){
            return false;
        }


        return false;

    }




}
