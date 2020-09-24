/*
Name: Andy Luong
Course: COMSC 75 - 204
Term/Year: Fall 2020
Date:09/20/20
Instructor: Loc Lam
Project Number: 1

The program will prompt you to enter your weekly work hours and hourly pay.
It will then print out gross pay, tax amount, take-home pay and annual income.
*/

import java.util.Scanner; //Imported Scanner to take user input
public class CalculatePay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Creates a Scanner
       
        //Take user input for hours worked and hourly pay
        System.out.println("Paycheck Management System");
        System.out.println("-------------------------------------------------");
        System.out.println("Please enter your weekly work hours ");
          double weeklyHours = input.nextDouble(); 
        System.out.println("Please enter your hourly pay rate ");
          double hourlyPay = input.nextDouble();
          //Calculations for output done below
          double grossPay = weeklyHours*hourlyPay; 
         
          double taxRate;
          if(weeklyHours >= 40){ //used if statement used to get tax rate
             taxRate = 20; }
         else {
             taxRate = 18; }

        //Calculations below from Project Specifications  
        double taxAmount = grossPay * (taxRate/100);
        double takeHome = grossPay - taxAmount;
        double annualIncome = grossPay * 52;
        
        //Prints expected output from Sample Run 1 & 2
        System.out.println("-------------------");
        System.out.print("Your weekly gross pay is $");
        System.out.println(grossPay);
        System.out.print("Your weekly tax amount is $");
        System.out.println(taxAmount);
        System.out.print("Your weekly take-home pay is $");
        System.out.println(takeHome);
        System.out.print("Your annual income is #");
        System.out.println(annualIncome);
        System.out.println("-------------------------------------------------");
        System.out.print("Bye!");
    } 
}

