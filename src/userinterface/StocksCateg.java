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
					
					txtpane1.setText("Periféricos são dispostivos utilizados para permitir uma mais intuitiva utilização de um computador. Esta categoria incluí ratos, teclados e outros dispostivos semelhantes.");
					
				}
				
				if(list.getSelectedIndex()==1){
					
					txtpane1.setText("Componentes são as peças internas de um computador, o que permite a máquina funcionar e são obrigatórios em qualquer computador. Esta categoria inclui CPUs, RAMs entre outros componentes semelhantes.");
					
				}
				
				if(list.getSelectedIndex()==2){
					
					txtpane1.setText("Acessórios são peças externas ao computador, semelhantes a periféricos, mas sem função de entrada ou saída obrigatória, ou com propósito de melhor a utilização. Esta categoria incluí discos externos, pen drive, tapetes para rato, e outros dispositivos semelhantes.");
					
				}
				
				if(list.getSelectedIndex()==3){
					
					txtpane1.setText("Software é a parte intena da máquina e que permite utilizar a máquina de forma útil. O software incluí variadas aplicações, como Sistemas Operativos, Antívírus, programas de edição de imagem e vídeo, entre outros softwares pagos.");
					
				}
				
				if(list.getSelectedIndex()==4){
					
					txtpane1.setText("Acessórios necessários para a utilização e instalação de redes locais ou exteriores. Exemplos de produtos nesta categoria são routers, switches, cabelagem, entre outros.");
					
				}
				
				if(list.getSelectedIndex()==5){
					
					txtpane1.setText("Na categoria mobile estão incluídos os telemóveis, tablets e os seus acessórios, como capas, carregadores, entre outros.");
					
				}
				
				if(list.getSelectedIndex()==6){
					
					txtpane1.setText("Produtos para informática cuja utilização é consumível, como os tinteiros para impressora.");
					
				}
				
				if(list.getSelectedIndex()==7){
					
					txtpane1.setText("Na categoria Computadores, estão incluídos todos os computadores já montados adquiridos, sejam portáteis, fixos ou híbridos.");
					
				}
				
				if(list.getSelectedIndex()==8){
					
					txtpane1.setText("Nesta categoria incluíu-se todas as consolas e os seus periféricos e acessórios.");
				}
				
				if(list.getSelectedIndex()==9){
					
					txtpane1.setText("Gadgets são todos os componentes informáticos que não se incluiem noutras categorias. Estes produtos são do Género dos Drones, das Camaras de Fotografia, e outros semelhantes.");
					
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
