import java.util.Scanner;

public class pilha {

    static int[] pilha = new int[10];
    static int valor;
    static int topo = -1;
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);      

        int opcao = -1;
        System.out.println();

        while(opcao != 0){

            System.out.println("1 - Empilhar");
            System.out.println("2 - Desempilhar");
            System.out.println("0 - sair");
            System.out.println("Escolha uma opção");
            opcao = leia.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Informe um valor: ");
                    valor = leia.nextInt();
                    topo = empilhar(valor);
                    break;
                case 2: 
                    System.out.println("Valor desempilhado: " + desempilhar());
                    break;

                case 0: 
                    System.out.println("Ate mais!");
                    opcao = 0;
                    break;
            
                default:
                    System.out.println("Opção invalida!");
            }
        }

        System.out.println("Valor topo: " + pilha[topo]);

        leia.close();

        System.out.println("Valor: " + pilha[0]);
        System.out.println("Valor: " + pilha[1]);

        
        System.out.println("Valor desempilhado: " + desempilhar());
    }

    public static int empilhar(int valor) {

        if (topo < pilha.length - 1) {
            topo++;
            pilha[topo] = valor;
        }

        return topo;
    }

    public static int desempilhar(){
        int valor = -1;
        if(topo >=0){
            valor = pilha[topo];
            topo--;           
        }
        return valor;
    }
}

