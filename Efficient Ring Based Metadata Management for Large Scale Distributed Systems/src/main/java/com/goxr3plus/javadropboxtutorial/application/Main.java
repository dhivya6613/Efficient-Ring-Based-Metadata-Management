package main.java.com.goxr3plus.javadropboxtutorial.application;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

public class Main {
	private static final String ACCESS_TOKEN1 = "GH6xzgdI8aQAAAAAAAAAAd-u2G4me0LW2fzcb7QcoWglR6pFIFQ1loDaI7KkmIEW";//dhivya
	private static final String ACCESS_TOKEN2 = "D7inr2YAdVoAAAAAAAAAAR2QgfEi4gr3jra7C-hzp1l1SJi7uEBKXRFAyLAjWGbm";//nithya
	private static final String ACCESS_TOKEN3 = "sl.Aj3NKIUatENPWxWVZyUK1-J4h4QzmMY_VGOdnjkUd5oJ4yNOndjby_-0wPdgZuNs8aVKUCKNgZ-75I-lAULJWFkjTS4mRKVyY0kVz454K_cMwqO9vVBJartEgQym4ScTm00YaoI";//sangavi
	private static final String ACCESS_TOKEN4 = "Xy9h1n5XlmQAAAAAAAAAAf403xn2zo9S_3UD5BJ95dQdwP8fvIBdjlxV1vXIseK8";//siva
	private static final String ACCESS_TOKEN5 = "sl.AoGbbZwSpXgslgDaiWkqMqmou_uMSAIb9DntqV34WRe83G00XcYW7GI7FvXKwRIdqET0ClwpWkIFvWZbkODlfVz3Tf3XeL666ASm5lieWyObAmBMXBNHbr9xEvEaatqXB89FZ5w";//durgadevi
	
	
	static String main_dir_path = "/Users/chutki/github"; 
	static String metadata_dir_path="/Users/chutki/Documents/project_7th_sem/metadata_files";
	static List<String> list=new ArrayList<>();
	
	public static void main(String args[]) {

	   //traverse file hierarchy
	   FileHierarchy f=new FileHierarchy();
	   int no_of_files=f.print_file(main_dir_path,list);
	   System.out.println("main function");
	   
	   //retrieve the metadata
	   MetadataRetrieval rm=new MetadataRetrieval();
	   rm.print_file(main_dir_path);

	   //create n-ary tree and assign angle
	   NamespaceTree nary=new NamespaceTree();
	   nary.create(main_dir_path);
	   
	   //assign angle 
	   AngleAssignment aa=new AngleAssignment();
	   aa.create(main_dir_path);
	   
	 //assign angle 
	   GetFrequency gf=new GetFrequency();
	   gf.create(main_dir_path);
	   
	   //anglecut implementation
	   AngleCut ac=new AngleCut();
	   FileCount fc=new FileCount();
	   int count=fc.getcount(metadata_dir_path);
	    System.out.println("----Anglecut-----");
	    System.out.println("Number of metadata nodes : "+no_of_files);
	    int no_of_servers=5;
		System.out.println("no of servers to be distributed : "+no_of_servers);
		//Scanner r=new Scanner(System.in);
		int no=no_of_files/4;
		int ideal_load_factor=no/no_of_servers;
		
	    for(int i=0;i<no_of_servers;i++) {
	    	System.out.println("server : "+i);
	    	if(i==1) System.out.println("access token "+ACCESS_TOKEN1);
	    	if(i==2) System.out.println("access token "+ACCESS_TOKEN2);
	    	if(i==3) System.out.println("access token "+ACCESS_TOKEN3);
	    	if(i==4) System.out.println("access token "+ACCESS_TOKEN4);
	    	if(i==5) System.out.println("access token "+ACCESS_TOKEN5);
	    	System.out.println("No of files alloted in server "+i+" : "+ ac.getfiles(no_of_files));
	    	
	    }
	    System.out.println();
	    int load_factor=no_of_files/no_of_servers;
	    
	    System.out.println("Ideal Load Factor : "+ load_factor);
	    System.out.println("Average Load Balancing Factor : "+ ac.load_balancing_factor());
	    System.out.println("Average Hop count taken for 10 input query files : "+ ac.hopcount());
				
		AngleCut.anglecut_implementation(metadata_dir_path,ideal_load_factor,no_of_servers);
		
		//freequency bassed allocation
		   FrequencyBasedAllocation ac1=new FrequencyBasedAllocation();
		   System.out.println();
		   System.out.println();
		   
		    System.out.println("----FrequencyBasedAllocation-----");
		    System.out.println("Number of metadata nodes : "+no_of_files);
		    
			System.out.println("no of servers to be distributed : "+no_of_servers);
			//Scanner r=new Scanner(System.in);
			
			
		    for(int i=0;i<no_of_servers;i++) {
		    	System.out.println("server : "+i);
		    	if(i==1) System.out.println("access token "+ACCESS_TOKEN1);
		    	if(i==2) System.out.println("access token "+ACCESS_TOKEN2);
		    	if(i==3) System.out.println("access token "+ACCESS_TOKEN3);
		    	if(i==4) System.out.println("access token "+ACCESS_TOKEN4);
		    	if(i==5) System.out.println("access token "+ACCESS_TOKEN5);
		    	System.out.println("No of files alloted in server "+i+" : "+ ac1.getfiles(no_of_files));
		    	
		    }
		    System.out.println();
		    int load_factor1=no_of_files/no_of_servers;
		    
		    System.out.println("Ideal Load Factor : "+ load_factor1);
		    System.out.println("Average Load Balancing Factor : "+ ac1.load_balancing_factor());
		    System.out.println("Average Hop count taken for 10 input query files : "+ ac1.hopcount());
					
		    FrequencyBasedAllocation.anglecut_implementation(metadata_dir_path,ideal_load_factor,no_of_servers);
			
	}
}
