package me.lenonb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.*;

public class FileManage
{
	private IFileObtain obtain;
	private ArrayList<String> _fileName;
	private String path;

	public FileManage(IFileObtain obtain, String path)
	{
		this.obtain = obtain;
		this.path = path;
		try
		{
			obtain.Open(this.path, "list");
			BufferedReader list = new BufferedReader(new InputStreamReader(
			        obtain.getFile()));
			String temp = " ";

			while ((temp = list.readLine()) != null)
			{
				_fileName.add(temp);
			}
		}
		catch (IOException e)
		{
			System.out.println("error !");
		}
	}
	
	public String[] getFileList()
	{
		return (String[]) _fileName.toArray();
	}
	public String[] Search(String name)
	{
		ArrayList<String> nameList = new ArrayList<String>(3);
		for (String file : _fileName)
		{
			if (file.indexOf(name) > 0)
			{
				nameList.add(file);
			}
		}
		
		return (String[]) nameList.toArray();
	}

	public status getFile(String fileName, InputStream fin)
	{
		try
		{
			obtain.Open(this.path, Search(fileName)[0]);
		}
		catch (MalformedURLException e)
		{
			return status.URLError;
		}
		catch (IOException e)
		{
			return status.URLError;
		}
		fin = obtain.getFile();
		return status.done;
	}
}