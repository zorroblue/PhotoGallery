package view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.Controller;

public class ViewList extends JFrame {

	
	private int width=650,height=450;
	BufferedImage image=null;
	

	/**
	 * Create the application.
	 */
	public ViewList() {
		initialize();
	}

/**
	 * Initialize the contents of the this.
	 */
	
	
	private void initialize() {
		

		
		 this.setSize(width, height);
	        this.setVisible(true);
	        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		
        
        try {
			image = ImageIO.read(new File("src/1.png"));
			if(image==null)
				throw new IOException();
			System.out.println("Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        final JPanel glass = new JPanel(){

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				g.drawImage(image, 50, 50, null);
			}
			
		};
        glass.setSize(450, 750);
//        glass.setBackground(Color.BLUE);
        glass.setVisible(true);

        
        JPanel controls = new JPanel();
        controls.setSize(200, 750);
  //      controls.setBackground(Color.RED);
        
        ArrayList<String> listItems=new Controller().getTitles();
        System.out.println("SIZE: "+listItems.size());
        final JList list=new JList(listItems.toArray());
        list.setLayoutOrientation(JList.VERTICAL);
        controls.add(list);
        controls.setVisible(true);

        list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				String s=(String)list.getSelectedValue();
				image=new Controller().getImageByTitle(s);
				glass.repaint();
				
			}
		});
        
        
        JSplitPane splitPane = new JSplitPane();
        splitPane.setSize(width, height);
        splitPane.setDividerSize(2);
        splitPane.setDividerLocation(200);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(controls);
        splitPane.setRightComponent(glass);

        this.add(splitPane);
      //  this.setVisible(true);
		
        
		
	}
	
	public BufferedImage getImage()
	{
		return this.image;
	}
	
}
