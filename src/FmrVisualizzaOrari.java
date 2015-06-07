

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class FmrVisualizzaOrari extends JFrame {

	private JPanel contentPane;
	private JTable table;

	

	/**
	 * Create the frame.
	 */

	public FmrVisualizzaOrari(String sceltaGiorno) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				
				
	
			}
		});
		setTitle("Visualizzazioni Prenotazioni Campo");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ModuloCampi mod = new ModuloCampi();
		int numCampi = mod.numeroCampi().size();
		String[] Vett = new String[] {"1^ Colonna","2^ Colonna","3^ Colonna","4^ Colonna","5^ Colonna","6^ Colonna","7^ Colonna","8^ Colonna","9^ Colonna","10^ Colonna","11^ Colonna","12^ Colonna","13^ Colonna","14^ Colonna","15^ Colonna","16^ Colonna","17^ Colonna","18^ Colonna"};
		Object[][] MatTab = new Object[numCampi+1][18];
		
		for(int i=0; i<numCampi; i++)
			for(int j=0; j<18; j++)
				MatTab[i][j] = null;
		
		for(int x=1; x<18; x++)
			MatTab[0][x] = x + 6;
		
		ArrayList<Campi> lstCampi = new ArrayList<Campi>();
		lstCampi = (ArrayList<Campi>) mod.numeroCampi();
		Campi CampoApp = null ;
		
		for(int z=1; z<=numCampi; z++)
		{
			
			CampoApp =  (Campi)lstCampi.get(z-1);
			MatTab[z][0] = CampoApp.getId();
			
		}
		

		ArrayList<Campi> numeroCampi = (ArrayList<Campi>) mod.numeroCampi();
		ArrayList<String> AlOrari = null;
		
		Campi campo = null;	
		
		
		
		for( int i=0; i< numeroCampi.size() ; i++)
		{
			campo = numeroCampi.get(i);
			int q=0;
			String Id = campo.getId();
			
			AlOrari =  mod.getGiornoOrari(sceltaGiorno, Id);
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
						MatTab[i+1][orario - 6] = "D";
						break;
					}
				}
			}
			
		}

	table = new JTable();
	table.setEnabled(false);
	table.setModel(new DefaultTableModel(MatTab,Vett));
	contentPane.add(table, BorderLayout.CENTER);
	
	

	}
	
	

}
