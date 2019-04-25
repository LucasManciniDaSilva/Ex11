package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Employee;

public class Program {

	public static void main(String[] args) throws IOException {
		
		   
		List<Employee> list = new ArrayList<>();
		
		String path = "/users/lucasmancini/in.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String employees = br.readLine();
			while(employees != null) {
				String[] fields = employees.split(", ");
				String name = fields[0];
				double salary = Double.parseDouble(fields[1]);
				
				list.add(new Employee(name, salary));
				
				employees = br.readLine();
			}
			 Collections.sort(list);
			 for(Employee e : list) {
				 System.out.println(e.getName() + ", " + e.getSalary());
			 }
			
		}
		
		catch(IOException e) {
			System.out.println("Fatal Error!!!!!!");
		}
	}

}
