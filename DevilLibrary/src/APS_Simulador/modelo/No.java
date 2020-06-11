//Pacote que os códigos se encontram.
package APS_Simulador.modelo;

//Classe principal No
public class No {

    //Variaveis que fazem o sistema dinâmico funcionar.
    private No proxNo;
    private int dado;

    //Construtor da classe
    public No(int dado) {
        this.dado = dado;
        this.proxNo = null;
    }

    //Métodos get e set
    public void setDado(int dado) {
        this.dado = dado;
    }

    public int getDado() {
        return this.dado;
    }

    public void setProxNo(No proxNo) {
        this.proxNo = proxNo;
    }

    public No getProxNo() {
        return this.proxNo;
    }
}
