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
public class Campo {
    
    String tipo;
    String nombre;
    int size;
    boolean key;
    String dato;

    public Campo(String tipo, String nombre, int size, boolean key) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.size = size;
        this.key = key;
    }

    public Campo() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
    
    @Override
    public String toString() {
        return  nombre;
    }
    
    
    
    
    
    
    
}


