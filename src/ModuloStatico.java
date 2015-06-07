/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author sys-thema
 */
public class ModuloStatico {
   

    public static String[] getNomeColonne()
    {
        String[] nomeColonne = new String[]{"ID","Nome","Cognome","Cellulare","Email","Indirizzo"};
        return nomeColonne; 
    }
    
    public static void msgBox(String infoMessage, String location)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Gestione Campi Tennis: " + location, JOptionPane.INFORMATION_MESSAGE);
    }
}

