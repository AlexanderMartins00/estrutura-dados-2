package aula07_12_09_26.exercicio01;

public class arvore {

    public no raiz;

    public arvore() {
        this.raiz = null;
    }

    private int getAltura(no no) {
        if (no == null)
            return 0;
        return no.altura;
    }

    private int getMax(int a, int b) {
        return (a > b) ? a : b;
    }

    private int getBalanceamento(no no) {
        if (no == null)
            return 0;
        return getAltura(no.esquerda) - getAltura(no.direita);
    }

    private no rotacaoDireita(no y) {
        no x = y.esquerda;
        no t2 = x.direita;

        x.direita = y;
        y.esquerda = t2;

        y.altura = getMax(getAltura(y.esquerda), getAltura(y.direita)) + 1;
        x.altura = getMax(getAltura(x.esquerda), getAltura(x.direita)) + 1;

        return x;
    }

    private no rotacaoEsquerda(no x) {
        no y = x.direita;
        no t2 = y.esquerda;

        y.esquerda = x;
        x.direita = t2;

        x.altura = getMax(getAltura(x.esquerda), getAltura(x.direita)) + 1;
        y.altura = getMax(getAltura(y.esquerda), getAltura(y.direita)) + 1;

        return y;
    }

    public void inserir(int valor) {
        this.raiz = inserir(this.raiz, valor);
    }

    private no inserir(no pai, int valor) {
        if (pai == null) {
            return new no(valor);
        }

        if (valor < pai.valor) {
            pai.esquerda = inserir(pai.esquerda, valor);
        } else if (valor > pai.valor) {
            pai.direita = inserir(pai.direita, valor);
        } else {
            return pai;
        }

        pai.altura = 1 + getMax(getAltura(pai.esquerda), getAltura(pai.direita));

        int balanco = getBalanceamento(pai);

        if (balanco > 1 && valor < pai.esquerda.valor) {
            return rotacaoDireita(pai);
        }

        if (balanco < -1 && valor > pai.direita.valor) {
            return rotacaoEsquerda(pai);
        }

        if (balanco > 1 && valor > pai.esquerda.valor) {
            pai.esquerda = rotacaoEsquerda(pai.esquerda);
            return rotacaoDireita(pai);
        }

        if (balanco < -1 && valor < pai.direita.valor) {
            pai.direita = rotacaoDireita(pai.direita);
            return rotacaoEsquerda(pai);
        }

        return pai;
    }

    public void remover(int valor) {
        this.raiz = remover(this.raiz, valor);
    }

    private no remover(no pai, int valor) {
        if (pai == null) {
            return pai;
        }

        if (valor < pai.valor) {
            pai.esquerda = remover(pai.esquerda, valor);
        } else if (valor > pai.valor) {
            pai.direita = remover(pai.direita, valor);
        } else {

            if ((pai.esquerda == null) || (pai.direita == null)) {
                no temp = (pai.esquerda != null) ? pai.esquerda : pai.direita;

                if (temp == null) {
                    temp = pai;
                    pai = null;
                } else {
                    pai = temp;
                }
            } else {

                no temp = obterNoMinimo(pai.direita);
                pai.valor = temp.valor;
                pai.direita = remover(pai.direita, temp.valor);
            }
        }

        if (pai == null) {
            return pai;
        }

        pai.altura = 1 + getMax(getAltura(pai.esquerda), getAltura(pai.direita));

        int balanco = getBalanceamento(pai);

        if (balanco > 1 && getBalanceamento(pai.esquerda) >= 0) {
            return rotacaoDireita(pai);
        }

        if (balanco > 1 && getBalanceamento(pai.esquerda) < 0) {
            pai.esquerda = rotacaoEsquerda(pai.esquerda);
            return rotacaoDireita(pai);
        }

        if (balanco < -1 && getBalanceamento(pai.direita) <= 0) {
            return rotacaoEsquerda(pai);
        }

        if (balanco < -1 && getBalanceamento(pai.direita) > 0) {
            pai.direita = rotacaoDireita(pai.direita);
            return rotacaoEsquerda(pai);
        }

        return pai;
    }

    private no obterNoMinimo(no node) {
        no atual = node;
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }

    public void emOrdem(no no) {
        if (no != null) {
            emOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdem(no.direita);
        }
    }

    public void exibir() {
        exibir(this.raiz, 0);
    }

    private void exibir(no no, int espaco) {
        int INCREMENTO = 8;
        if (no == null)
            return;

        espaco += INCREMENTO;
        exibir(no.direita, espaco);

        System.out.println();
        imprimirEspacos(espaco - INCREMENTO);
        System.out.println(no.valor);

        exibir(no.esquerda, espaco);
    }

    private void imprimirEspacos(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            System.out.print(" ");
        }
    }
}