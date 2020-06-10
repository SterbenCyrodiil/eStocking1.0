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
import modelos.stockstru;
import bdcon.StocksLigaBD;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

public class TbForn extends JInternalFrame {

	static QueryTableModel qtm;
	JComboBox cbOrdem;
	private Boolean retirar=false;
	private int linha;
	private Boolean selecionado=false;
	public static InserForn inserForn = new InserForn();
	boolean carrega=false;
	public static String codigo="";
	
	final JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TbForn frame = new TbForn();
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
	public TbForn() {
		getContentPane().setBackground(Color.BLACK);
		setBorder(null);
		setBounds(100, 100, 864, 464);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		qtm = new QueryTableModel();
	    getContentPane().setLayout(null);
	    table = new JTable(qtm);
	    table.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    		
	    		selecionado=true;
	    		
	    		linha = table.getSelectedRow();
	    		table.getSelectedColumn();
	    			    		
	    		JOptionPane.showMessageDialog(null, table.getValueAt(table.getSelectedRow(), table.getSelectedColumn() ));
	    				
	    		}
	    			    	
	    });
	    table.setBackground(Color.BLACK);
	    table.setForeground(Color.WHITE);
	    table.getTableHeader().setReorderingAllowed(false);
	    JScrollPane scrollpane = new JScrollPane(table);
	    scrollpane.setBounds(45, 34, 799, 320);
	    getContentPane().add(scrollpane);
	    
	    JButton btnCarr = new JButton("Carregar");
	    btnCarr.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    	
	    		tablecarreg();
	    		
	    	}
	    });
	    btnCarr.setForeground(Color.BLACK);
	    btnCarr.setBackground(Color.WHITE);
	    btnCarr.setBounds(45, 365, 108, 31);
	    getContentPane().add(btnCarr);
	    
	    cbOrdem = new JComboBox();
	    cbOrdem.setModel(new DefaultComboBoxModel(new String[] {"C\u00F3digo Crescente", "C\u00F3digo Decrescente", "A-Z", "Z-A"}));
	    cbOrdem.setForeground(Color.WHITE);
	    cbOrdem.setBackground(Color.BLACK);
	    cbOrdem.setBounds(161, 366, 149, 31);
	    getContentPane().add(cbOrdem);
	     
	}
	
	void tablecarreg(){
		
		if(cbOrdem.getSelectedIndex()==0){
    		qtm.setQuery("select * from fornecedor"
    				+ " order by fornecedor.cod_fornecedor ASC");
		   
    	}
    	
    	if(cbOrdem.getSelectedIndex()==1){
    		qtm.setQuery("select * from fornecedor"
    				+ " order by fornecedor.cod_fornecedor DESC");
		   
    	}
    	
    	if(cbOrdem.getSelectedIndex()==2){
    		qtm.setQuery("select * from fornecedor"
    				+ " order by fornecedor.nome ASC");
		   
    	}
    	
    	if(cbOrdem.getSelectedIndex()==3){
    		qtm.setQuery("select * from fornecedor"
    				+ " order by fornecedor.nome DESC");
		   
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
		
		    carrega=true;

	}
}
