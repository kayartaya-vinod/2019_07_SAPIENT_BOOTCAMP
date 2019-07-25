package com.publicissapient.training.entity;

public class MobilePhone implements Camera{

	@Override
	public void takePhoto() {
		System.out.println("taking photo from a phone");
	}

	@Override
	public void deletePhoto() {
		System.out.println("deleting a photo from the phone");
	}

}
