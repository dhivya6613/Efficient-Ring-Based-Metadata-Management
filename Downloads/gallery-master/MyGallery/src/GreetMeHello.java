
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

import database.AddImage;
import database.QuokkaDataLayer;

/**
 * 
 * @author rajasubs
 *	This is my first class in my web app 
 *	which performs a pilot run on my environment 
 *	and greet me at the end !
 */

/**
 * Reference
 * 
 * Link 0: https://community.jaspersoft.com/wiki/uninstall-mysql-mac-os-x
 * Link 1: https://beginnersbook.com/2017/07/how-to-create-and-run-servlet-in-eclipse-ide/
 * Link 2: https://crunchify.com/how-to-fix-java-lang-classnotfoundexception-org-springframework-web-servlet-dispatcherservlet-exception-spring-mvc-tomcat-and-404-error/
 * Link 3: https://stackoverflow.com/a/5775601/6680585
 * Link 4: https://dev.mysql.com/doc/refman/8.0/en/creating-ssl-rsa-files.html
 * 
 * mysql> desc MyImages;
+-------+--------------+------+-----+---------+-------+
| Field | Type         | Null | Key | Default | Extra |
+-------+--------------+------+-----+---------+-------+
| name  | varchar(100) | YES  |     | NULL    |       |
| image | mediumblob   | YES  |     | NULL    |       |
+-------+--------------+------+-----+---------+-------+
 
 * Note 1: Image data type is changed from Blob to Medium blob due to the size limitation since Blob data type can store max 65535 characters (65 KB approx).
 * So, changing this to mediumblob which can accomodate upto 16777215 (16MB).
 * Note 2: If you face any issue reg MySQL authentication then Link(4) should help.
 */

public class GreetMeHello extends HttpServlet {

	private String name;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
			QuokkaDataLayer quokka = new QuokkaDataLayer();
			quokka.readDataBase();
			out.println("Reading from database. " + quokka.resultSetString);
			
			//Invoke this for the first time only
			/*AddImage addImage = new AddImage();
			addImage.populateImageTable();
			System.out.println("Successfully populated image table !");*/
			
		} catch(Exception ex) {
			System.out.println("Unexpected exception here. Exception : " + ex);
		}
		out.println("<br> Rajasuba is a good girl :-P");
	}
}
