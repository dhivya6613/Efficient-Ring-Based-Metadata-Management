package main.java.com.goxr3plus.javadropboxtutorial.application;

import java.util.List;
import java.io.*;

public class FileHierarchy {
	static FileOutputStream fos = null;
    static File file;
  public static int print_file(String main_dir_path,List<String> list) {
	  File maindir = new File(main_dir_path); 
      
      if(maindir.exists() && maindir.isDirectory()) 
      { 
          // array for files and sub-directories  
          // of directory pointed by maindir 
          File arr[] = maindir.listFiles(); 
           
          try {
        	  file = new File("/Users/chutki/Documents/project_7th_sem/file_hierarchy.txt");
      	  fos = new FileOutputStream(file,true);
      	  if (!file.exists()) {
      	     file.createNewFile();
      	  }
      	  String temp_filename="\"Files from main directory : " + maindir;
      	  byte[] bytesArray = "**********************************************".getBytes();
    	  byte[] bytesArray1 = "\n".getBytes();
    	  byte[] bytesArray2 = temp_filename.getBytes();
    	  byte[] bytesArray3 = "\n".getBytes();
    	  byte[] bytesArray4 = "**********************************************".getBytes();
    	  byte[] bytesArray5 = "\n".getBytes();
    	  
      	  fos.write(bytesArray);
      	  fos.write(bytesArray1);
      	  fos.write(bytesArray2);
      	  fos.write(bytesArray3);
      	  fos.write(bytesArray4);
      	  fos.write(bytesArray5);
      	 
      	  fos.flush();
      	
             } 
             catch (IOException ioe) {
            	 ioe.printStackTrace();
             } 
  		
            
          // Calling recursive method 
          
          RecursivePrint(list,arr,0,0);  
          
         
          //Print the list
         // System.out.println("Inorder traversal of file hierarchy: ");
          
          /* for(String val:list) {
          	System.out.println(val);
           }*/
        
          
      }
	return list.size();
        
  }
  static void RecursivePrint(List<String> list,File[] arr,int index,int level)  
  { 
     
      if(index == arr.length) 
          return; 
        
    
      for (int i = 0; i < level; i++) {
    	  
    	  try {
      	  file = new File("/Users/chutki/Documents/project_7th_sem/file_hierarchy.txt");
    	  fos = new FileOutputStream(file,true);
    	  if (!file.exists()) {
    	     file.createNewFile();
    	  }
    	  byte[] bytesArray = "\t".getBytes();

    	  fos.write(bytesArray);
    	  fos.flush();
    	
           } 
           catch (IOException ioe) {
    	  ioe.printStackTrace();
           } 
      }
         
        
      // for files 
      if(arr[index].isFile()) {
      	if(arr[index].getName().equals(".DS_Store")==false) {
      		try {
            	  file = new File("/Users/chutki/Documents/project_7th_sem/file_hierarchy.txt");
          	  fos = new FileOutputStream(file,true);
          	  if (!file.exists()) {
          	     file.createNewFile();
          	  }
          	  byte[] bytesArray = arr[index].getName().getBytes();
           	  byte[] bytesArray1 = "\n".getBytes();
          	  fos.write(bytesArray);
          	  fos.write(bytesArray1);
          	  fos.flush();
          	
                 } 
                 catch (IOException ioe) {
          	  ioe.printStackTrace();
                 } 
      		
      	}
      	
           
      }
      // for sub-directories 
      else if(arr[index].isDirectory()) 
      { 
      	if(arr[index].getName().equals(".DS_Store")==false) {
      		try {
            	  file = new File("/Users/chutki/Documents/project_7th_sem/file_hierarchy.txt");
          	  fos = new FileOutputStream(file,true);
          	  if (!file.exists()) {
          	     file.createNewFile();
          	  }
          	  String temp_filename="[" + arr[index].getName() + "]";
          	  byte[] bytesArray = temp_filename.getBytes();
        	  byte[] bytesArray1 = "\n".getBytes();
          	  fos.write(bytesArray);
          	  fos.write(bytesArray1);
          	  fos.flush();
          	
                 } 
                 catch (IOException ioe) {
                	 ioe.printStackTrace();
                 } 
      		
      	}
          
          // recursion for sub-directories 
          RecursivePrint(list,arr[index].listFiles(), 0, level + 1); 
      } 
      if(arr[index].getName().equals(".DS_Store")==false) list.add(arr[index].getName());
      // recursion for main directory 
      RecursivePrint(list,arr,++index, level); 
     
      
 } 

}
