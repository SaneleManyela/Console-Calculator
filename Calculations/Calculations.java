/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Point;
import java.io.*;
import java.math.RoundingMode;
import java.text.*;
import java.util.Random;

/**
 *
 * @author Sanele
 */
public class Calculations {
    
    // A String class variable to hold the name of the user
    private static String strNames;
    
    private static Point pX; // Holds coordinates of point x
    private static Point pY; // Holds coordinates of point y
    
    // Handles the run of the program depending on user input
    private void handler() {
        System.out.println();
        
        System.out.println(new SimpleDateFormat("EEEE, dd MMMM yyyy").format(
                new java.util.Date()) + " | Welcome " + strNames);
        
        System.out.println("-------------------------------------------------");
        
        menu();
        
        System.out.println();
        
        System.out.print("Would you like to continue using the program? y/n -> ");
        String strUserAnswer = getConsoleInput();
        
        if(strUserAnswer.toLowerCase().equals("y")) {
            clearConsole();
            handler();
            
        } else if(strUserAnswer.toLowerCase().equals("n")) {
            exit();
            
        } else if(!(strUserAnswer.toLowerCase().equals("y")) || 
                !(strUserAnswer.toLowerCase().equals("n"))) {
                       
            do {
                System.out.print("Please enter y or n ->");
                strUserAnswer = getConsoleInput();
                
                if(strUserAnswer.toLowerCase().equals("y")) {
                    clearConsole();
                    
                    System.out.println();
                    
                    handler();
                    
                } else if(strUserAnswer.toLowerCase().equals("n")) {
                    exit();
                }
                
            } while(!strUserAnswer.toLowerCase().equals("y") &&
                    !strUserAnswer.toLowerCase().equals("n"));
        }
        
    }
    
    // A method used to get user input from the console
    private String getConsoleInput() {
        String str = "";
        try {
            InputStreamReader streamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            
            while(!(str = bufferedReader.readLine()).equals("")) {
                return str;
            }
            
        } catch (IOException ex) {
            System.out.println("An exception has occured: " + ex.getMessage());
        }
        return str;
    }
    
    // A method that prints the menu and requests user input
    private void menu() {
        System.out.println("1. Check position of two points");
        System.out.println("2. Calculate distance between two points");
        System.out.println("3. Calculate the area of a rectangle");
        System.out.println("4. Calculate the area of a circle");
        System.out.println("5. Determine the volume of a cube");
        System.out.println("6. Determine the circumference of a circle");
        System.out.println("7. Determine the perimeter of a rectangle");
        System.out.println("8. Determine the perimeter of a triangle");
        System.out.println("0. Exit");
        
        System.out.println();
        
        System.out.print("Please enter a menu option -> ");
        operations(getConsoleInput());
    }
    
    // The method uses a random generator to generates coordinates of a point
    private Point point() {
        Random rn = new Random();
        
        int x = rn.nextInt(80) + 1;
        int y = rn.nextInt(25) + 1;
        
        return new Point(x, y);
    }
    
    // This method rounds off a value to two decimal places
    private double roundOff(double dblValue) {
        DecimalFormat dformat = new DecimalFormat("#.##");
        dformat.setRoundingMode(RoundingMode.UP);
        return Double.parseDouble(dformat.format(dblValue));
    }
    
