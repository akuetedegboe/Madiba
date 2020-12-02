/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import entite.Lignevente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yvesdegboe
 */
public class LigneventeTableModel extends AbstractTableModel{
    

    
    private final String[] entete = {"Article", "Prix Unitaire", "Prix Total"};
    private List<Lignevente> ligneventes;

    public LigneventeTableModel() {
        Lignevente lignevente = new Lignevente();
        ligneventes = lignevente.findAll(Lignevente.class);
    }

 String[] entetes = {"Date", "vente Totale","Vendeur"};

 

    @Override
    public int getRowCount() {
        return ligneventes.size();
    }

    @Override
    public int getColumnCount() {
        return entete.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return entete[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch (columnIndex) {

           case 0:
                return ligneventes.get(rowIndex).getArticleId().getLibelle();
            case 1:
                return ligneventes.get(rowIndex).getArticleId().getPu();
            case 2:
                return ligneventes.get(rowIndex).getQte();
            case 3:
                return ligneventes.get(rowIndex).getPrixtotal();
            
            default:
                return "";
        }
    }

    public Lignevente getElementAt(int index) {

        return ligneventes.get(index);

    }
}
