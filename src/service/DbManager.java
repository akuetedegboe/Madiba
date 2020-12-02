package service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.text.JTextComponent;
import org.eclipse.persistence.config.PersistenceUnitProperties;

/**
 *
 * @author Shalom Djidoula
 */
public class DbManager {

    static Map properties;
    private static EntityManagerFactory emf;
    private static EntityTransaction tx;
    private static EntityManager em;
    private static final DbManager instance = new DbManager();

    private DbManager() {
       

    }

    public static EntityManager getEntityManager() {
        String user = "root";
        String pass = "";
//        String adress = "192.168.43.181";
        String adress = "localhost";
        properties = new HashMap();
        properties.put(PersistenceUnitProperties.JDBC_USER, user);
        //properties.put(PersistenceUnitProperties.JDBC_DRIVER, "com.mysql.jdbc.Driver");
        properties.put(PersistenceUnitProperties.JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(PersistenceUnitProperties.JDBC_PASSWORD, pass);
        properties.put(PersistenceUnitProperties.JDBC_URL, "jdbc:mysql://" + adress + ":3306/madibadb?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC");
        
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory("MadibaPU",properties);
            
        }
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
        tx = em.getTransaction();
        if(!tx.isActive()){
            tx.begin();
        }
        return em;
    }

    public static void commit() {
        tx.commit();
    }

    public static void end() {
        em.close();
        emf.close();
    }

        private static class PersistenceUnitManagerHolder {
        private final static DbManager instance = new DbManager();
    }

    public static DbManager getInstance() {     
         return PersistenceUnitManagerHolder.instance;
    }
    public static EntityManager getEm() {
        return em;
    }

//    public static DbManager getInstance() {
//        return instance;
//    }

    public static EntityTransaction getTx() {
        return tx;
    }

   

    //	Events, Components et JPopupMenu
    public JPopupMenu clicDroit(MouseEvent evt, final JTextComponent jTextComponent) {
        JPopupMenu jPopupMenu = new JPopupMenu();

        JMenuItem jMenuItemCopy = new JMenuItem("Copy");
        jMenuItemCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jTextComponent.copy();
            }
        });

        JMenuItem jMenuItemCut = new JMenuItem("Cut");
        jMenuItemCut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jTextComponent.cut();
            }
        });

        JMenuItem jMenuItemPaste = new JMenuItem("Paste");
        jMenuItemPaste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jTextComponent.paste();
            }
        });

        jPopupMenu.add(jMenuItemCopy);
        jPopupMenu.add(jMenuItemCut);
        jPopupMenu.add(jMenuItemPaste);

        return jPopupMenu;
    }

    public String entreeKeyTyped(KeyEvent evt) {
        String recherche = "";
        StringTokenizer stringTokenizer = new StringTokenizer(evt.toString(), ",");
        for (int i = 0; i < stringTokenizer.countTokens(); i++) {
            stringTokenizer.nextToken();
            if (i == 2) {
                recherche += stringTokenizer.nextToken();
            }
        }

        stringTokenizer = new StringTokenizer(recherche, "=");
        for (int i = 0; i < stringTokenizer.countTokens(); i++) {
            stringTokenizer.nextToken();
            if (i == 0) {
                recherche = stringTokenizer.nextToken();
            }
        }
        return recherche;
    }
}
