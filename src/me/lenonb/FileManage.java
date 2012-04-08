package me.lenonb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.*;

public class FileManage {
	private IFileObtain obtain ;
	private String lName[] ;
	private String path ;

	public FileManage(IFileObtain obtain , String path) {
		this.obtain = obtain ;
		this.path = path ;
		try {
			obtain.Open(this.path , "list") ;
			BufferedReader list = new BufferedReader(new InputStreamReader(obtain.getFile())) ;
			String temp = " ";
			ArrayList<String> nameList = null ;
					
			while(temp != null) {
				temp = list.readLine() ;
				nameList.add(temp) ;
			}
			lName = (String[])nameList.toArray() ;
		}
		catch(IOException e) {
			System.out.println("error !") ;
		}
	}
	
	public String[] Search(String name) {
		String[] str ;
		int i = 0 ;
		ArrayList<String> nameList = null ;
		String temp = " " ;

		while(temp != null) 
		{
			temp = lName[i] ;
			if(temp.indexOf(name) != -1) {
				nameList.add(temp) ;
			}
			i++ ;
		}
		str = (String[]) nameList.toArray() ;
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