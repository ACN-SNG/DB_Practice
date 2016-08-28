package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DBConnector {
	private static final String URL = "jdbc:mysql:"
			+ "//edwin.ce4c3z5mbudc.ap-southeast-1.rds.amazonaws.com:3306"
			+ "/edwin";
	private static final String USER = "edwin";
	private static final String PASS = "edwin12345";

	public Vector getUserData() {
		Statement st = null;
		ResultSet rs = null;
		Connection con = null;
		Vector users = new Vector();
		try {
			con = DriverManager.getConnection(URL, USER, PASS);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				Vector row = new Vector();
                row.add(rs.getString("name"));
                row.add(rs.getString("email"));
                row.add(rs.getString("nickname"));
                users.add(row);
			}
			con.close();
		} catch (SQLException sqex) {
			System.out.println("SQLException: " + 
									sqex.getMessage());
		}
		return users;
	}
}
