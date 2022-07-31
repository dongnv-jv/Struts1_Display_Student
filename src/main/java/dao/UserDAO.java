package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
