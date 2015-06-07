/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;
import java.text.AttributedCharacterIterator.Attribute;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.*;

/**
 *
 * @author sys-thema
 */
public class Modulo {
   

    
    public Object[][] getVetClienti()
    {
        Cliente cli;
        List<Cliente> lstCliAppo = visualizza();
        String[] VetCols = ModuloStatico.getNomeColonne();
        Object[] VetObj = new Object[VetCols.length];
        
        Object[][] VetCli = new Object[lstCliAppo.size()][VetCols.length];
     
        for(int i=0; i<lstCliAppo.size(); i++)
        {
            cli = lstCliAppo.get(i);
            
            for(int j=0; j<VetCols.length; j++)
            {
                VetObj = cli.getVetVal();
                VetCli[i][j] = VetObj[j];
            }
            
        }
                
        return VetCli;
  
    }
    
    public List<Cliente> visualizza(){
        List<Cliente> lstCli = new ArrayList<Cliente>(); 
          try{
              DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
              DocumentBuilder builder = documentFactory.newDocumentBuilder(); 
              Document document = builder.parse(new File("clienti.xml"));      
              
              NodeList cliente = document.getElementsByTagName("cliente");
              for(int i=0; i<cliente.getLength(); i++) {
			Node nodo = cliente.item(i); 
                        if(nodo.getNodeType() == Node.ELEMENT_NODE) { 
                        		Element clienti = (Element)nodo;
                                String id = clienti.getElementsByTagName("id").item(0).getFirstChild().getNodeValue();
                                String nome = clienti.getElementsByTagName("nome").item(0).getFirstChild().getNodeValue();
                                String cognome = clienti.getElementsByTagName("cognome").item(0).getFirstChild().getNodeValue();
                                String cellulare = clienti.getElementsByTagName("cellulare").item(0).getFirstChild().getNodeValue();
                                String email = clienti.getElementsByTagName("email").item(0).getFirstChild().getNodeValue();
                                String indirizzo = clienti.getElementsByTagName("indirizzo").item(0).getFirstChild().getNodeValue();
                          
                                Cliente cli = new Cliente(id,nome,cognome,cellulare,email,indirizzo);
                                lstCli.add(cli);
                          
                        }
              }
          }
          catch(Exception e) {
		e.printStackTrace(); 
	}  
        return lstCli;
    } 
    
    
    
    public String getMaxIdCliente(){
    	String ultimoid = null;
    	
    	try{
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = documentFactory.newDocumentBuilder(); 
            Document document = builder.parse(new File("clienti.xml"));      
            
            NodeList cliente = document.getElementsByTagName("cliente");
            for(int i=0; i<cliente.getLength(); i++) {
            	Node nodo = cliente.item(i); 
                if(nodo.getNodeType() == Node.ELEMENT_NODE) { 
                    	  		Element clienti = (Element)nodo;
                    	  		String id = clienti.getElementsByTagName("id").item(0).getFirstChild().getNodeValue();
                    	  		ultimoid=id;
                      			}
            	}
    		}
    	catch(Exception e) 
    		{
    			e.printStackTrace(); 
    		}  
    	int num = Integer.parseInt(ultimoid);
    	num++;
    	String idfinale = customFormat("000", num);
		return idfinale;
    } 



    public String customFormat(String pattern, double value ) {
    	String StrFormat = "";
    	
    	DecimalFormat myFormatter = new DecimalFormat(pattern);
    	StrFormat = myFormatter.format(value);
    	
    	return StrFormat;
    	}

    
    
