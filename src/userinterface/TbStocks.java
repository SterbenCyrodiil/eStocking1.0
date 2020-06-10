package userinterface;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modelos.QueryTableModel;
import modelos.stockregis;
import modelos.stockstru;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/*import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized; */







import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import javax.print.*;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import bdcon.StocksLigaBD;

import javax.swing.JLabel;

import userinterface.InserStocks.QueryResult;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TbStocks extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	
	static QueryTableModel qtm;
	JComboBox cbOrdem;
	private Boolean retirar=false;
	private int linha;
	private Boolean selecionado=false;
	int quantidadeindica;
	JComboBox cbCateg ;
	JComboBox cbForn;
	boolean carregado=false;
	DefaultComboBoxModel comboModel1;
	boolean tirou=false;
	
	final JTable table;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TbStocks frame = new TbStocks();
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
	public TbStocks() {
		getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				
				
				
			}
		});
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(Color.BLACK);
		setBorder(null);
		
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		qtm = new QueryTableModel();
	    table = new JTable(qtm);
	    table.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    		
	    		selecionado=true;
	    		
	    		linha = table.getSelectedRow();
	    		table.getSelectedColumn();
	    		
	    		if(retirar==false){
	    		
	    		JOptionPane.showMessageDialog(null, table.getValueAt(table.getSelectedRow(), table.getSelectedColumn() ));
	    		
	    		} else{
	    			
	    			linha=table.getSelectedRow();
	    			
	    			retirastock();
	    		//	colocareg();
					tablecarreg();
	    			
	    		}
	    		
	    	}
	    });
	    table.setBackground(Color.BLACK);
	    table.setForeground(Color.WHITE);
	    table.getTableHeader().setReorderingAllowed(false);
	    getContentPane().setLayout(null);
	    JScrollPane scrollpane = new JScrollPane(table);
	    scrollpane.setBounds(45, 34, 799, 320);
	    getContentPane().add(scrollpane);
	    
	    JButton btnCarr = new JButton("Carregar");
	    btnCarr.setBounds(45, 366, 108, 31);
	    btnCarr.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    	
	    		tablecarreg();
	    		
	    	}
	    });
	    btnCarr.setForeground(Color.BLACK);
	    btnCarr.setBackground(Color.WHITE);
	    getContentPane().add(btnCarr);
	    
	    cbOrdem = new JComboBox();
	    cbOrdem.setBounds(161, 366, 149, 31);
	    cbOrdem.setModel(new DefaultComboBoxModel(new String[] {"C\u00F3digo Crescente", "C\u00F3digo Decrescente", "A-Z", "Z-A", "Pre\u00E7o Crescente", "Pre\u00E7o Decrescente"}));
	    cbOrdem.setForeground(Color.WHITE);
	    cbOrdem.setBackground(Color.BLACK);
	    getContentPane().add(cbOrdem);
	    
	    JButton btnRetirarDeStock = new JButton("Retirar de Stock");
	    btnRetirarDeStock.setBounds(161, 409, 149, 31);
	    btnRetirarDeStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (retirar == false) {
					if (selecionado == true) {

						linha = table.getSelectedRow();

						retirastock();
					//	colocareg();
						
					} else {
						retirar = true;
						JOptionPane.showMessageDialog(null,
								"Selecione a linha que deseja modificar.");

					}

				} else {

					linha = table.getSelectedRow();

					retirastock();
					if(tirou==true){
					
					// colocareg();
					
					tirou=false;
					}
					
				//	tablecarreg();
					
				}

			}
	    });
	    btnRetirarDeStock.setForeground(Color.BLACK);
	    btnRetirarDeStock.setBackground(Color.WHITE);
	    getContentPane().add(btnRetirarDeStock);
	    
	    JLabel lblConsultaEspecfica = new JLabel("Consultas espec\u00EDfica:");
	    lblConsultaEspecfica.setForeground(Color.WHITE);
	    lblConsultaEspecfica.setBounds(328, 366, 200, 50);
	    getContentPane().add(lblConsultaEspecfica);
	    
	    JButton btnMaiorQuantidade = new JButton("Maior Quantidade");
	    btnMaiorQuantidade.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		maxq();
	    		
	    	}
	    });
	    btnMaiorQuantidade.setForeground(Color.BLACK);
	    btnMaiorQuantidade.setBackground(Color.WHITE);
	    btnMaiorQuantidade.setBounds(492, 366, 149, 31);
	    getContentPane().add(btnMaiorQuantidade);
	    
	    JButton btnMenorQuantidade = new JButton("Menor Quantidade");
	    btnMenorQuantidade.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		minq();
	    		
	    	}
	    });
	    btnMenorQuantidade.setForeground(Color.BLACK);
	    btnMenorQuantidade.setBackground(Color.WHITE);
	    btnMenorQuantidade.setBounds(653, 366, 149, 31);
	    getContentPane().add(btnMenorQuantidade);
	    
	    JButton btnMaiorPreounidade = new JButton("Maior Pre\u00E7o/uni");
	    btnMaiorPreounidade.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		maxp();
	    		
	    	}
	    });
	    btnMaiorPreounidade.setForeground(Color.BLACK);
	    btnMaiorPreounidade.setBackground(Color.WHITE);
	    btnMaiorPreounidade.setBounds(492, 409, 149, 31);
	    getContentPane().add(btnMaiorPreounidade);
	    
	    JButton btnMenuPreouni = new JButton("Menu Pre\u00E7o/uni");
	    btnMenuPreouni.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		minp();
	    		
	    	}
	    });
	    btnMenuPreouni.setForeground(Color.BLACK);
	    btnMenuPreouni.setBackground(Color.WHITE);
	    btnMenuPreouni.setBounds(653, 409, 149, 31);
	    getContentPane().add(btnMenuPreouni);
	    
	    cbCateg = new JComboBox();
	    cbCateg.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
    		tablecarregorde();
	    		
	    	}
	    });
	    cbCateg.setModel(new DefaultComboBoxModel(new String[] {"Selecionar Categoria", "Perif\u00E9ricos", "Componentes", "Acess\u00F3rios                                                                                         ", "Software", "Redes", "Mobile", "Consum\u00EDveis", "Computadores", "Consolas    ", "Gadjets"}));
	    cbCateg.setForeground(Color.WHITE);
	    cbCateg.setBackground(Color.BLACK);
	    cbCateg.setBounds(492, 452, 149, 31);
	    getContentPane().add(cbCateg);
	    
	    cbForn = new JComboBox();
	    cbForn.addFocusListener(new FocusAdapter() {
	    	@Override
	    	public void focusGained(FocusEvent arg0) {
	    		
		    	if(carregado==false){
		    		
		    		comboModel1 = new DefaultComboBoxModel();
					comboModel1 = cbforni();
					cbForn.setModel(comboModel1);
		    		carregado= true;
		    		
		    	}
	    		
	    	}
	    });
	    cbForn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    	if(cbForn.getSelectedIndex()!=0){
	    		
	    		QueryResult temp = (QueryResult) cbForn.getSelectedItem();
	    		
	    		String cod_f=(temp.recordCode);

	    		
	    		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
	    				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
	    				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.prec*stocks.quantidade as Total, stocks.moeda as Moeda from stocks "
	    				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
	    				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor) where stocks.cod_fornecedor='"+cod_f+"' GROUP BY stocks.codigo,"
	    				+ " stocks.nome, stocks.descr, categorias.nome, fornecedor.nome, stocks.quantidade, stocks.unidade, stocks.prec, stocks.moeda");
	    		
	    	}
	    	
	    	TableColumn column = null;
		    
		    for (int i = 0; i < 10; i++) {
		      
		    try{	
		    	
		    	column = table.getColumnModel().getColumn(i);
		        	
		    }catch (Exception ex){
		    	
		    	System.out.println(ex);
		    	
		    }
		    	if (i == 0) {
		            column.setPreferredWidth(200); 
		        } else {
		            
		        	column.setPreferredWidth(200);

		        	
		        }
		    
		    	
		    }  
	    	
	    	}
	    });
	    cbForn.setModel(new DefaultComboBoxModel(new String[] {"Selec. Fornecedor"}));
	    cbForn.setForeground(Color.WHITE);
	    cbForn.setBackground(Color.BLACK);
	    cbForn.setBounds(653, 452, 149, 31);
	    getContentPane().add(cbForn);
	    
	}

	void retirastock() {
		
		
	stockstru ss = new stockstru();
	StocksLigaBD sso = new StocksLigaBD();

	
	stockstru ssa = new stockstru();
	ssa = sso.redreg((table.getValueAt(linha, 0).toString()));

	
		int quantidadebd=ssa.getquantidade();
		String valor=JOptionPane.showInputDialog(null, "Indique a quantidade a retirar: ");
		
	
		
		if(valor!=null){
		
		quantidadeindica=Integer.parseInt(valor);
		
		if(quantidadeindica>quantidadebd){
			
			JOptionPane.showMessageDialog(null, "A quantidade indica é superior à existente em stock. Insira novamente.");
			
		}else{
		int quantifinal=quantidadebd-quantidadeindica;
		
		ss.setcods(Integer.parseInt((table.getValueAt(linha, 0).toString())));
		ss.setquantidade(quantifinal);
		

		sso.retirastocks(ss);
		
		JOptionPane.showMessageDialog(null, "Retirados "+quantidadeindica+" produtos em stock do produto "+(table.getValueAt(linha, 1).toString()));
		tirou=true;
		colocareg();
		
		}
		}

	// validação dos dados

}
	
	DefaultComboBoxModel cbforni() {
		DefaultComboBoxModel comboModel = new DefaultComboBoxModel();

		comboModel.addElement("Selec. Fornecedor");
		
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
		for (int i = 0; i < cbForn.getItemCount(); i++) {
			QueryResult temp = (QueryResult) pcomboBox.getItemAt(i);

			// JOptionPane.showMessageDialog(null, temp.description+"
			// "+temp.recordNumber);

			if (temp.recordCode.equals(pvalue)) {
				return i;

			}
		}
		return -1;
	}
	
	void tablecarreg(){
		
		if(cbOrdem.getSelectedIndex()==0){
    		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
    				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
    				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.prec*stocks.quantidade as Total, stocks.moeda as Moeda from stocks "
    				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
    				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor) GROUP BY stocks.codigo,"
    				+ " stocks.nome, stocks.descr, categorias.nome, fornecedor.nome, stocks.quantidade, stocks.unidade, stocks.prec, stocks.moeda  order by stocks.codigo ASC");
		   
    	}
    	
    	if(cbOrdem.getSelectedIndex()==1){
    		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
    				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
    				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
    				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
    				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor) order by stocks.codigo DESC");
		   
    	}
    	
    	if(cbOrdem.getSelectedIndex()==2){
    		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
    				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
    				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
    				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
    				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor) order by stocks.nome ASC");
		   
    	}
    	
    	if(cbOrdem.getSelectedIndex()==3){
    		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
    				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
    				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
    				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
    				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor) order by stocks.nome DESC");
		   
    	}
    	
    	if(cbOrdem.getSelectedIndex()==4){
    		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
    				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
    				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
    				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
    				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor) order by stocks.prec ASC");
		   
    	}
    	
    	if(cbOrdem.getSelectedIndex()==5){
    		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
    				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
    				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
    				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
    				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor) order by stocks.prec DESC");
		   
    	}
    	
    		TableColumn column = null;
		    
		    for (int i = 0; i < 10; i++) {
		      
		    try{	
		    	
		    	column = table.getColumnModel().getColumn(i);
		        	
		    }catch (Exception ex){
		    	
		    	System.out.println(ex);
		    	
		    }
		    	if (i == 0) {
		            column.setPreferredWidth(200); 
		        } else {
		            
		        	column.setPreferredWidth(200);

		        	
		        }
		    
		    	
		    }  
		
	}
	
	void tablecarregorde(){
		
		if(cbCateg.getSelectedIndex()==1){
    		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
    				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
    				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.prec*stocks.quantidade as Total, stocks.moeda as Moeda from stocks "
    				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
    				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor) where stocks.cod_categ=1  GROUP BY stocks.codigo,"
    				+ " stocks.nome, stocks.descr, categorias.nome, fornecedor.nome, stocks.quantidade, stocks.unidade, stocks.prec, stocks.moeda  order by stocks.codigo ASC");
		   
    	}
    	
    	if(cbCateg.getSelectedIndex()==2){
    		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
    				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
    				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
    				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
    				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor) where stocks.cod_categ=2 order by stocks.codigo DESC");
		   
    	}
    	
    	if(cbCateg.getSelectedIndex()==3){
    		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
    				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
    				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
    				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
    				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor) where stocks.cod_categ=3 order by stocks.nome ASC");
		   
    	}
    	
    	if(cbCateg.getSelectedIndex()==4){
    		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
    				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
    				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
    				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
    				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor) where stocks.cod_categ=4  order by stocks.nome DESC");
		   
    	}
    	
    	if(cbCateg.getSelectedIndex()==5){
    		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
    				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
    				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
    				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
    				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor)  where stocks.cod_categ=5  order by stocks.prec ASC");
		   
    	}
    	
    	if(cbCateg.getSelectedIndex()==6){
    		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
    				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
    				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
    				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
    				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor)  where stocks.cod_categ=6 order by stocks.prec DESC");
		   
    	}
    	
    	if(cbCateg.getSelectedIndex()==7){
    		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
    				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
    				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
    				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
    				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor)  where stocks.cod_categ=7 order by stocks.prec DESC");
		   
    	}
    	
    	if(cbCateg.getSelectedIndex()==8){
    		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
    				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
    				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
    				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
    				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor)  where stocks.cod_categ=7 order by stocks.prec DESC");
		   
    	}
    	
    	if(cbCateg.getSelectedIndex()==9){
    		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
    				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
    				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
    				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
    				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor)  where stocks.cod_categ=9 order by stocks.prec DESC");
		   
    	}
    	
    		TableColumn column = null;
		    
		    for (int i = 0; i < 10; i++) {
		      
		    try{	
		    	
		    	column = table.getColumnModel().getColumn(i);
		        	
		    }catch (Exception ex){
		    	
		    	System.out.println(ex);
		    	
		    }
		    	if (i == 0) {
		            column.setPreferredWidth(200); 
		        } else {
		            
		        	column.setPreferredWidth(200);

		        	
		        }
		    
		    	
		    }  
		
	}

	void colocareg(){
		
		stockregis sr = new stockregis();
		StocksLigaBD sso = new StocksLigaBD();
		sr = sso.redregis();
		
		int codebd=sr.getcodr();
		int novocod=codebd+1;
		
		sr.setcodr(novocod);
		sr.setcodp(table.getValueAt(linha, 0).toString());
		sr.setquantidade(quantidadeindica);
		sr.setprec(Double.parseDouble(table.getValueAt(linha, 7).toString()));
		DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
		Date data = new Date();
		sr.setdata(data.toString());
		sr.settipo("Saida");
		
		System.out.println("Entrou");
		
		sso.registo(sr);
		
	}
	
	void maxq(){
		
		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor) where quantidade=(select max(quantidade) from stocks)");
		
		
		
		TableColumn column = null;
	    
	    for (int i = 0; i < 10; i++) {
	      
	    try{	
	    	
	    	column = table.getColumnModel().getColumn(i);
	        	
	    }catch (Exception ex){
	    	
	    	System.out.println(ex);
	    	
	    }
	    	if (i == 0) {
	            column.setPreferredWidth(200); 
	        } else {
	            
	        	column.setPreferredWidth(200);

	        	
	        }
	    
	    	
	    }  
		
	}
	
