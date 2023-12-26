package com.demo.controller.global;

import java.util.ArrayList;
import java.util.List;

import com.demo.controller.model.Product;

public class GlobalData {
	public static List<Product>cart;
	static {
		cart=new ArrayList<Product>();
		
	}

}
