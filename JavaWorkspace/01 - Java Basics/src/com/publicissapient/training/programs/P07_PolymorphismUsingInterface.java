package com.publicissapient.training.programs;

import com.publicissapient.training.entity.Camera;
import com.publicissapient.training.entity.DSLRCamera;
import com.publicissapient.training.entity.MobilePhone;

public class P07_PolymorphismUsingInterface {

	public static void takePicture(Camera c1) {
		c1.takePhoto();
	}
	
	public static void main(String[] args) {
		
		takePicture(new MobilePhone());
		takePicture(new DSLRCamera());
		
		
	}
	
	
	
}
