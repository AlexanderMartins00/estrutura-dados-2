
package aula05_08_09_26;


public class arvore {

    no raiz;

    public arvore() {
        this.raiz = null;
    }

    private int getAltura(no no) {
        if (no == null)
            return 0;
        return no.altura;
    }

    private int getMax(int a, int b) {
        if (a > b)
            return a;
        return b;
    }

    private int getBalanceamento(no no) {
        if (no == null)
            return 0;
        return getAltura(no.esquerda) - getAltura(no.direita);
    }
    //y = 3
    //x = 2
    //t2 = null

    private no rotacaoDireita(no y){
        no x =y.esquerda;
        no t2 = x.direita;

        x.direita = y;
        y.esquerda = t2;

        y.altura = getMax(getAltura(y.esquerda), getAltura(y.direita)) + 1;
        x.altura = getMax(getAltura(x.esquerda), getAltura(x.direita)) + 1;

        return x;
    }

    private no rotacaoEsquerda(no x){
        no y =x.direita;
        no t2 = y.esquerda;

        y.esquerda = x;
        x.direita = t2;

        x.altura = getMax(getAltura(x.esquerda), getAltura(x.direita)) + 1;
        y.altura = getMax(getAltura(y.esquerda), getAltura(y.direita)) + 1;

        return y;
    }

    public void inserir(no pai, int valor) {

        if (valor < pai.valor) {
            if(pai.esquerda != null) {
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

        pai.altura = 1 + getMax(getAltura(pai.esquerda), getAltura(pai.direita));

        int balanco = getBalanceamento(pai);

        if(balanco > 1 && valor > pai.esquerda.valor){
            rotacaoDireita(pai);
        }
        if(balanco < -1 && valor > pai.direita.valor){
            rotacaoEsquerda(pai);
        }

        if(balanco > 1 && valor > pai.esquerda.valor){
            pai.esquerda = rotacaoEsquerda(pai.esquerda);
            rotacaoDireita(pai);
        }

        if(balanco < -1 && valor < pai.direita.valor){
            pai.direita = rotacaoDireita(pai.direita);
            rotacaoEsquerda(pai);
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

    public no mostrarValorMinimo(no node) {
        if (node.esquerda != null) {
            mostrarValorMinimo(node.esquerda);
            return node;
        } else {
            return null;
        }
    }

    public void exibir() {
        exibir(this.raiz, 0);
    }

    private void exibir(no no, int espaco) {

        int INCREMENTO = 8;

        if (no == null) {
            return;
        }

        espaco += INCREMENTO;

        // Primeiro o filho da direita (vai aparecer no topo)
        exibir(no.direita, espaco);

        System.out.println();
        imprimirEspacos(espaco - INCREMENTO);
        System.out.println(no.valor);

        // Depois o filho da esquerda (vai aparecer embaixo)
        exibir(no.esquerda, espaco);
    }
     private void imprimirEspacos(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            System.out.print(" ");
        }
    }
}
