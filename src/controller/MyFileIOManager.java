package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import model.Photo;

public class MyFileIOManager {

	public void writeToFile(ArrayList<Photo> photos)
	{
		File file=new File("data.txt");
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
        	oos.writeObject(photos);
		}
        catch(Exception e)
        {
        	e.printStackTrace();
        }
	}
	
	public ArrayList<Photo> readFromFile()
	{
		try
		{
			 ObjectInputStream ois=new ObjectInputStream(new FileInputStream("data.txt"));
			 ArrayList<Photo> photos=(ArrayList<Photo>)ois.readObject();
	         ois.close();
	         return photos;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
