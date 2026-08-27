package aula03_25_08_26;

public class arvoreGenerica {
    
    no raiz;

    public arvoreGenerica(int valorRaiz){
        this.raiz = new no(valorRaiz);
    }   

    public no adicionarFilho(no pai, int valorFilho){
        no novoFilho = new no(valorFilho);
        pai.filhos.add(novoFilho);
        return novoFilho;
        
        
    }
}
