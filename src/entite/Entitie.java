/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.List;
import javax.persistence.Query;
import service.DbManager;

/**
 *
 * @author Admin
 */
public class Entitie {

    protected Class entityClass;

    public Entitie() {
    }

    public boolean save() {
        try {
            DbManager.getEntityManager().persist(this);
            DbManager.getEntityManager().flush();
            DbManager.commit();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean refresh() {
        try {
            DbManager.getEntityManager().flush();
            DbManager.commit();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean update() {
        try {
            DbManager.getEntityManager().merge(this);
            DbManager.commit();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean delete() {
        try {
            DbManager.getEntityManager().remove(this);
            DbManager.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     *
     * @param T de classe de l'objet à retourner
     * @param limit
     * @return Une liste d'objet
     */
    public List findAll(Class T, Integer limit) {
        Query q = DbManager.getEntityManager().createNamedQuery(T.getSimpleName() + ".findAll");
        q.setMaxResults(limit);
        return q.getResultList();
    }

    public List findAll(Class T) {
        Query q = DbManager.getEntityManager().createNamedQuery(T.getSimpleName() + ".findAll");
        return q.getResultList();
    }

    public String changeFirstChar(String modele) {
        String model = modele;
        StringBuilder myBuilder = new StringBuilder(model);
        char c = myBuilder.substring(0, 1).toLowerCase().charAt(0);
        myBuilder.setCharAt(0, c);
        model = myBuilder.toString();
        return model;
    }

    public List findOne(String key, String modele) {
        List resultList = DbManager.getEntityManager()
                .createNamedQuery(entityClass.getSimpleName() + ".findBy" + modele)
                .setParameter(changeFirstChar(modele), key)
                .getResultList();
        if (resultList.isEmpty()) {
            return null;
        } else {
            return (List) resultList.get(0);
        }
    }

}
