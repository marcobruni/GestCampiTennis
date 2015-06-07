

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FmrModifica extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public FmrModifica() {

		setTitle("Modifica Cliente");
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
		
		
		JButton btnNewButton = new JButton("Modifica");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String CliNome = "";
				String CliCognome = "";
				String CliCellulare = "";
				String CliEmail = "";
				String CliIndirizzo = "";
				
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
							CliNome = (String) MatCli[i][1].toString();
							CliCognome = (String) MatCli[i][2].toString();
							CliCellulare = (String) MatCli[i][3].toString();
							CliEmail = (String) MatCli[i][4].toString();
							CliIndirizzo = (String) MatCli[i][5].toString();
						    break;
														
						}
							
					
				}
				
				client.setId(CodCli);
				client.setNome(CliNome);
				client.setCognome(CliCognome);
				client.setCellulare(CliCellulare);
				client.setEmail(CliEmail);
				client.setIndirizzo(CliIndirizzo);
				
				client.setModificaCliente(true);
				
				client.setFieldsTextBox();
				
				client.setVisible(true);

			}
		});
		panel.add(btnNewButton);
		
	}

}
