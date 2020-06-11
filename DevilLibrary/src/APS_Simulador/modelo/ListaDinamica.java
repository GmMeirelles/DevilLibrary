package APS_Simulador.modelo;

import APS_Simulador.modelo.No;

public class ListaDinamica {

    private No inicio, fim;

    /*Em lista dinamica sempre iniciamos inicio e fim com null*/
    public ListaDinamica() {
        this.fim = null;
        this.inicio = null;
    }

    /*Verifica se a lista está vazia*/
    /*BOA PRATICA > QUANDO CRIAMOS UM MÉTODO BOOLEAN É CONSIDERADO UMA BOA PR
     ATICA COLOCAR "is" ANTES DO NOME DO MÉTODO.
     */
    public boolean isEmpety() {
        return (this.fim == null);
    }

    public void insertAtFront(int dado) {
        No novoNo = new No(dado);

        if (this.isEmpety()) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            novoNo.setProxNo(this.inicio);
            inicio = novoNo;
        }
    }

    public void insertAtBack(int dado) {
        No novoNo = new No(dado);

        if (this.isEmpety()) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            fim.setProxNo(novoNo);
            fim = novoNo;
        }
    }

    public void print() {
        if (this.isEmpety()) {
            System.out.println("Lista vazia");
        } else {
            No auxiliar = inicio;

            while (auxiliar != null) {
                if (auxiliar.getProxNo() == null) {
                    System.out.println(auxiliar.getDado() + ".");
                } else {
                    System.out.print(auxiliar.getDado() + ", ");
                }
                auxiliar = auxiliar.getProxNo();
            }
        }
    }

    public int removeFromFront() {
        if (this.isEmpety()) {
            return 0;
        }

        No auxiliar = this.inicio;

        if (this.inicio == this.fim) {
            this.inicio = null;
            this.fim = null;
        } else {
            this.inicio = this.inicio.getProxNo();
        }
        return auxiliar.getDado();
    }

    public int removeFromBack() {
        if (this.isEmpety()) {
            return 0;
        }

        No auxiliar = this.fim;

        if (this.fim == this.inicio) {
            this.inicio = null;
            this.fim = null;
        } else {
            No atual = this.inicio;
            while (atual.getProxNo() != this.fim) {
                atual = atual.getProxNo();
            }
            this.fim = atual;
            atual.setProxNo(null);
        }
        return auxiliar.getDado();
    }

    public int find(int dado) {
        if (this.isEmpety()) {
            return 0;
        }
        No auxiliar = inicio;
        while (auxiliar != null) {
            if (auxiliar.getDado() == dado) {
                return auxiliar.getDado();
            }
            auxiliar = auxiliar.getProxNo();
        }
        return 0;
    }

    public int remove(int dado) {

        if (this.isEmpety()) {
            return 0;
        }
        No anterior = this.inicio;
        No atual = this.inicio;

        while (atual != null && atual.getDado() != dado) {
            anterior = atual;
            atual = atual.getProxNo();
        }
        if (atual == null) {
            return 0;
        }
        No auxiliar = atual;
        if (atual == this.inicio) {
            return this.removeFromFront();
        } else if (atual == this.fim) {
            return this.removeFromBack();
        } else {
            anterior.setProxNo(atual.getProxNo());
        }
        return auxiliar.getDado();
    }

    public int size() {
        int size = 0;
        if (this.isEmpety()) {
            return -1;
        } else {
            No auxiliar = this.inicio;
            while (auxiliar != null) {
                auxiliar = auxiliar.getProxNo();
                size++;
            }
        }
        return size;
    }
}
