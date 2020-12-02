/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import entite.Vente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yvesdegboe
 */
public class VenteTableModel extends AbstractTableModel{
    

    
    private final String[] entete = {"Date", "vente Totale","Vendeur"};
    private List<Vente> ventes;

    public VenteTableModel() {
        Vente vente = new Vente();
        ventes = vente.findAll(Vente.class);
    }



 

    @Override
    public int getRowCount() {
        return ventes.size();
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
                return ventes.get(rowIndex).getDatevente();
            case 1:
                return ventes.get(rowIndex).getTotalvente();
            case 2:
                return ventes.get(rowIndex).getUtiilisateurId().toString();
           
            default:
                return "";
        }
    }

    public Vente getElementAt(int index) {

        return ventes.get(index);

    }
}
