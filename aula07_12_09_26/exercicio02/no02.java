package aula07_12_09_26.exercicio02;

public class no02 {
    int valor;
    int altura;
    no02 esquerda;
    no02 direita;

    public no02(int valor) {
        this.valor = valor;
        this.altura = 1;
        this.esquerda = null;
        this.direita = null;
    }
}