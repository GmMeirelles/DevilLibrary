package APS_Simulador.modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import APS_Simulador.modelo.Fila;
import APS_Simulador.modelo.ListaDinamica;

//Classe jogador
public class Player {

    //Estanciando lista dinâmica e fila estática
    ListaDinamica lista = new ListaDinamica();
    Fila fila = new Fila(1000);

    //Definindo váriaveis que são usadas para montar as imagens, definir tamanho e etc.
    String playerSprint = "src\\res\\playerL.png", pergamineImage = "", fire = "src\\res\\fogueira.png", manualImage = "";
    private int x, y, dx, dy, height, width, widthPergamine, heightPergamine, widthFogueira, heightFogueira, heightManual, widthManual, verif;
    private Image person, perga, fogue, manu;

    //Construtor, onde definimos as cordenadas iniciais do jogador
    public Player() {
        this.x = 350;
        this.y = 310;
    }

    //Método que cria o sprint do fantasma 
    public void load() {
        ImageIcon referencia = new ImageIcon(playerSprint);
        person = referencia.getImage();

        height = person.getHeight(null);
        width = person.getWidth(null);
    }

    //Método que cria o pergaminho
    public void pergamine() {
        ImageIcon pergamine = new ImageIcon(pergamineImage);
        perga = pergamine.getImage();

        heightPergamine = perga.getHeight(null);
        widthPergamine = perga.getWidth(null);
    }

    //Método que cria manual do demonio
    public void manualD() {
        ImageIcon manualD = new ImageIcon(manualImage);
        manu = manualD.getImage();

        heightManual = manu.getHeight(null);
        widthManual = manu.getWidth(null);
    }

    //Método que cria a fogueira
    public void fogueira() {
        ImageIcon fogueira = new ImageIcon(fire);
        fogue = fogueira.getImage();

        heightFogueira = fogue.getHeight(null);
        widthFogueira = fogue.getWidth(null);
    }

    //Método que da o update da posição do sprint do fantasma 
    public void update() {
        x += dx;
        y += dy;
    }

    //Onde é mapeado as teclas que possuem ações
    public void keyPressed(KeyEvent tecla) {
        int code = tecla.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            playerSprint = "src\\res\\playerL.png";
            this.load();

            dx = -3;
            verif = 0;
        }
        if (code == KeyEvent.VK_RIGHT) {
            playerSprint = "src\\res\\playerR.png";
            this.load();

            dx = 3;
            verif = 0;
        }
        if (code == KeyEvent.VK_UP) {
            dy = -3;
            verif = 0;
        }
        if (code == KeyEvent.VK_DOWN) {
            dy = 3;
            verif = 0;

        }
        if (code == KeyEvent.VK_I) {
            pergamineImage = "src\\res\\pergamine.png";
            fire = "";
            this.pergamine();

            verif = 0;

        }

        if (code == KeyEvent.VK_D) {
            manualImage = "src\\res\\manualD.png";
            fire = "";
            this.manualD();

            verif = 0;

        }

        if (code == KeyEvent.VK_ESCAPE) {
            pergamineImage = "";
            manualImage = "";
            fire = "src\\res\\fogueira.png";
            this.pergamine();
            this.manualD();

            verif = 0;
        }
        if (code == KeyEvent.VK_X) {

            System.out.println("FILA REABASTECIDA, QUE A TORTURA RECOMECE.");
            for (int x = 1; x <= 1001; x++) {
                fila.enqueue(x);
            }

        }
        if (code == KeyEvent.VK_SPACE) {
            playerSprint = "src\\res\\playerL_WithBooks.png";
            this.load();

            if (x < 128) {
                while (x <= 128) {
                    dx = 3;
                    x++;
                }
            } else if (x > 128) {
                while (x >= 128) {
                    dx = -3;
                    x--;
                }
            }
            if (y < 310) {
                while (y <= 310) {
                    dy = 3;
                    y++;
                }
            } else if (y > 310) {
                while (y >= 310) {
                    dy = -3;
                    y--;
                }
            }

            //Parando a sprint do fantasma depois de uma ação feita
            dx = 0;
            dy = 0;

            //Adicionando na lista e desenfilerando da fila
            lista.insertAtBack(fila.dequeue());
            System.out.println("Tamanho da fila: " + fila.size());
            System.out.println("Tamanho da lista: " + lista.size());
            fila.display();
        }
    }

    //Default values das teclas
    public void keyRealease(KeyEvent tecla) {
        int code = tecla.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (code == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
        if (code == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (code == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getPerson() {
        return person;
    }

    public Image getPergamine() {
        return perga;
    }

    public Image getManual() {
        return manu;
    }

    public Image getFogueira() {
        return fogue;
    }

    public int getVerif() {
        return verif;
    }
}
