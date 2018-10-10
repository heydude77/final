package models;

import java.util.List;

public class Pet {
	String name;
	int type;
	List<String> feature;

	/*
	 * 	Source > generate setter
	 * 
	 */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<String> getFeature() {
		return feature;
	}
	public void setFeature(List<String> feature) {
		this.feature = feature;
	}
	
	@Override
	public String toString() {
		return "Pet [name=" + name + ", type=" + type + ", feature=" + feature + "]";
	}
	
	
	
	
	
}