    // This method validates if input is a number
    public boolean isInputNumber(String strInput) {
        for (char ch : strInput.toCharArray()) {
            if (ch != '.' && ch != '-' && !Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }
    
    // This method gets a double value using the method @getConsoleInput()
    public double getDoubleInput() {
        double z = 0D;
        
        System.out.print("Enter a value -> ");
        String strInput = getConsoleInput().trim();
                
        if(!isInputNumber(strInput)) {
            System.out.println("Please enter whole numbers.");
            System.out.println();
            do {
                System.out.print("Enter a whole number -> ");
                strInput = getConsoleInput();
                    
            } while(isInputNumber(strInput) == false);
            z = Double.parseDouble(strInput);
                    
        } else if(isInputNumber(strInput)) {
            z = Double.parseDouble(strInput);
        }
        return z;
    }
    
    // This method executes a certain operation depending on user chosen menu
    // option
    private void operations(String str) {
        try{
            switch(str) {
                case "1": // Checks if two points are equal
                    System.out.println();
                    
                    pX = point();
                    pY = point();
                    
                    if(pX.equals(pY)) {
                        System.out.println("Point X " + (pX.getX() + "," 
                                + pX.getY()) + " is equal to Point Y "
                                + pY.getX() + "," + pY.getY());
                        
                    } else if(!(pX.equals(pY))) {
                        System.out.println("Point X (" + pX.getX() + "," 
                                + pX.getY() + ") is NOT equal to Point Y ("
                                + pY.getX() + "," + pY.getY() +")");
                    }
                    break;
                    
                case "2": // Calculates the distance between two points
                    if(pX == null && pY == null) {
                        System.out.println("Please choose option 1 in the menu first"
                                + " to get point x and point y.");
                        
                    } else {
                        System.out.println();
                        
                        double dblDistance = roundOff(Math.sqrt(
                                Math.pow(pY.getX() - pX.getX(), 2) + 
                                        Math.pow(pY.getY() - pX.getY(), 2)));
                        
                        System.out.println("1. Hexadecimal");
                        System.out.println("2. Octal");
                        
                        System.out.println();
                        System.out.print("Choose option to print the distance results to -> ");
                        String strInput = getConsoleInput().trim();
                                                
                        if(!strInput.equals("1") && !strInput.equals("2")) {
                            do {
                                System.out.print("Enter option 1 or 2 -> ");
                                strInput = getConsoleInput();
                                
                                if(strInput.equals("1")) {
                                    System.out.println("The distance " + 
                                            dblDistance + " in hexadecimal is " +
                                            Integer.toHexString(
                                                    (int)dblDistance).toUpperCase());
                                    break;
                                } else if(strInput.equals("2")) {
                                    System.out.println("The distance " + 
                                            dblDistance + " in octal is " +
                                            Integer.toOctalString((int)dblDistance));
                                    break;
                                }
                                
                            } while(!strInput.equals("1") || !strInput.equals("2"));
                        } else {
                            if(strInput.equals("1")) {
                                System.out.println("The distance " + 
                                        dblDistance + " in hexadecimal is " +
                                        Integer.toHexString(
                                                (int)dblDistance).toUpperCase());
                            } else if(strInput.equals("2")) {
                                System.out.println("The distance " + 
                                        dblDistance + " in octal is " +
                                        Integer.toOctalString((int)dblDistance));
                            }
                        }
                    }
                    break;
                    
                case "3": // Calculates the area of a rectangle
                    System.out.println();
                    
                    System.out.println("Length:");
                    double dblLength = getDoubleInput();
                    
                    System.out.println("Breadth:");
                    double dblBreadth = getDoubleInput();
                    
                    System.out.println("The area of a rectangle with length " + 
                            dblLength + " and breadth " + dblBreadth +
                            " is " + roundOff(dblLength * dblBreadth) + " m\u00B2");
                    
                    break;
                    
                case "4": // Calculates the area of a circle
                    System.out.println();
                    
                    System.out.println("Radius:");
                    double dblRadius = getDoubleInput();
                    
                    System.out.println("The area of a circle with radius " +
                            dblRadius + " is " + roundOff((Math.PI) * Math.pow(dblRadius, 2)));
                    break;
                    
                case "5": // Calculates the volume of a cube
                    System.out.println();
                    
                    System.out.println("Length:");
                    dblLength = getDoubleInput();
                    
                    System.out.println("Breadth:");
                    dblBreadth = getDoubleInput();
                    
                    System.out.println("Height:");
                    double dblHeight = getDoubleInput();
                    
                    System.out.println("The volume of a cube with length " +
                            dblLength + ", breadth " + dblBreadth + ", height " +
                            dblHeight + " = " + roundOff(dblLength * dblBreadth * dblHeight));
                    break;
                    
                case "6": // Calculates the circumference of a circle
                    System.out.println();
                    
                    System.out.println("Radius:");
                    dblRadius = getDoubleInput();
                    
                    System.out.println("The circumference of a circle with radius " +
                            dblRadius + " is " + roundOff(2 * Math.PI * dblRadius));
                    break;
                    
                case "7": // Calculates the perimeter of a rectangle
                    System.out.println();
                    
                    System.out.println("Length:");
                    dblLength = getDoubleInput();
                    
                    System.out.println("Height:");
                    dblHeight = getDoubleInput();
                    
                    System.out.println("The perimeter of a rectangle with length " + 
                            dblLength + " and height " + dblHeight + " is " +
                            roundOff(2 * dblLength + 2 * dblHeight));
                    break;
                    
                case "8": // Calculates the perimeter of a triangle
                    System.out.println();
                    
                    System.out.println("Side X:");
                    double dblSideX = getDoubleInput();
                    
                    System.out.println("Base:");
                    double dblBase = getDoubleInput();
                    
                    System.out.println("Side Y:");
                    double dblSideY = getDoubleInput();
                    
                    System.out.println("The perimeter of a triangle with side 1 " +
                            dblSideX + ", side 2 " + dblSideY + ", and base " +
                            dblBase + " is " + roundOff(dblSideX + dblBase + dblSideY));
                    break;
                    
                case "0": // Terminates the program run
                    exit();
                    break;
                    
                default: // Executes when incorrect mebnu option is entered
                    System.out.println("Enter option 1 to 8 or 0");
                    break;
            } 
        } catch(Exception e) {
            System.out.println("An exception has occured: " + e.getMessage());
        }
    }
    
    // This method clears the command line interface
    private void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch(IOException | InterruptedException e) {
            System.out.println("An exception has occured " + e.getMessage());
        }
    }
    
    // This method bids farewell to a user, display the current time, and
    // terminates the program.
    private void exit() {
        System.out.println();
        
        System.out.println("Goodbye " + strNames + 
                ". The time is "+ 
                new SimpleDateFormat("hh:mm:ss a").format(new java.util.Date()));
        
        System.exit(0);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculations calc = new Calculations();
        
        System.out.print("Welcome guest, please enter your name -> ");
        Calculations.strNames = calc.getConsoleInput();
        
        calc.handler();
    }
    
}
