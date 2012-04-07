package me.lenonb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

public class FileManage {
	private IFileObtain obtain ;
	private String lName[] ;
	private String str[] ;
	private String path ;
	private String listPath ;
	private int MAX_STRING = 100 ;

	//private static final Done URLError = null;
	//private static final Done done = null;
	
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
	
	public Done getFile(String fileName , InputStream fin) {
			try {
				obtain.Open(this.path , str[0]) ;
			} 
			catch (MalformedURLException e) {
				return Done.URLError ;
			} 
			catch (IOException e) {
				return Done.URLError ;
			}
			
			fin = obtain.getFile() ;
			return Done.done ;
	}
}

