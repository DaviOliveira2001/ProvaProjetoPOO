/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.classe;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Collections;
/**
 *
 * @author odavi
 */
public class BdFamosos {
    public ArrayList <String> listaFamosos;
    public ArrayList <String> listaFamososAlfabetica;
    
    public BdFamosos(){
        listaFamosos = new ArrayList();
        listaFamososAlfabetica = new ArrayList();
    }
    public void save(String nome){
        listaFamosos.add(nome);
        listaFamososAlfabetica.add(nome);
        
        JOptionPane.showMessageDialog(null, "O artista foi salvo com sucesso.");
    }
    public String toString(){
        String result = "Lista de Famoso\n";
        if( !listaFamosos.isEmpty()){
            for(int i = 0; i < listaFamosos.size(); i++){
                result += listaFamosos.get(i)+"\n";
            }
        }else{
            result = "A base de dados se encontra vazia.";
        }
        return result;
    }
    public String toStringAlfabetico(){
        String result = "Lista de Famoso\n";
        if( !listaFamososAlfabetica.isEmpty()){
            Collections.sort(listaFamososAlfabetica);
            for(int i = 0; i < listaFamososAlfabetica.size(); i++){
                result += listaFamososAlfabetica.get(i)+"\n";
            }
        }else{
            result = "A base de dados se encontra vazia.";
        }
        return result;
    }
    public int getSize(){
        return listaFamosos.size();
    }
    public String getNome(int i){
        String r = "";
        if(i >= 0){
            r = listaFamosos.get(i);
            r = listaFamososAlfabetica.get(i);
        }else{
            r = "O nome do famoso não existe.";
        }
        return r;
    }
    public void delete(int i){
        if(i != -1){
            listaFamosos.remove(i);
            listaFamososAlfabetica.remove(i);
        }else{
            JOptionPane.showMessageDialog(null, "Nome não existe.");
        }
    }
    public int search(String nome){
        boolean achou = false;
        int i = 0, r = -1;
        while(i < listaFamosos.size() && !achou){
            if(listaFamosos.get(i).equals(nome)){
                r = i;
                achou = true;
            }//fim do if
            i++;//proximo nome
        }//fim do loop
        return r;
    }
    public void update(int i, String update){
        if(i != -1 || update.length() > 0){
            listaFamosos.set(i, update);
            JOptionPane.showMessageDialog(null, "Nome modificado com sucesso.");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possivel modificar "
                    + "o nome pois o mesmo não existe.");
        }
    }
        public void reset(int i){
            if(i != -1){
                listaFamosos.clear();
                listaFamososAlfabetica.clear();
            }else{
                JOptionPane.showMessageDialog(null, "A base de dados se encontra vazia.");
            }
        }
    }