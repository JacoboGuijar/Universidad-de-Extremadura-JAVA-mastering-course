import java.awt.Color;
import java.awt.Graphics;

public class Figura {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	
	public Figura(int x, int y, int alto, int ancho){
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
	}
	//getters y setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	//Oculta una Figura
	public void Ocultar(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(this.x,  this.y , getAncho(), getAlto());
	}

}
