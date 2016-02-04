package controller;

import java.util.ArrayList;

import model.Photo;
import view.ErrorDialog;

public class Controller {
	
	private ArrayList<Photo> photos=new ArrayList<Photo>();
	
	public ArrayList<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(ArrayList<Photo> photos) {
		this.photos = photos;
	}

	public Controller()
	{
		
	}
	
	public void addImage(Photo photo)
	{
		if(photo==null)
		{
			new ErrorDialog().invoke("Please input a valid image");
			return;
		}
		if(photos.size()==10)
		{
			new ErrorDialog().invoke("Could not add image as max. number of images allowed is 10!");
			return;
		}
		
		photos.add(photo);
		System.out.println("Added image!");
	}
}
