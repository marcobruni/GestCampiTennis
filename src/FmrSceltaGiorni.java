

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FmrSceltaGiorni extends JFrame {

	private JPanel contentPane;
	

	
	/**
	 * Create the frame.
	 */
	public FmrSceltaGiorni() {
		setTitle("Scelta giorni");
		
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JComboBox cmbCampi = new JComboBox();
		contentPane.add(cmbCampi, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				String[] giorni = {"Luned�","Marted�","Mercoled�","Gioved�","Venerd�","Sabato","Domenica"};

				cmbCampi.removeAllItems();
				
				cmbCampi.addItem(giorni[0]);
				cmbCampi.addItem(giorni[1]);
				cmbCampi.addItem(giorni[2]);
				cmbCampi.addItem(giorni[3]);
				cmbCampi.addItem(giorni[4]);
				cmbCampi.addItem(giorni[5]);
				cmbCampi.addItem(giorni[6]);
				
			}
		});
//		

		JButton btnNewButton = new JButton("Visualizza");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ModuloCampi mod = new ModuloCampi();
				
				String scelta;
				scelta = cmbCampi.getSelectedItem().toString();  //Scelta del giorno selezionato dal combobox!
				
				cmbCampi.removeAllItems();
				
				FmrVisualizzaOrari vis = new FmrVisualizzaOrari(scelta);

				vis.setVisible(true);
				
				
				
				//Evento per la visualizzazione del giorno selezionato.
			}
		});
		panel.add(btnNewButton);
		
	}

}
