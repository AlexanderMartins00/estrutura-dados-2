/* Arvore Binaria */

package aula04_01_09_26;

public class arvore {

    no raiz;

    public arvore() {
        this.raiz = null;
    }

    public void inserir(no pai, int valor) {

        if (valor < pai.valor) {
            if (pai.esquerda != null) {
                inserir(pai.esquerda, valor);
            } else {
                System.out.println("Inserindo " + valor + " a esquerda " + pai.valor);
                pai.esquerda = new no(valor);
            }
        } else if (valor > pai.valor) {
            if (pai.direita != null) {
                inserir(pai.direita, valor);
            } else {
                System.out.println("Inserindo " + valor + " a direita " + pai.valor);
                pai.direita = new no(valor);

            }
        }
    }

    public void emOrdem(no no) {

        if (no != null) {
            emOrdem(no.esquerda);
            System.out.print(no.valor + " - ");
            emOrdem(no.direita);
        }
    }

    public void preOrdem(no no) {

        if (no != null) {
            System.out.print(no.valor + " - ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }

    public void posOrdem(no no) {

        if (no != null) {
            posOrdem(no.esquerda);
            posOrdem(no.direita);
            System.out.print(no.valor + " - ");
        }
    }

    public no mostrarValorMinimo(no node){
        if(node.esquerda != null){
            mostrarValorMinimo(node.esquerda);
            return node;
        }
        else{
            return null;
        }
    }
}
