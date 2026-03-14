package com.capgemini.practice.experiments2;

import java.util.ArrayList;
import java.util.Scanner;

class Book{
	private int id;
	private String name;
	private int price;
	public Book(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}

class BookUtility{
	ArrayList<Book> bookList = new ArrayList<>();
	public void addBook(int id,String name,int price) {
		bookList.add(new Book(id,name,price));
	}
	
	public void updatePrice(int id,int price) {
		for(Book b : bookList) {
			if(b.getId() == id) {
				b.setPrice(price);
				System.out.println(b);
			}
		}
	}
	
	public void above500() {
		for(Book b : bookList) {
			if(b.getPrice() > 500) {
				System.out.println(b);
			}
		}
	}
}

public class Solution {
	public static void main(String[] args) {
		BookUtility bu = new BookUtility();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
		    char choice = sc.next().charAt(0);

		    switch(choice) {
		        case 'a':
		            int id = sc.nextInt();
		            String name = sc.next();
		            int price = sc.nextInt();
		            bu.addBook(id, name, price);
		            break;

		        case 'b':
		            int uid = sc.nextInt();
		            int newPrice = sc.nextInt();
		            bu.updatePrice(uid, newPrice);
		            break;

		        case 'c':
		            bu.above500();
		            break;

		        default:
		            flag = false;
		    }
		}
		sc.close();
	}

}
