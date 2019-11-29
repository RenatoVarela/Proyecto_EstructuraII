package proyectoestructura;

import java.util.ArrayList;
import java.util.Collections;

public class NodosArbol {
    
    ArrayList<Integer> llaves = new ArrayList<Integer>();
    int t = 7;
    ArrayList<NodosArbol> Hijos = new ArrayList<NodosArbol>();
   
    int k = -1;
    boolean Hoja;
    
    public NodosArbol(int t, boolean Hoja) {
        
        this.t = t;
        this.Hoja = Hoja;
        
    }
    
    public void Insertar_NOlleno(int k) {
        
        int i = llaves.size() - 1;
        
        if (Hoja == true) {
            
            llaves.add(k);
            
            Collections.sort(llaves);
            
        } else {
            
            while (i >= 0 && llaves.get(i) > k) {
                i--;
            }
            
            Hijos.get(i + 1).Insertar_NOlleno(k);
            Collections.sort(Hijos.get(i + 1).getLlaves());
            
            if (Hijos.get(i + 1).getLlaves().size() == t) {
                
                Split(i + 1, Hijos.get(i + 1));
                
            }
            
            Collections.sort(llaves);
            
        }
    }
    
    public void Split(int i, NodosArbol y) {
        
        NodosArbol z = new NodosArbol(y.getT(), y.isHoja());
        
        for (int j = ((y.getLlaves().size() - 1) / 2) + 1; j < y.getLlaves().size(); j++) {
            
            z.getLlaves().add(y.getLlaves().get(j));
            
        }
        
        int h = 0;
        if (y.isHoja() == false) {

//             for (int j = ((t-1)/2)+1; j < t; j++) {
//                 System.out.println(y.getChild().get(j).getLlaves());
//                
//             
//            }
            for (int j = ((t - 1) / 2) + 1; j <= t; j++) {
                
                z.getChild().add(h, y.getChild().get(j));
                h++;
            }
            
        }
        
        for (int j = llaves.size(); j >= i + 1; j--) {
            Hijos.add(j + 1, Hijos.get(j));
        }
        
        Hijos.add(i + 1, z);
        
        for (int j = llaves.size() - 1; j >= i; j--) {
            
            llaves.set(i + 1, llaves.get(i));
        }
        
        llaves.add(i, y.getLlaves().get((t - 1) / 2));
        
        int temp = y.getLlaves().size() / 2 + 1;
        
        for (int j = 1; j <= temp; j++) {
            
            y.getLlaves().remove(y.getLlaves().size() - 1);
            
        }
        
    }
    
    public int getT() {
        return t;
    }
    
    public void setT(int t) {
        this.t = t;
    }
    
    public ArrayList<NodosArbol> getChild() {
        return Hijos;
    }
    
    public void setChild(ArrayList<NodosArbol> c) {
        this.Hijos = c;
    }
    
    public ArrayList<Integer> getLlaves() {
        return llaves;
    }
    
    public void setLlaves(ArrayList<Integer> llaves) {
        this.llaves = llaves;
    }
    
    public boolean isHoja() {
        return Hoja;
    }
    
    public void setHoja(boolean leaf) {
        this.Hoja = leaf;
    }
    
    public NodosArbol Buscar(int k) {
        
        int i = 0;
        while (i < llaves.size() && k > llaves.get(i)) {
            i++;
        }
        
        System.out.println(i);
        
        if (llaves.contains(k)) {
            return this;
        }
        
        if (Hoja == true) {
            return null;
        }
        
        return Hijos.get(i).Buscar(k);
    }
    
    public boolean Demostracion(int k) {
        
        int i = llaves.size() - 1;
        
        if (Hoja == true) {
            
            return true;
            
        } else {
            
            return false;
            
        }
    }
    
    
     int index =0;
    public void Impresion2(int t,int index) {

        if (Hijos.isEmpty() == true) {
            // System.out.println("Cheke");
        } else {

            
            for (int i = 0; i < Hijos.size(); i++) {
                System.out.println("sub" + i);

                for (int j = 0; j < Hijos.get(i).getLlaves().size(); j++) {

                    System.out.println(Hijos.get(i).getLlaves().get(j));

                }

            }

            

            Hijos.get(index).Impresion2(t,index);

        }

    }
    
