package me.ghdawn.util;
import java.io.InputStream;

import android.R.bool;
import android.R.string;


public interface IFileObtain
{
	boolean Open(String path,String filename);
	InputStream getFile();
}
