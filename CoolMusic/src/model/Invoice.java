/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;


/**
 *
 * @author usu21
 */
public class Invoice {

    private int invoiceNum;
    private Date dateI;
    private User client;

    public Invoice() {
        client = new User();
        dateI = new Date();
    }

    public static final String PROP_CLIENT = "client";

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        User oldClient = this.client;
        this.client = client;
        propertyChangeSupport.firePropertyChange(PROP_CLIENT, oldClient, client);
    }
   

    public Date getDate() {
        return dateI;
    }

    public void setDate(Date date) {
        this.dateI = date;
    }

    public static final String PROP_INVOICENUM = "invoiceNum";

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        int oldInvoiceNum = this.invoiceNum;
        this.invoiceNum = invoiceNum;
        propertyChangeSupport.firePropertyChange(PROP_INVOICENUM, oldInvoiceNum, invoiceNum);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
