package com.example.demo;

import com.example.demo.controller.DataController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HneApplicationTests {

	@Test
	void contextLoads() {

		DataController controller = new DataController();

		String products = controller.getProducts("");
		System.out.println(products);

	}

}
