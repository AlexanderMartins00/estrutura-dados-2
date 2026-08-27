package aula02_18_08_26.src;
import java.util.Scanner;

public class fila {

    static int[] fila = new int[10];
    static int valor;
    static int fim = -1;
    static int inicio = 0;
    static int cont = 0;
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);      

        int opcao = -1;
        System.out.println();

        while(opcao != 0){

            System.out.println("1 - Emfilar");
            System.out.println("2 - enfileirar");
            System.out.println("0 - sair");
            System.out.println("Escolha uma opção");
            opcao = leia.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Informe um valor: ");
                    valor = leia.nextInt();
                    fim = enfileirar(valor);
                    break;
                case 2: 
                    System.out.println("Valor desemfilado: " + desenfileirar());
                    break;

                case 0: 
                    System.out.println("Ate mais!");
                    opcao = 0;
                    break;
            
                default:
                    System.out.println("Opção invalida!");
            }
        }

        System.out.println("Valor fim: " + fila[fim]);

        leia.close();

       
    }

    public static int enfileirar(int valor) {

        if(cont < fila.length){
            fim++;
            if(fim == fila.length){
                fim = 0;
            }
            fila[fim] = valor;
            cont++;
        }

        if (fim < fila.length - 1) {
            fim++;
            fila[fim] = valor;
        }

        return fim;
    }

    public static int desenfileirar(){
        int valor = -1;
       if(cont > 0){
            valor = fila[inicio];
            if(inicio >= fila.length) inicio = 0;

            cont--;
       }
       return valor;
    }
}

