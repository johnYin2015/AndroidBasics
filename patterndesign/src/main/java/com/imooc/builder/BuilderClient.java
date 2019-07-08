package com.imooc.builder;

import com.imooc.builder.Director;
import com.imooc.builder.Product;

public class BuilderClient {
	public static void main(String[] args)
    {
		Builder  builder = new ConcreteBuilder(); //可通过配置文件实现
		Director director = new  Director(builder);
		Product product = director.construct();
    }
}
