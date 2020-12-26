package main.java.com.goxr3plus.javadropboxtutorial.application;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;
import com.dropbox.core.v2.users.DbxUserUsersRequests;

public class FrequencyBasedAllocation {
	private static final String ACCESS_TOKEN1 = "GH6xzgdI8aQAAAAAAAAAAd-u2G4me0LW2fzcb7QcoWglR6pFIFQ1loDaI7KkmIEW";//dhivya
	private static final String ACCESS_TOKEN2 = "D7inr2YAdVoAAAAAAAAAAR2QgfEi4gr3jra7C-hzp1l1SJi7uEBKXRFAyLAjWGbm";//nithya
	private static final String ACCESS_TOKEN3 = "sl.Aj3NKIUatENPWxWVZyUK1-J4h4QzmMY_VGOdnjkUd5oJ4yNOndjby_-0wPdgZuNs8aVKUCKNgZ-75I-lAULJWFkjTS4mRKVyY0kVz454K_cMwqO9vVBJartEgQym4ScTm00YaoI";//sangavi
	private static final String ACCESS_TOKEN4 = "Xy9h1n5XlmQAAAAAAAAAAf403xn2zo9S_3UD5BJ95dQdwP8fvIBdjlxV1vXIseK8";//siva
	private static final String ACCESS_TOKEN5 = "sl.AoGbbZwSpXgslgDaiWkqMqmou_uMSAIb9DntqV34WRe83G00XcYW7GI7FvXKwRIdqET0ClwpWkIFvWZbkODlfVz3Tf3XeL666ASm5lieWyObAmBMXBNHbr9xEvEaatqXB89FZ5w";//durgadevi
	
	static DbxRequestConfig config1 = new DbxRequestConfig("dropbox/dhivya123");
	static DbxRequestConfig config2 = new DbxRequestConfig("dropbox/MDmanage");
	static DbxRequestConfig config3 = new DbxRequestConfig("dropbox/MiniPro");
	static DbxRequestConfig config4 = new DbxRequestConfig("dropbox/karnan");
	static DbxRequestConfig config5 = new DbxRequestConfig("dropbox/Asnii");
	
	
	static FileOutputStream fos = null;
    static File file;
    
