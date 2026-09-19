package aula07_12_09_26;

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

    // Método público de inserção
    public void inserir(int valor) {
        this.raiz = inserir(this.raiz, valor);
    }

    // Método privado recursivo com rebalanceamento AVL
    private no inserir(no pai, int valor) {
        if (pai == null) {
            return new no(valor);
        }

        if (valor < pai.valor) {
            pai.esquerda = inserir(pai.esquerda, valor);
        } else if (valor > pai.valor) {
            pai.direita = inserir(pai.direita, valor);
        } else {
            return pai; // Não permite valores duplicados
        }

        pai.altura = 1 + getMax(getAltura(pai.esquerda), getAltura(pai.direita));

        int balanco = getBalanceamento(pai);

        // Caso Esquerda-Esquerda (Rotacao Simples a Direita)
        if (balanco > 1 && valor < pai.esquerda.valor) {
            return rotacaoDireita(pai);
        }

        // Caso Direita-Direita (Rotacao Simples a Esquerda)
        if (balanco < -1 && valor > pai.direita.valor) {
            return rotacaoEsquerda(pai);
        }

        // Caso Esquerda-Direita (Rotacao Dupla a Direita)
        if (balanco > 1 && valor > pai.esquerda.valor) {
            pai.esquerda = rotacaoEsquerda(pai.esquerda);
            return rotacaoDireita(pai);
        }

        // Caso Direita-Esquerda (Rotacao Dupla a Esquerda)
        if (balanco < -1 && valor < pai.direita.valor) {
            pai.direita = rotacaoDireita(pai.direita);
            return rotacaoEsquerda(pai);
        }

        return pai;
    }

    // Método público de remoção
    public void remover(int valor) {
        this.raiz = remover(this.raiz, valor);
    }

    // Método privado recursivo para remoção na Árvore AVL
    private no remover(no pai, int valor) {
        if (pai == null) {
            return pai;
        }

        if (valor < pai.valor) {
            pai.esquerda = remover(pai.esquerda, valor);
        } else if (valor > pai.valor) {
            pai.direita = remover(pai.direita, valor);
        } else {
            // Nó com um filho ou nenhum
            if ((pai.esquerda == null) || (pai.direita == null)) {
                no temp = (pai.esquerda != null) ? pai.esquerda : pai.direita;

                if (temp == null) { // Sem filhos
                    temp = pai;
                    pai = null;
                } else { // Um filho
                    pai = temp;
                }
            } else {
                // Nó com dois filhos: obtém o menor elemento da subárvore direita
                no temp = obterNoMinimo(pai.direita);
                pai.valor = temp.valor;
                pai.direita = remover(pai.direita, temp.valor);
            }
        }

        if (pai == null) {
            return pai;
        }

        // Atualiza a altura do nó atual
        pai.altura = 1 + getMax(getAltura(pai.esquerda), getAltura(pai.direita));

        int balanco = getBalanceamento(pai);

        // Rebalanceamento pós-remoção
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
        if (no == null) return;

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