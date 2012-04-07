package me.lenonb;

import java.io.*;
import java.net.MalformedURLException;

public class FileManage {
	private IFileObtain obtain ;
	private String lName[] ;
	private String str[] ;
	private String path ;
	private String listPath ;
	private int MAX_STRING = 100 ;
	
	public FileManage(IFileObtain obtain , String path) {
		this.obtain = obtain ;
		this.path = path ;
		this.listPath = path.concat("list");
		
		try {
			BufferedReader list = new BufferedReader(new FileReader(listPath)) ;
			String temp = " ";
			int n = 0 ;
			lName = new String[MAX_STRING] ;
		
		
			while(temp != null) {
				temp = list.readLine() ;
				lName[n] = temp ;
				n++ ;
			}
		}
		catch(IOException e) {
			System.out.println("error !") ;
		}
	}
	
	public void Search(String name) {
		
		int n = 0 , i = 0 ;
		str = new String[MAX_STRING] ;
		
		String temp = " " ;

		while(temp != null) 
		{
			temp = lName[i] ;
			if(temp.indexOf(name) != -1) {
				str[n] = temp ;
				n++ ;
			}
		}
	}
	
	public String getFile(String fileName , InputStream fin) {
		
			try {
				obtain.Open(this.path , str[0]) ;
			} 
			catch (MalformedURLException e) {
				return "URLError";
			} 
			catch (IOException e) {
				return "URLError" ;
			}
			
			fin = obtain.getFile() ;
			return "done" ;
	}
}

