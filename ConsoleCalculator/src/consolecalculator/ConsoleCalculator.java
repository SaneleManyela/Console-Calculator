/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consolecalculator;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.*;
/**
 *
 * @author EL.2021.T2D0G7
 */
public class ConsoleCalculator {

    private static Instant startTime;
    private static Instant endTime;
        
    private static String strNames = "";
    
    private final Getters getters = new Getters();
    
    private void mainOperationsHandler() {
        System.out.println(new SimpleDateFormat("EEEE, dd MMMM yyyy").format(
                new java.util.Date()) + " | Welcome " + strNames); 
        
        System.out.println("-------------------------------------------------");
        
        mainMenu();
        
        System.out.println();
        
        System.out.print("Would you like to continue using the program? y/n -> ");
        String strUserAnswer = getters.getConsoleInput();
        
        if(strUserAnswer.toLowerCase().equals("y")) {
            clearConsole();
            mainOperationsHandler();
            
        } else if(strUserAnswer.toLowerCase().equals("n")) {
            runDetails();
            
        } else if(!(strUserAnswer.toLowerCase().equals("y")) || 
                !(strUserAnswer.toLowerCase().equals("n"))) {
                       
            do {
                System.out.print("Please enter y or n ->");
                strUserAnswer = getters.getConsoleInput();
                
                if(strUserAnswer.toLowerCase().equals("y")) {
                    clearConsole();
                    
                    System.out.println();
                    
                    mainOperationsHandler();
                    
                } else if(strUserAnswer.toLowerCase().equals("n")) {
                    runDetails();
                }
                
            } while(!strUserAnswer.toLowerCase().equals("y") &&
                    !strUserAnswer.toLowerCase().equals("n"));
        }
    }
    
    private void mainMenu() {
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Division");
        System.out.println("4. Multiplication");
        System.out.println("5. Cosine");
        System.out.println("6. Sine");
        System.out.println("7. Tangent");
        System.out.println("8. Log");
        System.out.println("9. Square Root");
        System.out.println("10. Reverse number sign");
        System.out.println("11. Conversions");
        System.out.println("0. Exit");
        
        System.out.println();
        
        System.out.print("Please enter a menu option -> ");
        mainOperations(getters.getConsoleInput());
        
    }
    
    private void conversionsHandler() {
        System.out.println();
        
        conversionsMenu();
        
        System.out.println();
        
        System.out.print("Would you like to continue converting? y/n -> ");
        String strUserAnswer = getters.getConsoleInput();
        
        if(strUserAnswer.toLowerCase().equals("y")) {
            clearConsole();
            conversionsHandler();
            
        } else if(strUserAnswer.toLowerCase().equals("n")) {
            clearConsole();
            mainOperationsHandler();
            
        } else if(!(strUserAnswer.toLowerCase().equals("y")) || 
                !(strUserAnswer.toLowerCase().equals("n"))) {
                       
            do {
                System.out.print("Please enter y or n ->");
                strUserAnswer = getters.getConsoleInput();
                
                if(strUserAnswer.toLowerCase().equals("y")) {
                    clearConsole();
                    
                    System.out.println();
                    
                    conversionsHandler();
                    
                } else if(strUserAnswer.toLowerCase().equals("n")) {
                    clearConsole();
                    mainOperationsHandler();
                }
                
            } while(!strUserAnswer.toLowerCase().equals("y") &&
                    !strUserAnswer.toLowerCase().equals("n"));
        }
    }
    
    private void conversionsMenu() {
        System.out.println("Conversions");
        System.out.println("-------------------------------------------------");
        System.out.println("1. Convert Hexadecimal to Decimal");
        System.out.println("2. Convert Octal to Decimal");
        System.out.println("3. Convert Decimal to Hexadecimal");
        System.out.println("4. Convert Octal to Hexadecimal");
        System.out.println("5. Convert Decimal to Octal");
        System.out.println("6. Convert Hexadecimal to Octal");
        
        System.out.println();
        
        System.out.print("Please enter a menu option -> ");
        conversionsOperations(getters.getConsoleInput());
    }
    
