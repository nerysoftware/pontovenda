/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JComboBox;

/**
 *
 * @author asnsoftware
 */
public class Metodos {
    public static String separadorDoisCampoCB_retona_Codigo(JComboBox cb){
    
            String array[] = new String[2];
        array = cb.getSelectedItem().toString().split("-");
      //  readJTableForDesc("SELECT * FROM cabecalholocacao WHERE cod_cliente ='" + array[0] + "'");
        return array[0];
    }
     public static String separadorDoisCampoCB_retona_Nome(JComboBox cb){
    
            String array[] = new String[2];
        array = cb.getSelectedItem().toString().split("-");
//        readJTableForDesc("SELECT * FROM cabecalholocacao WHERE cod_cliente ='" + array[0] + "'");
        return array[1];
    }
}
