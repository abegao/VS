package heloo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de Pista");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Pista pista = new Pista(1800,200);
        
        Semaphore semaforo = new Semaphore(1);

        RuaTransversal ruaTransversal = new RuaTransversal(0,400,1880,900, Color.GRAY);
        pista.addRuaTransversal(ruaTransversal); // Adiciona a rua transversal à pista

        Carro carro = new Carro(50, 100, Color.RED, semaforo); // Exemplo de carro vermelho
        pista.addCarro(carro); // Adiciona o carro à pista
        
        Carro carro2 = new Carro(50, 150, Color.BLUE, semaforo); // Exemplo de carro azul
        pista.addCarro(carro2); // Adiciona o carro à pista

        
        Caminhao caminhao = new Caminhao(50, 400, Color.BLUE); // Exemplo de caminhão azul
        pista.addCaminhao(caminhao); // Adiciona o caminhão à pista
        
        RuaVertical ruaVertical = new RuaVertical(50,900,50,70);
        pista.ruaVertical(ruaVertical);

        frame.getContentPane().add(ruaVertical);

        frame.add(pista);
        frame.pack();
        frame.setVisible(true);

        // Loop de atualização contínua
        while (true) {
            pista.atualizarPosicaoCarro(); // Atualiza a posição do carro
            pista.repaint(); // Redesenha a pista para atualizar a posição do carro

            try {
                Thread.sleep(100); // Aguarda 100 milissegundos antes de atualizar novamente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
