package listaduplamenteencadeada;

import utils.Iterador;

public class ListaDuplamenteEncadeada<T> {

    private Celula inicio, fim;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void adicionaInicio(T elemento) {
        Celula nova = new Celula(elemento);
        if (this.tamanho == 0) {
            inicio = fim = nova;
            this.tamanho += 1;
        } else {
            nova.setProximo(inicio);
            nova.getProximo().setAnterior(nova);
            inicio = nova;
            inicio.setAnterior(fim);
            fim.setProximo(inicio);
            this.tamanho += 1;
        }
    }

    public T Recupera(int posicao) {
        if (!existeDado()) {
            throw new ArrayIndexOutOfBoundsException("A lista está vazia!");
        } else if (posicao < 0 || posicao >= tamanho()) {
            throw new ArrayIndexOutOfBoundsException("Posição Inválida");
        } else {
            Iterador it = new Iterador(this.inicio);
            int i = 0;
            while (it.hasNext()) {
                if (i != posicao) {
                    it.next();
                    i++;
                } else {
                    break;
                }
            }
            return (T) it.getAtual().getElemento();
        }
    }

    public int tamanho() {;
        return this.tamanho;
    }

    public boolean existeDado() {
        return inicio != null;
    }

    public void limpa() {
        if (!existeDado()) {
            throw new ArrayIndexOutOfBoundsException("A lista está vazia!");
        }
        inicio = fim = null;
        this.tamanho = 0;
    }

    public void remove(int posicao) {
        if (!existeDado()) {
            throw new ArrayIndexOutOfBoundsException("A lista está vazia!");
        } else if (posicao < 0 || posicao > tamanho()) {
            throw new ArrayIndexOutOfBoundsException("Posição Inválida");
        } else {
            if (tamanho() == 1) {
                limpa();
            } else if (posicao >= tamanho() - 1) {
                removeFim();
            } else {
                Iterador it = new Iterador(this.inicio);
                int i = 0;
                while (it.hasNext()) {
                    if (i < posicao - 1) {
                        it.next();
                        i++;
                    } else {
                        Celula removido = it.getAtual().getProximo();
                        it.getAtual().setProximo(removido.getProximo());
                        it.getAtual().getProximo().setAnterior(it.getAtual());
                        removido.setProximo(null);
                        removido.setAnterior(null);
                        this.tamanho -= 1;
                        break;
                    }
                }
            }
        }
    }

    public void removeFim() {
        if (!existeDado()) {
            throw new ArrayIndexOutOfBoundsException("A lista está vazia!");
        } else if (tamanho() == 0) {
            limpa();
        } else {
            Iterador it = new Iterador(this.inicio);
            int i = 1;
            while (it.hasNext()) {
                if (i < tamanho() - 1) {
                    it.next();
                    i++;
                } else {
                    it.getAtual().setProximo(inicio);
                    fim = it.getAtual();
                    inicio.setAnterior(fim);
                    this.tamanho -= 1;
                    break;
                }
            }
        }
    }

    public void removeDuplicado() {
        if (!existeDado()) {
            throw new ArrayIndexOutOfBoundsException("A lista está vazia!");
        } else {
            Iterador iti = new Iterador(this.inicio);
            Iterador itj = new Iterador(this.inicio);
            int i = 0;

            while (iti.hasNext() && i < tamanho()) {
                boolean achou = false;
                int j = 0;
                itj = new Iterador(this.inicio);            
                while (itj.hasNext() && j < tamanho()) {
                    if (((itj.getAtual().getElemento() == iti.getAtual().getElemento()) && i != j)) {
                        remove(j);                   
                        achou = true;
                        break;
                    }
                    itj.next();
                    j++;
                }
                if (achou == false) {
                    iti.next();
                    i++;
                }
            }
        }
    }

}
