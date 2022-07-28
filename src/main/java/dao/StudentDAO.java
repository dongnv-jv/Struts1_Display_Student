package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import form.StudentForm;
import form.UserForm;
import utils.JDBCUtils;

public class StudentDAO {
	private StudentForm student;
	public int addStudent(StudentForm st) {
		int a = 0;
		try {
			Connection conn = JDBCUtils.getConnection();
			String sql = "INSERT INTO student(idst,name,dayofbirth,gpa,year) VALUES(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, st.getIdst());
			pst.setString(2, st.getName());
			pst.setString(3, st.getDayofbirth());
			pst.setDouble(4, st.getGpa());
			pst.setInt(5, st.getYear());
			a = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	public ArrayList<StudentForm> showListSt(){
		ArrayList<StudentForm> list = new ArrayList();
		
		try {
			Connection conn = JDBCUtils.getConnection();
			String sql = "SELECT * FROM student ";
			Statement stt = conn.createStatement();
			ResultSet rs= stt.executeQuery(sql);
			
			while(rs.next()) {
				StudentForm student= new StudentForm();	
				student.setIdst(rs.getString("idst"));
				student.setName(rs.getString("name"));
				student.setDayofbirth(rs.getString("dayofbirth"));
				student.setGpa(rs.getDouble("gpa"));
				student.setYear(rs.getInt("year"));
				list.add(student);			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
