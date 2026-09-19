package aula07_12_09_26.exercicio01;

public class principal {
    public static void main(String[] args) {
        arvore arvore = new arvore();

        arvore.inserir(50);

        int[] elementosInserir = {1, 64, 12, 18, 66, 38, 95, 58, 59, 70, 68, 39, 62, 7, 60, 43, 16, 67, 34, 35};
        
        
        for (int i = 0; i < elementosInserir.length; i++) {
            arvore.inserir(elementosInserir[i]);
        }

        System.out.println("\nEstrutura após inserção:");
        arvore.exibir();

        System.out.println("\n\nCaminhamento em Ordem:");
        arvore.emOrdem(arvore.raiz);
        System.out.println();
       
        int[] elementosRemover = {50, 95, 70, 60, 35};

        for (int i = 0; i < elementosRemover.length; i++) {
            System.out.println("Removendo: " + elementosRemover[i]);
            arvore.remover(elementosRemover[i]);
        }

        System.out.println("\nEstrutura da Árvore AVL após remoções:");
        arvore.exibir();

        System.out.println("\n\nCaminhamento em Ordem final:");
        arvore.emOrdem(arvore.raiz);
        System.out.println();
    }
}