void minq(){
		
		qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
				+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
				+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
				+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
				+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor) where quantidade=(select min(quantidade) from stocks)");
		
		
		
		TableColumn column = null;
	    
	    for (int i = 0; i < 10; i++) {
	      
	    try{	
	    	
	    	column = table.getColumnModel().getColumn(i);
	        	
	    }catch (Exception ex){
	    	
	    	System.out.println(ex);
	    	
	    }
	    	if (i == 0) {
	            column.setPreferredWidth(200); 
	        } else {
	            
	        	column.setPreferredWidth(200);

	        	
	        }
	    
	    	
	    }  
		
	}

void maxp(){
	
	qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
			+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
			+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
			+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
			+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor) where prec=(select max(prec) from stocks)");
	
	
	
	TableColumn column = null;
    
    for (int i = 0; i < 10; i++) {
      
    try{	
    	
    	column = table.getColumnModel().getColumn(i);
        	
    }catch (Exception ex){
    	
    	System.out.println(ex);
    	
    }
    	if (i == 0) {
            column.setPreferredWidth(200); 
        } else {
            
        	column.setPreferredWidth(200);

        	
        }
    
    	
    }  
	
}

void minp(){
	
	qtm.setQuery("select stocks.codigo as Código, stocks.nome as Nome, stocks.descr as Descrição, "
			+ "categorias.nome as Categorias, fornecedor.nome as Fornecedor, "
			+ "stocks.quantidade as Quantidade, stocks.unidade as Unidade, stocks.prec as Preço, stocks.moeda as Moeda from stocks "
			+ "inner join categorias on (categorias.cod_categ=stocks.cod_categ)"
			+ " inner join fornecedor on(fornecedor.cod_fornecedor=stocks.cod_fornecedor) where prec=(select min(prec) from stocks)");
	
	
	
	TableColumn column = null;
    
    for (int i = 0; i < 10; i++) {
      
    try{	
    	
    	column = table.getColumnModel().getColumn(i);
        	
    }catch (Exception ex){
    	
    	System.out.println(ex);
    	
    }
    	if (i == 0) {
            column.setPreferredWidth(200); 
        } else {
            
        	column.setPreferredWidth(200);

        	
        }
    
    	
    }  
	
}

