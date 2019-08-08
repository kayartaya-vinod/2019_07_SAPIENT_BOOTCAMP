package com.publicissapient.training.programs;

import java.util.Map;
import java.util.Map.Entry;

public class P19_SystemProperties {

	public static void main(String[] args) {
		
		Map<String, String> env = System.getenv();
		for(Entry<String, String> e: env.entrySet() ) {
			System.out.println(e.getKey() + " --> " + e.getValue());
		}
//		Properties props = System.getProperties();
//		for(Entry<Object, Object> p: props.entrySet()) {
//			System.out.println(p.getKey() + " --> " + p.getValue());
//		}
		
		
	}
}
