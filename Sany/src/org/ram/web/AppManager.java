package org.ram.web;

import java.io.*; 

public class AppManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(123);


try{  
	   FileWriter fw=new FileWriter("c://amsankar/githubconfig/abc.txt");  
	   fw.write("sample file");  
	   fw.close();  
	   
	   
		  FileReader fr=new FileReader("c://amsankar/githubconfig/config.txt");  
		  int i;  
		  while((i=fr.read())!=-1)  
		  System.out.println((char)i);  
		  
		  fr.close();
	   
		  
		  
	      File file = null;
	      String[] paths;
	  
	      try {      
	         // create new file object
	         file = new File("c://amsankar/githubconfig");

	         // array of files and directory
	         paths = file.list();

	         // for each name in the path array
	         for(String path:paths) {
	            // prints filename and directory name
	            System.out.println(path);
	         }
	      }catch(Exception e) {
	         // if any error occurs
	         e.printStackTrace();
	      }
		  
		  
		  
	   
	  }catch(Exception e){System.out.println(e);}  
	  System.out.println("success");  
	 

	  
  
	  
	  

	}

}
