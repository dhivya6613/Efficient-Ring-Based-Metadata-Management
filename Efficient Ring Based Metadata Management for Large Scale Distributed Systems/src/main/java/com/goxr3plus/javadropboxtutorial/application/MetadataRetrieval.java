package main.java.com.goxr3plus.javadropboxtutorial.application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MetadataRetrieval {
	public static  void print_file(String main_dir_path) {
		  File maindir = new File(main_dir_path); 
	      
	      if(maindir.exists() && maindir.isDirectory()) 
	      { 
	          // array for files and sub-directories  
	          // of directory pointed by maindir 
	          File arr[] = maindir.listFiles(); 
	          RecursivePrint(arr,0,0,0);  
	      }
	}
	
	static void RecursivePrint(File[] arr,int index,int level,int count)  
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
        		//System.out.println(arr[index].getName()); 
        		try {
        		      FileWriter myWriter = new FileWriter("/Users/chutki/Documents/project_7th_sem/metadata_files/"+arr[index].getName() +".txt");
        		      myWriter.write("filename: "+arr[index].getName());
          		      myWriter.write("\n");
          		      myWriter.write("get absolute space: "+arr[index].getAbsolutePath());
          		      myWriter.write("\n");
          		      myWriter.write("get free space: "+arr[index].getFreeSpace());
          		    myWriter.write("\n");
          		      myWriter.write("get parent: "+arr[index].getParent());
          		    myWriter.write("\n");
          		      myWriter.write("get usable space: "+arr[index].getUsableSpace());
          		    myWriter.write("\n");
          		      myWriter.write("Length: "+arr[index].length());
          		    myWriter.write("\n");
          		      myWriter.write("Hashcode: "+arr[index].hashCode());
          		    myWriter.write("\n");
          		     myWriter.write("CanonicalPath "+arr[index].getCanonicalPath());
          		   myWriter.write("\n");
          		     myWriter.write("lastModified: "+arr[index].lastModified());
          		   myWriter.write("\n");
          		     myWriter.write("canExecute "+arr[index].canExecute());
          		   myWriter.write("\n");
          		     myWriter.write("canRead: "+arr[index].canRead());
          		   myWriter.write("\n");
          		     myWriter.write("canWrite: "+arr[index].canWrite());
          		   myWriter.write("\n");
          		     myWriter.write("isHidden "+arr[index].isHidden());
          		   myWriter.write("\n");
          		     myWriter.write("isAbsolute: "+arr[index].isAbsolute());
          		   myWriter.write("\n");
          		     myWriter.write("isDirectory: "+arr[index].isDirectory());
          		   myWriter.write("\n");
        		      myWriter.close();
        		  //    System.out.println("Successfully wrote to the file.");
        		    } catch (IOException e) {
        		      System.out.println("An error occurred.");
        		      e.printStackTrace();
        		    }
        	}
         
           
        }
        // for sub-directories 
        else if(arr[index].isDirectory()) 
        { 
        	if(arr[index].getName().equals(".DS_Store")==false) {
        		//System.out.println("[" + arr[index].getName() + "]"); 
        	
        	try {
  		      FileWriter myWriter = new FileWriter("/Users/chutki/Downloads/metadata_files_4/"+arr[index].getName() +".txt");
  		      myWriter.write("filename: "+arr[index].getName());
  		      myWriter.write("\n");
  		      myWriter.write("get absolute space: "+arr[index].getAbsolutePath());
  		      myWriter.write("\n");
  		      myWriter.write("get free space: "+arr[index].getFreeSpace());
  		    myWriter.write("\n");
  		      myWriter.write("get parent: "+arr[index].getParent());
  		    myWriter.write("\n");
  		      myWriter.write("get usable space: "+arr[index].getUsableSpace());
  		    myWriter.write("\n");
  		      myWriter.write("Length: "+arr[index].length());
  		    myWriter.write("\n");
  		      myWriter.write("Hashcode: "+arr[index].hashCode());
  		    myWriter.write("\n");
  		     myWriter.write("CanonicalPath "+arr[index].getCanonicalPath());
  		   myWriter.write("\n");
  		     myWriter.write("lastModified: "+arr[index].lastModified());
  		   myWriter.write("\n");
  		     myWriter.write("canExecute "+arr[index].canExecute());
  		   myWriter.write("\n");
  		     myWriter.write("canRead: "+arr[index].canRead());
  		   myWriter.write("\n");
  		     myWriter.write("canWrite: "+arr[index].canWrite());
  		   myWriter.write("\n");
  		     myWriter.write("isHidden "+arr[index].isHidden());
  		   myWriter.write("\n");
  		     myWriter.write("isAbsolute: "+arr[index].isAbsolute());
  		   myWriter.write("\n");
  		     myWriter.write("isDirectory: "+arr[index].isDirectory());
  		   myWriter.write("\n");
  		      myWriter.close();
  		    //  System.out.println("Successfully wrote to the file.");
  		    } catch (IOException e) {
  		      System.out.println("An error occurred.");
  		      e.printStackTrace();
  		    }
        	}
            // recursion for sub-directories 
            RecursivePrint(arr[index].listFiles(), 0, level + 1,count++); 
        } 
        //if(arr[index].getName().equals(".DS_Store")==false) list.add(arr[index].getName());
        // recursion for main directory 
        RecursivePrint(arr,++index, level,count++); 
   } 
}
