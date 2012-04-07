package me.lenonb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

public class FileManage {
	private IFileObtain obtain ;
	private String lName[] ;
	private String str[] ;
	private String path ;
	private int MAX_STRING = 100 ;

	public FileManage(IFileObtain obtain , String path) {
		this.obtain = obtain ;
		this.path = path ;
		
		try {
			obtain.Open(path , "list") ;
			BufferedReader list = new BufferedReader(new InputStreamReader(obtain.getFile())) ;
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
	
	public String[] Search(String name) {
		
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
		
		return str ;
	}
	
	public status getFile(String fileName , InputStream fin) {
			try {
				obtain.Open(this.path , Search(fileName)[0]) ;
			} 
			catch (MalformedURLException e) {
				return status.URLError ;
			} 
			catch (IOException e) {
				return status.URLError ;
			}
			
			fin = obtain.getFile() ;
			return status.done ;
	}
}

