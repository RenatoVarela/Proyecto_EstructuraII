/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructura;

import java.util.LinkedList;

/**
 *
 * @author Asus Pc
 */
public class Archivo {
    
    String Nombre;
    LinkedList<Registro> lista = new LinkedList();

    public Archivo() {
    }

    public Archivo(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public LinkedList<Registro> getLista() {
        return lista;
    }

    public void setLista(LinkedList<Registro> lista) {
        this.lista = lista;
    }
    
    
    
    
       
    
}
