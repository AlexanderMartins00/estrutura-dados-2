package aula03_25_08_26;

public class principal {
    public static void main(String[] args) {
        arvoreGenerica arvore = new arvoreGenerica(1);

        no filho2 = arvore.adicionarFilho(arvore.raiz, 2);
        no filho3 = arvore.adicionarFilho(arvore.raiz, 3);
        no filho4 = arvore.adicionarFilho(arvore.raiz, 4);
        no filho5 = arvore.adicionarFilho(filho3, 5);
        no filho6 = arvore.adicionarFilho(filho2, 6);
        no filho7 = arvore.adicionarFilho(filho4, 7);
        no filho8 = arvore.adicionarFilho(filho2, 8);
        no filho9 = arvore.adicionarFilho(filho5, 9);
        arvore.exibir();
    }
}
