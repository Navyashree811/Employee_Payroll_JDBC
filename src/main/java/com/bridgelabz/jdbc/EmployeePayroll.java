/*
 *UC2:- Ability for Employee_Payroll_Service to retrieve the EmployeePayroll from the database. 
 *
 * @author : Navaya Shree
 * @since : 9/15/2022
 */
package com.bridgelabz.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.sql.Connection;

public class EmployeePayroll {
	public static void main(String[] args) throws SQLException {

		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
		String userName = "root";
		String password = "1234";
		Statement stmt = null;
		Connection con = null;
		ResultSet rs = null;

		String qry = "select * from employee_payroll";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded");

			con = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connetion Establish with db server");

			stmt = con.createStatement();

			rs = stmt.executeQuery(qry);

			System.err.println("id-> " + "EmployeesName-> " + "mobileNumber-> " + "address-> " +  "gender-> " + " basic_pay-> " + "deductions-> " + "taxable_pay-> " + "tax-> " + "net_pay-> "
					+ "start");

			while (rs.next()) {
				int id = rs.getInt("EmpId");
				String EmployeesName = rs.getString(2);
				long mobileNumber = rs.getLong(3);
				String address = rs.getString(4);
				String gender = rs.getString(5);
				double basic_pay = rs.getDouble(6);
				double deductions = rs.getDouble(7);
				double taxable_pay = rs.getDouble(8);
				double tax = rs.getDouble(9);
				double net_pay = rs.getDouble(10);
				Date start = rs.getDate(11);

				System.out.println();

				System.out.println(id + "->" + EmployeesName + "->" + mobileNumber + "->" + address + "->" 
						+ "->"  + gender + "->"  + basic_pay + "->"  + deductions  + " ->" + taxable_pay  + "->" + tax  + "->"
						+ net_pay + "->" + start);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (stmt != null) {
				try {
					stmt.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}

	}
}
