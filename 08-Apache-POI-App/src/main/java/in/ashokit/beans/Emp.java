package in.ashokit.beans;

public class Emp {

	private String empId;
	private String empName;
	private String empSalary;

	public Emp() {
		// TODO Auto-generated constructor stub
	}

	public Emp(String empId, String empName, String empSalary) {
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}

}
