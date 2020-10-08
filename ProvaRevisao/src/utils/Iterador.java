package utils;

import java.util.Iterator;
import listaduplamenteencadeada.Celula;

public class Iterador<T> implements Iterator {

    private Celula atual;

    public Iterador(Celula atual) {
        this.atual = atual;
    }

    @Override
    public boolean hasNext() {
        if (atual != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        T elemento = (T) atual.getElemento();
        atual = atual.getProximo();
        return elemento;
    }

    public Celula getAtual() {
        return atual;
    }
}
