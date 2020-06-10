package userinterface;

import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.JInternalFrame;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class Info extends JInternalFrame {

	Image img;
	Image img2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Info frame = new Info();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Info() {
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("eStocking v1.1 Alpha Preview");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(12, 27, 329, 27);
		getContentPane().add(lblNewLabel);
		
		JLabel lblDesenvolvidoPorRodrigo = new JLabel("Desenvolvido por Rodrigo Coelho");
		lblDesenvolvidoPorRodrigo.setForeground(Color.WHITE);
		lblDesenvolvidoPorRodrigo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDesenvolvidoPorRodrigo.setBackground(Color.WHITE);
		lblDesenvolvidoPorRodrigo.setBounds(12, 66, 244, 21);
		getContentPane().add(lblDesenvolvidoPorRodrigo);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
	//	lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Rodrigo\\OneDrive\\workspace\\PAPIdea2\\logo.jpg"));
		lblNewLabel_1.setBounds(643, 46, 255, 255);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Info.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		label.setBounds(269, 71, 16, 16);
		getContentPane().add(label);
		setBorder(null);
		setBounds(100, 100, 910, 545);
		
		try{
			
			
			
			File input= new File("logo.jpg");
			img= ImageIO.read(input);
			
		}catch(IOException ie){
			
			ie.printStackTrace();
			
		}
		
		try{
			
			File input= new File("bone.png");
			img2= ImageIO.read(input);
			
		}catch(IOException ie){
			
			ie.printStackTrace();
			
		}
		
		lblNewLabel_1.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		lblNewLabel_2.setBounds(540, 382, 358, 124);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblFeitoEm = new JLabel("Com tecnologia Java e SQL");
		lblFeitoEm.setForeground(Color.WHITE);
		lblFeitoEm.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFeitoEm.setBackground(Color.WHITE);
		lblFeitoEm.setBounds(12, 99, 200, 21);
		getContentPane().add(lblFeitoEm);
		
		JTextPane txtpnContactos = new JTextPane();
		txtpnContactos.setEditable(false);
		txtpnContactos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnContactos.setForeground(Color.WHITE);
		txtpnContactos.setBackground(Color.BLACK);
		txtpnContactos.setText("Email: rodrigosterben@outlook.pt / rodrigo.coelho1999@gmail.com\r\nTelem\u00F3vel: 913560559\r\nDiscord: Sterben Septim\r\n\r\nDispon\u00EDvel para apoio t\u00E9cnico\r\n");
		txtpnContactos.setBounds(23, 228, 568, 129);
		getContentPane().add(txtpnContactos);
		
		JLabel lblContactos = new JLabel("Contactos");
		lblContactos.setLabelFor(txtpnContactos);
		lblContactos.setForeground(Color.WHITE);
		lblContactos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContactos.setBounds(28, 194, 78, 22);
		getContentPane().add(lblContactos);
		
		JLabel lblRodrigoCoelho = new JLabel("Rodrigo Coelho 2017\r\n");
		lblRodrigoCoelho.setForeground(Color.WHITE);
		lblRodrigoCoelho.setBounds(402, 475, 126, 14);
		getContentPane().add(lblRodrigoCoelho);
		
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		

	}
}
