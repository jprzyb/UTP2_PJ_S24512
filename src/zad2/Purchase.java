package zad2;

import java.beans.*;

public class Purchase {
    private String prod;
    private String data;
    private Double price;

    public Purchase(String prod, String data, Double price) {
        this.prod = prod;
        this.data = data;
        this.price = price;
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        String oldValue = this.data;
        this.data = data;
        System.out.println("Change value of: data from: " + oldValue + " to: " + data);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) throws PropertyVetoException {
        Double oldValue = this.price;
        if (price < 1000) {
           new PropertyVetoException("Price change to: " + price + " not allowed");
        }
        this.price = price;
        System.out.println("Change value of: price from: " + oldValue + " to: " + price);
    }

    public String toString() {
        return "Purchase [prod=" + prod + ", data=" + data + ", price=" + price + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
}
