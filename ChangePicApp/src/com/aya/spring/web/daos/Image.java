package com.aya.spring.web.daos;



import org.hibernate.validator.constraints.NotBlank;


public class Image {
@NotBlank
private String name;


public Image() {

}

public Image(String name) {
	this();
	this.name = name;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	return "Image [name=" + name + "]";
}

}