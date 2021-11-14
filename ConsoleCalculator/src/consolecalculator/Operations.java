/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consolecalculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author EL.2021.T2D0G7
 */
public class Operations {
    
    private double roundOff(double dblValue) {
        DecimalFormat dformat = new DecimalFormat("#.##");
        dformat.setRoundingMode(RoundingMode.UP);
        return Double.parseDouble(dformat.format(dblValue));
    }
    
    public int addition(int x, int y) {
        return x + y;
    }
    
    public int Subtraction(int x, int y) {
        return x - y;
    }
    
    public int division(int x, int y) {
        return x / y;
    }
    
    public int multiplication(int x, int y) {
        int intAnswer = 0;
        int intCount = 0;
        
        while(y > 0) {
            if(y % 2 == 1) {
                intAnswer += x << intCount;
            } 
            intCount++;
            y /= 2;
        }
        return intAnswer;
    }
    
    public double cosine(double x) {
        return roundOff(Math.cos(x));
    }
    
    public double sine(double x) {
        return roundOff(Math.sin(x));
    }
    
    public double tangent(double x) {
        return roundOff(Math.tan(x));
    }
    
    public double log(double x) {
        return roundOff(Math.log(x));
    }
    
    public double squareRoot(double x) {
        return roundOff(Math.sqrt(x));
    }
    
    public double changeSign(double x) {
        if(x > 0) {
            return roundOff((x * -1));
            
        } else if(x < 0) {
            return roundOff(Math.abs(x)); 
        }
        return 0D;
    }
}
