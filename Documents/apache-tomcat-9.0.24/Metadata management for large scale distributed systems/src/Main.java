import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

public class Main {
	static String main_dir_path = "/Users/chutki/github"; 
	static List<String> list=new ArrayList<>();
	
	public static void main(String args[]) {

	   //traverse file hierarchy
	   file_hierarchy f=new file_hierarchy();
	   int no_of_files=f.print_file(main_dir_path,list);
	  
	   
	   //retrieve the metadata
	   Retrieve_Metadata rm=new Retrieve_Metadata();
	   rm.print_file(main_dir_path);

	   //create n-ary tree and assign angle
	   N_Ary_Tree_Creation nary=new N_Ary_Tree_Creation();
	   nary.create(main_dir_path);
	   
	   //assign angle 
	   AngleAssignment aa=new AngleAssignment();
	   aa.create(main_dir_path);
	   
	   
	}
}
