

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;

public class FmrVisualizza extends JFrame {

	private JPanel contentPane;
	private JTable table;

	
	/**
	 * Create the frame.
	 */
	public FmrVisualizza() {
		setTitle("Visualizzazione clienti ");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Modulo mod = new Modulo();
    	Object[][] matr = mod.getVetClienti();
    	Object[] vett = ModuloStatico.getNomeColonne();
    	
		table = new JTable(matr,vett);
		table.setForeground(Color.BLACK);
		table.setEnabled(false);
		contentPane.add(table, BorderLayout.CENTER);
	}

}
