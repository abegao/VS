package heloo;

import java.awt.Color;
import java.awt.Graphics;

public class RuaTransversal {
    private int x;
    private int y;
    private int comprimento;
    private int largura;
    private Color cor;

    public RuaTransversal(int x, int y, int comprimento, int largura, Color cor) {
        this.x = x;
        this.y = y;
        this.comprimento = comprimento;
        this.largura = largura;
        this.cor = cor;
    }

    public void desenhar(Graphics g) {
        g.setColor(cor);
        g.fillRect(x, y, comprimento, 50); // Exemplo de dimensões para a rua transversal
    }
}