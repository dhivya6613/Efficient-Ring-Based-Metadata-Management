package main.java.com.goxr3plus.javadropboxtutorial.application;

import java.io.File;

public class FileCount {
	public static int getcount(String main_dir_path) {
		 File maindir = new File(main_dir_path); 
          int res=0;
	        if(maindir.exists() && maindir.isDirectory()) 
	        { 
	            // array for files and sub-directories  
	            // of directory pointed by maindir 
	            File arr[] = maindir.listFiles(); 
	             res= count_files(arr,0,0,0);
	        }
	        return res;
	}
	public static int count_files(File[] arr,int index,int level,int count)  
    { 
        // terminate condition 
        if(index == arr.length) 
            return count; 
          
       
        if(arr[index].isFile()) {
        	//if(arr[index].getName().equals(".DS_Store")==false) System.out.println(getAlphaNumericString(9)+".txt");
            
        }
        // for sub-directories 
        else if(arr[index].isDirectory()) 
        { 
        	//if(arr[index].getName().equals(".DS_Store")==false) System.out.println(getAlphaNumericString(9)+".txt"); 
            
            // recursion for sub-directories 
            count_files(arr[index].listFiles(), 0, level + 1,count++); 
        } 
        // recursion for main directory 
        count_files(arr,++index, level,count++); 
        return count;
   } 
}
