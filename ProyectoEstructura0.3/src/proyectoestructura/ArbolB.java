package proyectoestructura;

import java.util.Collection;
import java.util.Collections;

public class ArbolB {

    NodosArbol raiz;
    int t;

    public ArbolB(int t) {
        raiz = null;
        this.t = t;
    }

    public void insert(int Numero) {

        if (raiz == null) {                                                                             

            raiz = new NodosArbol(t, true);
            raiz.getLlaves().add(Numero);

        } else if (raiz.getLlaves().size() == t - 1) {

            if (raiz.Demostracion(Numero) == true) {
                raiz.getLlaves().add(Numero);

                Collections.sort(raiz.getLlaves());

                NodosArbol s = new NodosArbol(t, false);

                s.getChild().add(0, raiz);

                s.Split(0, raiz);

                int i = 0;
                if (s.getLlaves().get(0) < Numero) {
                    i++;
                }
                //s.getChild().get(i).Insertar_NOlleno(Numero);

                raiz = s;
                Collections.sort(raiz.getLlaves());

            } else {
                Collections.sort(raiz.getLlaves());
                raiz.Insertar_NOlleno(Numero);

                if (raiz.getLlaves().size() == t) {

                    Collections.sort(raiz.getLlaves());

                    NodosArbol s = new NodosArbol(t, false);

                    s.getChild().add(0, raiz);

                    s.Split(0, raiz);

                    int i = 0;
                    if (s.getLlaves().get(0) < Numero) {
                        i++;
                    }

                    raiz = s;
                    Collections.sort(raiz.getLlaves());

                }
            }

        } else {

            Collections.sort(raiz.getLlaves());
            raiz.Insertar_NOlleno(Numero);
        }

    }
    
    
    public void eliminar(int numero){
        
        raiz.eliminar(numero);
        
    }
    
    
    
    
    

    public void Imprimir() {
        if (raiz != null) {
            //6
            //raiz.Impresion2(6,0);
            raiz.jaja();
        }
    }

    public NodosArbol Buscar(int k) {
        if (raiz == null) {
            return null;
        } else {
            return raiz.Buscar(k);
        }
    }
}
