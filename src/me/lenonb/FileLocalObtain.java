package me.lenonb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class FileLocalObtain implements IFileObtain {
	InputStream iStream ;
	
	@Override
	public boolean Open(String path, String name) throws FileNotFoundException {

		FileInputStream fi = new FileInputStream(path) ;
		
		iStream = (InputStream)fi ;
		
		return true ;
	}

	@Override
	public InputStream getFile() {
		return this.iStream ;
	}
}
