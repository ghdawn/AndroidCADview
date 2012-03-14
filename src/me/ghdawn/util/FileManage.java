package me.ghdawn.util;

import java.net.*;
import java.io.*;

/**
 * 
 * @author Lenon.B
 *
 */
public class FileManage {
	
	
	private FileOnlineObtain obtain ;	
	
	private int MAX_BUF= 100 ;			
	private int MAX_STRING = 100 ;
	private int i = 0 ;
	
	private byte[] buf ;				
	private String[] str , name ;
	private InputStream[] iStream ;
	
	//�����б?��������Ϊһ���ļ�����һ����URL��ַ���ڶ������ļ���
	public void readList(String path)  {
		
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(path)) ;		
			str = new String[MAX_STRING] ;										
			name = new String[MAX_STRING] ;
			
			
			for(i = 0 ; i < 100 ; i++) {
				str[i] = bfr.readLine() ;
				name[i] = bfr.readLine() ;
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("File Not Found !") ;
		} 
		catch (IOException e) {
			System.out.println("IOException !") ;
		}
	}
	
	
	public void getFileInputStream() {
		i = 0 ;
		iStream = new InputStream[MAX_STRING] ;
		
		while(str[i] != null) {			
			obtain.Open(str[i] , name[i]) ;
			iStream[i] = obtain.getFile() ;
		}
	}
	
	
	@SuppressWarnings("finally")
	public byte[] getByteFile(int n) {
		
		DataInputStream dataIStream = new DataInputStream(iStream[n]) ;
		
		try {
			MAX_BUF = MAX_BUF + obtain.getFileLength() ;
			buf = new byte[MAX_BUF] ;
			dataIStream.read(buf) ;											
		}
		catch(IOException e) {
			System.out.println("IO error !") ;
		}
		catch(Exception e) {
			System.out.println("Error !") ;
		}
		finally {
			return buf ;
		}
	}
	
}