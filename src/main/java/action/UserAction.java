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

	public ActionForward addStudent(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		request.setAttribute("didDisplayAdd", "displayAdd");
		if (session.getAttribute("hasUser") == null) {
			return mapping.findForward("loginReturn");
		}

		StudentForm st = (StudentForm) form;
		StudentDAO stDao = new StudentDAO();

		if (st.getIdst() == null || st.getName() == null) {
			st.setIdst(null);
			st.setName(null);
			st.setDayofbirth(null);
			st.setGpa(0);
			st.setYear(0);
			request.setAttribute("statusAdd", "prepareAdd");

			return mapping.findForward("addsuccess");
		} else {

			int a = stDao.addStudent(st);
			st.setIdst(null);
			st.setName(null);
			st.setDayofbirth(null);
			st.setGpa(0);
			st.setYear(0);
			if (a > 0) {
				request.setAttribute("statusAdd", "Addsuccess");
			} else {
				request.setAttribute("statusAdd", "Addfail");
			}
			return mapping.findForward("addsuccess");
		}
	}

	public ActionForward loginAdmin(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm user = (UserForm) form;
		HttpSession session = request.getSession();
		String didLogin = "Wrong Password or User";
		UserDAO userDAO = new UserDAO();
		if (userDAO.checkLogin(user)) {
			session.setAttribute("hasUser", user);
			return mapping.findForward("loginsuccess");
		} else
			request.setAttribute("didLogin", didLogin);
		return mapping.findForward("loginfail");
	}

	public ActionForward loginStudent(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String didLoginSt = "wrong username or pasword";
		StudentForm student = (StudentForm) form;
		StudentDAO stdao = new StudentDAO();

		if (stdao.checkLoginSt(student)) {
			session.setAttribute("isLoggedIn", student);

			return mapping.findForward("loginsuccessStudent");
		} else
			request.setAttribute("didLoginSt", didLoginSt);
		return mapping.findForward("loginfailStudent");

	}

	public ActionForward createUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("hasUser") == null) {
			return mapping.findForward("loginReturn");
		}
		UserForm user = (UserForm) form;
		int a = 0;
		String didCreateUser = "didCreateUser";
		UserDAO userDAO = new UserDAO();
		a = userDAO.createUser(user);
		if (a > 0) {
			return mapping.findForward("createsuccess");
		} else
			request.setAttribute("didCreateUser", didCreateUser);
		return mapping.findForward("createfail");
	}

	public ActionForward showList(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("hasUser") == null) {
			return mapping.findForward("loginReturn");
		}
		StudentDAO stDao = new StudentDAO();
		ArrayList<StudentForm> list = stDao.showListSt();
		request.setAttribute("list", list);
		return mapping.findForward("showlist");
	}

	public ActionForward showStudent(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		if (session.getAttribute("isLoggedIn") == null) {
			return mapping.findForward("loginReturn");
		}
		StudentForm stform = (StudentForm) form;
		StudentDAO stDao = new StudentDAO();
		StudentForm studentShowById = stDao.showSt(stform.getIdst());
		request.setAttribute("studentShowById", studentShowById);
		return mapping.findForward("showstudent");
	}

	public ActionForward changePasswordStudent(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		request.setAttribute("didChange", "didChange");
		if (session.getAttribute("isLoggedIn") == null) {
			return mapping.findForward("loginReturn");
		}
		StudentForm stform = (StudentForm) form;
		String pass = request.getParameter("pass");
		StudentDAO stDao = new StudentDAO();
		String statusChange = "Change Password Fail !";

		if (request.getParameter("pass") == null) {
			return mapping.findForward("changeSuccess");
		} else {
			int a = stDao.changePassword(stform.getIdst(), pass);
			return mapping.findForward("changeSuccess");
		}

	}

	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String idStudentForDelete = request.getParameter("delete");
		String statusDelete = " Delete Success";
		StudentDAO stDao = new StudentDAO();
		int a = 0;
		a = stDao.delete(idStudentForDelete);
		if (a != 0) {
			request.setAttribute("statusDelete", statusDelete);
		}
		return mapping.findForward("deleteSuccess");

	}

	public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		session.removeAttribute("hasUser");
		return mapping.findForward("logout");

	}

	public ActionForward logoutSt(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		session.removeAttribute("isLoggedIn");
		return mapping.findForward("logoutSt");

	}

	// Test branch develop_responsive
	public ActionForward checklogin(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String checklogin = request.getParameter("Admin");

		if (checklogin.equals("Admin")) {
			request.setAttribute("checklogin", "Admin");
		} else {

			request.setAttribute("checklogin", "Student");

		}
		return mapping.findForward("checklogin");
	}

}