    public void jaja(){
        System.out.println("padre");
        
        for (int i = 0; i < llaves.size(); i++) {
            System.out.println(llaves.get(i));
        }
        
        
        
        for (int i = 0; i < llaves.size(); i++) {
            Impresion2( t, i);
            
        }
        
    }
//    public void Impresion2() {
//        
//        for (int i = 0; i < llaves.size(); i++) {
//            System.out.println("s;" + llaves.get(i));
//        }
//        
//        for (int i = 0; i < Hijos.size(); i++) {
//            
//            System.out.println("Hijos nodo:" + i);
//            for (int j = 0; j < Hijos.get(i).getLlaves().size(); j++) {
//                
//                System.out.println("s;" + Hijos.get(i).getLlaves().get(j));
//            }
//            
//        }
//        
//    }
    
    public int EncontarLlave(int k) {
        int idx = 0;        
        while (idx < llaves.size() && llaves.get(idx) < k) {
            ++idx;
        }        
        return idx;        
        
    }

    ///Metodos para Eliminar1
    void merge(int valor) {
        NodosArbol child = Hijos.get(valor);
        NodosArbol Hermano = Hijos.get(valor + 1);
        
        child.getLlaves().add(/*(((t-1)/2) - 1),*/llaves.get(valor));
        llaves.remove(valor);
        
        int temp = Hermano.getLlaves().size();
        for (int i = 0; i < temp; ++i) {
            child.getLlaves().add(Hermano.getLlaves().get(0));
            System.out.println("he" + Hermano.getLlaves().get(0));
            Hermano.getLlaves().remove(0);
            
        }
        
        if (Hermano.getLlaves().size() == 0) {
            Hijos.remove(valor + 1);
        }
        
        if (!child.isHoja()) {
            child.EliminarNoHoja(valor);
        }


    }
    
    public void eliminar(int k) {
        
        int idx = EncontarLlave(k);
        
        if (idx < llaves.size() && llaves.get(idx) == k) {
            System.out.println("alla");
            
            if (Hoja) {
                System.out.println("vamo");
                EliminarHoja(idx);
            } else {
                System.out.println("vamo2");
                EliminarNoHoja(idx);
            }
            
        } else {
            System.out.println("aqui");
            
            if (Hoja) {
                System.out.println("no existe");
                return;
            }

//            for (int i = 0; i < Hijos.get(idx).getLlaves().size(); i++) {
//                System.out.println("here comes:" + Hijos.get(idx).getLlaves().get(i));
//                
//            }
            if (idx > llaves.size()) {
                Hijos.get(idx - 1).eliminar(k);
            } else {
                Hijos.get(idx).eliminar(k);
            }
            
            if (Hijos.get(idx).getLlaves().size() < ((t - 1) / 2)) {
                
                System.out.println("asdasiudbsahdbhusdaf");
                llenar(idx);
            }
            
        }
        return;
    }
    
    public void encontrar(int k) {
        
    }
    
    public void EliminarNoHoja(int idx) {
        
        int llave = llaves.get(idx);
        
        if (Hijos.get(idx).getLlaves().size() > ((t - 1) / 2)) {
            System.out.println("fijate que si");
            int pred = Predecesor(idx);
            
            llaves.set(idx, pred);
            //llaves.remove(pred);
            Hijos.get(idx).eliminar(pred);
        } else if (Hijos.get(idx + 1).getLlaves().size() >   ((t - 1) / 2)) {
            System.out.println("que cosas va");
            int succ = Sucesor(idx);
            llaves.set(idx, succ);
            //llaves.remove(succ);
            Hijos.get(idx + 1).eliminar(succ);
        } else {
            merge(idx);
            Hijos.get(idx).eliminar(llave);
        }
        
    }
    
    public void EliminarHoja(int valor) {
        
        for (int i = valor + 1; i < llaves.size(); ++i) {
            llaves.set(i - 1, llaves.get(i));
            
        }
        
        llaves.remove(valor);
        
    }
    
    public int Predecesor(int idx) {
        
        NodosArbol cur = Hijos.get(idx);
        while (!cur.isHoja()) {
            cur = cur.Hijos.get(cur.getLlaves().size());
            
        }
        
        return cur.llaves.get(cur.getLlaves().size() - 1);
    }
    
    public int Sucesor(int idx) {
        
        NodosArbol cur = Hijos.get(idx + 1);
        while (!cur.isHoja()) {
            cur = cur.getChild().get(0);
        }
        
        return cur.getLlaves().get(0);
    }
    
    public void llenar(int idx) {
        
        System.out.println("xd");
        if (idx != llaves.size()) {
            merge(idx);
        } else {
            merge(idx - 1);
        }        
    
        
    }
}
