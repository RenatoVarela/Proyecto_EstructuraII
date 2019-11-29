/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructura;

/**
 *
 * @author Asus Pc
 */
public class Data {
    int key;
    Object dato;

    public Data(int key, Object dato) {
        this.key = key;
        this.dato = dato;
    }

    public Data() {
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }
    
    
    
    
}
