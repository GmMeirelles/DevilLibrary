package APS_Simulador.modelo;

//Bibliotecas e outras classes
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

//Classe mainScreen
public class mainScreen extends JPanel implements ActionListener {

    //Variaveis que criam as imagens
    private Image fundo;
    private Player player;
    private Timer timer;

    //Método que coloca o background
    public mainScreen() {
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon referencia = new ImageIcon("src\\res\\background.png");
        fundo = referencia.getImage();

        player = new Player();
        player.load();
        player.pergamine();

        addKeyListener(new TecladoAdapter());

        timer = new Timer(5, this);
        timer.start();
    }

    //Método onde ativamos todas as imagens
    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);

        graficos.drawImage(player.getPerson(), player.getX(), player.getY(), this);

        graficos.drawImage(player.getPergamine(), 0, 0, this);
        graficos.drawImage(player.getManual(), 0, 0, this);

        graficos.drawImage(player.getFogueira(), 40, 380, null);
        player.fogueira();

        g.dispose();
    }

    //Onde  executamos ações com base nas teclas
    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        player.pergamine();
        repaint();
    }

    //Classe onde o movimento do fantasma é executado
    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyRealease(e);
        }

    }
}
