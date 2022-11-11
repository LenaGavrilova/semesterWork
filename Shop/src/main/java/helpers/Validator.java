package helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private final String emailReg = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+.+.[A-Za-z]{2,4}$";

    private final String loginReg = "^[a-zA-Z0-9_-]{5,30}$";

    private final String countryReg = "^[a-zA-Z]{2,}$";

    public String checkLogin(String login){

        Pattern pattern = Pattern.compile(loginReg);
        Matcher matcher = pattern.matcher(login);
        if(!matcher.matches()){
            return "Login should contains from letters, numbers";
        }
        return "Login - ok";
    }

    public String checkEmail(String email){
        Pattern pattern = Pattern.compile(emailReg);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()){
            return "It is not an email";
        }
        return "Email - ok";
    }

    public String checkPassword(String password) {
        if(password.length() < 5 || password.length() > 30) {
            return "Password should be from 5 to 40 characters long";
        }
        return "Password - ok";
    }
    public String checkCountry(String country){
        Pattern pattern = Pattern.compile(countryReg);
        Matcher matcher = pattern.matcher(country);
        if(!matcher.matches()){
            return "It is not a country";
        }
        return "Country - ok";
    }
}
