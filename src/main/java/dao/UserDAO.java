package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import form.StudentForm;
import form.UserForm;
import utils.PostgresJDBCUtils;

public class UserDAO {
	public boolean checkLogin(UserForm user) {
		boolean b = false;
		try {
			Connection conn = PostgresJDBCUtils.getConnection();
			String sql = "SELECT * FROM struts_user WHERE user_name = ? AND user_password = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getPassword());
			ResultSet rs = pstm.executeQuery();
			b = rs.next();
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	public int createUser(UserForm user) {
		int a = 0;
		try {
			Connection conn = PostgresJDBCUtils.getConnection();
			String sql = "INSERT INTO struts_user(user_name,user_password) VALUES(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			a = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return a;
	}
}
