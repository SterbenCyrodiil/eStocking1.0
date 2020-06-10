package userinterface;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDesktopPane;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

import javax.swing.UIManager;


public class Menu_Principal extends JFrame {

	public static JLayeredPane contentPane;
	public static JDesktopPane desktopPane;

	public static InserStocks inserStocks=new InserStocks();
	public static TbStocks TbStocks=new TbStocks();
	public static StocksCateg CategStocks=new StocksCateg();
	public static InserFaturas inserFaturas=new InserFaturas();
	public static TbFaturas TbFaturas=new TbFaturas();
	public static FaturasCateg categFaturas=new FaturasCateg();
	public static TbForn TbForn=new TbForn();
	public static Ajuda ajuda= new Ajuda();
	public static InserForn inserForn = new InserForn();
	public static HistoricoStock histstock= new HistoricoStock();
	public static InserEnt inserEnti=new InserEnt();
	public static TbEnt TbEnti=new TbEnt();
	public static Info info= new Info();
	Image img;
	
	JMenuBar menuBar;
	
	public static String codigoSel="";
	
	
	private JMenuItem Manuteno;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Principal frame = new Menu_Principal();
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
	public Menu_Principal() {
		setResizable(false);
		setForeground(Color.BLACK);
		setTitle("eStocking");
		
		try{
			
			 File imageFile = new File("/res");
			File input= new File("logo.jpg");
			img= ImageIO.read(input);
			
		}catch(IOException ie){
			
			ie.printStackTrace();
			
		} 
		
		setIconImage(img);
		setBackground(Color.BLACK);
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 631);
		contentPane = new JLayeredPane();
		contentPane.setBackground(Color.BLACK);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		
		
		
		JLabel lblNewLabel = new JLabel("Rodrigo Coelho 2017 ");
		lblNewLabel.setFont(new Font("Planewalker", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(688, 545, 176, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEstockingV = new JLabel("eStocking v1.1 Pre-Alpha Version");
		lblEstockingV.setFont(new Font("Planewalker", Font.PLAIN, 15));
		lblEstockingV.setForeground(Color.WHITE);
		lblEstockingV.setBounds(688, 545, 232, 45);
		contentPane.add(lblEstockingV);
		
		JLabel lblLigado = new JLabel("Estado: Ligado a base de dados");
		lblLigado.setForeground(Color.WHITE);
		lblLigado.setBounds(12, 526, 200, 50);
		contentPane.add(lblLigado);
				
				JLabel lblLogo = new JLabel("");
				lblLogo.setBounds(663, 41, 245, 267);
				contentPane.add(lblLogo);
				//lblLogo.setIcon(new ImageIcon("C:\\Users\\Rodrigo\\OneDrive\\workspace\\PAPidea1\\logo.jpg"));
				lblLogo.setIcon(new ImageIcon(img));
				
		JLabel lblIntro = new JLabel("");
		lblIntro.setBounds(0, 0, 682, 144);
		contentPane.add(lblIntro);
		lblIntro.setFont(new Font("Planewalker", Font.BOLD, 36));
		lblIntro.setForeground(Color.WHITE);
		
		
		menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 0, 934, 29);
		contentPane.add(menuBar);
		
		JMenu mnSistema = new JMenu("Sistema");
		mnSistema.setForeground(Color.WHITE);
		mnSistema.setBackground(Color.BLACK);
		menuBar.add(mnSistema);
		
		JMenuItem mntmSistema = new JMenuItem("Sair");
		mntmSistema.setBackground(Color.BLACK);
		mntmSistema.setForeground(Color.WHITE);
		mntmSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String[] btns = {"Sim","Não"};
				
				
				int sair = JOptionPane.showOptionDialog(contentPane,
						"Tem certeza que deseja sair?", "Aviso",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						btns, btns[0]);
				if (sair == JOptionPane.YES_OPTION) {
					System.exit(0);
				}else{
					
					
				
					
				}  
				
			}
		});
		mnSistema.add(mntmSistema);
		
		JMenuItem mntmVoltarAoInicio = new JMenuItem("Voltar ao inicio");
		mntmVoltarAoInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblLogo.setVisible(true);
				lblIntro.setVisible(true);
				lblEstockingV.setVisible(true);
				lblNewLabel.setVisible(true);

				desktopPane.remove(ajuda);
				
				desktopPane.remove(inserStocks);
				desktopPane.remove(TbStocks);
				desktopPane.remove(inserFaturas);
				desktopPane.remove(TbForn);
				desktopPane.remove(categFaturas);
				desktopPane.remove(TbFaturas);
				desktopPane.remove(CategStocks);
				desktopPane.remove(inserForn);
				desktopPane.remove(histstock);
				desktopPane.remove(inserEnti);
				desktopPane.remove(TbEnti);
				desktopPane.remove(info);
				
			}
		});
		mntmVoltarAoInicio.setBackground(Color.BLACK);
		mntmVoltarAoInicio.setForeground(Color.WHITE);
		mnSistema.add(mntmVoltarAoInicio);
		
		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				desktopPane.setVisible(true);
				desktopPane.remove(TbStocks);
				desktopPane.remove(inserFaturas);
				desktopPane.remove(TbFaturas);
				desktopPane.remove(CategStocks);
				desktopPane.remove(inserStocks); 
				desktopPane.remove(TbForn);
				desktopPane.remove(inserForn);
				desktopPane.remove(histstock);
				desktopPane.remove(inserEnti);
				desktopPane.remove(TbEnti);
				desktopPane.remove(categFaturas);
				desktopPane.remove(info);

				try {

					desktopPane.add(ajuda);

				} catch (Exception e1) {

					ajuda.setVisible(true);

				}

				ajuda.setVisible(true);
				lblLogo.setVisible(false);
				lblIntro.setVisible(false);
				lblEstockingV.setVisible(false);
				lblNewLabel.setVisible(false);

				try {
					ajuda.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mntmAjuda.setForeground(Color.WHITE);
		mntmAjuda.setBackground(Color.BLACK);
		mnSistema.add(mntmAjuda);
		
		JMenuItem mntmInformaes = new JMenuItem("Informa\u00E7\u00F5es");
		mntmInformaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				desktopPane.setVisible(true);
				desktopPane.remove(TbStocks);
				desktopPane.remove(inserFaturas);
				desktopPane.remove(TbFaturas);
				desktopPane.remove(CategStocks);
				desktopPane.remove(inserStocks); 
				desktopPane.remove(TbForn);
				desktopPane.remove(inserForn);
				desktopPane.remove(histstock);
				desktopPane.remove(inserEnti);
				desktopPane.remove(TbEnti);
				desktopPane.remove(categFaturas);
				desktopPane.remove(ajuda);

				try {

					desktopPane.add(info);

				} catch (Exception e1) {

					info.setVisible(true);

				}

				info.setVisible(true);
				lblLogo.setVisible(false);
				lblIntro.setVisible(false);
				lblEstockingV.setVisible(false);
				lblNewLabel.setVisible(false);

				try {
					info.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		mntmInformaes.setForeground(Color.WHITE);
		mntmInformaes.setBackground(Color.BLACK);
		mnSistema.add(mntmInformaes);
		
		JMenu mnStocks = new JMenu("Stocks");
		mnStocks.setBackground(Color.BLACK);
		mnStocks.setForeground(Color.WHITE);
		menuBar.add(mnStocks);
		
				
				JMenuItem menuStockInser = new JMenuItem("Inserir");
				menuStockInser.setBackground(Color.BLACK);
				menuStockInser.setForeground(Color.WHITE);
				menuStockInser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				desktopPane.setVisible(true);
				desktopPane.remove(TbStocks);
				desktopPane.remove(inserFaturas);
				desktopPane.remove(TbForn);
				desktopPane.remove(TbFaturas);
				desktopPane.remove(CategStocks);
				desktopPane.remove(categFaturas);
				desktopPane.remove(ajuda);
				desktopPane.remove(inserForn);
				desktopPane.remove(histstock);
				desktopPane.remove(inserEnti);
				desktopPane.remove(TbEnti);
				desktopPane.remove(info);

				try {

					desktopPane.add(inserStocks);

				} catch (Exception e1) {

					inserStocks.setVisible(true);

				}

				inserStocks.setVisible(true);
				lblLogo.setVisible(false);
				lblIntro.setVisible(false);
				lblEstockingV.setVisible(false);
				lblNewLabel.setVisible(false);

				try {
					inserStocks.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
				});
				mnStocks.add(menuStockInser);
				
				JMenuItem mntmConsulta = new JMenuItem("Consulta");
				mntmConsulta.setBackground(Color.BLACK);
				mntmConsulta.setForeground(Color.WHITE);
				mntmConsulta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						desktopPane.setVisible(true);
						desktopPane.remove(inserStocks);
						desktopPane.remove(inserFaturas);
						desktopPane.remove(TbFaturas);
						desktopPane.remove(CategStocks);
						desktopPane.remove(TbForn);
						desktopPane.remove(ajuda);
						desktopPane.remove(inserForn);
						desktopPane.remove(histstock);
						desktopPane.remove(inserEnti);
						desktopPane.remove(categFaturas);
						desktopPane.remove(TbEnti);
						desktopPane.remove(info);
						
								try{
									
									
									desktopPane.add(TbStocks);
									
									
								} catch (Exception e1){
									
									TbStocks.setVisible(true);
									
								}
								
								
								TbStocks.setVisible(true);
								lblLogo.setVisible(false);
								lblIntro.setVisible(false);
								lblEstockingV.setVisible(false);
								lblNewLabel.setVisible(false);
								
						try {
							TbStocks.setMaximum(true);
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				});
				mnStocks.add(mntmConsulta);
				
				JMenuItem mntmCategorias = new JMenuItem("Categorias");
				mntmCategorias.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						desktopPane.setVisible(true);
						desktopPane.remove(inserStocks);
						desktopPane.remove(TbStocks);
						desktopPane.remove(inserFaturas);
						desktopPane.remove(TbFaturas);
						desktopPane.remove(TbForn);
						desktopPane.remove(ajuda);
						desktopPane.remove(inserForn);
						desktopPane.remove(histstock);
						desktopPane.remove(inserEnti);
						desktopPane.remove(TbEnti);
						desktopPane.remove(categFaturas);
						desktopPane.remove(info);
						
						try {

							desktopPane.add(CategStocks);

						} catch (Exception e1) {

							CategStocks.setVisible(true);

						}

						CategStocks.setVisible(true);
						lblLogo.setVisible(false);
						lblIntro.setVisible(false);
						lblEstockingV.setVisible(false);
						lblNewLabel.setVisible(false);

						try {
							CategStocks.setMaximum(true);
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
				JMenuItem mntmHistorico = new JMenuItem("Hist\u00F3rico");
				mntmHistorico.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
						desktopPane.setVisible(true);
						desktopPane.remove(inserStocks);
						desktopPane.remove(TbStocks);
						desktopPane.remove(inserFaturas);
						desktopPane.remove(TbFaturas);
						desktopPane.remove(TbForn);
						desktopPane.remove(ajuda);
						desktopPane.remove(inserForn);
						desktopPane.remove(CategStocks);
						desktopPane.remove(inserEnti);
						desktopPane.remove(TbEnti);
						desktopPane.remove(categFaturas);
						desktopPane.remove(info);
						
						try {

							desktopPane.add(histstock);

						} catch (Exception e1) {

							histstock.setVisible(true);

						}

						histstock.setVisible(true);
						lblLogo.setVisible(false);
						lblIntro.setVisible(false);
						lblEstockingV.setVisible(false);
						lblNewLabel.setVisible(false);

						try {
							histstock.setMaximum(true);
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					
					}
				});
				mntmHistorico.setForeground(Color.WHITE);
				mntmHistorico.setBackground(Color.BLACK);
				mnStocks.add(mntmHistorico);
				mntmCategorias.setForeground(Color.WHITE);
				mntmCategorias.setBackground(Color.BLACK);
				mnStocks.add(mntmCategorias);
				
				JMenu mnFatuas = new JMenu("Faturas");
				mnFatuas.setForeground(Color.WHITE);
				mnFatuas.setBackground(Color.BLACK);
				menuBar.add(mnFatuas);
				
				Manuteno = new JMenuItem("Inserir");
				Manuteno.setForeground(Color.WHITE);
				Manuteno.setBackground(Color.BLACK);
				Manuteno.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						desktopPane.setVisible(true);
						desktopPane.remove(TbStocks);
						desktopPane.remove(inserStocks);
						desktopPane.remove(TbFaturas);
						desktopPane.remove(TbForn);
						desktopPane.remove(CategStocks);
						desktopPane.remove(ajuda);
						desktopPane.remove(inserForn);
						desktopPane.remove(histstock);
						desktopPane.remove(inserEnti);
						desktopPane.remove(TbEnti);
						desktopPane.remove(categFaturas);
						desktopPane.remove(info);
						
						try {

							desktopPane.add(inserFaturas);

						} catch (Exception e1) {

							inserFaturas.setVisible(true);

						}

						inserFaturas.setVisible(true);
						lblLogo.setVisible(false);
						lblIntro.setVisible(false);
						lblEstockingV.setVisible(false);
						lblNewLabel.setVisible(false);

						try {
							inserFaturas.setMaximum(true);
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				mnFatuas.add(Manuteno);
				
				JMenuItem mntmListagem_1 = new JMenuItem("Consulta");
				mntmListagem_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						desktopPane.setVisible(true);
						desktopPane.remove(TbStocks);
						desktopPane.remove(inserStocks);
						desktopPane.remove(TbForn);
						desktopPane.remove(inserFaturas);
						desktopPane.remove(CategStocks);
						desktopPane.remove(ajuda);
						desktopPane.remove(inserForn);
						desktopPane.remove(histstock);
						desktopPane.remove(inserEnti);
						desktopPane.remove(TbEnti);
						desktopPane.remove(categFaturas);
						desktopPane.remove(info);
						
						try {

							desktopPane.add(TbFaturas);

						} catch (Exception e1) {

							TbFaturas.setVisible(true);

						}

						TbFaturas.setVisible(true);
						lblLogo.setVisible(false);
						lblIntro.setVisible(false);
						lblEstockingV.setVisible(false);
						lblNewLabel.setVisible(false);

						try {
							TbFaturas.setMaximum(true);
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				});
				mntmListagem_1.setBackground(Color.BLACK);
				mntmListagem_1.setForeground(Color.WHITE);
				mnFatuas.add(mntmListagem_1);
				
				JMenuItem menuItem_2 = new JMenuItem("Categorias");
				menuItem_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						desktopPane.setVisible(true);
						desktopPane.remove(inserStocks);
						desktopPane.remove(TbStocks);
						desktopPane.remove(inserFaturas);
						desktopPane.remove(TbFaturas);
						desktopPane.remove(TbForn);
						desktopPane.remove(ajuda);
						desktopPane.remove(inserForn);
						desktopPane.remove(histstock);
						desktopPane.remove(inserEnti);
						desktopPane.remove(TbEnti);
						desktopPane.remove(CategStocks);
						desktopPane.remove(info);
						
						try {

							desktopPane.add(categFaturas);

						} catch (Exception e1) {

							categFaturas.setVisible(true);

						}

						categFaturas.setVisible(true);
						lblLogo.setVisible(false);
						lblIntro.setVisible(false);
						lblEstockingV.setVisible(false);
						lblNewLabel.setVisible(false);

						try {
							categFaturas.setMaximum(true);
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				menuItem_2.setForeground(Color.WHITE);
				menuItem_2.setBackground(Color.BLACK);
				mnFatuas.add(menuItem_2);
				
				JMenu mnFornecedores = new JMenu("Fornecedores");
				mnFornecedores.setBackground(Color.WHITE);
				mnFornecedores.setForeground(Color.WHITE);
				menuBar.add(mnFornecedores);
				
				JMenuItem mntmInserir = new JMenuItem("Inserir");
				mntmInserir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						desktopPane.setVisible(true);
						desktopPane.remove(TbStocks);
						desktopPane.remove(inserFaturas);
						desktopPane.remove(TbForn);
						desktopPane.remove(TbFaturas);
						desktopPane.remove(CategStocks);
						desktopPane.remove(inserStocks);
						desktopPane.remove(ajuda);
						desktopPane.remove(histstock);
						desktopPane.remove(inserEnti);
						desktopPane.remove(TbEnti);
						desktopPane.remove(categFaturas);
						desktopPane.remove(info);
						
						try {

							desktopPane.add(inserForn);

						} catch (Exception e1) {

							inserForn.setVisible(true);

						}

						inserForn.setVisible(true);
						lblLogo.setVisible(false);
						lblIntro.setVisible(false);
						lblEstockingV.setVisible(false);
						lblNewLabel.setVisible(false);

						try {
							inserForn.setMaximum(true);
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				mntmInserir.setBackground(Color.BLACK);
				mntmInserir.setForeground(Color.WHITE);
				mnFornecedores.add(mntmInserir);
				
				JMenuItem mntmConsulta_1 = new JMenuItem("Consulta");
				mntmConsulta_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						desktopPane.setVisible(true);
						desktopPane.remove(TbStocks);
						desktopPane.remove(TbFaturas);
						desktopPane.remove(inserStocks);
						desktopPane.remove(inserFaturas);
						desktopPane.remove(CategStocks);
						desktopPane.remove(ajuda);
						desktopPane.remove(inserForn);
						desktopPane.remove(histstock);
						desktopPane.remove(inserEnti);
						desktopPane.remove(TbEnti);
						desktopPane.remove(categFaturas);
						desktopPane.remove(info);
						
						try {

							desktopPane.add(TbForn);

						} catch (Exception e1) {

							TbForn.setVisible(true);

						}

						TbForn.setVisible(true);
						lblLogo.setVisible(false);
						lblIntro.setVisible(false);
						lblEstockingV.setVisible(false);
						lblNewLabel.setVisible(false);

						try {
							TbForn.setMaximum(true);
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				});
				mntmConsulta_1.setBackground(Color.BLACK);
				mntmConsulta_1.setForeground(Color.WHITE);
				mnFornecedores.add(mntmConsulta_1);
				
				JMenu mnEntidades = new JMenu("Entidades");
				mnEntidades.setForeground(Color.WHITE);
				mnEntidades.setBackground(Color.BLACK);
				menuBar.add(mnEntidades);
				
				JMenuItem menuItem = new JMenuItem("Inserir");
				menuItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						desktopPane.setVisible(true);
						desktopPane.remove(TbStocks);
						desktopPane.remove(TbFaturas);
						desktopPane.remove(inserStocks);
						desktopPane.remove(inserFaturas);
						desktopPane.remove(CategStocks);
						desktopPane.remove(ajuda);
						desktopPane.remove(inserForn);
						desktopPane.remove(histstock);
						desktopPane.remove(TbForn);
						desktopPane.remove(TbEnti);
						desktopPane.remove(categFaturas);
						desktopPane.remove(info);

						try {

							desktopPane.add(inserEnti);

						} catch (Exception e1) {

							inserEnti.setVisible(true);

						}

						inserEnti.setVisible(true);
						lblLogo.setVisible(false);
						lblIntro.setVisible(false);
						lblEstockingV.setVisible(false);
						lblNewLabel.setVisible(false);

						try {
							inserEnti.setMaximum(true);
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
					}
				});
				menuItem.setBackground(Color.BLACK);
				menuItem.setForeground(Color.WHITE);
				mnEntidades.add(menuItem);
				
				JMenuItem menuItem_1 = new JMenuItem("Consulta");
				menuItem_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						desktopPane.setVisible(true);
						desktopPane.remove(TbStocks);
						desktopPane.remove(TbFaturas);
						desktopPane.remove(inserStocks);
						desktopPane.remove(inserFaturas);
						desktopPane.remove(CategStocks);
						desktopPane.remove(ajuda);
						desktopPane.remove(inserForn);
						desktopPane.remove(histstock);
						desktopPane.remove(TbForn);
						desktopPane.remove(inserEnti);
						desktopPane.remove(categFaturas);
						desktopPane.remove(info);

						try {

							desktopPane.add(TbEnti);

						} catch (Exception e1) {

							TbEnti.setVisible(true);

						}

						TbEnti.setVisible(true);
						lblLogo.setVisible(false);
						lblIntro.setVisible(false);
						lblEstockingV.setVisible(false);
						lblNewLabel.setVisible(false);

						try {
							TbEnti.setMaximum(true);
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				});
				menuItem_1.setBackground(Color.BLACK);
				menuItem_1.setForeground(Color.WHITE);
				mnEntidades.add(menuItem_1);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBorder(null);
		desktopPane.setForeground(Color.BLACK);
		desktopPane.setBackground(new Color(0, 0, 0));
		desktopPane.setBounds(0, 31, 920, 559);
		contentPane.add(desktopPane);
	
		Menu_Login ecralogin = new Menu_Login();
		

		ecralogin.setEnabled(true);
		ecralogin.setModal(true);
		ecralogin.setVisible(true);
		
		if(ecralogin.abrir==false){
			
			System.exit(0);
			
		}
		
		DateFormat df = new SimpleDateFormat("HH");
		Date data = new Date();
		
		 if(Integer.parseInt(df.format(data))>=19 && Integer.parseInt(df.format(data))<24){
				
				lblIntro.setText("  Boa noite utilizador "+Menu_Login.nick);
				
			}
			
			if(Integer.parseInt(df.format(data))>=12 && Integer.parseInt(df.format(data))<19){
				
				lblIntro.setText("  Boa tarde utilizador "+Menu_Login.nick);
				
			}
			
			if(Integer.parseInt(df.format(data))>=7 && Integer.parseInt(df.format(data))<12){
				
				lblIntro.setText("  Bom dia utilizador "+Menu_Login.nick);
				
			}
			
			if(Integer.parseInt(df.format(data))>=0 && Integer.parseInt(df.format(data))<7){
				
				lblIntro.setText("  Bom amanhecer utilizador "+Menu_Login.nick);
				
			}
	
			setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, lblNewLabel, lblEstockingV, lblLigado, lblLogo, lblIntro, menuBar, mnSistema, mntmSistema, mntmVoltarAoInicio, mntmAjuda, mnStocks, menuStockInser, mntmConsulta, mntmCategorias, mnFatuas, Manuteno, mntmListagem_1, menuItem_2, mnFornecedores, mntmInserir, mntmConsulta_1, mnEntidades, menuItem, menuItem_1, desktopPane}));
	
	}
	
	public void shut(){
		
		
		
	}
}
