package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.Controller;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class ViewList extends JFrame {

	
	private int width=650,height=750;
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
		

		this.setTitle("PHOTO LIST");
		 this.setSize(width, height);
	        this.setVisible(true);
	        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		JPanel rightPanel=new JPanel(new BorderLayout());
        rightPanel.setVisible(true);
        
        
        final JPanel glass = new JPanel(){

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				g.drawImage(image, 50, 50, null);
			}
			
		};
		rightPanel.setSize(450,750);
        glass.setSize(450, 600);
        
        JPanel controls = new JPanel();
        controls.setLayout(new BorderLayout());
        controls.setSize(200, 750);
  //      controls.setBackground(Color.RED);
        JLabel jltitle=new JLabel("Titles");
        jltitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        controls.add(jltitle,BorderLayout.NORTH);
       controls.add(new JLabel(""),BorderLayout.LINE_END);
       
        ArrayList<String> listItems=new Controller().getTitles();
        System.out.println("SIZE: "+listItems.size());
        final JList list=new JList(listItems.toArray());
        list.setLayoutOrientation(JList.VERTICAL);
        list.setFont(new Font(Font.SERIF,3,15));
        controls.add(list,BorderLayout.CENTER);
        controls.setVisible(true);
        final JLabel description =new JLabel();
      //  description.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        list.addListSelectionListener(new ListSelectionListener() {
		
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				String s=(String)list.getSelectedValue();
				image=new Controller().getImageByTitle(s);
				description.setText(s);
				glass.revalidate();
				glass.repaint();
			//	Toast.makeToast(ViewList.this, "Title:"+s+"\n\n Annotation: "+new Controller().getAnnoByTitle(s), 3);
				
			}
		});
        
        rightPanel.add(glass);
        rightPanel.add(description);
        JSplitPane splitPane = new JSplitPane();
        splitPane.setSize(width, height);
        splitPane.setDividerSize(2);
        splitPane.setDividerLocation(200);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(controls);
        splitPane.setRightComponent(rightPanel);

        getContentPane().add(splitPane);
      //  this.setVisible(true);
		
        
		
	}
	
	public BufferedImage getImage()
	{
		return this.image;
	}
	
}
