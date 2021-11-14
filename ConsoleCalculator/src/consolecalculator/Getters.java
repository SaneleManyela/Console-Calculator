/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consolecalculator;

import java.io.*;

/**
 *
 * @author EL.2021.T2D0G7
 */
public class Getters {
    
    private final Validation validation = new Validation();
    
    public String getConsoleInput() {
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
    
    public int[] getIntegerOperands() {
        int[] arrOperands = new int[2];
        
        System.out.print("Enter first operand -> ");
        String strInput = getConsoleInput(); 
                
        if(!validation.isInputNumber(strInput)) {
            System.out.println("Please enter integers.");
            System.out.println();
            do {
                System.out.print("Enter an integer for the first operand -> ");
                strInput = getConsoleInput();
                    
            } while(validation.isInputNumber(strInput) == false);
                arrOperands[0] = Integer.parseInt(strInput);
                    
        } else if(validation.isInputNumber(strInput)) {
            arrOperands[0] = Integer.parseInt(strInput);
        }
                
        System.out.print("Enter second operand -> ");
        strInput = getConsoleInput();
                
        if(!validation.isInputNumber(strInput)) {
            System.out.println("Please enter integers.");
            System.out.println();
            do {
                System.out.print("Enter an integer for the second operand -> ");
                strInput = getConsoleInput();
                        
            } while(validation.isInputNumber(strInput) == false);
            arrOperands[1] = Integer.parseInt(strInput);
                    
        } else if(validation.isInputNumber(strInput)) {
            arrOperands[1] = Integer.parseInt(strInput);
        }
        return arrOperands;   
    }
    
    public double getDoubleInput() {
        double z = 0D;
        
        System.out.print("Enter a value -> ");
        String strInput = getConsoleInput();
                
        if(!validation.isInputNumber(strInput)) {
            System.out.println("Please enter whole numbers.");
            System.out.println();
            do {
                System.out.print("Enter a whole number -> ");
                strInput = getConsoleInput();
                    
            } while(validation.isInputNumber(strInput) == false);
            z = Double.parseDouble(strInput);
                    
        } else if(validation.isInputNumber(strInput)) {
            z = Double.parseDouble(strInput);
        }
        return z;
    }
    
    public String getHexadecimal() {
        System.out.print("Enter a hexadecimal -> ");
        String strInput = getConsoleInput();
        
        if(!validation.isInputHexadecimal(strInput)) {
            do {
                System.out.print("Enter hexadecimal -> ");
                strInput = getConsoleInput();
            } while(validation.isInputHexadecimal(strInput) == false);
            
        } else if(validation.isInputHexadecimal(strInput)) {
            return strInput;
        }
        return strInput;
    }
    
    public int getOctal() {
        System.out.print("Enter an octal number -> ");
        String strInput = getConsoleInput();
        
        if(!validation.isInputOctal(strInput)) {
            do {
                System.out.print("Enter an octal number -> ");
                strInput = getConsoleInput();
            } while(validation.isInputOctal(strInput) == false);
            
        } else if(validation.isInputOctal(strInput)) {
            return Integer.parseInt(strInput);
        }
        return 0;
    }
}
