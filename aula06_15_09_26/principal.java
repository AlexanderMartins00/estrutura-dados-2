package aula06_15_09_26;

public class principal {

    public static void main(String[] args) {
        arvoreRedBlack arvore = new arvoreRedBlack();

        int[] valores = {10, 20, 30, 15, 25, 5, 1};

        for (int i = 0; i < valores.length; i++) {
            System.out.println("Inserindo: " + valores[i]);
            arvore.insert(valores[i]);
        }

        arvore.exibir();
    }
}