void imprimir(){

	
	
	/*

     String file = "";
     String message = "";
     String fontfile = "";

     PDDocument doc = new PDDocument();
     try
     {
         PDPage page = new PDPage();
         doc.addPage(page);

         // load the font as this needs to be embedded
         PDFont font = PDType0Font.load(doc, new File(fontfile));
         
         // A PDF/A file needs to have the font embedded if the font is used for text rendering
         // in rendering modes other than text rendering mode 3.
         //
         // This requirement includes the PDF standard fonts, so don't use their static PDFType1Font classes such as
         // PDFType1Font.HELVETICA.
         //
         // As there are many different font licenses it is up to the developer to check if the license terms for the
         // font loaded allows embedding in the PDF.
         // 
         if (!font.isEmbedded())
         {
         	throw new IllegalStateException("PDF/A compliance requires that all fonts used for"
         			+ " text rendering in rendering modes other than rendering mode 3 are embedded.");
         }

         // create a page with the message
         PDPageContentStream contents = new PDPageContentStream(doc, page);
         contents.beginText();
         contents.setFont(font, 12);
         contents.newLineAtOffset(100, 700);
         contents.showText(message);
         contents.endText();
         contents.saveGraphicsState();
         contents.close();

         // add XMP metadata
         XMPMetadata xmp = XMPMetadata.createXMPMetadata();
         
         try
         {
             DublinCoreSchema dc = xmp.createAndAddDublinCoreSchema();
             dc.setTitle(file);
             
             PDFAIdentificationSchema id = xmp.createAndAddPFAIdentificationSchema();
             id.setPart(1);
             id.setConformance("B");
             
             XmpSerializer serializer = new XmpSerializer();
             ByteArrayOutputStream baos = new ByteArrayOutputStream();
             serializer.serialize(xmp, baos, true);

             PDMetadata metadata = new PDMetadata(doc);
             metadata.importXMPMetadata(baos.toByteArray());
             doc.getDocumentCatalog().setMetadata(metadata);
         }
         catch(BadFieldValueException e)
         {
             // won't happen here, as the provided value is valid
             throw new IllegalArgumentException(e);
         }

         // sRGB output intent
         InputStream colorProfile = CreatePDFA.class.getResourceAsStream(
                 "/org/apache/pdfbox/resources/pdfa/sRGB.icc");
         PDOutputIntent intent = new PDOutputIntent(doc, colorProfile);
         intent.setInfo("sRGB IEC61966-2.1");
         intent.setOutputCondition("sRGB IEC61966-2.1");
         intent.setOutputConditionIdentifier("sRGB IEC61966-2.1");
         intent.setRegistryName("http://www.color.org");
         doc.getDocumentCatalog().addOutputIntent(intent);

         doc.save(file);
     }
     finally
     {
         doc.close();
     }
 }

*/
	
	  File file = new File("printtest.txt");
	  
	  
	  
	  InputStream is = null ;
	  
	  
	  try {
		is = new BufferedInputStream(new FileInputStream(file));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	  
	  
	
	  PrintService service = PrintServiceLookup.lookupDefaultPrintService();
	  
	  DocFlavor flavor = DocFlavor.INPUT_STREAM.TEXT_PLAIN_US_ASCII;
	  
	  Doc doc = new SimpleDoc(is, flavor, null);
	
	 
	  
	  DocPrintJob job = service.createPrintJob();
	  
	  
	  try {
		   job.print(doc, null);
		  } catch (PrintException e) {
		   e.printStackTrace();
		  }  
	  
	  try {
		is.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
}
}
