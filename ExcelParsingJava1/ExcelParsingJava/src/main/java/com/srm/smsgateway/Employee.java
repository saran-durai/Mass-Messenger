package com.srm.smsgateway;


public class Employee {

	private String employeeId;
	private String employeeName;
	private String employeeNameId;
	private String mobileNumber;
	private String supervisor;
	private String timesheetStatus;
	private String smsStatus;

	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getEmployeeNameId() {
		return employeeNameId;
	}

	public void setEmployeeNameId(String employeeNameId) {
		this.employeeNameId = employeeNameId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getTimesheetStatus() {
		return timesheetStatus;
	}

	public void setTimesheetStatus(String timesheetStatus) {
		this.timesheetStatus = timesheetStatus;
	}

	public String getSmsStatus() {
		return smsStatus;
	}

	public void setSmsStatus(String smsStatus) {
		this.smsStatus = smsStatus;
	}

	public Employee(String id,String name, String mobile){
		this.employeeId = id;
		this.employeeName = name;
		this.employeeNameId = "";
		this.mobileNumber = mobile;
		this.supervisor = "";
		this.timesheetStatus = "";
		this.smsStatus = "";
	}

	public Employee(String id, String name, String nameId, String supervisor){
		this.employeeId = id;
		this.employeeName = name;
		this.employeeNameId = nameId;
		this.mobileNumber = "";
		this.supervisor = supervisor;
		this.timesheetStatus = "missing";
		this.smsStatus = "pending";
	}
	
	@Override
    public boolean equals(Object obj) 
    { 
          
    // if both the object references are  
    // referring to the same object. 
    if(this == obj) 
            return true; 
          
        // if(!(obj instanceof Employee)) return false; ---> avoid. 
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
          
        // type casting of the argument.  
        Employee employee = (Employee) obj; 
          
        // comparing the state of argument with  
        // the state of 'this' Object. 
        return (employee.employeeId == this.employeeId); 
    } 
      
    @Override
    public int hashCode() 
    {
        return this.employeeId.hashCode(); 
    }
	
	@Override
	public String toString(){
		return employeeId + "::" + employeeName + "::" + mobileNumber  + "::" + employeeNameId + "::" + supervisor;
	}
	
}
