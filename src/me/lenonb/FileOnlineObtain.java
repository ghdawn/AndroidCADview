package me.lenonb;

import java.io.* ;
import java.net.* ; 

public class FileOnlineObtain implements IFileObtain {
	InputStream iStream ;
	
	@Override
	public boolean Open(String path , String name) throws MalformedURLException , IOException  {
		
		String fullPath ;
		name = name.concat(".svg") ;
		fullPath = path.concat(name) ;
			
		URL url;
			
		url = new URL(fullPath);
		URLConnection conn = url.openConnection() ;
			
		iStream = conn.getInputStream() ;
			
		return true ;		
	}
	
	@Override
	public InputStream getFile() {
		return this.iStream ;
	}
	
}
