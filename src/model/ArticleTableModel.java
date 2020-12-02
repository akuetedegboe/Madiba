/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



import entite.Article;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yvesdegboe
 */
public class ArticleTableModel extends AbstractTableModel{
    

    
    private final String[] entete = {"Libelle", "Prix Unitaire"};
    private List<Article> articles;

    public ArticleTableModel() {
        Article article = new Article();
        articles = article.findAll(Article.class);
    }

 String[] entetes = {"Date", "vente Totale","Vendeur"};

 

    @Override
    public int getRowCount() {
        return articles.size();
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
                return articles.get(rowIndex).getLibelle();
            case 1:
                return articles.get(rowIndex).getPu();
            case 2:
              
            default:
                return "";
        }
    }

    public Article getElementAt(int index) {

        return articles.get(index);

    }
}
