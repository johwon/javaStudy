package studentTest;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Employees implements Serializable{
	private int employeeId;    
	private String fisrtName;
	private String lastName;       
	private String email;          
	private String phoneNumber;           
	private Date hireDate;               
	private String jobId;       
	private double salary;                   
	private double commissiontPct;      
	private int managerId;              
	private int departmentId;


	public Employees(int employeeId, String fisrtName, String lastName, String email, String phoneNumber, Date hireDate,
			String jobId, double salary, double commissiontPct, int managerId, int departmentId) {
		super();
		this.employeeId = employeeId;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.commissiontPct = commissiontPct;
		this.managerId = managerId;
		this.departmentId = departmentId;
	}
	public Employees(int employeeId, String fisrtName, double salary) {
		super();
		this.employeeId = employeeId;
		this.fisrtName = fisrtName;
		this.salary = salary;
	}
	
	//getter, setter
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFisrtName() {
		return fisrtName;
	}
	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getCommissiontPct() {
		return commissiontPct;
	}
	public void setCommissiontPct(double commissiontPct) {
		this.commissiontPct = commissiontPct;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	//객체비교 equals
	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}
	@Override
	public boolean equals(Object obj) {
		Employees e = null;
		if(!(obj instanceof Employees)) {
			return false;
		}
		e = (Employees)obj;
		return this.employeeId == e.employeeId;
	}
	
	//toString
	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", fisrtName=" + fisrtName + ", salary=" + salary + "]";
	}

	
	
	
	
	
	
	
	
	
	
}

