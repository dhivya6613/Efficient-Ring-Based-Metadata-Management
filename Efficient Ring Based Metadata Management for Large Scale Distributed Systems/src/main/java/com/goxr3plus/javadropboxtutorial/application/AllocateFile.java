package main.java.com.goxr3plus.javadropboxtutorial.application;
import java.io.*;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;
import com.dropbox.core.v2.users.DbxUserUsersRequests;

public class AllocateFile {
	public static void uploadfiles(File file,DbxClientV2 client,String filename) {
		  
		 
		 try (InputStream in = new FileInputStream(file)) {
	            try {
	            	try {
	        		      FileWriter myWriter = new FileWriter("/Users/chutki/Documents/project_7th_sem/Upload_details.txt");
	        		      myWriter.write("allocated successfully ");
	    		    }catch (IOException e) {
	        		      System.out.println("An error occurred.");
	        		      e.printStackTrace();
	        		    }
					FileMetadata metadata = client.files().uploadBuilder("/"+filename+".txt")
					    .uploadAndFinish(in);
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        } catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch(SecurityException e1) {
				e1.printStackTrace();
			}
		 catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
}
}
