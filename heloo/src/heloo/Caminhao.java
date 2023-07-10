package heloo;

import java.awt.*;
import java.awt.Graphics;

public class Caminhao {
    private int x;
    private int y;
    private Color cor;

    public Caminhao(int x, int y, Color cor) {
        this.x = x;
        this.y = y;
        this.cor = cor;
    }

    public void mover(int distancia) {
        x += distancia; // Move o caminhão para a direita pela distância especificada
    }

    public void desenhar(Graphics g) {
        g.setColor(cor);
        g.fillRect(x, y, 80, 40);
    }
}
