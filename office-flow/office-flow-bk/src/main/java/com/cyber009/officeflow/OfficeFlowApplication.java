package com.cyber009.officeflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class OfficeFlowApplication {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> r = new LinkedList<>();
		int h = 0;
		for(int i=0; i<candies.length; i++) {
			if(candies[i] > h) h = candies[i];
		}
		for(int i=0; i<candies.length; i++) {
			if(candies[i] + extraCandies <= h)
				r.add(Boolean.TRUE);
			else
				r.add(Boolean.FALSE);
		}
		return r;
	}
	public static void main(String[] args) {
		SpringApplication.run(OfficeFlowApplication.class, args);
	}

}
