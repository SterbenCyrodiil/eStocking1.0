package userinterface;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class FaturasCateg extends JInternalFrame {
	
	JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FaturasCateg frame = new FaturasCateg();
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
	public FaturasCateg() {
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				
				if(list.getSelectedIndex()==0){
					
					textPane.setText("Pagamentos relacionados com a utilização de eletricidade");
					
				}
				
				if(list.getSelectedIndex()==1){
					
					textPane.setText("Pagamentos relacionados com a utilização de água");
					
				}
				
				if(list.getSelectedIndex()==2){
					
					textPane.setText("Pagamentos relacionados com aquisições de produtos a fornecedores");
					
				}
				
				if(list.getSelectedIndex()==3){
					
					textPane.setText("Pagamentos relacionados com gás, caso existam na empresa");
					
				}
				
				if(list.getSelectedIndex()==4){
					
					textPane.setText("Caso exista renda, as faturas da renda devem ser aqui colocadas");
					
				}
				
			}
		});
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Eletricidade", "\u00C1gua", "Pagamentos", "G\u00E1s", "Renda"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setForeground(Color.WHITE);
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setBackground(Color.BLACK);
		list.setBounds(37, 124, 134, 125);
		getContentPane().add(list);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setForeground(Color.WHITE);
		textPane.setBackground(Color.BLACK);
		textPane.setBounds(181, 63, 317, 232);
		getContentPane().add(textPane);
		setBorder(null);
		setBounds(100, 100, 526, 367);

	}
}
