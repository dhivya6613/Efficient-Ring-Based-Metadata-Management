package database;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Class for adding image from local machine's folder
 * 
 * Ideally this has to be moved to a separate class
 * And this has to be provided as a feature/option for the user to add image 
 */
public class AddImage {

	Connection con;
	String imageRepo;
	
	public AddImage() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/dhivya","root","");		
			imageRepo = "/Users/rajasubs/Desktop/image_files/";
		} catch(Exception ex) {
			System.out.println("Exception while creating mysql connection. Exception : " + ex);
		}
	}
	public void populateImageTable() {
		try{
			addImage("cat");
			addImage("dog");
			addImage("quokka");
			
			closeConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void addImage(String name) {
		try {
			
			// Here local file system is considered as the input/upload point for image
			// Ideally this freedom has to be given to the user. Like we should have an upload 
			// option in our web page which should ideally allow user to upload an image. 
			
			File file=new File(imageRepo + name + ".jpg");
			FileInputStream fis=new FileInputStream(file);

			PreparedStatement ps=con.prepareStatement("insert into MyImages(name,image) values(?,?)"); 
			
			System.out.println("Name len : " + name.length() + " File len : " + file.length());
			
			ps.setString(1, name);
			ps.setBinaryStream(2,fis,(int)file.length());
			ps.executeUpdate();

			ps.close();
			fis.close();
		} catch(Exception ex) {
			System.out.println("Exception while adding image to database. Exception : " + ex);
		}
	}
	public void closeConnection() {
		try {
			con.close();
		} catch(Exception ex) {
			System.out.println("Exception while clearing the resources.");
		}
	}
}
