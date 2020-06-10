package userinterface;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Ajuda extends JInternalFrame {

	JTextPane txtpane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajuda frame = new Ajuda();
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
	public Ajuda() {
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
			
				if(list.getSelectedIndex()==0){
					
					txtpane.setText("Para inserir uma nova entrada na tabela ou adicionar valores a um produto existente, v� a Menu>Stocks>Inserir; \r\n"
							+ "Para nova entrada: cliquem em Novo, insira corretamente os dados e clique em Guardar; \r\n"
							+ "Para adicionar valores, clique em Adicionar Valores, insira os valores corretamente e clique em Guardar;\r\n"
							+ "Para apagar um registo na base de dados, coloque o c�digo da entrada que deseja apagar e clique em Apagar;\r\n"
							+ "Os formatos de dados devem ser os seguintes: C�digo-Num�rico, Nome- Caracteres, Descri��o-Caracteres, Quantidade-N�meros Inteiros, Pre�o-N�mero Decimal (por unidade)");
					
				}
				
				if(list.getSelectedIndex()==1){
					
					txtpane.setText("Para listar, v� a Menu>Stocks>Listar e selecione o tipo de listagem que quer, e clique em Carregar para iniciar a table. \r\n"
							+ "Para ver com detalhe a informa��o, clique em cima da c�lula da tabela e um pop-up mostrar� a informa��o requisitada.\r\n"
							+ "Para retirar produtos de Stocks, clique numa c�lula da linha que pretende retirar e em seguida em Retirar de Stock, ou o contr�rio, clicando no bot�o primeiro e na c�lula depois; \r\n"
							+ "Para executar v�ras listagens diferentes, clique nos respetivos bot�es; \r\n"
							+ "Para ver o hist�rico de movimentos, v� a Hist�rico no mesmo menu;");
					
				}
				
				if(list.getSelectedIndex()==2){
					
					txtpane.setText("Para inserir uma nova entrada na tabela, v� a Menu>Faturas>Inserir; \r\n"
							+ "Para nova entrada: cliquem em Novo, insira corretamente os dados e clique em Guardar; \r\n"
							+ "A fun��o de apagar n�o est� presente, pois a fatura dever� sempre ficar presente nos registos;\r\n"
							+ "Os formatos de dados devem ser os seguintes: C�digo-Num�rico, Nome- Caracteres, Refer�ncia- Caracteres, Valor-N�mero Decimal");
				}
				
				if(list.getSelectedIndex()==3){
					
					txtpane.setText("Para listar, v� a Menu>Faturas>Listar e selecione o tipo de listagem que quer, e clique em Carregar para iniciar a tabela. \r\n"
							+ "Para ver com detalhe a informa��o, clique em cima da c�lula da tabela e um pop-up mostrar� a informa��o requisitada.\r\n"
							+ "Para executar v�ras listagens diferentes, clique nos respetivos bot�es; \r\n");
					
				}
				
				if(list.getSelectedIndex()==4){
					
					txtpane.setText("Para inserir uma nova entrada na tabela, v� a Menu>Fornecedores>Inserir; \r\n"
							+ "Para nova entrada: cliquem em Novo, insira corretamente os dados e clique em Guardar; \r\n"
							+ "A fun��o de apagar n�o est� presente, pois o fornecedor dever� sempre ficar presente nos registos para previnir erros;\r\n"
							+ "Os formatos de dados devem ser os seguintes: C�digo-Num�rico, Telefone- Num�rico, sendo todos os outros caracteres; \r\n"
							+ "Para atualizar dados, cliquem em Atualizar e selecione o que pretende atualizar, insira os campos atualizados e clique em Guardar;");
					
				}
				
				if(list.getSelectedIndex()==5){
					
					txtpane.setText("Para listar, v� a Menu>Fornecedores>Listar e selecione o tipo de listagem que quer, e clique em Carregar para iniciar a tabela. \r\n"
							+ "Para ver com detalhe a informa��o, clique em cima da c�lula da tabela e um pop-up mostrar� a informa��o requisitada.\r\n");
					
				}
				
				if(list.getSelectedIndex()==6){
					
					txtpane.setText("Para inserir uma nova entrada na tabela, v� a Menu>Entidades>Inserir; \r\n"
							+ "Para nova entrada: cliquem em Novo, insira corretamente os dados e clique em Guardar; \r\n"
							+ "A fun��o de apagar n�o est� presente, pois o fornecedor dever� sempre ficar presente nos registos para previnir erros;\r\n"
							+ "Os formatos de dados devem ser os seguintes: C�digo-Num�rico, Telefone- Num�rico, sendo todos os outros caracteres; \r\n"
							+ "Para atualizar dados, cliquem em Atualizar e selecione o que pretende atualizar, insira os campos atualizados e clique em Guardar;");
					
					
				}
				
				if(list.getSelectedIndex()==7){
					
					txtpane.setText("Para listar, v� a Menu>Entidades>Listar e selecione o tipo de listagem que quer, e clique em Carregar para iniciar a tabela. \r\n"
							+ "Para ver com detalhe a informa��o, clique em cima da c�lula da tabela e um pop-up mostrar� a informa��o requisitada.\r\n");
					
				}
				
			}
		});
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Manuten\u00E7\u00E3o de Stocks", "Listagem de Stocks", "Manuten\u00E7\u00E3o de Faturas", "Listagem de Faturas", "Manuten\u00E7\u00E3o de Fornecedores", "Listagem de Fornecedores", "Manuten\u00E7\u00E3o de Entidades", "Listagem de Entidades"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setForeground(Color.WHITE);
		list.setBackground(Color.BLACK);
		list.setBounds(10, 87, 233, 194);
		getContentPane().add(list);
		
		txtpane = new JTextPane();
		txtpane.setEditable(false);
		txtpane.setBackground(Color.BLACK);
		txtpane.setForeground(Color.WHITE);
		txtpane.setBounds(242, 87, 538, 302);
		getContentPane().add(txtpane);
		setBorder(null);
		setBounds(100, 100, 780, 405);

	}
}
