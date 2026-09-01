package aula03_25_08_26;

public class arvoreGenerica {

    no raiz;

    public arvoreGenerica(int valorRaiz) {
        this.raiz = new no(valorRaiz);
    }

    public no adicionarFilho(no pai, int valorFilho) {
        no novoFilho = new no(valorFilho);
        pai.filhos.add(novoFilho);
        return novoFilho;
    }

    // Começa na raiz
    public void exibir() {
        exibir(this.raiz, 0);
    }

    // Metodo exibir
    private void exibir(no atual, int nivel) {

        // imprimir quantidade de espaços de acordo com o nivel
        for (int i = 0; i < nivel; i++) {
            System.out.print("   ");
        }

        if (nivel == 0) {
            System.out.println("\n  0  1° 2° 3°\n");
            System.out.println(" [" + atual.valor + "] ");
        } else {
            System.out.println(" [" + atual.valor + "] ");
        }

        for (int i = 0; i < atual.filhos.size(); i++) {
            no filho = atual.filhos.get(i);
            exibir(filho, nivel + 1);
        }
    }
}