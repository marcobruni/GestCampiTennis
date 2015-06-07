

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Canvas;

import javax.swing.JEditorPane;

import java.awt.Color;

public class FmrMain extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public FmrMain() {
		setTitle("Gestione Campi Tennis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(70, 70, 500, 450);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Clienti");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmVisualizza = new JMenuItem("Visualizza");
		
		mntmVisualizza.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				FmrVisualizza vis = new FmrVisualizza();
				vis.setVisible(true);
			}
		});
		mnNewMenu.add(mntmVisualizza);
		
		JMenuItem mntmAggiungi = new JMenuItem("Aggiungi");
		mntmAggiungi.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				FrmCliente vis = new FrmCliente();
				vis.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmAggiungi);
		
		JMenuItem mntmModifica = new JMenuItem("Modifica");
		mntmModifica.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent arg0) {
				FmrModifica vis = new FmrModifica();
				vis.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmModifica);
		
		JMenuItem mntmElimina = new JMenuItem("Elimina");
		mntmElimina.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				FmrElimina vis = new FmrElimina();
				vis.setVisible(true);
			}
		});
		mnNewMenu.add(mntmElimina);
		
		JMenu mnCampi = new JMenu("Campi");
		menuBar.add(mnCampi);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Visualizza");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent arg0) {
				FmrSceltaGiorni vis = new FmrSceltaGiorni();
				vis.setVisible(true);
			}
		});
		mnCampi.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Prenotazione");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent arg0) {
				FmrPrenotazioneCampi vis = new FmrPrenotazioneCampi();
				vis.setVisible(true);
			}
		});
		mnCampi.add(mntmNewMenuItem_1);
		
		
		contentPane = new JPanel();
	//	contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
