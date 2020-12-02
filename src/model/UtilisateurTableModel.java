/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import entite.Utilisateur;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yvesdegboe
 */
public class UtilisateurTableModel extends AbstractTableModel{
    

    
    private final String[] entete = {"Nom", "Prenom","Login","Password","Type"};
    private List<Utilisateur> utilisateurs;

    public UtilisateurTableModel() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateurs = utilisateur.findAll(Utilisateur.class);
    }

 String[] entetes = {"Date", "vente Totale","Vendeur"};

 

    @Override
    public int getRowCount() {
        return utilisateurs.size();
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
                return utilisateurs.get(rowIndex).getNom();
            case 1:
                return utilisateurs.get(rowIndex).getPrenom();
            case 2:
                return utilisateurs.get(rowIndex).getLogin();
            case 3:
                return utilisateurs.get(rowIndex).getPassword();
            case 4:
                return utilisateurs.get(rowIndex).getTypeutilisateur();
            default:
                return "";
        }
    }

    public Utilisateur getElementAt(int index) {

        return utilisateurs.get(index);

    }
}
