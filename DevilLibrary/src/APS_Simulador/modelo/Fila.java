package APS_Simulador.modelo;

public class Fila {

    private int[] vetorFila;
    private int fim = -1;

    public Fila(int maxSize) {
        vetorFila = new int[maxSize];
        fim = -1;
    }

    public boolean isFull() {
        return (fim == vetorFila.length - 1);
    }

    public void enqueue(int dado) {
        if (!isFull()) {
            fim++;
            vetorFila[fim] = dado;
        }
    }

    public void display() {
        System.out.println("**** Imprimindo a fila ****");
        for (int i = 0; i <= fim; i++) {
            System.out.print(vetorFila[i] + " ");
        }
        System.out.println("\n************");
    }

    public boolean isEmpty() {
        return (fim == -1);
    }

    public int dequeue() {
        int elemento;
        if (!isEmpty()) {
            elemento = vetorFila[0];
            for (int i = 0; i < fim; i++) {
                vetorFila[i] = vetorFila[i + 1];
            }
            fim--;
            return elemento;
        } else {
            return -1;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return vetorFila[0];
        } else {
            return -1;
        }
    }

    public int size() {
        int queueSize = 0;
        for (int i = 0; i <= fim; i++) {
            queueSize++;
        }
        return queueSize;
    }
}
