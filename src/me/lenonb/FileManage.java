package me.lenonb;

import java.io.*;
import java.net.MalformedURLException;

public class FileManage {
	private IFileObtain obtain ;
	private String name ;
	private String path ;
	private int MAX_STRING = 100 ;
	
	public FileManage(IFileObtain obtain , String path) {
		this.obtain = obtain ;
		this.path = path ;
	}
	
	public String[] Search(String name) {
		this.name = name ;
		int n = 0 ;
		
		InputStreamReader iStreamReader = new InputStreamReader(obtain.getFile()) ;
		BufferedReader br = new BufferedReader(iStreamReader) ;
		
		String[] str ;
		str = new String[MAX_STRING] ;
		String temp = " " ;

		try {
			while(temp != null) 
			{
				temp = br.readLine() ;
				if(temp.indexOf(name) != -1) {
					str[n] = temp ;
					n++ ;
				}
			}
		} 
		catch (IOException e) {
			System.err.println("Error") ;
		}
		
		return str ;
	}
	
	public String getFile(String fileName , InputStream fin) {
		
			try {
				obtain.Open(this.path , Search(name)[0]) ;
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
