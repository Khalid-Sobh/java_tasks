/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Khalid Sobh
 */
public class Main {
    
    public static void main(String[] args){
        
        ComparisonClass object = new ComparisonClass();
        String one = object.betterString("Khalid", "Sobh", (str1, str2) -> str1.length() > str2.length());
        System.out.println(one);

        Boolean result = object.checkString("dfd546", ComparisonClass::allLetters);
        System.out.println(result);
        
        
        
    }
    
}
