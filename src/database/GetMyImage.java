package database;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;

import javax.imageio.ImageIO;

public class GetMyImage extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/dhivya","root","");
			String name = request.getParameter("name");
			
			byte b[];
			Blob blob;
			
			System.out.println("Going to fetch image : " + name);
			PreparedStatement ps=con.prepareStatement("select * from MyImages where name= \"" + name + "\""); 
			ResultSet rs=ps.executeQuery();
			
			response.setContentType("image/jpg");

			while(rs.next()){
				System.out.println("Entering here to write image");
				blob=rs.getBlob("image");
				b=blob.getBytes(1,(int)blob.length());

				response.getOutputStream().write(b);
			}
			
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
