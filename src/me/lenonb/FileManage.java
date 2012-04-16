package me.lenonb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.*;


import android.util.Log;

public class FileManage
{
	private IFileObtain obtain;
	private ArrayList<String> _fileName = new ArrayList<String>(3);
	private String path;

	public FileManage(IFileObtain obtain, String path)
	{
		this.obtain = obtain;
		this.path = path;
		try
		{
			if (!obtain.Open(this.path, "list"))
			{
				Log.e("myTag", "No file List");
				return;
			}
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

	public InputStream getFile(String fileName) 
	{

		try
        {
	        if (!obtain.Open(this.path, fileName + ".svg"))
	        {
	        	Log.e("mytag", "File not exist");
	        }
        }
        catch (MalformedURLException e)
        {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
        catch (IOException e)
        {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }

		return obtain.getFile();

	}
}