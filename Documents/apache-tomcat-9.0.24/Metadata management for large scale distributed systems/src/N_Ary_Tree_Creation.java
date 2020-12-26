import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.io.*;
//import Test.DirectoryNode;

public class N_Ary_Tree_Creation {
	static FileOutputStream fos = null;
    static File file;
	static List<String> list1=new ArrayList<>();
	public static void create(String main_dir_path) {
		 File maindir = new File(main_dir_path); 
	      
	      if(maindir.exists() && maindir.isDirectory()) 
	      { 
	    	  File arr[] = maindir.listFiles(); 
	    	  traverse_and_distribute(arr,0,0,0);
	    	  
	    	  String list[] = new String[list1.size()]; 
	    	  
	          // ArrayList to Array Conversion 
	          for (int j = 0; j < list1.size(); j++) { 
	    
	              // Assign each value to String array 
	              list[j] = list1.get(j); 
	          } 
	    
	          final DirectoryNode directoryRootNode = createDirectoryTree(list);

	          System.out.println(directoryRootNode);
	          
	          List<List<String>> levelList = levelOrder(directoryRootNode);
	          
	          assign_angle(directoryRootNode);
	          
	          
	          for (List<String> level : levelList) {
	              for (String val : level) {
	                  String temp=val + "  |  ";
	                  try {
	    	          	  file = new File("/Users/chutki/Documents/project_7th_sem/Level_Order_traversal_of_n_ary_tree.txt");
	    	        	  fos = new FileOutputStream(file,true);
	    	        	  if (!file.exists()) {
	    	        	     file.createNewFile();
	    	        	  }
	    	        	  
	    	        	  
	    	        	  byte[] bytesArray = temp.getBytes();

	    	        	  fos.write(bytesArray);
	    	        	  fos.flush();
	    	        	
	    	               } 
	    	               catch (IOException ioe) {
	    	        	  ioe.printStackTrace();
	    	               } 
	              }
	              try {
    	          	  file = new File("/Users/chutki/Documents/project_7th_sem/Level_Order_traversal_of_n_ary_tree.txt");
    	        	  fos = new FileOutputStream(file,true);
    	        	  if (!file.exists()) {
    	        	     file.createNewFile();
    	        	  }
    	        	  
    	        	  String f="\n"+"\n"+"\n";
    	        	  
    	        	  byte[] bytesArray = f.getBytes();

    	        	  fos.write(bytesArray);
    	        	  fos.flush();
    	        	
    	               } 
    	               catch (IOException ioe) {
    	        	  ioe.printStackTrace();
    	               } 
	              
	              
	              List<List<Integer>> levelList1 = printangle(directoryRootNode);
		          
		          
		          
		          
		       
	          }
	      }
	}
	static void traverse_and_distribute(File[] arr,int index,int level,int count)  
    { 
        // terminate condition 
        if(index == arr.length) 
            return; 
          
          
        // for files 
        if(arr[index].isFile()) {
        	if(arr[index].getName().equals(".DS_Store")==false) list1.add(arr[index].getPath()); 
         
            
        }
        // for sub-directories 
        else if(arr[index].isDirectory()) 
        { 
        	if(arr[index].getName().equals(".DS_Store")==false) list1.add(arr[index].getPath());
            
            // recursion for sub-directories 
        	traverse_and_distribute(arr[index].listFiles(), 0, level + 1,count+1); 
        } 
      
        // recursion for main directory 
        traverse_and_distribute(arr,++index, level,count+1); 
   }
	public static DirectoryNode createDirectoryTree(final String[] list) {
	    DirectoryNode treeRootNode = null;
	    for (final String rawPath : list) {
	      final String path = rawPath.startsWith("/") ? rawPath.substring(1) : rawPath;
	      final String[] pathElements = path.split("/");
	      DirectoryNode movingNode = null;
	      for (final String pathElement : pathElements) {
	        movingNode = new DirectoryNode(movingNode, pathElement);
	      }

	      if (treeRootNode == null) {
	        treeRootNode = movingNode.getRoot();
	      } else {
	        treeRootNode.merge(movingNode.getRoot());
	      }
	    }

	    return treeRootNode;
	  }
	public static int getangle(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	  public static class DirectoryNode {

	    public final Set<DirectoryNode> children = new LinkedHashSet<>();

	    public final String value;
	    public static int angle=0;
	    public static int frequency;
	    public static int tag;
	    
	    public final DirectoryNode parent;

	    public DirectoryNode(final DirectoryNode parent, final String value) {
	      this.parent = parent;
	      if (this.parent != null) {
	        this.parent.children.add(this);
	      }

	      this.value = value;
	    }

	    public Set<DirectoryNode> getChildren() {
	      return this.children;
	    }

	    public String getValue() {
	      return this.value;
	    }

	    public DirectoryNode getParent() {
	      return this.parent;
	    }

	    public int getLeafCount() {
	      int leafCount = this.isLeaf() ? 1 : 0;
	      for (final DirectoryNode child : this.children) {
	        leafCount += child.getLeafCount();
	      }

	      return leafCount;
	    }

	    public boolean isLeaf() {
	      return this.children.isEmpty();
	    }

	    public DirectoryNode getRoot() {
	      return this.parent == null ? this : this.parent.getRoot();
	    }

	    public void merge(final DirectoryNode that) {
	      if (!this.value.equals(that.value)) {
	        return;
	      } else if (this.children.isEmpty()) {
	        this.children.addAll(that.children);
	        return;
	      }

	      final DirectoryNode[] thisChildren = this.children
	        .toArray(new DirectoryNode[this.children.size()]);
	      for (final DirectoryNode thisChild : thisChildren) {
	        for (final DirectoryNode thatChild : that.children) {
	          if (thisChild.value.equals(thatChild.value)) {
	            thisChild.merge(thatChild);
	          } else if (!this.children.contains(thatChild)) {
	            this.children.add(thatChild);
	          }
	        }
	      }
	    }

	    @Override
	    public boolean equals(final Object o) {
	      if (this == o) {
	        return true;
	      }
	      if (o == null || getClass() != o.getClass()) {
	        return false;
	      }
	      final DirectoryNode that = (DirectoryNode) o;
	      return Objects.equals(this.value, that.value)
	        && Objects.equals(this.parent, that.parent);
	    }

	    @Override
	    public int hashCode() {
	      return Objects.hash(this.value, this.parent);
	    }


	    @Override
	    public String toString() {
	    	String temp="\n"+"{" +
	    	        "value='" + this.value + '\'' +"\n"+
	    	        ", children=" + this.children +"\n"+
	    	        '}';
	    	try {
	          	  file = new File("/Users/chutki/Documents/project_7th_sem/N-Ary_tree_creation.txt");
	        	  fos = new FileOutputStream(file,true);
	        	  if (!file.exists()) {
	        	     file.createNewFile();
	        	  }
	        	  
	        	  
	        	  byte[] bytesArray = temp.getBytes();

	        	  fos.write(bytesArray);
	        	  fos.flush();
	        	
	               } 
	               catch (IOException ioe) {
	        	  ioe.printStackTrace();
	               } 
	      return "";
	    }
	    
	  }
	  public static List<List<String>> levelOrder(DirectoryNode root) {
	      List<List<String>> levelList = new ArrayList<>();

	      if (root == null) {
	          return levelList;
	      }

	      Queue<DirectoryNode> queue = new LinkedList<>();
	      queue.add(root);

	      while (!queue.isEmpty()) {
	          int n = queue.size();
	          List<String> level = new ArrayList<>();

	          while (n-- > 0) {
	        	  DirectoryNode node = queue.remove();
	              level.add(node.value);
	              queue.addAll(node.children);
	          }
	          levelList.add(level);
	      }
	      return levelList;
	  }
	  public static void assign_angle(DirectoryNode root) {
	      List<List<String>> levelList = new ArrayList<>();
	  
	      
	      if (root == null) {
	          return;
	      }

	      Queue<DirectoryNode> queue = new LinkedList<>();
	      queue.add(root);
	      DirectoryNode.angle=180;
	      
	      while (!queue.isEmpty()) {
	          int n = queue.size();
	          int angle=queue.peek().angle/n;
	          List<String> level = new ArrayList<>();

	          while (n-- > 0) {
	        	  
	        	  DirectoryNode node = queue.remove();
	              level.add(node.value);
	              queue.addAll(node.children);
	              DirectoryNode.angle=angle;
	              
	          }
	          levelList.add(level);
	      }
	      return;
	  }
	  public static List<List<Integer>> printangle(DirectoryNode root) {
	      List<List<Integer>> levelList = new ArrayList<>();

	      if (root == null) {
	          return levelList;
	      }

	      Queue<DirectoryNode> queue = new LinkedList<>();
	      queue.add(root);

	      while (!queue.isEmpty()) {
	          int n = queue.size();
	          List<Integer> level = new ArrayList<>();

	          while (n-- > 0) {
	        	  DirectoryNode node = queue.remove();
	              level.add(N_Ary_Tree_Creation.DirectoryNode.angle);
	              queue.addAll(node.children);
	          }
	          levelList.add(level);
	      }
	      return levelList;
	  }
}
