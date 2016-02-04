package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.ObjectInputStream.GetField;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class MainWindow extends JFrame
{
	public MainWindow() {
		getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel panel = new JPanel();
		getContentPane().add(panel, "name_5011405471703");
		setBounds(100,100,400,400);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fileChooser=new JFileChooser();
				int returnValue =fileChooser.showOpenDialog(null);
				if(returnValue ==fileChooser.APPROVE_OPTION)
				{
					File selectedFile=fileChooser.getSelectedFile();
					String extension=getFileExtension(selectedFile);
					if(extension.equals("jpg")|| extension.equals("png")||extension.equals("jpeg")||extension.equals("gif"))
					{
						//upload the image
						ImagePanel imagePanel=new ImagePanel(selectedFile);
						getContentPane().add(imagePanel, "image");
						System.out.println("Added the image");
					}
					else
					{
						new ErrorDialog().invoke("Please select a proper image (jpg/png/gif)");
					}
				}
			}
		});
	}
public static void main(String args[])
{
	new MainWindow().setVisible(true);
}

public String getFileExtension(File file)
{
	String name=file.getName();
	try
	{
		return name.substring(name.lastIndexOf(".")+1);
	}
	catch(Exception e)
	{
		return "";
	}
}

/*public void start()
{
	ImagePanel panel = new ImagePanel(new ImageIcon("view/1.png").getImage());
	  getContentPane().add(panel);
	  setVisible(true);
	  setSize(800,800);
	  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	  
}*/
}


