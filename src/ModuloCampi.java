

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ModuloCampi {
	
	
	
	public static ArrayList<String> getGiornoOrari(String Giorno , String id)
	{
		ArrayList<String> AlOrari = new ArrayList<>();
		try
		{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			
			Document doc = builder.parse(new File("C:\\Users\\sys-thema\\workspace\\GestioneCampiTennis\\campi.xml"));
            
			Element  RootElement = doc.getDocumentElement();
		
            NodeList campi = doc.getElementsByTagName("campo");

            for(int i=0; i<campi.getLength(); i++) {
            	
    						Node campo = (Node)campi.item(i);
    						
    						String idCampo = campo.getChildNodes().item(1).getTextContent().toString();
    						
    						if(idCampo.trim().equals(id))
    						{
    							String luned� = campo.getChildNodes().item(5).getNodeName();
        						String marted� = campo.getChildNodes().item(7).getNodeName();
        						String mercoled� = campo.getChildNodes().item(9).getNodeName();
        						String gioved� = campo.getChildNodes().item(11).getNodeName();
        						String venerd� = campo.getChildNodes().item(13).getNodeName();
        						String sabato = campo.getChildNodes().item(15).getNodeName();
        						String domenica = campo.getChildNodes().item(17).getNodeName();
        						
    							if(luned�.trim().toLowerCase().equals(Giorno.toLowerCase()))
    							{
    								
    								int numeroOrariFalsiLuned� = campo.getChildNodes().item(5).getChildNodes().getLength();
    								int numeroOrariLuned� = (numeroOrariFalsiLuned�-1)/2;
    								
    								for( int x = 1 ; x<numeroOrariLuned�+1; x++ )
    								{
    									int valore = (x * 2)-1;
    									AlOrari.add(campo.getChildNodes().item(5).getChildNodes().item(valore).getTextContent());
    									
    								}
    								break;
    							}
    							
    							else if(marted�.trim().toLowerCase().equals(Giorno.toLowerCase()))
    							{
    								
    								int numeroFalsiMarted� = campo.getChildNodes().item(7).getChildNodes().getLength();
									int numeroOrariMarted� = (numeroFalsiMarted�-1)/2;
									
									for( int z = 1 ; z<numeroOrariMarted�+1; z++ )
									{
										int valore = (z * 2)-1;
										AlOrari.add(campo.getChildNodes().item(7).getChildNodes().item(valore).getTextContent());
									}
									break;
    							}
    							
    							
    							else if(mercoled�.trim().toLowerCase().equals(Giorno.toLowerCase()))
    							{
    								int numeroFalsiMercoled� = campo.getChildNodes().item(9).getChildNodes().getLength();
									int numeroOrariMercoled� = (numeroFalsiMercoled�-1)/2;
									
									for( int c = 1 ; c<numeroOrariMercoled�+1; c++ )
									{
										int valore = (c * 2)-1;
										AlOrari.add(campo.getChildNodes().item(9).getChildNodes().item(valore).getTextContent());
									}
									break;
    							}
    							
    							else if(gioved�.trim().toLowerCase().equals(Giorno.toLowerCase()))
    							{
    								int numeroFalsiGioved� = campo.getChildNodes().item(11).getChildNodes().getLength();
									int numeroOrariGioved� = (numeroFalsiGioved�-1)/2;
									
									for( int q = 1 ; q<numeroOrariGioved�+1; q++ )
									{
										int valore = (q * 2)-1;
										AlOrari.add(campo.getChildNodes().item(11).getChildNodes().item(valore).getTextContent());
									}
									break;
    							}
    							
    							else if(venerd�.trim().toLowerCase().equals(Giorno.toLowerCase()))
    							{
    								int numeroFalsiVenerd� = campo.getChildNodes().item(13).getChildNodes().getLength();
									int numeroOrariVenerd� = (numeroFalsiVenerd�-1)/2;
									
									for( int w = 1 ; w<numeroOrariVenerd�+1; w++ )
									{
										int valore = (w * 2)-1;
										AlOrari.add(campo.getChildNodes().item(13).getChildNodes().item(valore).getTextContent());
									}
									break;
    							}
    							
    							else if(sabato.trim().toLowerCase().equals(Giorno.toLowerCase()))
    							{
    								int numeroFalsiSabato = campo.getChildNodes().item(15).getChildNodes().getLength();
									int numeroOrariSabato = (numeroFalsiSabato-1)/2;
									
									for( int e = 1 ; e<numeroOrariSabato+1; e++ )
									{
										int valore = (e * 2)-1;
										AlOrari.add(campo.getChildNodes().item(15).getChildNodes().item(valore).getTextContent());
									}
									break;
    							}
    							
    							else
    							{
    								int numeroFalsiDomenica = campo.getChildNodes().item(17).getChildNodes().getLength();
									int numeroOrariDomenica = (numeroFalsiDomenica-1)/2;
									
									for( int r = 1 ; r<numeroOrariDomenica+1; r++ )
									{
										int valore = (r * 2)-1;
										AlOrari.add(campo.getChildNodes().item(17).getChildNodes().item(valore).getTextContent());
									}
									break;
    							}
	
    					}
            	}
            
		}	
		
		catch(Exception e) 
		{
			e.printStackTrace(); 
		}  
		
		
		return AlOrari;
		
	}
	
	
	
	public List<Campi> numeroCampi(){
		List<Campi> lstCampi = new ArrayList<Campi>();
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = documentFactory.newDocumentBuilder(); 
            Document document = builder.parse(new File("campi.xml"));      
            
			
            NodeList campo = document.getElementsByTagName("campo");
            
            for(int i=0; i<campo.getLength(); i++) {
            	Node nodo = campo.item(i);
            	if(nodo.getNodeType() == Node.ELEMENT_NODE) { 
            		Element campi = (Element)nodo;
            		String id = campi.getElementsByTagName("id").item(0).getFirstChild().getNodeValue();
            		Campi camp = new Campi(id);
            		lstCampi.add(camp);
            		
            	}
            }
            
            
   	} catch(Exception e) {
			e.printStackTrace(); 
		} 
		
	 return lstCampi;	
	}
	
	
	
	
	
}
