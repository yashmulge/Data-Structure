package com.yj.utility;

import java.util.TreeMap;

public class StringTreeMap {
	private TreeMap<String, String> stringMap;

	public StringTreeMap() {
		stringMap = new TreeMap<>();
	}

	public void addString(String key, String value) {
		stringMap.put(key, value);
	}

	public void deleteString(String key) {
		stringMap.remove(key);
	}

	public void displayAllStrings() {
		stringMap.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
	}

	public String getString(String key) {
		return stringMap.get(key);
	}

	public boolean containsString(String key) {
		return stringMap.containsKey(key);
	}

	public int size() {
		return stringMap.size();
	}
}
