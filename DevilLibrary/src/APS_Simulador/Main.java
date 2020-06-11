package APS_Simulador;

import APS_Simulador.modelo.Fila;
import APS_Simulador.modelo.ListaDinamica;
import APS_Simulador.modelo.Player;
import APS_Simulador.modelo.mainScreen;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;

/**
 *
 * @author Matheus Meirelles da Silva
 */
public class Main extends JFrame {

    //Construtor Main
    public Main() {

        add(new mainScreen());

        setTitle("Biblioteca Infinita");
        setSize(960, 501);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {

        //Onde executamos e tudo começa a rodar
        new Main();

    }
}
