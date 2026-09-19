package aula07_12_09_26;

public class no {
    int valor;
    int altura;
    no esquerda;
    no direita;

    public no(int valor) {
        this.valor = valor;
        this.altura = 1;
        this.esquerda = null;
        this.direita = null;
    }
}