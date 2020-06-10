package userinterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utilitarios.PostgreSQLJDBC;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;

public class Menu_Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	public static String nick="";
	public static String  txtNewLabel="";
	public static Connection myCon=null;
	private boolean vazio=false;
	public static boolean abrir=false;
	private JTextField textField_pass;
	boolean mostra=false;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		
			Menu_Login dialog = new Menu_Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Menu_Login() {
		setUndecorated(true);
		setModal(true);
		setTitle("eStocking- Login");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rodrigo\\OneDrive\\workspace\\PAPidea1\\logo.jpg"));
		setBounds(100, 100, 450, 375);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBackground(Color.BLACK);
			textField.setForeground(Color.WHITE);
			textField.setBounds(173, 97, 168, 35);
			contentPanel.add(textField);
			textField.setColumns(10);
			textField.setText("postgres");
		}
		
		JLabel lblUtilizador = new JLabel("Utilizador");
		lblUtilizador.setForeground(Color.WHITE);
		lblUtilizador.setBounds(71, 107, 68, 14);
		contentPanel.add(lblUtilizador);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(71, 153, 46, 14);
		contentPanel.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(Color.BLACK);
		passwordField.setBounds(173, 144, 168, 35);
		contentPanel.add(passwordField);
		
		passwordField.setText("");
		
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 256, 365, 14);
		lblNewLabel.setText("Estado: Desligado, em Stand-by");
		contentPanel.add(lblNewLabel);
		
		JLabel lblBemvindoAoPrograma = new JLabel("Bem-vindo ao programa eStocking!");
		lblBemvindoAoPrograma.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBemvindoAoPrograma.setForeground(Color.WHITE);
		lblBemvindoAoPrograma.setBounds(42, 29, 320, 31);
		contentPanel.add(lblBemvindoAoPrograma);
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(mostra==false){
				
				textField_pass.setVisible(true);
				textField_pass.setText(passwordField.getText());
				passwordField.setVisible(false);
				mostra=true;
				
				}else{
					
					passwordField.setVisible(true);
					passwordField.setText(textField_pass.getText());
					textField_pass.setVisible(false);
					mostra=false;
				}
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		button.setBounds(355, 145, 39, 31);
		contentPanel.add(button);
		
		textField_pass = new JTextField();
		textField_pass.setVisible(false);
		textField_pass.setText("postgres");
		textField_pass.setForeground(Color.WHITE);
		textField_pass.setColumns(10);
		textField_pass.setBackground(Color.BLACK);
		textField_pass.setBounds(173, 144, 168, 35);
		contentPanel.add(textField_pass);
	
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setForeground(Color.WHITE);
				okButton.setBackground(Color.BLACK);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if(!textField.getText().equals("") && !passwordField.getText().equals("")){
						
					try
					{
						myCon=PostgreSQLJDBC.liga_pgs(textField.getText() ,passwordField.getText());
						
					}
					catch (Exception e) {
				         e.printStackTrace();
				        System.err.println(e.getClass().getName()+": "+e.getMessage());
				        
				        
				      }
						}else{
							
							JOptionPane.showMessageDialog(null, "Preencha os campos!");
							vazio=true;
						}

					//	System.out.print(myCon);

						if (myCon!=null)
						{
							abrir=true;
							lblNewLabel.setText("Estado: Ligado");
							//txtNewLabel="Ligou";
							nick=textField.getText();
							JOptionPane.showMessageDialog(null, "Ligado com sucesso. Utilizador: "+nick);
							
							dispose();
						}
						
						else
						{
							//txtNewLabel="Não ligou";
						
							
							
							lblNewLabel.setText("Estado: Pendente, em Stand-by");
							
							if(vazio==false){
							JOptionPane.showMessageDialog(null, "Autenticação falhou");
							vazio=false;
							}
							
							vazio=false;
						}
						
						
						
						
					}
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				
				getRootPane().setDefaultButton(okButton);
			}
			
			
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(Color.BLACK);
				cancelButton.setForeground(Color.WHITE);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
