package me.lenonb;

import java.io.* ;
import java.net.MalformedURLException;

public interface IFileObtain {
	boolean Open(String path , String name) throws MalformedURLException, IOException ;
	InputStream getFile() ;
}
