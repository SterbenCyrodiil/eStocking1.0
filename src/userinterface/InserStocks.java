package userinterface;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.Color;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import bdcon.StocksLigaBD;
import modelos.QueryTableModel;
import modelos.stockregis;
import modelos.stockstru;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextPane;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;



public class InserStocks extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static InserStocks frame;
	private JTextField txtc;
	private JTextField txtn;
	private JTextField txtd;
	private JTextField txtp;
	private JTextField txtq;
	private JComboBox cbcateg;
	private JComboBox cbforn;
	private JComboBox cbuni;
	private JComboBox cbmoeda;
	DefaultComboBoxModel comboModel1;
	private JButton btnVeri;
	private JButton btnNovo;
	private boolean checkwork=false;
	private JTextPane txtpnInsiraTodosOs;
	private JButton btnins;
	private boolean update=false;
	private boolean verificou=false;
	private JButton btnApagar;
	private JButton btnAdicionar;
	private boolean incrementar=false;
	private boolean atualizar=false;
	private boolean novo=false;
	private boolean carregou=false;
	private boolean dot=false;
	int opcao=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new InserStocks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public InserStocks() {
		
		setBackground(Color.BLACK);
		setBorder(null);
		setBounds(100, 100, 711, 465);
	
		
		
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setBounds(45, 51, 46, 14);
		lblNewLabel.setForeground(Color.WHITE);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(45, 77, 46, 14);
		lblNome.setForeground(Color.WHITE);
		getContentPane().add(lblNome);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(45, 100, 66, 14);
		lblDescrio.setForeground(Color.WHITE);
		getContentPane().add(lblDescrio);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(45, 125, 66, 14);
		lblCategoria.setForeground(Color.WHITE);
		getContentPane().add(lblCategoria);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(45, 178, 46, 14);
		lblPreo.setForeground(Color.WHITE);
		getContentPane().add(lblPreo);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setBounds(45, 206, 82, 14);
		lblFornecedor.setForeground(Color.WHITE);
		getContentPane().add(lblFornecedor);
		
		JLabel lblUnidades = new JLabel("Unidades");
		lblUnidades.setBounds(45, 231, 82, 14);
		lblUnidades.setForeground(Color.WHITE);
		getContentPane().add(lblUnidades);
		
		txtc = new JTextField();
		txtc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				verificou=true;
				
				if(novo==true){
				
				try{
					
					Integer.parseInt(txtc.getText());
					
				}catch(Exception exp){
					
					txtc.setText("");
					JOptionPane.showMessageDialog(null, "Preencha corretamente o campo");
					
				}
				
			//	stockshow();
				
				}
				
			}
		});
		txtc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				verificou=true;
				
				if(opcao==0){
					if(carregou==false){
						
						carregou=true;
						txtc.setText("");
							
					}else{
					
					try{
						
						if(txtc.getText()!="" && arg0.getKeyCode()!=KeyEvent.VK_BACK_SPACE){
							int teste=Integer.parseInt(txtc.getText());
							}	
									
					}catch(Exception e2){
					
						if(!txtc.getText().equals("") && arg0.getKeyCode()!=KeyEvent.VK_BACK_SPACE){
							
							
							
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
			public void keyReleased(KeyEvent arg0) {
				
				verificou=true;
				
				if(opcao==0){
					if(carregou==false){
						
						carregou=true;
						txtc.setText("");
							
					}else{
					
					try{
						
						if(txtc.getText()!="" && arg0.getKeyCode()!=KeyEvent.VK_BACK_SPACE){
							int teste=Integer.parseInt(txtc.getText());
							}	
									
					}catch(Exception e2){
					
						if(!txtc.getText().equals("") && arg0.getKeyCode()!=KeyEvent.VK_BACK_SPACE){
							
							
							
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
		txtc.setBounds(131, 45, 221, 20);
		txtc.setBackground(Color.BLACK);
		txtc.setForeground(Color.WHITE);
		getContentPane().add(txtc);
		txtc.setColumns(10);
		
		txtn = new JTextField();
		txtn.setBounds(131, 71, 221, 20);
		txtn.setEnabled(false);
		txtn.setForeground(Color.WHITE);
		txtn.setColumns(10);
		txtn.setBackground(Color.BLACK);
		getContentPane().add(txtn);
		
		txtd = new JTextField();
		txtd.setBounds(131, 95, 221, 20);
		txtd.setEnabled(false);
		txtd.setForeground(Color.WHITE);
		txtd.setColumns(10);
		txtd.setBackground(Color.BLACK);
		getContentPane().add(txtd);
		
		cbcateg = new JComboBox();
		cbcateg.setBounds(131, 122, 221, 20);
		cbcateg.setEnabled(false);
		cbcateg.setModel(new DefaultComboBoxModel(new String[] {"SELECIONAR", "Perif\u00E9ricos", "Componentes", "Acess\u00F3rios", "Software", "Redes", "Mobile", "Consum\u00EDveis", "Computadores", "Consolas", "Gadjets"}));
		cbcateg.setBackground(Color.BLACK);
		cbcateg.setForeground(Color.WHITE);
		getContentPane().add(cbcateg);
		
		txtp = new JTextField();
		txtp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				try{
					
					Double.parseDouble(txtp.getText());
					
				}catch(Exception exp){
					
					txtp.setText("");
					JOptionPane.showMessageDialog(null, "Preencha corretamente o campo");
					
				}
				
			}
		});
		txtp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				
				
				if(opcao==0){
					if(carregou==false){
						
						carregou=true;
						txtp.setText("");
							
					}else{
					
					try{
						
						if(txtp.getText()!="" && arg0.getKeyCode()!=KeyEvent.VK_BACK_SPACE){
							Double teste=Double.parseDouble(txtp.getText());
							}	
									
					}catch(Exception e2){
					
						if(!txtp.getText().equals("") && arg0.getKeyCode()!=KeyEvent.VK_BACK_SPACE && arg0.getKeyCode()!=KeyEvent.VK_PERIOD){
							
						
							
							if(txtp.getText().contains(".")){
							
							
							txtp.setText(txtp.getText().substring(0, txtp.getText().length()-1 ));
							//JOptionPane.showMessageDialog(null, "Entrou..."+txtc.getText());
							opcao=0;
							
							}
						}						
	
							
							System.out.println(e2);
							
						
					}
					}
				}
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(opcao==0){
					if(carregou==false){
						
						carregou=true;
						txtp.setText("");
							
					}else{
					
					try{
						
						if(txtp.getText()!="" && e.getKeyCode()!=KeyEvent.VK_BACK_SPACE && e.getKeyCode()!=KeyEvent.VK_PERIOD){
							Double teste=Double.parseDouble(txtp.getText());
							}	
									
					}catch(Exception e2){
					
if(!txtp.getText().equals("") && e.getKeyCode()!=KeyEvent.VK_BACK_SPACE && e.getKeyCode()!=KeyEvent.VK_PERIOD){
							

							
							if(txtp.getText().contains(".")){
							
							
							txtp.setText(txtp.getText().substring(0, txtp.getText().length()-1 ));
							//JOptionPane.showMessageDialog(null, "Entrou..."+txtc.getText());
							opcao=0;
							
							}
}						
	
							
							System.out.println(e2);
							
						
					}
					}
				}
				
			}
		});
		txtp.setBounds(131, 175, 221, 20);
		txtp.setEnabled(false);
		txtp.setForeground(Color.WHITE);
		txtp.setColumns(10);
		txtp.setBackground(Color.BLACK);
		getContentPane().add(txtp);
		
		cbforn = new JComboBox();
		cbforn.setBounds(131, 200, 221, 20);
		cbforn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		cbforn.setEnabled(false);
		cbforn.setModel(new DefaultComboBoxModel(new String[] {"SELECIONAR"}));
		cbforn.setForeground(Color.WHITE);
		cbforn.setBackground(Color.BLACK);
		getContentPane().add(cbforn);
		
		cbmoeda = new JComboBox();
		cbmoeda.setBounds(131, 228, 101, 20);
		cbmoeda.setEnabled(false);
		cbmoeda.setModel(new DefaultComboBoxModel(new String[] {"Moeda", "Euro", "Libra"}));
		cbmoeda.setForeground(Color.WHITE);
		cbmoeda.setBackground(Color.BLACK);
		getContentPane().add(cbmoeda);
		
		cbuni = new JComboBox();
		cbuni.setBounds(251, 228, 101, 20);
		cbuni.setEnabled(false);
		cbuni.setModel(new DefaultComboBoxModel(new String[] {"Unidades", "Pe\u00E7a", "Kilograma"}));
		cbuni.setForeground(Color.WHITE);
		cbuni.setBackground(Color.BLACK);
		getContentPane().add(cbuni);
		
		btnins = new JButton("Guardar");
		btnins.setBounds(131, 260, 221, 23);
		btnins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(novo==true){
				
				if(txtc.getText()!="" && txtn.getText()!="" && txtd.getText()!="" && cbcateg.getSelectedIndex()!=0
						&& txtp.getText()!="" && cbforn.getSelectedIndex()!=0 && cbmoeda.getSelectedIndex()!=0
						&& cbuni.getSelectedIndex()!=0 && txtq.getText()!=""){
				
				
				
				insertstock();
				colocareg();
				
				
				
				txtn.setEnabled(false);
				txtd.setEnabled(false);
				cbcateg.setEnabled(false);
				txtp.setEnabled(false);
				cbforn.setEnabled(false);
				cbmoeda.setEnabled(false);
				cbuni.setEnabled(false);
				txtq.setEnabled(false);
				btnins.setEnabled(false);
				
				txtc.setText("");
				txtn.setText("");
				txtd.setText("");
				cbcateg.setSelectedIndex(0);
				txtp.setText("");
				cbforn.setSelectedIndex(0);
				cbmoeda.setSelectedIndex(0);
				cbuni.setSelectedIndex(0);
				txtq.setText("");
				

				
				}else{
					
					JOptionPane.showMessageDialog(null, "Preencha corretamente os campos");
					
				}
				
				}
				
				if(incrementar==true){
					
					adicionastock();
					colocareg();
					
					txtn.setEnabled(false);
					txtd.setEnabled(false);
					cbcateg.setEnabled(false);
					txtp.setEnabled(false);
					cbforn.setEnabled(false);
					cbmoeda.setEnabled(false);
					cbuni.setEnabled(false);
					txtq.setEnabled(false);
					btnins.setEnabled(false);
					
					txtc.setText("");
					txtn.setText("");
					txtd.setText("");
					cbcateg.setSelectedIndex(0);
					txtp.setText("");
					cbforn.setSelectedIndex(0);
					cbmoeda.setSelectedIndex(0);
					cbuni.setSelectedIndex(0);
					txtq.setText("");
					
				}
				
				
			}
		});
		btnins.setEnabled(false);
		btnins.setForeground(Color.BLACK);
		btnins.setBackground(Color.WHITE);
		getContentPane().add(btnins);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(45, 153, 82, 14);
		lblQuantidade.setForeground(Color.WHITE);
		getContentPane().add(lblQuantidade);
		
		txtq = new JTextField();
		txtq.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				try{
					
					Integer.parseInt(txtq.getText());
					
				}catch(Exception exp){
					
					txtq.setText("");
					JOptionPane.showMessageDialog(null, "Preencha corretamente o campo");
					
				}
				
			}
		});
		txtq.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(opcao==0){
					if(carregou==false){
						
						carregou=true;
						txtq.setText("");
							
					}else{
					
					try{
						
						if(txtq.getText()!=""){
							int teste=Integer.parseInt(txtq.getText());
							}	
									
					}catch(Exception e2){
					
						if(!txtq.getText().equals("") && arg0.getKeyCode()!=KeyEvent.VK_BACK_SPACE){
							
							
							
							txtq.setText(txtq.getText().substring(0, txtq.getText().length()-1 ));
							//JOptionPane.showMessageDialog(null, "Entrou..."+txtc.getText());
							opcao=0;
							
							}
							
							System.out.println(e2);
							
						
					}
					}
				}
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
				if(opcao==0){
					if(carregou==false){
						
						carregou=true;
						txtq.setText("");
							
					}else{
					
					try{
						
						if(txtq.getText()!="" && e.getKeyCode()!=KeyEvent.VK_BACK_SPACE){
							int teste=Integer.parseInt(txtq.getText());
							}	
									
					}catch(Exception e2){
					
						if(!txtq.getText().equals("") && e.getKeyCode()!=KeyEvent.VK_BACK_SPACE){
							
							txtq.setText(txtq.getText().substring(0, txtq.getText().length()-1 ));
							//JOptionPane.showMessageDialog(null, "Entrou..."+txtc.getText());
							opcao=0;
							
							}
							
							System.out.println(e2);
										
					}
					}
				}
				
			}
		});
		txtq.setBounds(131, 149, 221, 20);
		txtq.setEnabled(false);
		txtq.setForeground(Color.WHITE);
		txtq.setColumns(10);
		txtq.setBackground(Color.BLACK);
		getContentPane().add(txtq);
		
		btnVeri = new JButton("Verificar");
		btnVeri.setBounds(364, 46, 101, 24);
		btnVeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtc.setEnabled(true);
				txtn.setEnabled(true);
				txtd.setEnabled(true);
				cbcateg.setEnabled(true);
				txtp.setEnabled(true);
				cbforn.setEnabled(true);
				cbmoeda.setEnabled(true);
				cbuni.setEnabled(true);
				txtq.setEnabled(true);
				btnins.setEnabled(true);
				
				comboModel1 = new DefaultComboBoxModel();
				comboModel1 = cbforni();
				cbforn.setModel(comboModel1);
				verificou=true;
				
				stockshow();
				
				verificou=false;
				
			}
		});
		btnVeri.setForeground(Color.BLACK);
		btnVeri.setBackground(Color.WHITE);
		getContentPane().add(btnVeri);
		
		btnNovo = new JButton("Novo");
		btnNovo.setToolTipText("Desbloqueia todos os campos para inser\u00E7\u00E3o");
		btnNovo.setBounds(364, 173, 175, 25);
		btnNovo.setForeground(Color.BLACK);
		btnNovo.setBackground(Color.WHITE);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				atualizar=false;
				incrementar =false;
				novo=true;
				
				txtc.setEnabled(true);
				txtn.setEnabled(true);
				txtd.setEnabled(true);
				cbcateg.setEnabled(true);
				txtp.setEnabled(true);
				cbforn.setEnabled(true);
				cbmoeda.setEnabled(true);
				cbuni.setEnabled(true);
				txtq.setEnabled(true);
				btnins.setEnabled(true);
				txtc.setText("");
				txtn.setText("");
				txtd.setText("");
				cbcateg.setSelectedIndex(0);
				txtp.setText("");
				cbforn.setSelectedIndex(0);
				cbmoeda.setSelectedIndex(0);
				cbuni.setSelectedIndex(0);
				txtq.setText("");
				update=false;
				
				
				
				comboModel1 = new DefaultComboBoxModel();
				comboModel1 = cbforni();
				cbforn.setModel(comboModel1);
				
			}
		});
		getContentPane().add(btnNovo);
		
		txtpnInsiraTodosOs = new JTextPane();
		txtpnInsiraTodosOs.setBounds(368, 97, 283, 68);
		txtpnInsiraTodosOs.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtpnInsiraTodosOs.setText("Insira todos os dados corretamente, e preencha todos os campos!\r\nClique em Novo para come\u00E7ar a edi\u00E7\u00E3o");
		txtpnInsiraTodosOs.setBackground(Color.BLACK);
		txtpnInsiraTodosOs.setForeground(Color.WHITE);
		getContentPane().add(txtpnInsiraTodosOs);
		
		btnApagar = new JButton("Apagar");
		btnApagar.setBounds(477, 45, 101, 24);
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				apagastock();
				
			}
		});
		btnApagar.setForeground(Color.BLACK);
		btnApagar.setBackground(Color.WHITE);
		getContentPane().add(btnApagar);
		
		btnAdicionar = new JButton("Adicionar valores");
		btnAdicionar.setToolTipText("Adiciona novos valores de uma entrada");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				incrementar=true;
				atualizar=false;
				novo=false;
				
				txtc.setEnabled(true);
				txtn.setEnabled(false);
				txtd.setEnabled(false);
				cbcateg.setEnabled(false);
				txtp.setEnabled(true);
				cbforn.setEnabled(false);
				cbmoeda.setEnabled(false);
				cbuni.setEnabled(false);
				txtq.setEnabled(true);
				btnins.setEnabled(true);
				
			}
		});
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setBackground(Color.WHITE);
		btnAdicionar.setBounds(364, 201, 175, 25);
		getContentPane().add(btnAdicionar);

	}
	
	
	DefaultComboBoxModel cbforni() {
		DefaultComboBoxModel comboModel = new DefaultComboBoxModel();

		comboModel.addElement("Selecionar");
		
		try {
			String xsql = "select nome,cod_fornecedor from fornecedor order by nome";

			Statement stmt = Menu_Login.myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(xsql);

			while (rs.next()) {
				comboModel.addElement(new QueryResult(rs.getString("cod_fornecedor"), rs.getString("nome")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return comboModel;
	}

	class QueryResult {
		String recordCode;
		String description;

		public QueryResult(String rc, String desc) {
			recordCode = rc;
			description = desc;
		}

		public String toString() {
			return description;
		}
	
	
	}	
	
	int getComboIndex(JComboBox pcomboBox, String pvalue) {
		for (int i = 0; i < cbforn.getItemCount(); i++) {
			QueryResult temp = (QueryResult) pcomboBox.getItemAt(i);

			// JOptionPane.showMessageDialog(null, temp.description+"
			// "+temp.recordNumber);

			if (temp.recordCode.equals(pvalue)) {
				return i;

			}
		}
		return -1;
	}
	
	void insertstock() {

		if (txtc.getText() != "" && txtn.getText() != ""
				&& txtd.getText() != "" && cbcateg.getSelectedIndex() != 0
				&& txtp.getText() != "" && cbforn.getSelectedIndex() != 0
				&& cbmoeda.getSelectedIndex() != 0
				&& cbuni.getSelectedIndex() != 0 && txtq.getText() != "") {

			stockstru ss = new stockstru();
			
			StocksLigaBD sso = new StocksLigaBD();

			if (!(sso.verificaS(txtc.getText()))) {

				ss.setcods(Integer.parseInt(txtc.getText()));
				ss.setnome(txtn.getText());
				ss.settexto(txtd.getText());
				ss.setcod_c(cbcateg.getSelectedIndex());
				QueryResult temp = (QueryResult) cbforn.getSelectedItem();
				ss.setcod_f(temp.recordCode);
				ss.setquantidade(Integer.parseInt(txtq.getText()));
				ss.setprec(Double.parseDouble(txtp.getText()));
				ss.setunidade(cbuni.getSelectedItem().toString());
				ss.setmoeda(cbmoeda.getSelectedItem().toString());
	
				sso.adicionaS(ss);
				
				JOptionPane.showMessageDialog(null, "Dados insiridos com sucesso na base de dados. Nome: "+ss.getnome() );

			} else {
				
				JOptionPane.showMessageDialog(null, "Já existe em base de dados. Use outro código!");
				
				stockstru ssa = new stockstru();
				ssa = sso.redreg(txtc.getText());

				
				
			}

			// validação dos dados
		} else {

			JOptionPane.showMessageDialog(null,
					"Os campos não podem estar vazios ao gravar");


	}
	}
	
	void colocareg(){
		
		stockregis sr = new stockregis();
		StocksLigaBD sso = new StocksLigaBD();
		sr = sso.redregis();
		
		int codebd=sr.getcodr();
		int novocod=codebd+1;
		
		sr.setcodr(novocod);
		sr.setcodp(txtc.getText());
		sr.setquantidade(Integer.parseInt(txtq.getText()));
		sr.setprec(Double.parseDouble(txtp.getText()));
		DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
		Date data = new Date();
		sr.setdata(df.format(data).toString());
		sr.settipo("Adicionar");
		
		sso.registo(sr);
		
	}

	
	void adicionastock() {

		if (txtc.getText() != "" && txtp.getText() != "" && txtq.getText() != "") {

			stockstru ss = new stockstru();
			StocksLigaBD sso = new StocksLigaBD();

			
			stockstru ssa = new stockstru();
			ssa = sso.redreg(txtc.getText());

				int quantidadeex=Integer.parseInt(txtq.getText());
				double precex=Double.parseDouble((txtp.getText()));
				double precbd=ssa.getprec();
				int quantidadebd=ssa.getquantidade();
				int quantifinal=quantidadeex+quantidadebd;
				double precmedia= ((quantidadeex*precex)+(quantidadebd*precbd))/(quantidadeex+quantidadebd);
				ss.setcods(Integer.parseInt(txtc.getText()));
				ss.setquantidade(quantifinal);
				ss.setprec(precmedia);
			/*	DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
				Date data = new Date(); */
				

				sso.alteravalores(ss);

				JOptionPane.showMessageDialog(null, "Adicionado com sucesso em base de dados");
			

			// validação dos dados
		} else {

			JOptionPane.showMessageDialog(null,
					"Os campos não podem estar vazios ao gravar");

		}
		
	}
	
	
	
	void stockshow() {

		StocksLigaBD dao = new StocksLigaBD();

		if (!txtc.getText().isEmpty()) {

			if ((dao.verificaS(txtc.getText()))) {

				update = true;
				stockstru ssa = new stockstru();

				ssa = dao.redreg(txtc.getText());

				if (verificou == true) {

					JOptionPane.showMessageDialog(null, "Encontrado. Produto: "
							+ ssa.getnome());
					txtc.setEnabled(true);
					txtn.setEnabled(true);
					txtd.setEnabled(true);
					cbcateg.setEnabled(true);
					txtp.setEnabled(true);
					cbforn.setEnabled(true);
					cbmoeda.setEnabled(true);
					cbuni.setEnabled(true);
					txtq.setEnabled(true);
					btnins.setEnabled(true);
					
					String nomelimpo=ssa.getnome().trim();

					txtn.setText(ssa.getnome().trim());
				/*	txtd.setText(ssa.gettexto());
					cbcateg.setSelectedIndex(ssa.getcod_c());
					txtp.setText(Double.toString(ssa.getprec()));
					// cbforn.setSelectedIndex(Integer.parseInt(ssa.getcod_f()));
					txtq.setText(Integer.toString(ssa.getquantidade()));
					cbmoeda.setSelectedItem(ssa.getmoeda());
					cbuni.setSelectedItem(ssa.getunidade());
					int idx = getComboIndex(cbforn, ssa.getcod_f() );
					cbforn.setSelectedItem(idx);
					*/
					
				}

			} else {

				JOptionPane.showMessageDialog(null, "Produto não encontrado");

			}

		}

	}	

	void apagastock(){
		
	      stockstru sal = new stockstru();
		 StocksLigaBD dao = new StocksLigaBD();
		
		 sal.setcods(Integer.parseInt(txtc.getText()));
		
		if ((txtc.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios ao apagar");
		} else {
			
		if (!(dao.apaga(txtc.getText()))); {
			JOptionPane.showMessageDialog(null,
					"Entrada " +sal.getcods()+" apagada com sucesso! ");
			stockregis sr = new stockregis();
			StocksLigaBD sso = new StocksLigaBD();
			sr = sso.redregis();
			
			int codebd=sr.getcodr();
			int novocod=codebd+1;
			
			sr.setcodr(novocod);
			sr.setcodp(txtc.getText());
			sr.setquantidade(sr.getquantidade());
			sr.setprec(sr.getprec());
			DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
			Date data = new Date();
			sr.setdata(df.format(data).toString());
			sr.settipo("Apagar");
			
			sso.registo(sr);
			
	  }
	}
}
	
}
