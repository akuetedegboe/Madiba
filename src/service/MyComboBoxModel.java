/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author 
 * @param <T>
 */
public class MyComboBoxModel<T> extends DefaultComboBoxModel<T> {

    List list;

    public MyComboBoxModel() {
    }

    public MyComboBoxModel( List list) {
        this.list = list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public List getList() {
        return list;
    }
    
    


    // Ces deux dernieres methodes suivantes ne sont pas encore exploitees. ?
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public T getElementAt(int index) {
        return (T) list.get(index);
    }
}
