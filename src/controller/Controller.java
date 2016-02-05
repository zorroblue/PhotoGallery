package controller;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import model.Photo;
import view.ErrorDialog;

public class Controller {
	
	private static ArrayList<Photo> photos=new ArrayList<Photo>();
	
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
    }
	
	public ArrayList<String> getTitles()
	{	
		ArrayList<String> items=new ArrayList<String>();
		for(Photo p: photos)
		{
			items.add(p.getTitle());
		}
		
		return items;
	}
	
	public BufferedImage getImageByTitle(String title)
	{
		for(Photo p:photos)
		{
			if(p.getTitle().equals(title))
				return p.getImage();
		}
		return null;
	}
	
	public String getAnnoByTitle(String title)
	{
		for(Photo p:photos)
		{
			if(p.getTitle().equals(title))
				return p.getAnnotation();
		}
		return null;
	}
}
