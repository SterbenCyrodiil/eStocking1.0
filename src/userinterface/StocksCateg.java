package userinterface;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextPane;

public class StocksCateg extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StocksCateg frame = new StocksCateg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


JTextPane txtpane1;

	/**
	 * Create the frame.
	 */
	public StocksCateg() {
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				
				if(list.getSelectedIndex()==0){
					
					txtpane1.setText("Perif�ricos s�o dispostivos utilizados para permitir uma mais intuitiva utiliza��o de um computador. Esta categoria inclu� ratos, teclados e outros dispostivos semelhantes.");
					
				}
				
				if(list.getSelectedIndex()==1){
					
					txtpane1.setText("Componentes s�o as pe�as internas de um computador, o que permite a m�quina funcionar e s�o obrigat�rios em qualquer computador. Esta categoria inclui CPUs, RAMs entre outros componentes semelhantes.");
					
				}
				
				if(list.getSelectedIndex()==2){
					
					txtpane1.setText("Acess�rios s�o pe�as externas ao computador, semelhantes a perif�ricos, mas sem fun��o de entrada ou sa�da obrigat�ria, ou com prop�sito de melhor a utiliza��o. Esta categoria inclu� discos externos, pen drive, tapetes para rato, e outros dispositivos semelhantes.");
					
				}
				
				if(list.getSelectedIndex()==3){
					
					txtpane1.setText("Software � a parte intena da m�quina e que permite utilizar a m�quina de forma �til. O software inclu� variadas aplica��es, como Sistemas Operativos, Ant�v�rus, programas de edi��o de imagem e v�deo, entre outros softwares pagos.");
					
				}
				
				if(list.getSelectedIndex()==4){
					
					txtpane1.setText("Acess�rios necess�rios para a utiliza��o e instala��o de redes locais ou exteriores. Exemplos de produtos nesta categoria s�o routers, switches, cabelagem, entre outros.");
					
				}
				
				if(list.getSelectedIndex()==5){
					
					txtpane1.setText("Na categoria mobile est�o inclu�dos os telem�veis, tablets e os seus acess�rios, como capas, carregadores, entre outros.");
					
				}
				
				if(list.getSelectedIndex()==6){
					
					txtpane1.setText("Produtos para inform�tica cuja utiliza��o � consum�vel, como os tinteiros para impressora.");
					
				}
				
				if(list.getSelectedIndex()==7){
					
					txtpane1.setText("Na categoria Computadores, est�o inclu�dos todos os computadores j� montados adquiridos, sejam port�teis, fixos ou h�bridos.");
					
				}
				
				if(list.getSelectedIndex()==8){
					
					txtpane1.setText("Nesta categoria inclu�u-se todas as consolas e os seus perif�ricos e acess�rios.");
				}
				
				if(list.getSelectedIndex()==9){
					
					txtpane1.setText("Gadgets s�o todos os componentes inform�ticos que n�o se incluiem noutras categorias. Estes produtos s�o do G�nero dos Drones, das Camaras de Fotografia, e outros semelhantes.");
					
				}
				
			}
		});
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Perif\u00E9ricos", "Componentes", "Acess\u00F3rios", "Software", "Redes", "Mobile", "Consum\u00EDveis", "Computadores", "Consolas", "Gadjets"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setForeground(Color.WHITE);
		list.setBackground(Color.BLACK);
		list.setBounds(34, 88, 147, 276);
		getContentPane().add(list);
		
		txtpane1 = new JTextPane();
		txtpane1.setEditable(false);
		txtpane1.setForeground(Color.WHITE);
		txtpane1.setBackground(Color.BLACK);
		txtpane1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpane1.setBounds(256, 88, 441, 276);
		getContentPane().add(txtpane1);
		setBorder(null);
		setBounds(100, 100, 729, 462);

	}
}
