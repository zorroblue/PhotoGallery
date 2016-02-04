package model;


import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import view.ErrorDialog;

public class Photo 
{
	BufferedImage image;
	String title;
	String annotation;
	String resource;
	
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public java.awt.image.BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if(title.length()>20)
		{
			//error
			new  ErrorDialog().invoke("Please enter the title less than 20 characters");
			return;
		}
		this.title = title;
	}
	public String getAnnotation() {
		return annotation;
	}
	public void setAnnotation(String annotation) {
		if(annotation.length()>100)
			{
				new ErrorDialog().invoke("Please enter the annotation less than 100 characters");
				return;
			}
		this.annotation = annotation;
	}
	
	public BufferedImage getImageByTitle(String title)
	{
		if(this.title.equals(title))
			return image;
		else
			return null;
	}
	
	public void initialiseImage(File file)
	{
		try
		{
			this.image=ImageIO.read(file);
			if(this.image==null)
				{
					new ErrorDialog().invoke("The image is not proper!");
					throw new Exception() ;
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
