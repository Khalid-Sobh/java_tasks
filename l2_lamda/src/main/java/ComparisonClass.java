
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Khalid Sobh
 */
public class ComparisonClass {
    String betterString(String str1, String str2, BiPredicate<String, String> biPredicate)
    {
        if (biPredicate.test(str1, str2))
                return str1;
            return str2;
    }


    boolean checkString(String str1, Predicate<String> predicate)
    {
        return predicate.test(str1);

    }

    static boolean  allLetters(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if (!Character.isLetter(str.charAt(i)))
            {
                return false;
            }
        }

        return true;
    }
    
}
