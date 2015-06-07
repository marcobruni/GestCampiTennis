

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCliente extends JFrame {

	private JPanel contentPane;
	final JLabel lblId;
	private JLabel nome;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtCellulare;
	private JTextField txtEmail;
	private JTextField txtIndirizzo;
	
	private String CliId;
	private String CliNome;
	private String CliCognome;
	private String CliCellulare;
	private String CliEmail;
	private String CliIndirizzo;
	
	private boolean modificaCliente = false;
			
			
	public void setId(String i){ CliId = i; }
	public void setNome(String n){ CliNome = n; }
	public void setCognome(String c){ CliCognome = c; }
	public void setCellulare(String cell){ CliCellulare = cell; }
	public void setEmail(String e){ CliEmail = e; }
	public void setIndirizzo(String indi){ CliIndirizzo = indi; }
	
	 
	public boolean getModificaCliente(){ return modificaCliente; }
	public void setModificaCliente(boolean nuovClie){  modificaCliente= nuovClie; }
	
	public void setFieldsTextBox()
	{
		if(modificaCliente){
			lblId.setText(CliId);
			txtNome.setText(CliNome);
			txtCognome.setText(CliCognome);
			txtCellulare.setText(CliCellulare);
			txtEmail.setText(CliEmail);
			txtIndirizzo.setText(CliIndirizzo);
			}	
	}
	
	
	
	

	/**
	 * Create the frame.
	 */
	public FrmCliente() {
		
	
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
		});
		Modulo mod = new Modulo();
		
		setTitle("Cliente");
		setForeground(Color.BLACK);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblId = new JLabel("ID: " +mod.getMaxIdCliente().toString() );
		
		nome = new JLabel("Nome:" );
		nome.setForeground(Color.BLUE);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel cognome = new JLabel("Cognome:");
		cognome.setForeground(Color.BLUE);
		
		txtCognome = new JTextField();
		txtCognome.setColumns(10);
		
		JLabel cellulare = new JLabel("Cellulare:");
		cellulare.setForeground(Color.BLUE);
		
		txtCellulare = new JTextField();
		txtCellulare.setColumns(10);
		
		JLabel email = new JLabel("E-Mail:");
		email.setForeground(Color.BLUE);
		
		txtEmail = new JTextField();
		txtEmail.setText("");
		txtEmail.setColumns(10);
		
		JLabel indirizzo = new JLabel("Indirizzo:");
		indirizzo.setForeground(Color.BLUE);
		
		txtIndirizzo = new JTextField();
		txtIndirizzo.setColumns(10);
		
		JDesktopPane desktopPane = new JDesktopPane();
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		
		JDesktopPane desktopPane_2 = new JDesktopPane();
		
		JButton salva = new JButton("SALVA");
		salva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		salva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				if(txtNome.getText().length() == 0)
					ModuloStatico.msgBox("Missing Name!", "Controllo Dati");
				else if(txtCognome.getText().length() == 0)
					ModuloStatico.msgBox("Missing Surname!", "Controllo Dati");
				else if(txtCellulare.getText().length() == 0)
					ModuloStatico.msgBox("Missing Telephone Number!", "Controllo Dati");
				else if(txtEmail.getText().length() == 0)
					ModuloStatico.msgBox("Missing E-Mail!", "Controllo Dati");
				else if(txtIndirizzo.getText().length() == 0)
					ModuloStatico.msgBox("Missing Address!", "Controllo Dati");
				else {
					Modulo mod = new Modulo();
					
					if(modificaCliente==false)
					{
						String lblId= mod.getMaxIdCliente();
					  mod.nuovoCliente(lblId, txtNome.getText() , txtCognome.getText(), txtCellulare.getText(), txtEmail.getText(), txtIndirizzo.getText() );
					}
					else
					{
						
					  mod.modificaCliente(lblId.getText(), txtNome.getText(), txtCognome.getText(), txtCellulare.getText(), txtEmail.getText(), txtIndirizzo.getText());
					}
				}
				
			}
			
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(indirizzo)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
									.addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
									.addGap(109))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(21)
									.addComponent(txtIndirizzo, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))))
						.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(2)
								.addComponent(email)
								.addGap(33)
								.addComponent(txtEmail))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(2)
								.addComponent(cellulare)
								.addGap(20)
								.addComponent(txtCellulare))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(cognome)
								.addGap(18)
								.addComponent(txtCognome))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addComponent(nome)
								.addGap(36)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))))
					.addGap(169))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(403)
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(382, Short.MAX_VALUE)
					.addComponent(desktopPane_2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(325, Short.MAX_VALUE)
					.addComponent(salva)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblId)
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(nome))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(21)
									.addComponent(cognome))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(txtCognome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(21)
									.addComponent(cellulare))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(txtCellulare, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(21)
									.addComponent(email))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(21)
									.addComponent(indirizzo))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(txtIndirizzo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addGap(22)))
					.addGap(11)
					.addComponent(salva)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(desktopPane_2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);


	}
}
