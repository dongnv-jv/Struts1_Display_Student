package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import form.UserForm;
import utils.JDBCUtils;

public class UserAction extends MappingDispatchAction {

	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("addsuccess");
	}

	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Connection conn = JDBCUtils.getConnection();
		String password = null;
		String name = null;
		UserForm user = (UserForm) form;
		try {
			String sql = "SELECT * FROM user";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				name = rs.getString("name");
				password = rs.getString("password");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("loginfail");
		}

		if (name.equals(user.getName()) && password.equals(user.getPassword())) {
			return mapping.findForward("loginsuccess");
		} else
			return mapping.findForward("loginfail");
	}

	public ActionForward createUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Connection conn = JDBCUtils.getConnection();
		int a = 0;
		UserForm user = (UserForm) form;
		
		
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		try {
			String sql = "INSERT INTO user(name,password) VALUES(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			a = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("createfail");
		}
		if (a > 0) {
			return mapping.findForward("createsuccess");
		} else

			return mapping.findForward("createfail");

	}
}
