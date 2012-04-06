package me.lenonb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class FileLocalObtain implements IFileObtain {
	InputStream iStream ;
	
	@Override
	public boolean Open(String path, String name) throws FileNotFoundException {

		String fullPath ;
		name = name.concat(".svg") ;
		fullPath = path.concat(name) ;
		
		FileInputStream fi = new FileInputStream(fullPath) ;
		
		iStream = (InputStream)fi ;
		
		return true ;
	}

	@Override
	public InputStream getFile() {
		return this.iStream ;
	}
}
