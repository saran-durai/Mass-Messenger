package com.srm.smsgateway;

import java.util.List;

import static com.srm.smsgateway.ReadExcel.readMobileData;
import static com.srm.smsgateway.ReadExcel.readTimesheetData;

public class Main {
	public static void main(String[] args) {
		String mobileNumberFile =  "Daily - Timesheet Reminder Report_Peak-2.xlsx";
		String timesheetFile = "Daily Floor Check Results.xlsx";

		List<Employee> mobileNumberList = readMobileData(mobileNumberFile);
		List<Employee> timesheetEmployeesList = readTimesheetData(timesheetFile);

		for (Employee tsEmployee : timesheetEmployeesList) {
			String msgContent;

			Employee mobilenumberEmployee = mobileNumberList.stream()
					.filter(mnEmployee -> (tsEmployee.getEmployeeId()).equals(mnEmployee.getEmployeeId()))
					.findAny()
					.orElse(null);

			if (mobilenumberEmployee == null) {
				continue;
			}

			System.out.print(tsEmployee.getEmployeeId());
			System.out.print("     ");

			System.out.print(tsEmployee.getEmployeeName());
			System.out.print("     ");

			System.out.print(mobilenumberEmployee.getMobileNumber());
			System.out.print("     ");

			System.out.print(tsEmployee.getSupervisor());
			System.out.println("     \n");

			msgContent = "Reminder -  Dear " + tsEmployee.getEmployeeName() + "  Please log into Costpoint and enter your time for today.  From " + tsEmployee.getSupervisor() + "  ";

			SmsSender.sendSMS(mobilenumberEmployee.getMobileNumber(), "<!-- twilio number --> ", msgContent);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}