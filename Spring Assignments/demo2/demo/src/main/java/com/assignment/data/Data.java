package com.assignment.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.assignment.models.Info;
import com.assignment.models.User;

@Component
public class Data {
	
	public List<User> getData() {
		List<User> list = new ArrayList<>();
		list.add( new User("user","pass"));
		return list;
	}
	
	public List<Info> getZipData(){
		List<Info> list = new ArrayList<>();
		list.add(new Info(04,"MH","Mumbai","IN"));
		list.add(new Info(01,"DL","Delhi","IN"));
		list.add(new Info(05,"KA","Bengluru","IN"));
		list.add(new Info(737,"NYC","New York City","USA"));
		return list;
		
	}
	
}
