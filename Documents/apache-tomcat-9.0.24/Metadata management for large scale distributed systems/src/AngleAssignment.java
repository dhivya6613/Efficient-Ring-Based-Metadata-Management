import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AngleAssignment {
	static FileOutputStream fos = null;
    static File file;
	public static void create(String main_dir_path) {
		 File maindir = new File(main_dir_path); 
	      
	      if(maindir.exists() && maindir.isDirectory()) 
	      { 
	    	  File arr[] = maindir.listFiles(); 
	    	  angle_assignment(arr,0,0,0,0);
	      }
	}
	static void angle_assignment(File[] arr,int index,int level,int count,int angle)  
    { 
		N_Ary_Tree_Creation nary=new N_Ary_Tree_Creation();
        // terminate condition 
        if(index == arr.length) 
            return; 
          
        // tabs for internal levels 
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
        		String temp=arr[index]+".txt" +"-> angle: "+nary.getangle(0,360)+" degree"; 
        		try {
  	          	  file = new File("/Users/chutki/Documents/project_7th_sem/AngleAssignment.txt");
  	        	  fos = new FileOutputStream(file,true);
  	        	  if (!file.exists()) {
  	        	     file.createNewFile();
  	        	  }
  	        	  
  	        	  
  	        	  byte[] bytesArray = temp.getBytes();
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
        		String temp="[" + arr[index]+".txt"  + "]" +"-> angle: "+nary.getangle(0,360)+" degree "; 
        		try {
  	          	  file = new File("/Users/chutki/Documents/project_7th_sem/AngleAssignment.txt");
  	        	  fos = new FileOutputStream(file,true);
  	        	  if (!file.exists()) {
  	        	     file.createNewFile();
  	        	  }
  	        	  
  	        	  
  	        	  byte[] bytesArray = temp.getBytes();
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
            angle_assignment(arr[index].listFiles(), 0, level + 1,count++,angle); 
        } 
        // recursion for main directory 
        angle_assignment(arr,++index, level,count++,angle); 
   } 
}
