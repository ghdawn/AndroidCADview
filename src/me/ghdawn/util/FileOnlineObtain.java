package me.ghdawn.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * @author Lenon.B
 * 
 */
class FileOnlineObtain implements IFileObtain
{
	private InputStream inputStream;

	public boolean Open(String path, String name)
	{
		URL url;

		try
		{
			url = new URL(path);
			URLConnection conn = (URLConnection) url.openConnection();
			inputStream = conn.getInputStream();

			return true;
		}
		catch (MalformedURLException e)
		{
			return false;
		}
		catch (IOException e)
		{
			return false;
		}
	}

	public InputStream getFile()
	{
		return this.inputStream;
	}

	public int getFileLength() throws Exception
	{
		return this.inputStream.available();
	}
}