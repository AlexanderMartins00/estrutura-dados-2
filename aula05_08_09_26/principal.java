
package aula05_08_09_26;

public class principal {
    public static void main(String[] args) {
        arvore arvore = new arvore();

        arvore.raiz = new no(10);

        arvore.inserir(arvore.raiz, 8);
        arvore.inserir(arvore.raiz, 18);
        arvore.inserir(arvore.raiz, 5);
        arvore.inserir(arvore.raiz, 9);
        arvore.inserir(arvore.raiz, 13);
        arvore.inserir(arvore.raiz, 20);
        arvore.inserir(arvore.raiz, 7);

        System.out.println("\nEstrutura da arvore");
        arvore.exibir();

        System.out.println("\nImprimindo em ordem ");
        arvore.emOrdem(arvore.raiz);

        System.out.println("\nImprimindo em pre ordem ");
        arvore.preOrdem(arvore.raiz);

        System.out.println("\nImprimindo em pos ordem ");
        arvore.posOrdem(arvore.raiz);

        System.out.println("\nImprimindo o menor no ");
        arvore.mostrarValorMinimo(arvore.raiz);
    }
}
