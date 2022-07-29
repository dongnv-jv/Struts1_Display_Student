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
			String sql = "SELECT * FROM struts_user WHERE user_name = ? AND user_password = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, "dongbk97");
			pstm.setString(2, "1234");
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				System.out.println("ĐĂng nhập thành công");	
			} else
			System.out.println(1);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
}
}
