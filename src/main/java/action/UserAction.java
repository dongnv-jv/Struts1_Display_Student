package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import dao.StudentDAO;
import form.StudentForm;
import form.UserForm;
import utils.JDBCUtils;

public class UserAction extends MappingDispatchAction {

	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		StudentForm st = (StudentForm) form;
		StudentDAO stDao = new StudentDAO();
		int a = 0;
		try {
			a = stDao.addStudent(st);
			if (a > 0) {
				return mapping.findForward("addsuccess");
			} else
				return mapping.findForward("addfail");
		} catch (Exception e) {
			return mapping.findForward("addfail");

		}

	}

	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Connection conn = JDBCUtils.getConnection();

		UserForm user = (UserForm) form;
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		try {
			String sql = "SELECT * FROM user WHERE name = ? AND password = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getPassword());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				return mapping.findForward("loginsuccess");
			} else
				return mapping.findForward("loginfail");
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("loginfail");
		}
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
	public ActionForward showList(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		StudentDAO stDao = new StudentDAO();
		ArrayList<StudentForm> list=stDao.showListSt();
		request.setAttribute("list", list);
		
		
		return mapping.findForward("showlist");

	}
}
