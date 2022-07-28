package test;

import java.util.ArrayList;

import dao.StudentDAO;
import form.StudentForm;

public class Main {
public static void main(String[] args) {
	StudentDAO stdao= new StudentDAO();
	
	
	StudentForm st=stdao.showSt("ABC123");
	
	
		System.out.println(st);
	
}
}
