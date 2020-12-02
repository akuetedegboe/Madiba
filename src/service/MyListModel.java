/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Admin
 */
public class MyListModel extends AbstractListModel<Object> {

    private List list ;

    public MyListModel() {
    }

    public MyListModel(List list) {
        this.list = list;
    }

    public void setEvents(List list) {
        this.list = list;
    }
    
    
    
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index);
    }


}
