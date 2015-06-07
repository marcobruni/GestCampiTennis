

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Campi {
	private String id;
	private String descrizione;
	private ArrayList<String> AlLun;
	private ArrayList<String> AlMar;
	private ArrayList<String> AlMer;
	private ArrayList<String> AlGio;
	private ArrayList<String> AlVen;
	private ArrayList<String> AlSab;
	private ArrayList<String> AlDom;


	//Costruttore.
	public Campi(String Parid)
	{
		this.id = Parid;
		
	} 

	
	//Metodi getter e setter degli attributi.
	public String getId(){ return id; }
    private void setId(String i){ id=i; }
    
    public String getDescrizione(){ return descrizione; }
    private void setDescrizione(String des){ descrizione = des; }
    
    public ArrayList<String> getLunOrari(){
    	AlLun = ModuloCampi.getGiornoOrari("luned�",id);
    	return AlLun;
        }
    
    public ArrayList<String> getMarOrari(){
    	AlMar = ModuloCampi.getGiornoOrari("marted�",id);
    	return AlMar;
    }
	
    public ArrayList<String> getMerOrari(){
    	AlMer = ModuloCampi.getGiornoOrari("mercoled�",id);
    	return AlMer;
    }
    
    public ArrayList<String> getGioOrari(){
    	AlGio = ModuloCampi.getGiornoOrari("Gioved�",id);
    	return AlGio;
    }
    
    public ArrayList<String> getVenOrari(){
    	AlVen = ModuloCampi.getGiornoOrari("venerd�",id);
    	return AlVen;
    }
    
    public ArrayList<String> getSabOrari(){
    	AlSab = ModuloCampi.getGiornoOrari("sabato",id);
    	return AlSab;
    }
    
    public ArrayList<String> getDomOrari(){
    	AlDom = ModuloCampi.getGiornoOrari("domenica",id);
    	return AlDom;
    }
	
	
}

