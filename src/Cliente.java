



import java.util.List;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;   
import org.w3c.dom.*;  
import java.io.*;

/**
 *
 * @author sys-thema
 */
public class Cliente {
    //Attributi della classe cliente..
    private String id;
    private String nome;
    private String cognome;
    private String cellulare;
    private String email;
    private String indirizzo;
    
    //Costruttore  
    public Cliente(String id,String nome,String cognome,String cellulare,String email,String indirizzo)
        {
         this.id=id;
         this.nome=nome;
         this.cognome=cognome;
         this.cellulare=cellulare;
         this.email=email;
         this.indirizzo=indirizzo;
        }
    
    //Metodi Getter e Setter degli attributi della classe "Cliente"
    public String getId(){ return id; }
    private void setId(String i){ id=i; }
    
    public String getNome(){ return nome; } 
    private void setNome(String n){ nome=n; }
    
    public String getCognome(){ return cognome; }
    private void setCognome(String c){ cognome=c; }
    
    public String getCellulare(){ return cellulare; }
    private void setCellulare(String cell){ cellulare=cell; }
    
    public String getEmail(){ return email; } 
    private void setEmail(String e){ email=e; } 
    
    public String getIndirizzo(){ return indirizzo; }
    private void setIndirizzo(String indi){ indirizzo=indi; }
    
    public Object[] getVetVal(){
        Object[] vet = new Object[6];
        vet[0]=getId();
        vet[1]=getNome();
        vet[2]=getCognome();
        vet[3]=getCellulare();
        vet[4]=getEmail();
        vet[5]=getIndirizzo();
        
       return vet;
       
       }
    
    
    
}
