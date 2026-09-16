package aula06_15_09_26;

public class arvoreRedBlack {

    public No raiz;

    private static final int VERMELHO = 1;
    private static final int PRETO = 0;

    public boolean isRed(No no) {
        if (no == null) return false;
        return no.cor == VERMELHO;
    }

    public void insert(int valor) {
        raiz = insert(raiz, valor);
        raiz.cor = PRETO;
    }

    private No insert(No no, int valor) {

        if (no == null) {
            return new No(valor, VERMELHO);
        }

        if (valor < no.valor) {
            no.esquerda = insert(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = insert(no.direita, valor);
        }

        return balancear(no);
    }

    private No balancear(No no) {

        // Caso RR: filho direito vermelho e esquerdo preto -> rotaciona à esquerda
        if (isRed(no.direita) && !isRed(no.esquerda)) {
            no = rotacionarEsquerda(no);
        }

        // Caso LL: filho esquerdo e neto esquerdo vermelhos -> rotaciona à direita
        if (isRed(no.esquerda) && isRed(no.esquerda.esquerda)) {
            no = rotacionarDireita(no);
        }

        // Ambos os filhos vermelhos -> flip de cor
        if (isRed(no.esquerda) && isRed(no.direita)) {
            flipCores(no);
        }

        return no;
    }

    private No rotacionarEsquerda(No no) {
        No filhoDireito = no.direita;
        no.direita = filhoDireito.esquerda;
        filhoDireito.esquerda = no;
        filhoDireito.cor = no.cor;
        no.cor = VERMELHO;
        return filhoDireito;
    }

    private No rotacionarDireita(No no) {
        No filhoEsquerdo = no.esquerda;
        no.esquerda = filhoEsquerdo.direita;
        filhoEsquerdo.direita = no;
        filhoEsquerdo.cor = no.cor;
        no.cor = VERMELHO;
        return filhoEsquerdo;
    }

    private void flipCores(No no) {
        no.cor = 1 - no.cor;
        no.esquerda.cor = 1 - no.esquerda.cor;
        no.direita.cor = 1 - no.direita.cor;
    }

    public void exibir() {
        exibir(this.raiz, 0);
    }

    private void exibir(No no, int espaco) {
        int INCREMENTO = 8;

        if (no == null) {
            return;
        }

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