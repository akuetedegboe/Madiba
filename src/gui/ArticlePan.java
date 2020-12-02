/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import entite.Article;
import model.ArticleTableModel;
import service.MessageDialog;

/**
 *
 * @author yvesdegboe
 */
public class ArticlePan extends javax.swing.JPanel {

    private Article currentArticle;
    private boolean nouveau = true;

    /**
     * Creates new form ArticlePan
     */
    public ArticlePan() {
        initComponents();
//         ArticleTableModel cptModels = new ArticleTableModel();
//        articleTable.setModel(cptModels);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        libellefield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pufield = new javax.swing.JTextField();
        ajoutBtnart = new javax.swing.JButton();
        nouveauBtnart = new javax.swing.JButton();
        modifBtnart = new javax.swing.JButton();
        suppBtnart = new javax.swing.JButton();
        anBtnart = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        articleTable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(840, 510));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setPreferredSize(new java.awt.Dimension(240, 460));

        jLabel1.setText("Libelle");

        libellefield.setToolTipText("");

        jLabel2.setText("Prix Unitaire");

        ajoutBtnart.setBackground(new java.awt.Color(0, 51, 153));
        ajoutBtnart.setText("Enregistrer");
        ajoutBtnart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutBtnartActionPerformed(evt);
            }
        });

        nouveauBtnart.setBackground(new java.awt.Color(0, 51, 153));
        nouveauBtnart.setText("Nouveau");

        modifBtnart.setBackground(new java.awt.Color(0, 51, 153));
        modifBtnart.setText("Modifier");

        suppBtnart.setBackground(new java.awt.Color(0, 51, 153));
        suppBtnart.setText("Supprimer");

        anBtnart.setBackground(new java.awt.Color(0, 51, 153));
        anBtnart.setText("Annuler");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(anBtnart, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppBtnart, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifBtnart, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nouveauBtnart, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ajoutBtnart, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pufield, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(libellefield, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(libellefield, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(pufield, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(ajoutBtnart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(nouveauBtnart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(modifBtnart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(suppBtnart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(anBtnart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setPreferredSize(new java.awt.Dimension(570, 460));

        articleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Libelle", "Prix Unitaire"
            }
        ));
        jScrollPane1.setViewportView(articleTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ajoutBtnartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutBtnartActionPerformed
        boolean pass = true;
        if (libellefield.getText().equals("")) {
            pass = false;
        }
        if (pufield.getText().equals("")) {
            pass = false;
        }

        if (pass) {

            Article article = new Article();

            article.setLibelle(libellefield.getText());
            article.setPu(Double.parseDouble(pufield.getText()));

            boolean reponse;

            if (nouveau) {
                reponse = article.save();

            } else {
                article = currentArticle;
                article.setId(currentArticle.getId());
                article.setLibelle(libellefield.getText());
                article.setPu(Double.parseDouble(pufield.getText()));
                reponse = article.update();

            }

            if (reponse) {
                if (nouveau) {
                    MessageDialog.successMessage("ok", "le article " + article.toString() + " a été créé avec succès");

                } else {
                    MessageDialog.successMessage("ok", "le article " + article.toString() + " a été mis à jour avec succès");

                }
//                this.dispose();

            } else {
                MessageDialog.ErrorMessage();
            }
        } else {
            MessageDialog.warningMessage("Attention", "Tous les champs marqués (*) sont obligatoires!");
        }
//        String lib;
//       Double pua;
//        boolean pass = true;
//         if (libellefield.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Veuillez saisir le libelle de l'article");
//        } else if (pufield.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Veuillez saisir le prix unitaire de l'article");
//        }else {
//
//           
//            lib = libellefield.getText();
//            pua=Double.parseDouble(pufield.getText());
//           
//            if (pass == true) {
//                Article u = new Article();
//              
//                try {
//                    u.setLibelle(lib);
//                    u.setPu(pua);
//                    
//                   u.save();
//                        JOptionPane.showMessageDialog(null, "Enregistrement effectué", "@TASFACT", JOptionPane.INFORMATION_MESSAGE);
//                    ArticleTableModel um = new ArticleTableModel();
//                    articleTable.setModel(um);
//                   
//                   
////                    d.cardReplace(Principale, clientList);
//
//                } catch (Exception e2) {
//                    e2.printStackTrace();
//                    JOptionPane.showMessageDialog(jPanel1, "Echec d'enregistrement!", "Attention", JOptionPane.WARNING_MESSAGE);
//                }
//            }
//        }  // TODO add your handling code here:
    }//GEN-LAST:event_ajoutBtnartActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajoutBtnart;
    private javax.swing.JButton anBtnart;
    private javax.swing.JTable articleTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField libellefield;
    private javax.swing.JButton modifBtnart;
    private javax.swing.JButton nouveauBtnart;
    private javax.swing.JTextField pufield;
    private javax.swing.JButton suppBtnart;
    // End of variables declaration//GEN-END:variables
}