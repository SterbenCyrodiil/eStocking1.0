package userinterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelos.entistru;
import modelos.entistru;
import bdcon.EntLigaBD;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class InserEnt extends JInternalFrame {

	private JTextField txtn;
	private JTextField txtm;
	private JTextField txttel;
	private JTextField txtemail;
	private JTextField txtdescr;
	private JTextField txtc;
	private boolean atualizar=false;
	private boolean novo=false;
	boolean verificou=true;
	private JCheckBox chbmorada;
	private JCheckBox chbtel;
	private JCheckBox chbem;
	private JCheckBox chbdesc;
	private boolean carregou=false;
	private int opcao=1;
	boolean entrou = false;
	boolean barrar = false;
	boolean morada=false;
	boolean tel=false;
	boolean email=false;
	boolean descr=true;
	boolean select=false;
	boolean apanhou=false;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserEnt frame = new InserEnt();
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
	public InserEnt() {
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setForeground(Color.WHITE);
		lblCdigo.setBounds(40, 44, 119, 23);
		getContentPane().add(lblCdigo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(40, 73, 119, 23);
		getContentPane().add(lblNome);
		
		JLabel lblMorada = new JLabel("Morada");
		lblMorada.setForeground(Color.WHITE);
		lblMorada.setBounds(40, 102, 119, 23);
		getContentPane().add(lblMorada);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				
				
			}
		});
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setBounds(40, 136, 119, 23);
		getContentPane().add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(40, 165, 119, 23);
		getContentPane().add(lblEmail);
		
		JLabel lblDescricao = new JLabel("Descrica\u00E7\u00E3o");
		lblDescricao.setForeground(Color.WHITE);
		lblDescricao.setBounds(40, 194, 119, 23);
		getContentPane().add(lblDescricao);
		
		
		
		txtc = new JTextField();
		txtc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				try{
					
					Integer.parseInt(txtc.getText());
					
				}catch(Exception exp){
					
					txtc.setText("");
					JOptionPane.showMessageDialog(null, "Preencha corretamente o campo");
					
				}
				
			}
		});
	
		txtc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			
				
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				
			if(opcao==0){
				if(carregou==false){
					
					carregou=true;
					txtc.setText("");
						
				}else{
				
				try{
					
					if(txtc.getText()!=""){
						int teste=Integer.parseInt(txtc.getText());
						}	
								
				}catch(Exception e2){
				
					if(!txtc.getText().equals("")){
						
						
						
						txtc.setText(txtc.getText().substring(0, txtc.getText().length()-1 ));
						//JOptionPane.showMessageDialog(null, "Entrou..."+txtc.getText());
						opcao=0;
						
						}
						
						System.out.println(e2);
						
					
				}
				}
			}
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				if(opcao==1){
				
				if(carregou==false){
					
					carregou=true;
					txtc.setText("");
					
					
				}else{
				
				try{
					
					if(txtc.getText()!=""){
					int teste=Integer.parseInt(txtc.getText());
					
					
					}			
					
				}catch(Exception e2){
					
					
					
					if(!txtc.getText().equals("")){
					
						
						
					txtc.setText(txtc.getText().substring(0, txtc.getText().length()-1 ));
					//JOptionPane.showMessageDialog(null, "Entrou..."+txtc.getText());
					opcao=0;
					
					}
					
					System.out.println(e2);
					
				}
				}
				}
				
			}
		});
		txtc.setBackground(Color.BLACK);
		txtc.setForeground(Color.WHITE);
		txtc.setBounds(125, 44, 157, 23);
		getContentPane().add(txtc);
		txtc.setColumns(10);
		
		txtn = new JTextField();
		txtn.setEnabled(false);
		txtn.setForeground(Color.WHITE);
		txtn.setColumns(10);
		txtn.setBackground(Color.BLACK);
		txtn.setBounds(125, 73, 157, 23);
		getContentPane().add(txtn);
		
		txtm = new JTextField();
		txtm.setEnabled(false);
		txtm.setForeground(Color.WHITE);
		txtm.setColumns(10);
		txtm.setBackground(Color.BLACK);
		txtm.setBounds(125, 102, 157, 23);
		getContentPane().add(txtm);
		
		txttel = new JTextField();
		txttel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				try{
					
					Integer.parseInt(txttel.getText());
					
					
				}catch(Exception exp){
					
					txttel.setText("");
					JOptionPane.showMessageDialog(null, "Preencha corretamente o campo");
					
				}
				
				try{
					
					if(txttel.getText().length()==9){
						
						System.out.println("Correta");
						
					}
					
				}catch(Exception exp2){
					
					JOptionPane.showMessageDialog(null, "Preencha o campo de telefone com 9 caracteres");
					
				}

				
			}
		});
		txttel.setEnabled(false);
		txttel.setForeground(Color.WHITE);
		txttel.setColumns(10);
		txttel.setBackground(Color.BLACK);
		txttel.setBounds(125, 136, 157, 23);
		getContentPane().add(txttel);
		
		txtemail = new JTextField();
		txtemail.setEnabled(false);
		txtemail.setForeground(Color.WHITE);
		txtemail.setColumns(10);
		txtemail.setBackground(Color.BLACK);
		txtemail.setBounds(125, 165, 157, 23);
		getContentPane().add(txtemail);
		
		txtdescr = new JTextField();
		txtdescr.setEnabled(false);
		txtdescr.setForeground(Color.WHITE);
		txtdescr.setColumns(10);
		txtdescr.setBackground(Color.BLACK);
		txtdescr.setBounds(125, 194, 157, 23);
		getContentPane().add(txtdescr);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				novo=true;
				atualizar=false;
				
				chbdesc.setVisible(false);
				chbtel.setVisible(false);
				chbmorada.setVisible(false);
				chbem.setVisible(false);
				
				txtn.setEnabled(true);
				txtm.setEnabled(true);
				txttel.setEnabled(true);
				txtemail.setEnabled(true);
				txtdescr.setEnabled(true);
				

				
				txtc.setText("");
				txtn.setText("");
				txtm.setText("");
				txttel.setText("");
				txtemail.setText("");
				txtdescr.setText("");
				
			}
		});
		btnNovo.setBackground(Color.WHITE);
		btnNovo.setBounds(294, 165, 89, 23);
		getContentPane().add(btnNovo);
		
		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				verificou=true;
				entishow();
				
				
			}
		});
		btnVerificar.setBackground(Color.WHITE);
		btnVerificar.setBounds(294, 44, 89, 23);
		getContentPane().add(btnVerificar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {	
				atualizar=true;
				novo=false;
				
				verificou=true;
				entishow();
				
				txtn.setEnabled(true);
				txtm.setEnabled(false);
				txttel.setEnabled(false);
				txtemail.setEnabled(false);
				txtdescr.setEnabled(false);		
				
				if(entrou=true){
				
				chbdesc.setVisible(true);
				chbtel.setVisible(true);
				chbmorada.setVisible(true);
				chbem.setVisible(true);
				
				entrou=false;
				
				}
				
								
			}
		});
		btnAtualizar.setBackground(Color.WHITE);
		btnAtualizar.setBounds(294, 194, 89, 23);
		getContentPane().add(btnAtualizar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				insertent();
			
				if(atualizar==true){
					
					atualizaent();
					
				}
				
			}
		});
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setBounds(125, 233, 157, 23);
		getContentPane().add(btnGuardar);
		
		chbmorada = new JCheckBox("Morada");
		chbmorada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(chbmorada.isSelected()==true){	
				
				txtm.setEnabled(true);
				morada=true;
						
			}else{
				
				txtm.setEnabled(false);
				morada=false;
				
			}
				
			}
		});
		chbmorada.setVisible(false);
		chbmorada.setBackground(Color.BLACK);
		chbmorada.setForeground(Color.WHITE);
		chbmorada.setBounds(412, 193, 112, 24);
		getContentPane().add(chbmorada);
		
		chbtel = new JCheckBox("Telefone");
		chbtel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chbtel.isSelected()==true){	
					
					txttel.setEnabled(true);
					tel=true;
					
					
				}else{
					
					txttel.setEnabled(false);
					tel=false;
					
				}
				
			}
		});
		chbtel.setVisible(false);
		chbtel.setForeground(Color.WHITE);
		chbtel.setBackground(Color.BLACK);
		chbtel.setBounds(412, 221, 112, 24);
		getContentPane().add(chbtel);
		
		chbem = new JCheckBox("Email");
		chbem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chbem.isSelected()==true){	
					
					txtemail.setEnabled(true);
					email=true;
				
				}else{
					
					txtemail.setEnabled(false);
					email=false;
					
				}
				
			}
		});
		chbem.setVisible(false);
		chbem.setForeground(Color.WHITE);
		chbem.setBackground(Color.BLACK);
		chbem.setBounds(412, 249, 112, 24);
		getContentPane().add(chbem);
		
		chbdesc = new JCheckBox("Descri\u00E7\u00E3o");
		chbdesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(chbdesc.isSelected()==true){	
					
					txtdescr.setEnabled(true);
					descr=true;
					
					
				}else{
					
					txtdescr.setEnabled(false);
					descr=false;
					
				}
				
			}
		});
		chbdesc.setVisible(false);
		chbdesc.setForeground(Color.WHITE);
		chbdesc.setBackground(Color.BLACK);
		chbdesc.setBounds(412, 277, 112, 24);
		getContentPane().add(chbdesc);
		setBorder(null);
		setBounds(100, 100, 605, 342);
		
		

	}
	
	void insertent() {

		if (!txtc.getText().isEmpty() && !txtn.getText().isEmpty()&& !txtm.getText().isEmpty() && !txttel.getText().isEmpty() &&
				!txtemail.getText().isEmpty() && !txtdescr.getText().isEmpty()){

			entistru ss = new entistru();
			
			
			EntLigaBD sso = new EntLigaBD();

			if (!(sso.verificaF(txtc.getText()))) {

				ss.setcod_e(txtc.getText());
				ss.setnome(txtn.getText());
				ss.setmorada(txtm.getText());
				ss.settelefone(txttel.getText());
				ss.setemail(txtemail.getText());
				ss.setdescr(txtdescr.getText());
	

				sso.adicionaE(ss);
				
				JOptionPane.showMessageDialog(null, "Entidade guardado com sucesso");

			} else {

				sso.redreg(txtc.getText());
				JOptionPane.showMessageDialog(null, "J� existe em base de dados");

				
				
			}

			// valida��o dos dados
		} else {

			JOptionPane.showMessageDialog(null,
					"Os campos n�o podem estar vazios ao gravar");


	}
	}
	
	void atualizaent() {

		entistru ss = new entistru();

		EntLigaBD sso = new EntLigaBD();

		entistru ssa = new entistru();

		if ((sso.verificaF(txtc.getText()))) {
			
			ss = sso.redreg(txtc.getText());

			ssa.setcod_e(txtc.getText());
			
			if(chbmorada.isSelected()==true){
				
				select=true;
				
				if(txtm.getText().equals("")){
					
					barrar=true;
					
				}else{
					
					ssa.setmorada(txtm.getText());
					
				}
				
			}else{
				
				ssa.setmorada(ss.getmorada());
				
			}
			
			if(chbtel.isSelected()==true){
				
				select=true;
				
				if(txttel.getText().equals("")){
					
					barrar=true;
					
				}else{
					
					ssa.settelefone(txttel.getText());
					
				}
				
			}else{
				
				ssa.settelefone(ss.gettelefone());
				
			}
			
			if(chbem.isSelected()==true){
				
				select=true;
				
				if(txtemail.getText().equals("")){
					
					barrar=true;
					
				}else{
					
					ssa.setemail(txtemail.getText());
					
				}
				
			}else{
				
				ssa.setemail(ss.getemail());
				
			}
			
			if(chbdesc.isSelected()==true){
				
				select=true;
				
				if(txtdescr.getText().equals("")){
					
					JOptionPane.showMessageDialog(null,
							barrar);
					
					barrar=true;
					
					
				}else{
					
					ssa.setdescr(txtdescr.getText());
					
				}
				
			}else{
				
				ssa.setdescr(ss.getdescr());
				
			}
			
			
			if(barrar==true){
				
				JOptionPane.showMessageDialog(null,
						"Preencha os campos corretamente" +barrar);
				
				barrar=false;
				
				
			}else{
				
				if(select==true){
					
					ssa.setcod_e(ss.getcod_e());
					
					sso.alteradados(ssa);
					
					JOptionPane.showMessageDialog(null,
							"Entidade atualizado com sucesso");
					
					entrou=true;
					
				}
				
			}
			
			}

		// valida��o dos dados

	}
	
	void entishow() {

		EntLigaBD dao = new EntLigaBD();

		if (!txtc.getText().isEmpty()) {

			if ((dao.verificaF(txtc.getText()))) {

			
				entistru ssa = new entistru();

				ssa = dao.redreg(txtc.getText());

				if (verificou == true) {

					JOptionPane.showMessageDialog(null, "Encontrada. Entidade: "
							+ ssa.getnome());
				
					
					txtc.setEnabled(true);
					txtn.setEnabled(false);
					txtm.setEnabled(false);
					txttel.setEnabled(false);
					txtemail.setEnabled(false);
					txtdescr.setEnabled(false);
					
					String nomelimpo=ssa.getnome().trim();

					txtn.setText(ssa.getnome().trim());
					txtm.setText(ssa.getmorada().trim());
					txttel.setText(ssa.gettelefone().trim());
					// cbenti.setSelectedIndex(Integer.parseInt(ssa.getcod_f()));
					txtemail.setText(ssa.getemail().trim());
					txtdescr.setText(ssa.getdescr());
					
					
					
				//	txtq.setText(Integer.toString(ssa.getquantidade()));

				}

			} else {

				JOptionPane.showMessageDialog(null, "Entidade n�o encontrada");

			}
			
		}else{
			
			JOptionPane.showMessageDialog(null, "Insira um c�digo de entidade");
			
		}
		
	}
	

}
