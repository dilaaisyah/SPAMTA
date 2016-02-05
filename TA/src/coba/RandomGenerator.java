/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coba;

    import java.util.*;  
      
    public class RandomGenerator { 
        private static Random random = new Random();  
      
        public static String generateActivationCode(int length) {  
            String code = new String("");  
            for (int i = 0; i < length; i++) {  
                code += (char) (random.nextInt(10) + '0');  
            }  
            return code;  
        }
        
        public static void main(String[] args) {  
        RandomGenerator random = new RandomGenerator();  
        for (int i = 0; i < 10; i++) {  
            System.out.println("" + random.generateActivationCode(1) + "");  
        }  
    }  
    }  
