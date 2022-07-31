package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import dao.StudentDAO;
import dao.UserDAO;
import form.StudentForm;
import form.UserForm;
import utils.JDBCUtils;
import utils.PostgresJDBCUtils;

public class UserAction extends MappingDispatchAction {
	public ActionForward addST(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			HttpSession session = request.getSession();
			UserForm user2 = (UserForm) session.getAttribute("check");
			if (user2.getName() == null && user2.getPassword() == null) {
				return mapping.findForward("login");
			}

		} catch (Exception e) {
			return mapping.findForward("login");
		}
		return mapping.findForward("addST");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			HttpSession session = request.getSession();
			UserForm user2 = (UserForm) session.getAttribute("check");
			if (user2.getName() == null && user2.getPassword() == null) {
				return mapping.findForward("login");
			}
			String sr = "wrong";
			StudentForm st = (StudentForm) form;
			StudentDAO stDao = new StudentDAO();
			int a = 0;
			try {
				a = stDao.addStudent(st);
				if (a > 0) {

					request.setAttribute("ac", sr);
					return mapping.findForward("addsuccess");
				} else
					request.setAttribute("sr", sr);
				return mapping.findForward("addfail");
			} catch (Exception e) {
				return mapping.findForward("addfail");

			}
		} catch (Exception e) {
			return mapping.findForward("login");
		}

	}

	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// Connection conn = JDBCUtils.getConnection();
		UserForm user = (UserForm) form;

//		try {
		HttpSession session = request.getSession();
//			UserForm user2 = (UserForm) session.getAttribute("check");
//			if (user2.getName() == null && user2.getPassword() == null) {

		String er = "Wrong Password or User";
		UserDAO userDAO = new UserDAO();
		if (userDAO.checkLogin(user)) {
			session.setAttribute("check", user);

			return mapping.findForward("loginsuccess");
		} else
			request.setAttribute("error", er);
		return mapping.findForward("loginfail");
//			} else
//				return mapping.findForward("loginsuccess");
//		} catch (Exception e) {
//			return mapping.findForward("loginfail");
//		}
	}

	public ActionForward loginSt(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// Connection conn = JDBCUtils.getConnection();
		String err = "wrong";
		Connection conn = PostgresJDBCUtils.getConnection();
		StudentForm student = (StudentForm) form;
		try {
			String sql = "SELECT * FROM struts_student WHERE st_id = ? AND st_password = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, student.getIdst());
			pstm.setString(2, student.getPassword());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				return mapping.findForward("loginsuccessStudent");
			} else
				request.setAttribute("errSt", err);
			return mapping.findForward("loginfailStudent");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errSt", err);
			return mapping.findForward("loginfailStudent");
		}
	}

	public ActionForward createUS(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			HttpSession session = request.getSession();
			UserForm user2 = (UserForm) session.getAttribute("check");
			if (user2.getName() == null && user2.getPassword() == null) {
				return mapping.findForward("login");
			}

		} catch (Exception e) {
			return mapping.findForward("login");
		}
		return mapping.findForward("createUS");
	}

	public ActionForward createUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			HttpSession session = request.getSession();
			UserForm user2 = (UserForm) session.getAttribute("check");
			if (user2.getName() == null && user2.getPassword() == null) {
				return mapping.findForward("login");
			} else {
				Connection conn = PostgresJDBCUtils.getConnection();
				int a = 0;
				UserForm user = (UserForm) form;
				String s = "success";
				try {
					String sql = "INSERT INTO struts_user(user_name,user_password) VALUES(?,?)";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setString(1, user.getName());
					pst.setString(2, user.getPassword());
					a = pst.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("fail", s);
					return mapping.findForward("createfail");
				}
				if (a > 0) {
					return mapping.findForward("createsuccess");
				} else
					request.setAttribute("fail", s);
				return mapping.findForward("createfail");
			}
		} catch (Exception e) {
			return mapping.findForward("login");
		}
	}

	public ActionForward showList(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			HttpSession session = request.getSession();
			UserForm user2 = (UserForm) session.getAttribute("check");
			if (user2.getName() == null && user2.getPassword() == null) {
				return mapping.findForward("login");
			}

			StudentDAO stDao = new StudentDAO();
			ArrayList<StudentForm> list = stDao.showListSt();

			for (StudentForm studentForm : list) {
				System.out.println(studentForm);
			}
			request.setAttribute("list", list);
			return mapping.findForward("showlist");
		} catch (Exception e) {
			return mapping.findForward("login");
		}
	}

	public ActionForward showStudent(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		StudentForm stform = (StudentForm) form;

		StudentDAO stDao = new StudentDAO();

		StudentForm st = stDao.showSt(stform.getIdst());
		System.out.println(st);
		request.setAttribute("st", st);
		return mapping.findForward("showstudent");

	}

	public ActionForward changePassword(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		StudentForm stform = (StudentForm) form;
		String pass = request.getParameter("pass");
		StudentDAO stDao = new StudentDAO();

		int a = stDao.changePassword(stform.getIdst(), pass);

		return mapping.findForward("chagesuccess");

	}

	public ActionForward Delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String id = request.getParameter("delete");
		String delete = " delete";
		// String id2= (String) request.getAttribute("deletest");
		StudentDAO stDao = new StudentDAO();

		int a = stDao.delete(id);
		if (a > 0) {
			request.setAttribute("del", delete);
		}
		return mapping.findForward("delete");

	}

}
