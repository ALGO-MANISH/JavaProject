package javaProject;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main extends JFrame {
	
	public Main (String s) {
		super(s);
	}
	
	JLabel l1,l2,l3,l4;	
	JButton b1,b2,b3,b4,b5;
	
	
	
	private void operate(int key,String msg) {
		JFileChooser fileChooser=new JFileChooser();
		fileChooser.showOpenDialog(null);
		File file=fileChooser.getSelectedFile();
		
		//file fileInputStrem 
		try {
			FileInputStream fis=new FileInputStream(file);
			byte[]data=new byte[fis.available()];
			fis.read(data);
			int i=0;
			for(byte b: data) {				
				data[i]=(byte) (b^key);
				i++;
			}
			
			FileOutputStream fos=new FileOutputStream(file);
			fos.write(data);
			fos.close();
			fis.close();			
			JOptionPane.showMessageDialog(null,msg);
			
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public  void setComponents() {
		//add(new JLabel(new ImageIcon("aa.jpg")));
		Font font =new Font("Roboto",Font.BOLD,20);
		Font font1=new Font("Roboto",Font.BOLD,15);
		
		
		l1=new JLabel("Welcome to File Encryption/Decryption Portal ");
		l2=new JLabel("Choose an operation");
		b1=new JButton("Encryption");		
		b2=new JButton("Decryption");		
		l1.setFont(font);
		l2.setFont(font1);
		setLayout(null);
		
		
		l1.setBounds(50,30,500,30);		
		l2.setBounds(200,100,500,30);
		b1.setBounds(150,150,100,40);
		b2.setBounds(300,150,100,40);
		
		
		b1.addActionListener(e->{	
			
			JFrame f1=new JFrame();
			f1.setTitle("Encryption");
			f1.setSize(500,350);
			f1.setLocationRelativeTo(null);	
			f1.setLayout(null);			
			f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
			
			l3=new JLabel("Write Your Encryption Key");
			l3.setBounds(130,110,400,30);
			l3.setFont(font1);
			b3=new JButton("Open File");
			b3.setBounds(180,200,100,40);
			JTextField t1=new JTextField(8);
			t1.setBounds(150,150,150,30);
			t1.setFont(font1);
			
			f1.add(t1);
			f1.add(l3);
			f1.add(b3);
			f1.setVisible(true);

			
			b3.addActionListener(ee->{				
				String tempText= t1.getText();
				int temp=Integer.parseInt(tempText);
				String msg="Encryption Done";
				operate(temp,msg);
				f1.setVisible(false);
			});	
			
		});
		
		
		b2.addActionListener(e->{			
			JFrame f1=new JFrame();
			f1.setTitle("Decryption");
			f1.setSize(500,350);
			f1.setLocationRelativeTo(null);	
			f1.setLayout(null);			
			f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			l3=new JLabel("Type Your Decryption Key");
			l3.setBounds(130,110,400,30);
			l3.setFont(font1);
			b3=new JButton("Open File");
			b3.setBounds(180,200,100,40);
			JTextField t1=new JTextField(8);
			t1.setBounds(150,150,150,30);
			t1.setFont(font1);
			
			f1.add(t1);
			f1.add(l3);
			f1.add(b3);			
			f1.setVisible(true);
	
			
			
			b3.addActionListener(ee->{				
				String tempText= t1.getText();
				int temp=Integer.parseInt(tempText);
				String msg="Decryption Done";
				operate(temp,msg);
				f1.setVisible(false);
			});
				
			
		});
		
		
		add(l1);
		add(l2);
		add(b1);
		add(b2);	
		
		
	}
	

	public static void main(String[] args) {
		
		Main jf=new Main("File Operation");
		jf.setComponents();
	//	jf.getContentPane().setBackground(Color.CYAN);
		
		jf.setLocation(new Point(450, 250));
		jf.setSize(600,350);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

	}

}
