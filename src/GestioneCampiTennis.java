/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GestioneCampiTennis {

    public static void main(String[] args) {
    	
        FmrMain prova = new FmrMain();
        JLabel sfondo = new JLabel(new ImageIcon("/home/marco/workspace/Prova1/RollandGarros.jpg"));
        prova.add(sfondo);
        prova.setVisible(true);

    }
}
