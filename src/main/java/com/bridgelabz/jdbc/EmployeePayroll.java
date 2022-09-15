/* * UC5:- Ability to retrieve all employees who have joined in a particular data range from the payroll service database .
 *
 * @author : Navaya Shree
 * @since : 9/15/2022
 */
package com.bridgelabz.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;

public class EmployeePayroll {
	static Connection con;

	public static void main(String[] args) throws Exception, SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String qry = "select * from employee_payroll where start between Cast('2020-01-01' as date) and date (now())";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Driver Class Loaded");

			con = ConnectionDB.createCP();

			System.out.println("Connetion Establish with db server");

			pstmt = con.prepareStatement(qry);
			System.out.println("Data Update");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				long phone_number = rs.getLong(3);
				String address = rs.getString(4);
				String gender = rs.getString(5);
				double basic_pay = rs.getDouble(6);
				double deductions = rs.getDouble(7);
				double taxable_pay = rs.getDouble(8);
				double tax = rs.getDouble(9);
				double met_pay = rs.getDouble(10);
				Date state = rs.getDate(11);

				System.out.println("EmpId :-" + id + "  " + "EmpName :- " + name + " " + "Emp_PhoneNo. :-"
						+ phone_number + " " + "EmpAddress :- " + address + " " + "Gender :- " + gender + " "
						+ "Basic_Pay " + basic_pay + " " + " Deduction :- " + deductions + " " + "Taxable_pay :- "
						+ taxable_pay + " " + "Tax :-" + tax + " " + "Met_Pay :- " + met_pay + " " + "Date :-" + state);
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
			if (pstmt != null) {
				try {
					pstmt.close();

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
			System.out.println("Closed All Resources");
		}

	}
}
