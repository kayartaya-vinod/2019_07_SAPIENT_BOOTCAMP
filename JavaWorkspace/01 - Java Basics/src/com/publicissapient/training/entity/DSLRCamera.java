package com.publicissapient.training.entity;

public class DSLRCamera implements Camera{

	@Override
	public void takePhoto() {
		System.out.println("taking photo from a DSLRCamera");
	}

	@Override
	public void deletePhoto() {
		System.out.println("deleting a photo from the DSLRCamera");
	}

}
