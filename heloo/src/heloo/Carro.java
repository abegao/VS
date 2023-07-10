package heloo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Carro {
    private int x;
    private int y;
    private Color cor;
    private Semaphore semaforo;
    private boolean parado;
    private long tempoParado;
    private long tempoParadoLimite;

    public Carro(int x, int y, Color cor, Semaphore semaforo) {
        this.x = x;
        this.y = y;
        this.cor = cor;
        this.semaforo = semaforo;
        this.parado = false;
        this.tempoParadoLimite = TimeUnit.SECONDS.toMillis(2); // Definindo o tempo de parada em segundos
    }

    public void mover(int distancia) {
        try {
            semaforo.acquire(); // Adquire a permissão do semáforo
            if (!parado) {
                x += distancia; // Move o carro para a direita pela distância especificada
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release(); // Libera a permissão do semáforo
        }
    }

    public void desenhar(heloo.Graphics2D g2d) {
        g2d.setColor(cor);
        g2d.fillRect(x, y, 50, 30);
    }

    public void parar() {
        parado = true;
        tempoParado = System.currentTimeMillis();
    }

    public boolean isParado() {
        return parado;
    }

    public boolean tempoParadoExpirou() {
        return System.currentTimeMillis() - tempoParado >= tempoParadoLimite;
    }

    public void reiniciarMovimento() {
        parado = false;
        tempoParado = 0;
    }

    public boolean chegouNoLimite() {
        return x >= 250; // Limite de posição para parar o carro
    }

	public void desenhar(java.awt.Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(cor);
        g.fillRect(x, y, 50, 30);
	}
}