    public void nuovoCliente(String lblId, String txtNome , String txtCognome, String txtCellulare, String txtEmail , String txtIndirizzo  ) {
		try{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			
			Document doc = builder.parse(new File("/home/marco/workspace/Prova1/clienti.xml"));
			Element rootElement = (Element) doc.getFirstChild();
			
			Element child1 = doc.createElement("cliente");
			
			Element field1 = doc.createElement("id");
			field1.setTextContent(lblId);
			child1.appendChild(field1);
			
			Element field2 = doc.createElement("nome");
			field2.setTextContent(txtNome);
			child1.appendChild(field2);
			
			Element field3 = doc.createElement("cognome");
			field3.setTextContent(txtCognome);
			child1.appendChild(field3);
			
			Element field4 = doc.createElement("cellulare");
			field4.setTextContent(txtCellulare);
			child1.appendChild(field4);
			
			Element field5 = doc.createElement("email");
			field5.setTextContent(txtEmail);
			child1.appendChild(field5);
			
			Element field6 = doc.createElement("indirizzo");
			field6.setTextContent(txtIndirizzo);
			child1.appendChild(field6);
			
			rootElement.appendChild(child1);
			
			
		// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("/home/marco/workspace/Prova1/clienti.xml"));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
			transformer.transform(source,result);    
			try{
				ModuloStatico.msgBox("Success Saved", "Controllo Dati");
			}
			catch(Exception e)
				{
				e.printStackTrace(); 
				}
			
			
		}
		catch(Exception e) 
			{
				e.printStackTrace(); 
			}  
    	
    	
    	
		
	}
    
    public void modificaCliente(String lblId, String txtNome , String txtCognome, String txtCellulare, String txtEmail , String txtIndirizzo)
    {
      try{
    	  	DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			
			Document doc = builder.parse(new File("C:\\Users\\sys-thema\\workspace\\GestioneCampiTennis\\clienti.xml"));
    	    
			
			Element child1 = doc.createElement("cliente");
			
			Element field1 = doc.createElement("id");
			field1.setTextContent(lblId);
			child1.appendChild(field1);
			
			Element field2 = doc.createElement("nome");
			field2.setTextContent(txtNome);
			child1.appendChild(field2);
			
			Element field3 = doc.createElement("cognome");
			field3.setTextContent(txtCognome);
			child1.appendChild(field3);
			
			Element field4 = doc.createElement("cellulare");
			field4.setTextContent(txtCellulare);
			child1.appendChild(field4);
			
			Element field5 = doc.createElement("email");
			field5.setTextContent(txtEmail);
			child1.appendChild(field5);
			
			Element field6 = doc.createElement("indirizzo");
			field6.setTextContent(txtIndirizzo);
			child1.appendChild(field6);
			
			
			NodeList cliente = doc.getElementsByTagName("cliente");

			for(int j=0; j<cliente.getLength(); j++) {
				Node nodo = cliente.item(j); 
				if(nodo.getNodeType() == Node.ELEMENT_NODE) { 
					Element clienti = (Element)nodo;
					String id = clienti.getElementsByTagName("id").item(0).getFirstChild().getNodeValue();
					if(id.trim().equals(lblId)){
					((Node) doc.getFirstChild().getChildNodes()).replaceChild(child1 , clienti) ;
					
					}
				}
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\Users\\sys-thema\\workspace\\GestioneCampiTennis\\clienti.xml"));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
			transformer.transform(source,result);    
			
			try{
				ModuloStatico.msgBox("Success Saved", "Controllo Dati");
			}
			catch(Exception e)
				{
				e.printStackTrace(); 
				}
			
      
		
      }
      
      
      
      catch(Exception e) 
		{
			e.printStackTrace(); 
		}  
    }
    

    
   
    
    public void eliminaCliente(String lblId)
    {
    	try{
    		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			
			Document doc = builder.parse(new File("C:\\Users\\sys-thema\\workspace\\GestioneCampiTennis\\clienti.xml"));
			
			NodeList cliente = doc.getElementsByTagName("cliente");

			for(int j=0; j<cliente.getLength(); j++) {
				Node nodo = cliente.item(j); 
				if(nodo.getNodeType() == Node.ELEMENT_NODE) { 
					Element clienti = (Element)nodo;
					String id = clienti.getElementsByTagName("id").item(0).getFirstChild().getNodeValue();
					if(id.trim().equals(lblId)){
					((Node) doc.getFirstChild().getChildNodes()).removeChild(clienti);
					
					}
				}
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\Users\\sys-thema\\workspace\\GestioneCampiTennis\\clienti.xml"));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
			transformer.transform(source,result);    
			
			try{
				ModuloStatico.msgBox("Success Erase", "Controllo Dati");
			}
			catch(Exception e)
				{
				e.printStackTrace(); 
				}	
			
			
			
    	}
    	
    	catch(Exception e) 
  		{
  			e.printStackTrace(); 
  		}
    }

}

