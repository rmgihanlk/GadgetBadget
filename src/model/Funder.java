package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Funder {
		
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
	
	public String insertFunder(String FID, String amount, String details) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}

			String query = " insert into funder(`FID`,`amount`,`details`)  values (?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(1, FID);preparedStmt.setInt(1, 0);
			preparedStmt.setDouble(2, Double.parseDouble(amount));
			preparedStmt.setString(3, details);
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the funder.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String readFunders() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			output = "<table border='1'><tr><th>FID </th><th>amount</th>" + "<th>details</th>"
					+ "<th>Update</th><th>Remove</th></tr>";
			String query = "select * from funder";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String FID = rs.getString("FID");
				String amount = Double.toString(rs.getDouble("amount"));
				String details = rs.getString("details");

				output += "<tr><td>" + FID + "</td>";
				output += "<td>" + amount + "</td>";
				output += "<td>" + details + "</td>";

				output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
						+ "<td><form method='post' action='items.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
						+ "<input name='FID' type='hidden' value='" + FID + "'>" + "</form></td></tr>";
			}
			con.close();

			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateFunder(String FID, String amount, String details) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			String query = "UPDATE funder SET FID=?,amount=?,details=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(1, FID);
			preparedStmt.setDouble(2, Double.parseDouble(amount));
			preparedStmt.setString(3, details);
			
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteFunder(String FID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			String query = "delete from funder where FID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(1, FID);

			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
