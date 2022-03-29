package com.OB_Spring_789_new.ObSpring789;

import com.OB_Spring_789_new.ObSpring789.Entity.Laptop;
import com.OB_Spring_789_new.ObSpring789.Repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpring789Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObSpring789Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null, "Samsung" , 8, 399.99);
		Laptop laptop2 = new Laptop(null, "Apple" , 32, 899.99);
		Laptop laptop3 = new Laptop(null, "MSI" , 16, 599.99);

		repository.save(laptop1);
		repository.save(laptop2);
		repository.save(laptop3);

		System.out.println("Numero de laptops en la base de datos: " + repository.findAll().size());

		System.out.println("Hola!");


	}

}
