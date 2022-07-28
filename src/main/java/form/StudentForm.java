package form;

import org.apache.struts.action.ActionForm;

public class StudentForm extends ActionForm {
	private String idst;
	private String name;
	private String dayofbirth;
	private double gpa;
	private int year;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdst() {
		return idst;
	}

	public void setIdst(String idst) {
		this.idst = idst;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDayofbirth() {
		return dayofbirth;
	}

	public void setDayofbirth(String dayofbirth) {
		this.dayofbirth = dayofbirth;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "StudentForm [idst=" + idst + ", name=" + name + ", dayofbirth=" + dayofbirth + ", gpa=" + gpa
				+ ", year=" + year + "]";
	}

}
