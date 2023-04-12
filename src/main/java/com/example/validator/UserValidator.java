package com.example.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.example.pojo.User;

@Component
public class UserValidator implements Validator {

	 	@Override
	    public boolean supports(Class<?> arg0) {
	        
	       //return true; always works
	       
	       return User.class.isAssignableFrom(arg0); //user and all its subclasses
	    }

	    @Override
	    public void validate(Object arg0, Errors error) {
	        
	        ValidationUtils.rejectIfEmptyOrWhitespace(error, "first", "empty-first", "Firstname cannot be empty");
	        ValidationUtils.rejectIfEmptyOrWhitespace(error, "last", "empty-last", "Lastname cannot be empty");
	       
	    }
	    
}
