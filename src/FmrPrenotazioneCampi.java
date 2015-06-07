

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JDesktopPane;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FmrPrenotazioneCampi extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private String scelta;
	
	/**
	 * Create the frame.
	 */
	public FmrPrenotazioneCampi() {
		setTitle("Prenotazione Campo");
JLabel lblCliente = new JLabel("Cliente ");
		
		final JComboBox cmbClienti = new JComboBox();
		
		JLabel lblGiorno = new JLabel("Giorno");
		
		final JComboBox cmbGiorni = new JComboBox();
		
		JLabel lblOrario = new JLabel("Orario");
		
		JLabel lblDa = new JLabel("Da :");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblAlle = new JLabel("Alle :");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				String[] giorni = {"Luned�","Marted�","Mercoled�","Gioved�","Venerd�","Sabato","Domenica"};

				cmbGiorni.removeAllItems();
				
				cmbGiorni.addItem(giorni[0]);
				cmbGiorni.addItem(giorni[1]);
				cmbGiorni.addItem(giorni[2]);
				cmbGiorni.addItem(giorni[3]);
				cmbGiorni.addItem(giorni[4]);
				cmbGiorni.addItem(giorni[5]);
				cmbGiorni.addItem(giorni[6]);
				
				
				scelta = cmbGiorni.getSelectedItem().toString();
				
				Modulo modul = new Modulo();
				Object[][] MatCli = modul.getVetClienti();
				
				cmbClienti.removeAllItems();
				
				String riga = "";
				for(int i=0; i<MatCli.length ; i++)
				{
					riga = MatCli[i][1] + " - " + MatCli[i][2] ;
					cmbClienti.addItem(riga);
				}
					
				
		}
			
		});
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		JButton btnSalve = new JButton("Salva");
		btnSalve.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(textField.getText().length() == 0)
					ModuloStatico.msgBox("Inserimento data mancante!", "Controllo Dati");
				else if(textField_1.getText().length() == 0)
					ModuloStatico.msgBox("Inserimento data mancante!", "Controllo Dati");
				
				else 
				{
					int primaData=0;
					int secondaData=0;

					ModuloCampi mod = new ModuloCampi();
					
					String Da = textField.getText();
					int OrarioDa=Integer.parseInt(Da);
					String A = textField_1.getText();
					int OrarioA=Integer.parseInt(A);
					
					ArrayList<Campi> numeroCampi = (ArrayList<Campi>) mod.numeroCampi();
					ArrayList<String> AlOrari = null;
					
					Campi campo = null;	
					
					for( int i=0; i< numeroCampi.size() ; i++)
					{
						campo = numeroCampi.get(i);
						int q=0;
						String Id = campo.getId();
						
						AlOrari =  mod.getGiornoOrari(scelta, Id);
						int[] ArrayOrari =  new int [(AlOrari.size())*2];
						
						for(int j=0; j<AlOrari.size(); j++)
						{
							int trattino = AlOrari.get(j).indexOf("-");
							
							String stringaNumero = AlOrari.get(j).substring(0 , trattino);
							
							int primoOrario=Integer.parseInt(stringaNumero);
							
							ArrayOrari[q] = primoOrario; 

							String stringaSecNumero = AlOrari.get(j).substring(trattino+1);
							int secondoOrario=Integer.parseInt(stringaSecNumero);
							
							ArrayOrari[q+1] = secondoOrario;
							
							q = q + 2;

						}
						
						for(int orario=7; orario<24; orario++)
						{
							
							for (int indice = 0; indice < (AlOrari.size() * 2); indice = indice +2 )
							{
								if( ( orario >= ArrayOrari[indice]) && ( orario <= ArrayOrari[indice+1]))
								{
									if(OrarioDa == ArrayOrari[indice]) primaData=1;
								//	if(OrarioA == ArrayOrari[indice]) ModuloStatico.msgBox("2^ Data DISPONIBILE ", "Controllo Dati");
									break;
								}
								
							}	
							
							for (int indice = 0; indice < (AlOrari.size() * 2); indice = indice +1 )
							{
								if( ( orario >= ArrayOrari[indice]) && ( orario <= ArrayOrari[indice+1]))
								{
									if(OrarioA == ArrayOrari[indice]) secondaData=1;
									break;
								}
							}
								
							
							
						}
						if(primaData==1)
							 ModuloStatico.msgBox("1^ Data � disponibile del campo :  " + campo.getId().toString()  , "Controllo Dati");
						else ModuloStatico.msgBox("1^ Data non � disponibile per il campo : " +  campo.getId().toString() , "Controllo Dati");
						if(secondaData==1)
							 ModuloStatico.msgBox("2^ Data � disponibile per il campo : " +  campo.getId().toString() , "Controllo Dati");
						else ModuloStatico.msgBox("2^ Data non � disponibile per il campo : " +  campo.getId().toString() , "Controllo Dati");
					}
					
					
					
				}
					
					
					
		
			}
		});
		

		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCliente)
								.addComponent(lblGiorno)
								.addComponent(lblOrario))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(cmbGiorni, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cmbClienti, 0, 179, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addGap(11))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(113)
							.addComponent(lblDa)
							.addGap(74)
							.addComponent(lblAlle)))
					.addContainerGap(152, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(312, Short.MAX_VALUE)
					.addComponent(btnSalve)
					.addGap(23))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCliente)
						.addComponent(cmbClienti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGiorno)
						.addComponent(cmbGiorni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDa)
						.addComponent(lblAlle))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOrario)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnSalve)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
