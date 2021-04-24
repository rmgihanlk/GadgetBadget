package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Researcher {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf-db", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
 
	public String insertResearcher(String RID, String name, String address, String phone, String email) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}

			String query = " insert into researcher(`RID`,`name`,`address`,`phone`,`email`)  values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(1, RID);
			preparedStmt.setString(2, name);
			preparedStmt.setString(3, address);
			preparedStmt.setString(4, phone);
			preparedStmt.setString(5, email);

			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the researcher.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readResearchers() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			output = "<table border='1'><tr><th>Researcher Code</th><th>Researcher Name</th>"
					+ "<th>Researcher Address</th>" + "<th>Researcher phone</th>" + "<th>Researcher email</th>"
					+ "<th>Update</th><th>Remove</th></tr>";
			String query = "select * from researcher";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String RID = rs.getString("RID");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String email = rs.getString("email");

				output += "<tr><td>" + RID + "</td>";
				output += "<td>" + name + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + phone + "</td>";
				output += "<td>" + email + "</td>";

				output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
						+ "<td><form method='post' action='researcher.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
						+ "<input name='RID	' type='hidden' value='" + RID + "'>" + "</form></td></tr>";
			}
			con.close();

			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the researcher.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateResearcher(String RID, String name, String address, String phone, String email) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			String query = "UPDATE researcher SET name=?,address=?,phone=?,email=? WHERE RID	=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(1, name);
			preparedStmt.setString(2, address);
			preparedStmt.setString(3, phone);
			preparedStmt.setString(4, email);
			preparedStmt.setString(5, RID);

			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the researcher.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteResearcher(String RID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			String query = "delete from researcher where RID	=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(1, RID);

			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the researcher.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
