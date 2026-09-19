package aula07_12_09_26.exercicio02;

public class arvore02 {

    public no02 raiz;

    public arvore02() {
        this.raiz = null;
    }

    private int getAltura(no02 no02) {
        if (no02 == null)
            return 0;
        return no02.altura;
    }

    private int getMax(int a, int b) {
        return (a > b) ? a : b;
    }

    private int getBalanceamento(no02 no02) {
        if (no02 == null)
            return 0;
        return getAltura(no02.esquerda) - getAltura(no02.direita);
    }

    private no02 rotacaoDireita(no02 y) {
        no02 x = y.esquerda;
        no02 t2 = x.direita;

        x.direita = y;
        y.esquerda = t2;

        y.altura = getMax(getAltura(y.esquerda), getAltura(y.direita)) + 1;
        x.altura = getMax(getAltura(x.esquerda), getAltura(x.direita)) + 1;

        return x;
    }

    private no02 rotacaoEsquerda(no02 x) {
        no02 y = x.direita;
        no02 t2 = y.esquerda;

        y.esquerda = x;
        x.direita = t2;

        x.altura = getMax(getAltura(x.esquerda), getAltura(x.direita)) + 1;
        y.altura = getMax(getAltura(y.esquerda), getAltura(y.direita)) + 1;

        return y;
    }

    public void inserir(int valor) {
        this.raiz = inserir(this.raiz, valor);
    }

    private no02 inserir(no02 pai, int valor) {
        if (pai == null) {
            return new no02(valor);
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

    private no02 remover(no02 pai, int valor) {
        if (pai == null) {
            return pai;
        }

        if (valor < pai.valor) {
            pai.esquerda = remover(pai.esquerda, valor);
        } else if (valor > pai.valor) {
            pai.direita = remover(pai.direita, valor);
        } else {

            if ((pai.esquerda == null) || (pai.direita == null)) {
                no02 temp = (pai.esquerda != null) ? pai.esquerda : pai.direita;

                if (temp == null) {
                    temp = pai;
                    pai = null;
                } else {
                    pai = temp;
                }
            } else {

                no02 temp = obterno02Minimo(pai.direita);
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

    private no02 obterno02Minimo(no02 no02de) {
        no02 atual = no02de;
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }

    public void emOrdem(no02 no02) {
        if (no02 != null) {
            emOrdem(no02.esquerda);
            System.out.print(no02.valor + " ");
            emOrdem(no02.direita);
        }
    }

    public void exibir() {
        exibir(this.raiz, 0);
    }

    private void exibir(no02 no02, int espaco) {
        int INCREMENTO = 8;
        if (no02 == null)
            return;

        espaco += INCREMENTO;
        exibir(no02.direita, espaco);

        System.out.println();
        imprimirEspacos(espaco - INCREMENTO);
        System.out.println(no02.valor);

        exibir(no02.esquerda, espaco);
    }

    private void imprimirEspacos(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            System.out.print(" ");
        }
    }
}