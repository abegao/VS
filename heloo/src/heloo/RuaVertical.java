package heloo;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class RuaVertical extends JPanel {
    private int largura;
    private int altura;
    private int ruaX;
    private int ruaY;

    public RuaVertical(int largura, int altura, int ruaX, int ruaY) {
        this.largura = largura;
        this.altura = altura;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, largura, altura);

        g.setColor(Color.YELLOW);
        int ruaX = 450; // Posição x da rua
        int ruaY = 70; // Posição y inicial da rua
        int ruaAltura = altura; // Altura da rua
        int ruaLargura = 20; // Largura da rua
        g.fillRect(ruaX, ruaY, ruaLargura, ruaAltura);
    }

	public void desenhar(Graphics g) {
		// TODO Auto-generated method stub
		 g.setColor(Color.GRAY);
	     g.fillRect(0, 0, largura, altura);
	}
}


