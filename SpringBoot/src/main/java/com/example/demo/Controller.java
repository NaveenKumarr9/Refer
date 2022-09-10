package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping("/")
	@ResponseBody
	String hello() {
		return "Naveen Kumar!!";
	}

	@RequestMapping("/cacl/{num}/{num2}")
	public String addition(@PathVariable int num, @PathVariable int num2) {

		return "Addition =" + (num + num2) + "\nSubstraction =" + (num + num2) + "\nDivision =" + (num / num2)
				+ "\nMultiplication =" + (num * num2);

	}

	@RequestMapping("/grades/{name}/{marks}")
	public String grade(@PathVariable String name, @PathVariable int marks) {

		Student1 std = new Student1(name,marks);
		return std.grades();

	}
}
