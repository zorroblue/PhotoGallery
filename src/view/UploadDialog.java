package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Controller;
import controller.MyFileIOManager;
import model.Photo;

public class UploadDialog extends JFrame{

	private File fileSelected=null;
	private Controller controller=new Controller();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadDialog window = new UploadDialog();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public UploadDialog() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		JLabel lblLocation = new JLabel("Enter file location :");
		JLabel lblTitle=new JLabel("Enter title :");
		JLabel lblAnno=new JLabel("Enter annotation :");
		final JTextField tfLocation=new JTextField();
		final JTextField tfTitle=new JTextField();
		final JTextField tfAnno=new JTextField();
		
		
		JButton bSubmit =new JButton("SUBMIT");
		tfLocation.setEditable(false);

		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(lblLocation)
						.addComponent(tfLocation)
						)
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(lblTitle)
						.addComponent(tfTitle)
						)
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(lblAnno)
						.addComponent(tfAnno)
						)
				.addGap(10)
				
				.addComponent(bSubmit)			
				
				);
		
		groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(lblLocation)
						.addComponent(lblTitle)
						.addComponent(lblAnno)
						.addGap(30)
						)
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(tfLocation)
						.addComponent(tfTitle)
						.addComponent(tfAnno)
				.addComponent(bSubmit)
						)
				);
			tfLocation.setText("Enter...");
			tfLocation.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					JFileChooser fileChooser=new JFileChooser();
					int returnValue =fileChooser.showOpenDialog(null);
					if(returnValue ==fileChooser.APPROVE_OPTION)
					{
						final File selectedFile=fileChooser.getSelectedFile();
						String extension=getFileExtension(selectedFile);
						if(extension.equals("jpg")|| extension.equals("png")||extension.equals("jpeg")||extension.equals("gif"))
						{
							tfLocation.setText(selectedFile.getName());
							setSelectedFile(selectedFile);
						}
						else
						{
							new ErrorDialog().invoke("Please select a proper image (jpg/png/gif)");
						}
					}
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			bSubmit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(tfLocation.getText().equals("Enter...") || tfTitle.getText().length()==0|| tfAnno.getText().length()==0)
					{
						new ErrorDialog().invoke("Enter all values!!");
						return;
					}
					else
					{
						if(tfTitle.getText().length()>20)
						{
							new ErrorDialog().invoke("The title must be less than 20 characters long!");
							return;
						}
						else if(tfAnno.getText().length()>100)
						{
							new ErrorDialog().invoke("The annotation must be less than 100 characters long!");
							return ;
						}
						else
						{
							Photo photo=new Photo();
							try
							{
								photo.initialiseImage(fileSelected);
								photo.setTitle(tfTitle.getText());
								photo.setAnnotation(tfAnno.getText());
								controller.getPhotos().add(photo);
								
								UploadDialog.this.setVisible(false);
								new HomePage().setVisible(true);
							}
							catch(Exception exp)
							{
								new ErrorDialog().invoke("Error in processing image!Please try again!");
								return;
							}
						}
					}
					
				}
			});
			
		this.getContentPane().setLayout(groupLayout);
		//this.getContentPane().add(lblEnterFileLocation);
		
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
			
			public void setSelectedFile(File file)
			{
				this.fileSelected=file;
			}
}

