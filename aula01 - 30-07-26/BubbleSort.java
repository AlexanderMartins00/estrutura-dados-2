import java.util.concurrent.ThreadLocalRandom;

public class BubbleSort {
     public static void main(String[] args) {
        int[] vetor = new int [1000];        
        long startTime;
        long endTime;
        long duration;
        for(int cont = 0; cont < vetor.length; cont++){
            vetor[cont] = ThreadLocalRandom.current().nextInt(1, 10);
        }
        startTime = System.nanoTime();
        for(int cont = 0; cont < vetor.length - 1 ; cont++){
            for(int cont2 = 0; cont2 < vetor.length - 1 ; cont2++){
                if(vetor[cont2] > vetor[cont2 + 1]){
                    int aux = vetor[cont2];
                    vetor[cont2] = vetor[cont2 + 1];
                    vetor[cont2 + 1] = aux;
                }
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime); // Tempo em nanossegundos           
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime); // Tempo em nanossegundos
         System.out.println("\nTempo: " + (duration / 1000000.0) + " ms");
    }
    
}
