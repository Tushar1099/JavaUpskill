package com.assignment.creditserviceimpl;

import org.springframework.stereotype.Service;

import com.assignment.creditservice.CreditService;

@Service
public class CreditServiceImpl implements CreditService {

	@Override
	public String ValidateCreditCard(String creditcard) {
		int length = creditcard.length();
		for (char c : creditcard.toCharArray()) {
			if(!(c>='0' && c<='9')) {
				return "Credit card should only have numbers!";
			}
		}
		if(length == 15) {
			int digits = ((creditcard.charAt(0)-'0')*1000) + ((creditcard.charAt(1)-'0')*100) + ((creditcard.charAt(2)-'0')*10) + (creditcard.charAt(3)-'0');
			if(digits==2014 || digits==2149) {
				return "enRoute";
			}
		}
		if(length >= 16 && length <= 19) {
			int digits = ((creditcard.charAt(0)-'0')*1000) + ((creditcard.charAt(1)-'0')*100) + ((creditcard.charAt(2)-'0')*10) + (creditcard.charAt(3)-'0');
			if(digits>=3528 && digits<=3589) {
				return "JCB";
			}
			if(creditcard.charAt(0)=='4') {
				return "Visa";
			}
			digits = (digits*10) + (creditcard.charAt(4)-'0');
			digits = (digits*10) + (creditcard.charAt(5)-'0');
			if((creditcard.charAt(0)=='5') && (creditcard.charAt(1)>='1' && creditcard.charAt(1)<='5') && (digits>=510000 && digits<=559999)) {
				return "Mastercard";
			}
			if((creditcard.charAt(0)=='2') && (creditcard.charAt(1)>='2' && creditcard.charAt(1)<='7') && (digits>=222100 && digits<=272099)) {
				return "Mastercard";
			}
			if((digits>=601100 && digits<=601109) || (digits>=601120 && digits<=601149) || (digits>=601177 && digits<=601179) || (digits>=601186 && digits<=601199) || (digits>=644000 && digits<=659999) || (digits == 601174)) {
				return "American Express";
			}
		}
		
		return "Not a valid credit card.";
	}

}