	public static void anglecut_implementation(String main_dir_path,int load_factor,int servers) {
		 File maindir = new File(main_dir_path); 
        
	        if(maindir.exists() && maindir.isDirectory()) 
	        { 
	            
	             File arr[] = maindir.listFiles(); 
	             traverse(arr,0,0,0,load_factor,servers);
	        }
	       
	}
	static void traverse(File[] arr,int index,int level,int count,int load_factor,int servers)  
    { 
        // terminate condition 
        if(index == arr.length) 
            return; 
          
        // tabs for internal levels 
        for (int i = 0; i < level; i++) 
            System.out.print("\t"); 
          
        // for files 
        if(arr[index].isFile()) {
        	if(arr[index].getName().equals(".DS_Store")==false) {
        		allocate(arr[index],arr[index].getName(),load_factor,servers,count);
        		
        	}
            
        }
        // for sub-directories 
        else if(arr[index].isDirectory()) 
        { 
        	if(arr[index].getName().equals(".DS_Store")==false) {
        		allocate(arr[index],arr[index].getName(),load_factor,servers,count);
        	}
            
            traverse(arr[index].listFiles(), 0, level + 1,count++,load_factor,servers); 
        } 
        traverse(arr,++index, level,count++,load_factor,servers); 
   } 
	 public static int getfiles(int max){
	     int min=max-15;
	    return (int) ((Math.random() * (max - min)) + min);
	}
	 public static int load_balancing_factor(){
	     int min=87;
	     int max=91;
	     
	    return (int) ((Math.random() * (max - min)) + min);
	}
	 public static int hopcount(){
	     int min=3;
	     int max=4;
	     
	    return (int) ((Math.random() * (max - min)) + min);
	}
	public static void allocate(File file,String name,int load_factor,int servers,int count) {
		 if(servers==2) {
		    	if(count<load_factor) {
		    		try {
		    			
		    			DbxClientV2 client;
		    			client = new DbxClientV2(config1, ACCESS_TOKEN1);
		    			FullAccount account;
		    			DbxUserUsersRequests r1 = client.users();
		    			account = r1.getCurrentAccount();
		    			
		    			
		    		    AllocateFile alloc=new AllocateFile();
		    		    
		    		    try {
		              	  file = new File("/Users/chutki/Documents/project_7th_sem/upload_details.txt");
		            	  fos = new FileOutputStream(file,true);
		            	  if (!file.exists()) {
		            	     file.createNewFile();
		            	  }
		            	  String temp_filename="filename :"+file+"\n"+" allocated to  "+account.getName().getDisplayName();
		            	  byte[] bytesArray = temp_filename.getBytes();
		            	  byte[] bytesArray1 = "\n".getBytes();
		            	  fos.write(bytesArray);
		            	  fos.write(bytesArray1);
		            	  fos.flush();
		            	
		                   } 
		                   catch (IOException ioe) {
		                  	 ioe.printStackTrace();
		                   } 
		    		
		    		    AllocateFile.uploadfiles(file, client, name);
		    		} catch (DbxException ex1) {
		    			ex1.printStackTrace();
		    		}
		    		
		    	}
		    	else {
		    		try {
		    			
		    			DbxClientV2 client;
		    			client = new DbxClientV2(config2, ACCESS_TOKEN2);
		    			FullAccount account;
		    			DbxUserUsersRequests r1 = client.users();
		    			account = r1.getCurrentAccount();
		    			//System.out.println(account.getName().getDisplayName());
		    			
		    		    AllocateFile alloc=new AllocateFile();
		    		    
		    		          try {
			              	  file = new File("/Users/chutki/Documents/project_7th_sem/upload_details.txt");
			            	  fos = new FileOutputStream(file,true);
			            	  if (!file.exists()) {
			            	     file.createNewFile();
			            	  }
			            	  String temp_filename="filename :"+file+"\n"+" allocated to  "+account.getName().getDisplayName();
			            	  byte[] bytesArray = temp_filename.getBytes();
			            	  byte[] bytesArray1 = "\n".getBytes();
			            	  fos.write(bytesArray);
			            	  fos.write(bytesArray1);
			            	  fos.flush();
			            	
			                   } 
			                   catch (IOException ioe) {
			                  	 ioe.printStackTrace();
			                   } 
			    		
		    		
		    		    AllocateFile.uploadfiles(file, client, name);
		    		} catch (DbxException ex1) {
		    			ex1.printStackTrace();
		    		}
		    		
		    	}
		    }
		 else if(servers==3) {
			 if(count<load_factor) {
				 try {
		    			
		    			DbxClientV2 client;
		    			client = new DbxClientV2(config1, ACCESS_TOKEN1);
		    			FullAccount account;
		    			DbxUserUsersRequests r1 = client.users();
		    			account = r1.getCurrentAccount();
		    			//System.out.println(account.getName().getDisplayName());
		    			
		    		    AllocateFile alloc=new AllocateFile();
		    		    
		    		    try {
			              	  file = new File("/Users/chutki/Documents/project_7th_sem/upload_details.txt");
			            	  fos = new FileOutputStream(file,true);
			            	  if (!file.exists()) {
			            	     file.createNewFile();
			            	  }
			            	  String temp_filename="filename :"+file+"\n"+" allocated to  "+account.getName().getDisplayName();
			            	  byte[] bytesArray = temp_filename.getBytes();
			            	  byte[] bytesArray1 = "\n".getBytes();
			            	  fos.write(bytesArray);
			            	  fos.write(bytesArray1);
			            	  fos.flush();
			            	
			                   } 
			                   catch (IOException ioe) {
			                  	 ioe.printStackTrace();
			                   } 
			    		
		    		
		    		    AllocateFile.uploadfiles(file, client, name);
		    		} catch (DbxException ex1) {
		    			ex1.printStackTrace();
		    		}
			 }
			 else if(count<2*load_factor) {
				 try {
		    			
		    			DbxClientV2 client;
		    			client = new DbxClientV2(config2, ACCESS_TOKEN2);
		    			FullAccount account;
		    			DbxUserUsersRequests r1 = client.users();
		    			account = r1.getCurrentAccount();
		    			//System.out.println(account.getName().getDisplayName());
		    			
		    		    AllocateFile alloc=new AllocateFile();
		    		    
		    		    try {
			              	  file = new File("/Users/chutki/Documents/project_7th_sem/upload_details.txt");
			            	  fos = new FileOutputStream(file,true);
			            	  if (!file.exists()) {
			            	     file.createNewFile();
			            	  }
			            	  String temp_filename="filename :"+file+"\n"+" allocated to  "+account.getName().getDisplayName();
			            	  byte[] bytesArray = temp_filename.getBytes();
			            	  byte[] bytesArray1 = "\n".getBytes();
			            	  fos.write(bytesArray);
			            	  fos.write(bytesArray1);
			            	  fos.flush();
			            	
			                   } 
			                   catch (IOException ioe) {
			                  	 ioe.printStackTrace();
			                   } 
			    		
		    		   
		    		
		    		    AllocateFile.uploadfiles(file, client, name);
		    		} catch (DbxException ex1) {
		    			ex1.printStackTrace();
		    		}
			 }
			 else{
				 try {
		    			
		    			DbxClientV2 client;
		    			client = new DbxClientV2(config3, ACCESS_TOKEN3);
		    			FullAccount account;
		    			DbxUserUsersRequests r1 = client.users();
		    			account = r1.getCurrentAccount();
		    			//System.out.println(account.getName().getDisplayName());
		    			
		    		    AllocateFile alloc=new AllocateFile();
		    		    
		    		    try {
			              	  file = new File("/Users/chutki/Documents/project_7th_sem/upload_details.txt");
			            	  fos = new FileOutputStream(file,true);
			            	  if (!file.exists()) {
			            	     file.createNewFile();
			            	  }
			            	  String temp_filename="filename :"+file+"\n"+" allocated to  "+account.getName().getDisplayName();
			            	  byte[] bytesArray = temp_filename.getBytes();
			            	  byte[] bytesArray1 = "\n".getBytes();
			            	  fos.write(bytesArray);
			            	  fos.write(bytesArray1);
			            	  fos.flush();
			            	
			                   } 
			                   catch (IOException ioe) {
			                  	 ioe.printStackTrace();
			                   } 
			    		
		    		
		    		    AllocateFile.uploadfiles(file, client, name);
		    		} catch (DbxException ex1) {
		    			ex1.printStackTrace();
		    		}
			 }
			 
		  }
		 else if(servers==4) {
			 if(count<load_factor) {
				 try {
		    			
		    			DbxClientV2 client;
		    			client = new DbxClientV2(config1, ACCESS_TOKEN1);
		    			FullAccount account;
		    			DbxUserUsersRequests r1 = client.users();
		    			account = r1.getCurrentAccount();
		    			//System.out.println(account.getName().getDisplayName());
		    			
		    		    AllocateFile alloc=new AllocateFile();
		    		    
		    		    try {
			              	  file = new File("/Users/chutki/Documents/project_7th_sem/upload_details.txt");
			            	  fos = new FileOutputStream(file,true);
			            	  if (!file.exists()) {
			            	     file.createNewFile();
			            	  }
			            	  String temp_filename="filename :"+file+"\n"+" allocated to  "+account.getName().getDisplayName();
			            	  byte[] bytesArray = temp_filename.getBytes();
			            	  byte[] bytesArray1 = "\n".getBytes();
			            	  fos.write(bytesArray);
			            	  fos.write(bytesArray1);
			            	  fos.flush();
			            	
			                   } 
			                   catch (IOException ioe) {
			                  	 ioe.printStackTrace();
			                   } 
			    		
		    		
		    		    AllocateFile.uploadfiles(file, client, name);
		    		} catch (DbxException ex1) {
		    			ex1.printStackTrace();
		    		}
			 }
			 else if(count<2*load_factor) {
				 try {
		    			
		    			DbxClientV2 client;
		    			client = new DbxClientV2(config2, ACCESS_TOKEN2);
		    			FullAccount account;
		    			DbxUserUsersRequests r1 = client.users();
		    			account = r1.getCurrentAccount();
		    			//System.out.println(account.getName().getDisplayName());
		    			
		    		    AllocateFile alloc=new AllocateFile();
		    		    
		    		    try {
			              	  file = new File("/Users/chutki/Documents/project_7th_sem/upload_details.txt");
			            	  fos = new FileOutputStream(file,true);
			            	  if (!file.exists()) {
			            	     file.createNewFile();
			            	  }
			            	  String temp_filename="filename :"+file+"\n"+" allocated to  "+account.getName().getDisplayName();
			            	  byte[] bytesArray = temp_filename.getBytes();
			            	  byte[] bytesArray1 = "\n".getBytes();
			            	  fos.write(bytesArray);
			            	  fos.write(bytesArray1);
			            	  fos.flush();
			            	
			                   } 
			                   catch (IOException ioe) {
			                  	 ioe.printStackTrace();
			                   } 
			    		
		    		
		    		    AllocateFile.uploadfiles(file, client, name);
		    		} catch (DbxException ex1) {
		    			ex1.printStackTrace();
		    		}
			 }
			 else if(count<3*load_factor){
				 try {
		    			
		    			DbxClientV2 client;
		    			client = new DbxClientV2(config3, ACCESS_TOKEN3);
		    			FullAccount account;
		    			DbxUserUsersRequests r1 = client.users();
		    			account = r1.getCurrentAccount();
		    			//System.out.println(account.getName().getDisplayName());
		    			
		    		    AllocateFile alloc=new AllocateFile();
		    		    
		    		    try {
			              	  file = new File("/Users/chutki/Documents/project_7th_sem/upload_details.txt");
			            	  fos = new FileOutputStream(file,true);
			            	  if (!file.exists()) {
			            	     file.createNewFile();
			            	  }
			            	  String temp_filename="filename :"+file+"\n"+" allocated to  "+account.getName().getDisplayName();
			            	  byte[] bytesArray = temp_filename.getBytes();
			            	  byte[] bytesArray1 = "\n".getBytes();
			            	  fos.write(bytesArray);
			            	  fos.write(bytesArray1);
			            	  fos.flush();
			            	
			                   } 
			                   catch (IOException ioe) {
			                  	 ioe.printStackTrace();
			                   } 
			    		
		    		
		    		    AllocateFile.uploadfiles(file, client, name);
		    		} catch (DbxException ex1) {
		    			ex1.printStackTrace();
		    		}
			 }
			 else {
				 try {
		    			
		    			DbxClientV2 client;
		    			client = new DbxClientV2(config4, ACCESS_TOKEN4);
		    			FullAccount account;
		    			DbxUserUsersRequests r1 = client.users();
		    			account = r1.getCurrentAccount();
		    			//System.out.println(account.getName().getDisplayName());
		    			
		    		    AllocateFile alloc=new AllocateFile();
		    		    try {
			              	  file = new File("/Users/chutki/Documents/project_7th_sem/upload_details.txt");
			            	  fos = new FileOutputStream(file,true);
			            	  if (!file.exists()) {
			            	     file.createNewFile();
			            	  }
			            	  String temp_filename="filename :"+file+"\n"+" allocated to  "+account.getName().getDisplayName();
			            	  byte[] bytesArray = temp_filename.getBytes();
			            	  byte[] bytesArray1 = "\n".getBytes();
			            	  fos.write(bytesArray);
			            	  fos.write(bytesArray1);
			            	  fos.flush();
			            	
			                   } 
			                   catch (IOException ioe) {
			                  	 ioe.printStackTrace();
			                   } 
			    		
		    		    
		    		   
		    		
		    		    AllocateFile.uploadfiles(file, client, name);
		    		} catch (DbxException ex1) {
		    			ex1.printStackTrace();
		    		}
			 }
			 
		  }
		 else if(servers==5) {
			 if(count<load_factor) {
				 try {
		    			
		    			DbxClientV2 client;
		    			client = new DbxClientV2(config1, ACCESS_TOKEN1);
		    			FullAccount account;
		    			DbxUserUsersRequests r1 = client.users();
		    			account = r1.getCurrentAccount();
		    			//System.out.println(account.getName().getDisplayName());
		    			
		    		    AllocateFile alloc=new AllocateFile();
		    		    try {
			              	  file = new File("/Users/chutki/Documents/project_7th_sem/upload_details.txt");
			            	  fos = new FileOutputStream(file,true);
			            	  if (!file.exists()) {
			            	     file.createNewFile();
			            	  }
			            	  String temp_filename="filename :"+file+"\n"+" allocated to  "+account.getName().getDisplayName();
			            	  byte[] bytesArray = temp_filename.getBytes();
			            	  byte[] bytesArray1 = "\n".getBytes();
			            	  fos.write(bytesArray);
			            	  fos.write(bytesArray1);
			            	  fos.flush();
			            	
			                   } 
			                   catch (IOException ioe) {
			                  	 ioe.printStackTrace();
			                   } 
			    		
		    		    
		    		   
		    		
		    		    AllocateFile.uploadfiles(file, client, name);
		    		} catch (DbxException ex1) {
		    			ex1.printStackTrace();
		    		}
			 }
			 else if(count<2*load_factor) {
				 try {
		    			
		    			DbxClientV2 client;
		    			client = new DbxClientV2(config2, ACCESS_TOKEN2);
		    			FullAccount account;
		    			DbxUserUsersRequests r1 = client.users();
		    			account = r1.getCurrentAccount();
		    			//System.out.println(account.getName().getDisplayName());
		    			
		    		    AllocateFile alloc=new AllocateFile();
		    		    
		    		    try {
			              	  file = new File("/Users/chutki/Documents/project_7th_sem/upload_details.txt");
			            	  fos = new FileOutputStream(file,true);
			            	  if (!file.exists()) {
			            	     file.createNewFile();
			            	  }
			            	  String temp_filename="filename :"+file+"\n"+" allocated to  "+account.getName().getDisplayName();
			            	  byte[] bytesArray = temp_filename.getBytes();
			            	  byte[] bytesArray1 = "\n".getBytes();
			            	  fos.write(bytesArray);
			            	  fos.write(bytesArray1);
			            	  fos.flush();
			            	
			                   } 
			                   catch (IOException ioe) {
			                  	 ioe.printStackTrace();
			                   } 
			    		
		    		
		    		    AllocateFile.uploadfiles(file, client, name);
		    		} catch (DbxException ex1) {
		    			ex1.printStackTrace();
		    		}
			 }
			 else if(count<3*load_factor){
				 try {
		    			
		    			DbxClientV2 client;
		    			client = new DbxClientV2(config3, ACCESS_TOKEN3);
		    			FullAccount account;
		    			DbxUserUsersRequests r1 = client.users();
		    			account = r1.getCurrentAccount();
		    			//System.out.println(account.getName().getDisplayName());
		    			
		    		    AllocateFile alloc=new AllocateFile();
		    		    
		    		    try {
			              	  file = new File("/Users/chutki/Documents/project_7th_sem/upload_details.txt");
			            	  fos = new FileOutputStream(file,true);
			            	  if (!file.exists()) {
			            	     file.createNewFile();
			            	  }
			            	  String temp_filename="filename :"+file+"\n"+" allocated to  "+account.getName().getDisplayName();
			            	  byte[] bytesArray = temp_filename.getBytes();
			            	  byte[] bytesArray1 = "\n".getBytes();
			            	  fos.write(bytesArray);
			            	  fos.write(bytesArray1);
			            	  fos.flush();
			            	
			                   } 
			                   catch (IOException ioe) {
			                  	 ioe.printStackTrace();
			                   } 
			    		
		    		
		    		    AllocateFile.uploadfiles(file, client, name);
		    		} catch (DbxException ex1) {
		    			ex1.printStackTrace();
		    		}
			 }
			 else if(count<4*load_factor){
				 try {
		    			
		    			DbxClientV2 client;
		    			client = new DbxClientV2(config4, ACCESS_TOKEN4);
		    			FullAccount account;
		    			DbxUserUsersRequests r1 = client.users();
		    			account = r1.getCurrentAccount();
		    			//System.out.println(account.getName().getDisplayName());
		    			
		    		    AllocateFile alloc=new AllocateFile();
		    		    
		    		    try {
			              	  file = new File("/Users/chutki/Documents/project_7th_sem/upload_details.txt");
			            	  fos = new FileOutputStream(file,true);
			            	  if (!file.exists()) {
			            	     file.createNewFile();
			            	  }
			            	  String temp_filename="filename :"+file+"\n"+" allocated to  "+account.getName().getDisplayName();
			            	  byte[] bytesArray = temp_filename.getBytes();
			            	  byte[] bytesArray1 = "\n".getBytes();
			            	  fos.write(bytesArray);
			            	  fos.write(bytesArray1);
			            	  fos.flush();
			            	
			                   } 
			                   catch (IOException ioe) {
			                  	 ioe.printStackTrace();
			                   } 
			    		
		    		
		    		    AllocateFile.uploadfiles(file, client, name);
		    		} catch (DbxException ex1) {
		    			ex1.printStackTrace();
		    		}
			 }
			 else {
				 try {
		    			
		    			DbxClientV2 client;
		    			client = new DbxClientV2(config5, ACCESS_TOKEN5);
		    			FullAccount account;
		    			DbxUserUsersRequests r1 = client.users();
		    			account = r1.getCurrentAccount();
		    			//System.out.println(account.getName().getDisplayName());
		    			
		    		    AllocateFile alloc=new AllocateFile();
		    		    
		    		    try {
			              	  file = new File("/Users/chutki/Documents/project_7th_sem/upload_details.txt");
			            	  fos = new FileOutputStream(file,true);
			            	  if (!file.exists()) {
			            	     file.createNewFile();
			            	  }
			            	  String temp_filename="filename :"+file+"\n"+" allocated to  "+account.getName().getDisplayName();
			            	  byte[] bytesArray = temp_filename.getBytes();
			            	  byte[] bytesArray1 = "\n".getBytes();
			            	  fos.write(bytesArray);
			            	  fos.write(bytesArray1);
			            	  fos.flush();
			            	
			                   } 
			                   catch (IOException ioe) {
			                  	 ioe.printStackTrace();
			                   } 
			    		
		    		
		    		    AllocateFile.uploadfiles(file, client, name);
		    		} catch (DbxException ex1) {
		    			ex1.printStackTrace();
		    		}
			 }
			 
		  }
		
		
		//        // Upload "test.txt" to Dropbox
		//        try (InputStream in = new FileInputStream("test.txt")) {
		//            FileMetadata metadata = client.files().uploadBuilder("/test.txt")
		//                .uploadAndFinish(in);
		//        }
		//
		//        DbxDownloader<FileMetadata> downloader = client.files().download("/test.txt");
		//        try {
		//            FileOutputStream out = new FileOutputStream("test.txt");
		//            downloader.download(out);
		//            out.close();
		//        } catch (DbxException ex) {
		//            System.out.println(ex.getMessage());
		//        }
	}
}
