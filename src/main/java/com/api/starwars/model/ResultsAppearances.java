package com.api.starwars.model;

import java.util.List;

public class ResultsAppearances {

	private String count;
	private String next;
	private String previous;
	private List<Results> results;	
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public List<Results> getResults() {
		return results;
	}
	public void setResults(List<Results> results) {
		this.results = results;
	}
	
	public class Results {
		String name;
		String rotationPeriod;
		String orbitalPeriod;
		String diameter;
		String climate;
		String gravity;
		String terrain;
		String surfaceWater;
		String population;
		List<String> residents;
		List<String> films;
		String created;
		String edited;
		String url;
	}	
}
