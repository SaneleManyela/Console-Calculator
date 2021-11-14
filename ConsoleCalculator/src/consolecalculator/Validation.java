/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consolecalculator;

/**
 *
 * @author EL.2021.T2D0G7
 */
public class Validation {
    public boolean isInputNumber(String strInput) {
        for (char ch : strInput.toCharArray()) {
            if (ch != '.' && ch != '-' && !Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isInputDecimal(String strInput) {
        for(char ch : strInput.toCharArray()) {
            if(!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isInputHexadecimal(String strInput) {
        char[] arrCh = strInput.toCharArray();
        
        for(char ch : arrCh) {
            if((ch >= '0' && ch <= '9')
                    || (ch >= 'A' && ch <= 'F')) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isInputOctal(String strInput) {
        for(char ch : strInput.toCharArray()) {
            if((ch >= '0' && ch <= '7') && Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }
}
