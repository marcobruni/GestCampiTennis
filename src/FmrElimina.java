

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FmrElimina extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public FmrElimina() {
		setTitle("Elimina Cliente");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JComboBox cmbClienti = new JComboBox();
		contentPane.add(cmbClienti, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Elimina");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				String app;
				app = cmbClienti.getSelectedItem().toString();
				int trova=app.indexOf(" ");
				
				
				String CodCli = app.substring(0, trova);
				
				Modulo mod = new Modulo();
				Object[][] MatCli = mod.getVetClienti();
				
				FrmCliente client = new FrmCliente();	
				
				for(int i=0; i<MatCli.length ; i++)
				{
						if (MatCli[i][0].toString().trim().equals(CodCli.trim()))
						{
							mod.eliminaCliente(CodCli);
						    break;
														
						}
							
					
				}
			}
		});
		panel.add(btnNewButton);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				Modulo mod = new Modulo();
				Object[][] MatCli = mod.getVetClienti();
				
				cmbClienti.removeAllItems();
				
				String riga = "";
				for(int i=0; i<MatCli.length ; i++)
				{
					riga = MatCli[i][0] + " - " + MatCli[i][1] + " - " + MatCli[i][2] ;
					cmbClienti.addItem(riga);
				}
			}
		});
		
	}

}
