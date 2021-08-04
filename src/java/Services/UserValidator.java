/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author congt
 */
public class UserValidator {
    public static String validatePassaword(String password) {
        if (password == null || password.equals("")) {
            return "Password cannot be empty.";
        }
        
        return null;
    }
}
