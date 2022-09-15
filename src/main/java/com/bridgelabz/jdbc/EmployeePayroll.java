/* UC6:- Ability to find sum, average, min, max and number of male and female employees .
 *
 * @author : Navaya Shree
 * @since : 9/15/2022
 */
package com.bridgelabz.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class EmployeePayroll {
	static Connection con;
	static Statement stmt;
	static ResultSet rs;

	public static void main(String[] args) throws Exception, SQLException {

		String qry = "select avg(basic_pay), sum(basic_pay), min(basic_pay), max(basic_pay) from employee_payroll where gender = 'F' group by gender; ";
		try {

			System.out.println("Driver Class Loaded");

			con = ConnectionDB.createCP();

			System.out.println("Connetion Establish with db server");

			stmt = con.createStatement();
			System.out.println("Data Update");

			rs = stmt.executeQuery(qry);

			while (rs.next()) {
				double sum = rs.getDouble(1);
				System.out.println("avgrage of basic_pay : " + sum);
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
			System.out.println("Closed All Resources");
		}
	}
}
