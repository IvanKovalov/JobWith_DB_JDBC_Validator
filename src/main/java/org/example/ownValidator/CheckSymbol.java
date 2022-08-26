package org.example.ownValidator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class  CheckSymbol implements ConstraintValidator< Check, String> {

    private int amountOfVowel;

    @Override
    public void initialize( Check contactNumber) {
        amountOfVowel = contactNumber.value();
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
        String []stringSymbols = contactField.toLowerCase().split("");
        int counterVowel = 0;
        for (int i = 0; i < contactField.length(); i++){
            if(stringSymbols[i].equals("a")|| stringSymbols[i].equals("e")|| stringSymbols[i].equals("o") || stringSymbols[i].equals("i")|| stringSymbols[i].equals("u")|| stringSymbols[i].equals("y")){
                counterVowel ++;
            }
        }
        if(counterVowel >= amountOfVowel ){
            return true;
        }
        return false;
    }

}