package test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.Connection;

import dao.StudentDAO;
import form.StudentForm;
import utils.PostgresJDBCUtils;

public class Main {
public static void main(String[] args) {
	StudentDAO stdao= new StudentDAO();
		try {
			Connection conn= PostgresJDBCUtils.getConnection();
			StudentDAO stDao = new StudentDAO();
			StudentForm st= new StudentForm();
			st.setYear(2019);
			st.setName("Đông");
			int a = stDao.addStudent(st);
			if (a>0) {
				System.out.println("ĐĂng nhập thành công");	
			} else
			System.out.println(1);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
}
}
