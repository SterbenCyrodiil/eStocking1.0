package userinterface;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import modelos.faturastru;
import modelos.stockstru;
import userinterface.InserStocks.QueryResult;
import bdcon.FaturasLigaBD;
import bdcon.StocksLigaBD;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class InserFaturas extends JInternalFrame {
	private JTextField txtc;
	private JTextField txtn;
	private JTextField txtref;
	private JTextField txtv;
	DefaultComboBoxModel comboModel1;
	DefaultComboBoxModel comboModel2;
	JComboBox cbmoeda;
	JComboBox cbcateg;
	JComboBox cbent;
	private boolean carregou=false;
	JButton btnin;
	int opcao=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserFaturas frame = new InserFaturas();
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
	public InserFaturas() {
		getContentPane().setBackground(Color.BLACK);
		
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setBounds(70, 60, 58, 14);
		lblNewLabel.setForeground(Color.WHITE);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(70, 85, 58, 14);
		lblNome.setForeground(Color.WHITE);
		getContentPane().add(lblNome);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(70, 110, 58, 14);
		lblCategoria.setForeground(Color.WHITE);
		getContentPane().add(lblCategoria);
		
		JLabel lblReferncia = new JLabel("Refer\u00EAncia");
		lblReferncia.setBounds(70, 135, 74, 14);
		lblReferncia.setForeground(Color.WHITE);
		getContentPane().add(lblReferncia);
		
		JLabel lblEntidade = new JLabel("Entidade");
		lblEntidade.setBounds(70, 160, 58, 14);
		lblEntidade.setForeground(Color.WHITE);
		getContentPane().add(lblEntidade);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(70, 185, 58, 14);
		lblValor.setForeground(Color.WHITE);
		getContentPane().add(lblValor);
		
		JLabel lblMoeda = new JLabel("Moeda");
		lblMoeda.setBounds(70, 210, 58, 14);
		lblMoeda.setForeground(Color.WHITE);
		getContentPane().add(lblMoeda);
		
		txtc = new JTextField();
		txtc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				comboModel1 = new DefaultComboBoxModel();
				comboModel1 = cbenti();
				cbent.setModel(comboModel1);
				
				comboModel2 = new DefaultComboBoxModel();
				comboModel2 = cbcategi();
				cbcateg.setModel(comboModel2);
				
				faturashow();
				
			}
		});
		txtc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
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
		});
		txtc.setBounds(146, 57, 221, 20);
		txtc.setForeground(Color.WHITE);
		txtc.setColumns(10);
		txtc.setBackground(Color.BLACK);
		getContentPane().add(txtc);
		
		txtn = new JTextField();
		txtn.setEnabled(false);
		txtn.setBounds(146, 82, 221, 20);
		txtn.setForeground(Color.WHITE);
		txtn.setColumns(10);
		txtn.setBackground(Color.BLACK);
		getContentPane().add(txtn);
		
		txtref = new JTextField();
		txtref.setEnabled(false);
		txtref.setBounds(146, 132, 221, 20);
		txtref.setForeground(Color.WHITE);
		txtref.setColumns(10);
		txtref.setBackground(Color.BLACK);
		getContentPane().add(txtref);
		
		txtv = new JTextField();
		txtv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(opcao==0){
					if(carregou==false){
						
						carregou=true;
						txtv.setText("");
							
					}else{
					
					try{
						
						if(txtv.getText()!="" && arg0.getKeyCode()!=KeyEvent.VK_BACK_SPACE){
							Double teste=Double.parseDouble(txtv.getText());
							}	
									
					}catch(Exception e2){
					
						if(!txtv.getText().equals("") && arg0.getKeyCode()!=KeyEvent.VK_BACK_SPACE && arg0.getKeyCode()!=KeyEvent.VK_PERIOD){
							
						
							
							if(txtv.getText().contains(".")){
							
							
							txtv.setText(txtv.getText().substring(0, txtv.getText().length()-1 ));
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
			public void keyReleased(KeyEvent arg0) {
				
				if(opcao==0){
					if(carregou==false){
						
						carregou=true;
						txtv.setText("");
							
					}else{
					
					try{
						
						if(txtv.getText()!="" && arg0.getKeyCode()!=KeyEvent.VK_BACK_SPACE){
							Double teste=Double.parseDouble(txtv.getText());
							}	
									
					}catch(Exception e2){
					
						if(!txtv.getText().equals("") && arg0.getKeyCode()!=KeyEvent.VK_BACK_SPACE && arg0.getKeyCode()!=KeyEvent.VK_PERIOD){
							
						
							
							if(txtv.getText().contains(".")){
							
							
							txtv.setText(txtv.getText().substring(0, txtv.getText().length()-1 ));
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
		txtv.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {

				try{
					
					Double.parseDouble(txtv.getText());
					
				}catch(Exception exp){
					
					txtv.setText("");
					JOptionPane.showMessageDialog(null, "Preencha corretamente o campo");
					
				}
			
			}
		});
		txtv.setEnabled(false);
		txtv.setBounds(146, 182, 221, 20);
		txtv.setForeground(Color.WHITE);
		txtv.setColumns(10);
		txtv.setBackground(Color.BLACK);
		getContentPane().add(txtv);
		
		cbcateg = new JComboBox();
		cbcateg.setBounds(146, 107, 221, 20);
		cbcateg.setForeground(Color.WHITE);
		cbcateg.setEnabled(false);
		cbcateg.setBackground(Color.BLACK);
		getContentPane().add(cbcateg);
		
		cbent = new JComboBox();
		cbent.setBounds(146, 155, 221, 20);
		cbent.setForeground(Color.WHITE);
		cbent.setEnabled(false);
		cbent.setBackground(Color.BLACK);
		getContentPane().add(cbent);
		
		cbmoeda = new JComboBox();
		cbmoeda.setBounds(146, 210, 221, 20);
		cbmoeda.setModel(new DefaultComboBoxModel(new String[] {"Selecionar", "Euro", "D\u00F3lar", "Libra UK"}));
		cbmoeda.setForeground(Color.WHITE);
		cbmoeda.setEnabled(false);
		cbmoeda.setBackground(Color.BLACK);
		getContentPane().add(cbmoeda);
		
		btnin = new JButton("Inserir");
		btnin.setBounds(146, 242, 101, 23);
		btnin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtc.getText()!="" && txtn.getText()!="" && txtref.getText()!="" && cbcateg.getSelectedIndex()!=0 && 
						txtv.getText()!="" && cbent.getSelectedIndex()!=0 && cbmoeda.getSelectedIndex()!=0){
				
				insertfatura();
				JOptionPane.showMessageDialog(null, "Inserido com sucesso em Base de Dados");
				txtc.setEditable(false);
				txtc.setText("");
				txtn.setEditable(false);
				txtn.setText("");
				cbcateg.setEnabled(false);
				cbcateg.setSelectedIndex(0);
				txtref.setEditable(false);
				txtref.setText("");
				txtv.setEditable(false);
				txtv.setText("");
				cbent.setEnabled(false);
				btnin.setEnabled(false);
				cbent.setSelectedIndex(0);
				cbmoeda.setEnabled(false);
				cbmoeda.setSelectedIndex(0);
				
				}
			}
		});
		btnin.setForeground(Color.BLACK);
		btnin.setEnabled(false);
		btnin.setBackground(Color.WHITE);
		getContentPane().add(btnin);
		
		JButton btnn = new JButton("Novo");
		btnn.setBounds(266, 242, 101, 25);
		btnn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				comboModel1 = new DefaultComboBoxModel();
				comboModel1 = cbenti();
				cbent.setModel(comboModel1);
				
				comboModel2 = new DefaultComboBoxModel();
				comboModel2 = cbcategi();
				cbcateg.setModel(comboModel2);
				
				txtc.setEnabled(true);
				txtn.setEnabled(true);
				txtref.setEnabled(true);
				cbcateg.setEnabled(true);
				txtv.setEnabled(true);
				cbent.setEnabled(true);
				cbmoeda.setEnabled(true);
				
				
				txtc.setEditable(true);
				txtc.setText("");
				txtn.setEditable(true);
				txtn.setText("");
				cbcateg.setEnabled(true);
				cbcateg.setSelectedIndex(0);
				txtref.setEditable(true);
				txtref.setText("");
				txtv.setEditable(true);
				txtv.setText("");
				cbent.setEnabled(true);
				btnin.setEnabled(true);
				cbent.setSelectedIndex(0);
				cbmoeda.setEnabled(true);
				cbmoeda.setSelectedIndex(0);
				
			}
		});
		btnn.setForeground(Color.BLACK);
		btnn.setBackground(Color.WHITE);
		getContentPane().add(btnn);
		
		JButton btnve = new JButton("Verificar");
		btnve.setBounds(379, 55, 101, 24);
		btnve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboModel1 = new DefaultComboBoxModel();
				comboModel1 = cbenti();
				cbent.setModel(comboModel1);
				
				comboModel2 = new DefaultComboBoxModel();
				comboModel2 = cbcategi();
				cbcateg.setModel(comboModel2);
				
				faturashow();
				
				
			}
		});
		btnve.setForeground(Color.BLACK);
		btnve.setBackground(Color.WHITE);
		getContentPane().add(btnve);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnApagar.setForeground(Color.BLACK);
		btnApagar.setBackground(Color.WHITE);
		btnApagar.setBounds(494, 54, 101, 24);
		getContentPane().add(btnApagar);
		setBorder(null);
		setBounds(100, 100, 689, 419);

	}
	
	DefaultComboBoxModel cbcategi() {
		DefaultComboBoxModel comboMode2 = new DefaultComboBoxModel();

		comboMode2.addElement("Selecionar");
		
		try {
			String xsql = "select nome, cod_categf from categ_fa order by nome";

			Statement stmt = Menu_Login.myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(xsql);

			while (rs.next()) {
				comboMode2.addElement(new QueryResult(rs.getString("cod_categf"), rs.getString("nome")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return comboMode2;
	}

	class QueryResult2 {
		String recordCode;
		String description;

		public QueryResult2(String rc, String desc) {
			recordCode = rc;
			description = desc;
		}

		public String toString() {
			return description;
		}
	
	
	}	
	
	int getComboIndex2(JComboBox pcomboBox, String pvalue) {
		for (int i = 0; i < cbent.getItemCount(); i++) {
			QueryResult temp = (QueryResult) pcomboBox.getItemAt(i);

			// JOptionPane.showMessageDialog(null, temp.description+"
			// "+temp.recordNumber);

			if (temp.recordCode.equals(pvalue)) {
				return i;

			}
		}
		return -1;
	}
	
	DefaultComboBoxModel cbenti() {
		DefaultComboBoxModel comboModel = new DefaultComboBoxModel();

		comboModel.addElement("Selecionar");
		
		try {
			String xsql = "select nome, cod_entidade from entidade order by nome";

			Statement stmt = Menu_Login.myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(xsql);

			while (rs.next()) {
				comboModel.addElement(new QueryResult(rs.getString("cod_entidade"), rs.getString("nome")));
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
		for (int i = 0; i < cbent.getItemCount(); i++) {
			QueryResult temp = (QueryResult) pcomboBox.getItemAt(i);

			// JOptionPane.showMessageDialog(null, temp.description+"
			// "+temp.recordNumber);

			if (temp.recordCode.equals(pvalue)) {
				return i;

			}
		}
		return -1;
	}
	
void insertfatura() {
		
	if(txtc.getText()!="" && txtn.getText()!="" && txtref.getText()!="" && cbcateg.getSelectedIndex()!=0 
			&& txtv.getText()!="" && cbent.getSelectedIndex()!=0 && cbmoeda.getSelectedIndex()!=0){
	
		faturastru fs = new faturastru();
		FaturasLigaBD fso = new FaturasLigaBD();

		fs.setcod_fa(Integer.parseInt(txtc.getText()));
		fs.setnome(txtn.getText());
		fs.setcod_c(cbcateg.getSelectedIndex());
		fs.setref(txtref.getText());
		QueryResult temp = (QueryResult) cbent.getSelectedItem();
		fs.setcod_e(temp.recordCode);
		fs.setvalor(Integer.parseInt(txtv.getText()));
		fs.setmoeda(cbmoeda.getSelectedItem().toString());
		DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
		Date data = new Date();
		fs.setdata(df.format(data));
		
		fso.adicionaF(fs);

		// validação dos dados
	}else{
			
			
			JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios ao gravar");
			
			
			
		} /*else {

			if (!(dao.verifica_se_existe_em_categorias(txt_codigo.getText()))) {
				dao.adicionaS(categ);
				JOptionPane.showMessageDialog(null,
						"Categoria " + txt_designacao.getText() + " inserida com sucesso! ");
			} 
		}*/

	}

void faturashow() {

	FaturasLigaBD dao = new FaturasLigaBD();

	if (!txtc.getText().isEmpty()) {

		if ((dao.verificaS(txtc.getText()))) {

			
			faturastru ssa = new faturastru();

			ssa = dao.redreg(txtc.getText());

			

				JOptionPane.showMessageDialog(null, "Encontrado. Produto: "
						+ ssa.getnome());
				txtc.setEnabled(true);
				txtn.setEnabled(true);
				txtref.setEnabled(true);
				cbcateg.setEnabled(true);
				txtv.setEnabled(true);
				cbent.setEnabled(true);
				cbmoeda.setEnabled(true);
				
				btnin.setEnabled(true);
				
				txtn.setText(ssa.getnome().trim());
				
			/*	String nomelimpo=ssa.getnome().trim();

				
				txtref.setText(ssa.getref().trim());
				cbcateg.setSelectedIndex(ssa.getcod_c());
				
				// cbforn.setSelectedIndex(Integer.parseInt(ssa.getcod_f()));
				int idx = getComboIndex(cbent, ssa.getcod_e() );
				cbent.setSelectedIndex(idx);
				
				txtv.setText(Integer.toString(ssa.getvalor()));
				
				int idx2 = getComboIndex2(cbcateg, Integer.toString(ssa.getcod_c()) );
				cbcateg.setSelectedIndex(idx2);
				cbmoeda.setSelectedItem(ssa.getmoeda());
				
*/

		} else {

			JOptionPane.showMessageDialog(null, "Produto não encontrado");

		}

	}

}	

}
