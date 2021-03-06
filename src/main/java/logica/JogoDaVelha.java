package logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JogoDaVelha extends JPanel implements MouseListener, KeyListener {
    Font minhaFontGrande = new Font("Arial", Font.BOLD, 120);
    Font minhaFontMedia = new Font("Arial", Font.BOLD, 40);
    Font minhaFontPeq = new Font("Arial", Font.BOLD, 20);

    int matriz[][];
    static int jogador = 1;
    int ganhador = 0;
    private boolean jogarNov = false;

    private int vitoriaP1 =0;
    private int vitoriaP2 = 0;
    private int empates = 0;

    public JogoDaVelha() {
        matriz = new int[3][3];
        imprimirTabuleiro();

    }

    @Override
    protected void paintComponent(Graphics g2) {
        Graphics2D g = (Graphics2D) g2.create();

        if (jogarNov) {
            int jogarNovamente = new JOptionPane().showConfirmDialog(this, "Deseja jogar novamente?");
            if (jogarNovamente == JOptionPane.OK_OPTION) {
                jogarNov = false;
                reiniciarJogo();
            } else {
                System.exit(1);
            }
        }
        g.setFont(minhaFontGrande);

        g.setColor(Color.white);
        g.fillRect(0, 0, 600, 600);

        g.setStroke(new BasicStroke(5));
        g.setColor(Color.black);
        g.drawLine(0, 200, 600, 200);
        g.drawLine(0, 400, 600, 400);

        g.drawLine(200, 0, 200, 600);
        g.drawLine(400, 0, 400, 600);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == 1) {
                    g.drawString("X", 65 + j * 200, 140 + i * 200);
                } else if (matriz[i][j] == 2) {
                    g.drawString("O", 65 + j * 200, 140 + i * 200);
                }
            }
        }

        if (ganhador !=0){
            g.setColor(Color.red);
            g.setFont(minhaFontMedia);
            g.drawString("O jogador " + ganhador + " venceu!!!", 100,190);
            jogarNov = true;
            repaint();
        }



    }

    private void reiniciarJogo() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = 0;
                ganhador = 0;
            }

        }
    }

    private void imprimirTabuleiro() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();

        }
    }


    public void mouseClicked(MouseEvent e) {
        int x = (e.getX() - 8) / 200;
        int y = (e.getY() - 30) / 200;


        System.out.println("X = " + x + " - " + (e.getX() - 8));
        System.out.println("Y = " + y + " - " + (e.getY() - 30));

        if (matriz[y][x] == 0) {
            if (jogador == 1) {
                matriz[y][x] = 1;
                jogador = 2;
            } else {
                matriz[y][x] = 2;
                jogador = 1;
            }
        }

        verificarGanhador();
        repaint();
        imprimirTabuleiro();

    }

    private void verificarGanhador() {

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == matriz[i][1] && matriz[i][0] == matriz[i][2] && matriz[i][0] != 0) {
                System.out.println("Houve um ganhador linha");
                ganhador = matriz[i][0];
                System.out.println("Ganhador é " + ganhador);

            }
        }

            for (int j = 0; j < matriz.length; j++) {
                if (matriz[0][j] == matriz[1][j] && matriz[0][j] == matriz[2][j] && matriz[0][j] != 0) {
                    System.out.println("Houve ganhador coluna");
                    ganhador = matriz[0][j];
                    System.out.println("Ganhador é " + ganhador);
                    break;

                }
            }

            if ((matriz[0][0] == matriz[1][1] && matriz[0][0] == matriz[2][2] && matriz[0][0] != 0)||(matriz[0][2] == matriz[1][1] && matriz[2][0] == matriz[0][2] && matriz[0][2] != 0)){
                System.out.println("Ganhador na diagonal");
                ganhador = matriz[1][1];
                System.out.println("Ganhador é " + ganhador);
            }
            if (ganhador == 1) vitoriaP1++;
            if (ganhador == 2) vitoriaP2++;

        }






    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
