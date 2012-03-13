package me.lenonb;

import java.io.*;
import java.net.MalformedURLException;

public class FileManage {
	private IFileObtain obtain ;
	private String name ;
	
	public FileManage(IFileObtain obtain) {
		this.obtain = obtain ;
	}
	
	public String Search(String name) {
		this.name = name ;
		
		InputStreamReader iStreamReader = new InputStreamReader(obtain.getFile()) ;
		BufferedReader br = new BufferedReader(iStreamReader) ;
		
		String str = null ;
		String temp = " " ;

		try {
			while(temp != null) 
			{
				temp = br.readLine() ;
				if(temp.indexOf(name) != -1) {
					str = temp ;
					break ;
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
				obtain.Open(this.Search(name) , this.name) ;
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
