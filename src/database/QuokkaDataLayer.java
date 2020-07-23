package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Driver;

public class QuokkaDataLayer {
	private Connection connect = null;
	private ResultSet resultSet = null;

	public String resultSetString;

	public String readDataBase() throws Exception {
		try {        	
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/dhivya?user=root");
			resultSet = connect.createStatement().executeQuery("select * from dhivya.quokka");
			printResultSet(resultSet);
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
		return resultSetString;
	}
	private void printResultSet(ResultSet resultSet) {
		try {
			while (resultSet.next()) {        	
				String name = resultSet.getString("name");
				String age = resultSet.getString("age");
				System.out.println("Name: " + name);
				System.out.println("Age: " + age);

				resultSetString = "Name : " + name + " Age : " + age;
			}
		} catch(Exception ex) {
			System.out.println("Exception is :" +ex);
		}
	}
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			System.out.println("Exception while closing the allocated resources. Exception : " + e);
		}
	}
}