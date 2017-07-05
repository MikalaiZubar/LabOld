package com.epam.library;

import java.util.Scanner;

import com.epam.service.DataBaseServices;

public class CorporateBooksReadingCounter {

	public static void main(String[] args) throws InterruptedException{
		Scanner sc = new Scanner(System.in);
		
		DataBaseServices dbs = new DataBaseServices();
		/*dbs.populateTable();*/       
		//Execute this to populate intermediate table
		
		System.out.println("Welcome to EPAM library management......");
		boolean flag = true;
		while(flag)
		{
			System.out.println("You can perform the following operations: ");
			System.out.println("1. View report on the employees who have read more than 1 book");
			System.out.println("2. View report on the employees who have read less than or equal to 2 books");
			System.out.println("3. Update Book Title.");
			System.out.println("Enter 0 to exit");
		
			switch (sc.nextInt()) {
				case 0:
					flag = false;
					break;
				case 1:
					dbs.getEmployeesWhoReadMoreThanOneBook();
					break;
		
				case 2:
					dbs.getEmployeesWhoReadLessThanOrEqualToTwoBook();
					break;
		
				case 3:
					dbs.updateTitle();
					break;
					
				default:
					System.out.println("InValid selection");
					break;
				}
		}
		System.out.println("Thank You for visiting.....");
		sc.close();
		
	}

}
