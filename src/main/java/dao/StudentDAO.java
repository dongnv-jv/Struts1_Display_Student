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
import utils.PostgresJDBCUtils;

public class StudentDAO {
	private StudentForm student;

	public int addStudent(StudentForm st) {
		int a = 0;
		try {
			Connection conn = PostgresJDBCUtils.getConnection();
			String sql = "INSERT INTO struts_student(st_id,st_name,st_dayofbirth,st_gpa,st_year) VALUES(?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, st.getIdst());
			pstm.setString(2, st.getName());
			pstm.setString(3, st.getDayofbirth());
			pstm.setDouble(4, st.getGpa());
			pstm.setInt(5, st.getYear());
			a = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public ArrayList<StudentForm> showListSt() {
		ArrayList<StudentForm> list = new ArrayList();
		try {
			Connection conn = PostgresJDBCUtils.getConnection();
			String sql = "SELECT * FROM struts_student ";
			Statement sttm = conn.createStatement();
			ResultSet rs = sttm.executeQuery(sql);

			while (rs.next()) {
				StudentForm student = new StudentForm();
				student.setIdst(rs.getString("st_id"));
				student.setName(rs.getString("st_name"));
				student.setDayofbirth(rs.getString("st_dayofbirth"));
				student.setGpa(rs.getDouble("st_gpa"));
				student.setYear(rs.getInt("st_year"));
				list.add(student);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public StudentForm showSt(String id) {
		StudentForm student = new StudentForm();
		try {
			Connection conn = PostgresJDBCUtils.getConnection();
			String sql2 = "SELECT * FROM struts_student WHERE st_id = '" + id + "'";
			Statement stt = conn.createStatement();
			ResultSet rs = stt.executeQuery(sql2);
			while (rs.next()) {

				student.setIdst(rs.getString("st_id"));
				student.setName(rs.getString("st_name"));
				student.setDayofbirth(rs.getString("st_dayofbirth"));
				student.setGpa(rs.getDouble("st_gpa"));
				student.setYear(rs.getInt("st_year"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	public int changePassword(String id, String password) {
		StudentForm student = new StudentForm();
		int a = 0;
		try {
			Connection conn = PostgresJDBCUtils.getConnection();
			String sql = "UPDATE struts_student SET st_password = '" + password + "' WHERE st_id='" + id + "'";
			Statement stt = conn.createStatement();

			a = stt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public int delete(String id) {
		StudentForm student = new StudentForm();
		int a = 0;
		try {
			Connection conn = PostgresJDBCUtils.getConnection();
			String sql = "DELETE FROM struts_student WHERE st_id = '" + id + "'";
			Statement stt = conn.createStatement();
			a = stt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public boolean checkLoginSt(StudentForm st) {
		boolean b = false;
		try {
			Connection conn = PostgresJDBCUtils.getConnection();
			String sql = "SELECT * FROM struts_student WHERE st_id = ? AND st_password = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, st.getIdst());
			pstm.setString(2, st.getPassword());
			ResultSet rs = pstm.executeQuery();
			b = rs.next();
		} catch (Exception e) {
			b = false;
		}
		return b;
	}
}
