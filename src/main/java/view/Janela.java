package view;

import logica.JogoDaVelha;

import javax.swing.*;

public class Janela {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JogoDaVelha tabuleiro = new JogoDaVelha();
        tabuleiro.setBounds(0,0,600,600);
        frame.add(tabuleiro);

        frame.addMouseListener(tabuleiro);
    }
}
