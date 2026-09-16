package aula06_15_09_26;

public class No {

    public int valor;
    public No esquerda;
    public No direita;
    public int cor; // 0 - preto, 1 - vermelho

    public No(int valor, int cor){
        this.valor = valor;
        this.cor = cor;
    }

}
