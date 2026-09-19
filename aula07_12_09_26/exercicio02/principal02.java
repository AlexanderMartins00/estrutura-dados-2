package aula07_12_09_26.exercicio02;

public class principal02 {
    public static void main(String[] args) {
        arvore02 arvore02 = new arvore02();

        int[] arvoreInicial = {7, 5, 3, 25, 10, 8, 20, 50, 30};
        for(int i = 0; i < arvoreInicial.length; i++){
            arvore02.inserir(arvoreInicial[i]);
        }

        int[] elementosInserir = {1, 64, 12, 18, 66, 38, 95, 58, 59, 70, 68, 39, 62, 60,43, 16, 67, 34, 35};
        
        
        for (int i = 0; i < elementosInserir.length; i++) {
            arvore02.inserir(elementosInserir[i]);
        }

        System.out.println("\nEstrutura após inserção:");
        arvore02.exibir();

        System.out.println("\n\nCaminhamento em Ordem:");
        arvore02.emOrdem(arvore02.raiz);
        System.out.println();
       
        int[] elementosRemover = {35, 34, 67, 16, 43, 60, 62, 39, 68, 70, 59, 58, 95, 38, 66, 18, 12, 64, 1};

        for (int i = 0; i < elementosRemover.length; i++) {
            System.out.println("Removendo: " + elementosRemover[i]);
            arvore02.remover(elementosRemover[i]);
        }

        System.out.println("\nEstrutura da Árvore AVL após remoções:");
        arvore02.exibir();

        System.out.println("\n\nCaminhamento em Ordem final:");
        arvore02.emOrdem(arvore02.raiz);
        System.out.println();
    }
}