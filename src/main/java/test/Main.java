package test;

import java.util.ArrayList;

import dao.StudentDAO;
import form.StudentForm;

public class Main {
public static void main(String[] args) {
	StudentDAO stdao= new StudentDAO();
	
	
	ArrayList<StudentForm> list=stdao.showListSt();
	
	for (StudentForm studentForm : list) {
		System.out.println(studentForm);
	}
}
}