    private void conversionsOperations(String str) {
        try {
            int intDecimal;
            switch(str) {
                case "1":
                    System.out.println();
                    System.out.println("Decimal representation of the hexadecimal is " 
                        + Integer.parseInt(getters.getHexadecimal(), 16));
                    break;
                
                case "2":
                    System.out.println();
                    System.out.println("Decimal representation of the octal is " + 
                        Integer.parseInt(String.valueOf(getters.getOctal()), 8));
                    break;
                
                case "3":
                    System.out.println();
                    System.out.println("Hexidecimal representation of the decimal is "
                        + Integer.toHexString(
                            (int)getters.getDoubleInput()).toUpperCase());
                    break;
                
                case "4":
                    System.out.println();
                    intDecimal = Integer.parseInt(
                        String.valueOf(getters.getOctal()), 8);
                    System.out.println("The hexidecimal representation of the number is "
                        + Integer.toHexString(intDecimal).toUpperCase());
                    break;
                
                case "5":
                    System.out.println();
                    System.out.println("Octal representation of the decimal is " +
                        Integer.toOctalString((int)getters.getDoubleInput()));
                    break;
                
                case "6":
                    System.out.println();
                    intDecimal = Integer.parseInt(getters.getHexadecimal(), 16);
                    System.out.println("The octal representation of the hexadecimal is " 
                        + Integer.parseInt(String.valueOf(intDecimal), 8));
                    break;
                
                default:
                    System.out.println();
                    System.out.println("Enter option 1 to 6.");
                    break;
            }
        } catch(NumberFormatException e) {
            System.out.println("An exception has occured: " + e.getMessage());
        }
    }
    
    
    private void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch(IOException | InterruptedException e) {
            System.out.println("An exception has occured " + e.getMessage());
        }
    }
    
    private void runDetails() {
        ConsoleCalculator.endTime = Instant.now();
        
        System.out.println();
        
        System.out.println("Goodbye " + strNames + 
                ". The time is "+ 
                new SimpleDateFormat("hh:mm:ss a").format(new java.util.Date())+
                ". You used the program for a duration of " + 
                Duration.between(ConsoleCalculator.startTime, ConsoleCalculator.endTime));
        
        System.exit(0);
    }
    
    private void mainOperations(String str) {
        Operations ops = new Operations();
        
        double z;
        try {
            switch(str) {
                case "1":
                    System.out.println();
                
                    int[] arrAdd = getters.getIntegerOperands();
                
                    System.out.println(arrAdd[0] + " + " + arrAdd[1] + " = " + 
                        ops.addition(arrAdd[0], arrAdd[1]));
                
                    break;
                
                case "2":
                    System.out.println();
                
                    int[] arrSub = getters.getIntegerOperands();
                
                    System.out.println(arrSub[0] + " - " + arrSub[1] + " = " + 
                        ops.Subtraction(arrSub[0], arrSub[1]));
                    break;
                
                case "3":
                    System.out.println();
                
                    int[] arrDiv = getters.getIntegerOperands();
                
                    System.out.println(arrDiv[0] + " / " + arrDiv[1] + " = " + 
                        ops.division(arrDiv[0], arrDiv[1]));
                    break;
                
                case "4":
                    System.out.println();
                
                    int[] arrMulti = getters.getIntegerOperands();
                
                    System.out.println(arrMulti[0] + " * " + arrMulti[1] + " = " + 
                        ops.multiplication(arrMulti[0], arrMulti[1]));
                    break;
                
                case "5":
                    System.out.println();
                
                    z = getters.getDoubleInput();
                
                    System.out.println("Cosine of " + z + " is " + 
                        ops.cosine(z) + "\u00B0");
                    break;
                
                case "6":
                    System.out.println();
                
                    z = getters.getDoubleInput();
                
                    System.out.println("Sine of " + z + " is " + 
                        ops.sine(z) + "\u00B0");
                    break;
                
                case "7":
                    System.out.println();
                
                    z = getters.getDoubleInput();
                
                    System.out.println("Tangent of " + z + " is " + 
                        ops.tangent(z) + "\u00B0");
                    break;
                
                case "8":
                    System.out.println();
                
                    z = getters.getDoubleInput();
                
                    System.out.println("Log of " + z + " is " + 
                        ops.log(z));
                    break;
                
                case "9":
                    System.out.println();
                
                    z = getters.getDoubleInput();
                
                    System.out.println("Square root of " + z + " is " + 
                        ops.squareRoot(z));
                    break;
                
                case "10":
                    System.out.println();
                
                    z = getters.getDoubleInput();
                    System.out.println(z + " when its sign is changed is " +
                        ops.changeSign(z));
                    break;
                
                case "11":
                    System.out.println();
                    clearConsole();
                    conversionsHandler();
                    break;
                
                case "0":
                    System.out.println();
                    runDetails();
                    break;
                
                default:
                    System.out.println();
                    System.out.println("Enter option 1 to 11 or 0 to exit.");
                    break;
            }
        } catch(Exception e) {
            System.out.println("An exception has occured: " + e.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConsoleCalculator.startTime = Instant.now();
        
        ConsoleCalculator calc = new ConsoleCalculator();
        
        if(args.length != 0 && args.length == 2) {
            strNames = args[0] + " " + args[1];
            
        } else if(args.length == 1){
            strNames = args[0];
        }
        
        calc.mainOperationsHandler();
    }
}
