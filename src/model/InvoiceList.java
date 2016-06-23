/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author Juan
 */
public class InvoiceList {

    private ObservableList<Invoice> list;

    public InvoiceList() {
        list = ObservableCollections.observableList(new ArrayList<Invoice>());
    }

    public void insertInvoice(Invoice in) {
        list.add(in);
    }
        

    public static final String PROP_LIST = "list";

    public ObservableList<Invoice> getList() {
        return list;
    }

    public void setList(ObservableList<Invoice> list) {
        ObservableList<Invoice> oldList = this.list;
        this.list = list;
        propertyChangeSupport.firePropertyChange(PROP_LIST, oldList, list);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
