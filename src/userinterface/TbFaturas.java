package userinterface;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import modelos.QueryTableModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TbFaturas extends JInternalFrame {

	QueryTableModel qtm;
	JComboBox cbOrdem;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TbFaturas frame = new TbFaturas();
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
	public TbFaturas() {
		setBorder(null);
		getContentPane().setBackground(Color.BLACK);
		setBounds(100, 100, 795, 464);
		
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		qtm = new QueryTableModel();
	    getContentPane().setLayout(null);
	    final JTable table = new JTable(qtm);
	    table.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    		
	    		table.getSelectedRow();
	    		table.getSelectedColumn();
	    		
	    		JOptionPane.showMessageDialog(null, table.getValueAt(table.getSelectedRow(), table.getSelectedColumn() ));
	    		
	    	}
	    });
	    table.setBackground(Color.BLACK);
	    table.setForeground(Color.WHITE);
	    table.getTableHeader().setReorderingAllowed(false);
	    JScrollPane scrollpane = new JScrollPane(table);
	    scrollpane.setBounds(45, 34, 687, 320);
	    getContentPane().add(scrollpane);

	    
	    JButton btnCarr = new JButton("Carregar");
	    btnCarr.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    	
	    	if(cbOrdem.getSelectedIndex()==0){
	    		qtm.setQuery("select faturas.codigo as Código, faturas.nome as Nome,"
	    				+ "categ_fa.nome as Categorias, entidade.nome as Entidade, "
	    				+ "faturas.ref as Referência, faturas.valor as Valor, faturas.moeda as Moeda, faturas.data from faturas "
	    				+ "inner join categ_fa on (categ_fa.cod_categf=faturas.cod_categ)"
	    				+ " inner join entidade on(entidade.cod_entidade=faturas.cod_ent) order by faturas.codigo ASC");
    		   
	    	}
	    	
	    	if(cbOrdem.getSelectedIndex()==1){
	    		qtm.setQuery("select faturas.codigo as Código, faturas.nome as Nome,"
	    				+ "categ_fa.nome as Categorias, entidade.nome as Entidade, "
	    				+ "faturas.ref as Referência, faturas.valor as Valor, faturas.moeda as Moeda, faturas.data from faturas "
	    				+ "inner join categ_fa on (categ_fa.cod_categf=faturas.cod_categ)"
	    				+ " inner join entidade on(entidade.cod_entidade=faturas.cod_ent) order by faturas.codigo DESC");
    		   
	    	}
	    	
	    	if(cbOrdem.getSelectedIndex()==2){
	    		qtm.setQuery("select faturas.codigo as Código, faturas.nome as Nome,"
	    				+ "categ_fa.nome as Categorias, entidade.nome as Entidade, "
	    				+ "faturas.ref as Referência, faturas.valor as Valor, faturas.moeda as Moeda, faturas.data from faturas "
	    				+ "inner join categ_fa on (categ_fa.cod_categf=faturas.cod_categ)"
	    				+ " inner join entidade on(entidade.cod_entidade=faturas.cod_ent) order by faturas.nome ASC");
    		   
	    	}
	    	
	    	if(cbOrdem.getSelectedIndex()==3){
	    		qtm.setQuery("select faturas.codigo as Código, faturas.nome as Nome,"
	    				+ "categ_fa.nome as Categorias, entidade.nome as Entidade, "
	    				+ "faturas.ref as Referência, faturas.valor as Valor, faturas.moeda as Moeda, faturas.data from faturas "
	    				+ "inner join categ_fa on (categ_fa.cod_categf=faturas.cod_categ)"
	    				+ " inner join entidade on(entidade.cod_entidade=faturas.cod_ent) order by faturas.nome DESC");
    		   
	    	}
	    	
	    	if(cbOrdem.getSelectedIndex()==4){
	    		qtm.setQuery("select faturas.codigo as Código, faturas.nome as Nome,"
	    				+ "categ_fa.nome as Categorias, entidade.nome as Entidade, "
	    				+ "faturas.ref as Referência, faturas.valor as Valor, faturas.moeda as Moeda, faturas.data from faturas "
	    				+ "inner join categ_fa on (categ_fa.cod_categf=faturas.cod_categ)"
	    				+ " inner join entidade on(entidade.cod_entidade=faturas.cod_ent) order by faturas.valor ASC");
    		   
	    	}
	    	
	    	if(cbOrdem.getSelectedIndex()==5){
	    		qtm.setQuery("select faturas.codigo as Código, faturas.nome as Nome,"
	    				+ "categ_fa.nome as Categorias, entidade.nome as Entidade, "
	    				+ "faturas.ref as Referência, faturas.valor as Valor, faturas.moeda as Moeda, faturas.data from faturas "
	    				+ "inner join categ_fa on (categ_fa.cod_categf=faturas.cod_categ)"
	    				+ " inner join entidade on(entidade.cod_entidade=faturas.cod_ent) order by faturas.valor DESC");
    		   
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
	    btnCarr.setForeground(Color.BLACK);
	    btnCarr.setBackground(Color.WHITE);
	    btnCarr.setBounds(45, 366, 108, 31);
	    getContentPane().add(btnCarr);
	    
	    cbOrdem = new JComboBox();
	    cbOrdem.setModel(new DefaultComboBoxModel(new String[] {"C\u00F3digo Crescente", "C\u00F3digo Decrescente", "A-Z", "Z-A", "Pre\u00E7o Crescente", "Pre\u00E7o Decrescente"}));
	    cbOrdem.setForeground(Color.WHITE);
	    cbOrdem.setBackground(Color.BLACK);
	    cbOrdem.setBounds(161, 366, 149, 31);
	    getContentPane().add(cbOrdem);
	    
	}

}
