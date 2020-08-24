import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class Fantasma extends Personaje implements Runnable{
	private FinDelJuego GameOver = new FinDelJuego();

	Comida [] C = new Comida[Juego.MAXCOMIDAS];
	private Personaje P = null;
	private JPanel J = null;
	private Thread Hilo = null;
	private JSpinner S;
	private Random r  = null;
	Fantasma(String ruta, JPanel J, Comida C[], Personaje P, JSpinner S) {
		super(ruta);
		this.J = J;
		this.C = C;
		this.P = P;
		this.S = S;
		if(Hilo == null) {
			this.Hilo = new Thread(this);
			Hilo.start();
		}
		if (r == null)
			r = new Random();
	}

	@Override
	public void run() {
		boolean play = true;
		
		while(play) {
			movimiento();
			
			if((int)S.getValue() == 0) {
				GameOver.setVisible(true);
				play=false;		//Si se pierde se detienen los fantasmas.
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//getters y setters
	public Comida[] getC() {
		return C;
	}

	public void setC(Comida[] c) {
		C = c;
	}

	public Personaje getP() {
		return P;
	}

	public void setP(Personaje p) {
		P = p;
	}
	
	void movimiento() {
	
		int movimiento;
		
		movimiento = r.nextInt(4);
		Ocultar(J.getGraphics());
		
		if (haytrogol() == true)
			S.setValue(0);
		
		//Volvemos a mostrar la comida
		for (int i = 0; i<Juego.MAXCOMIDAS; i++)
			C[i].Mostrar(J.getGraphics());
		
		//0,1,2,3,arriba,bajo,izquierda,derecha
		if(movimiento==0)
			Subir(0);
		else if(movimiento == 1)
			Bajar(J.getHeight());
		else if(movimiento == 2)
			Izquierda(10);
		else if(movimiento == 3)
			Derecha(J.getWidth());
		
		Mostrar(J.getGraphics());
		
		if(haytrogol() == true)
			S.setValue(0);
	}
	

	//Comprobar si en la casilla del fantasma está el personaje
	boolean haytrogol() {
		boolean trogol = false;
		
		if(P.getX() == getX() && P.getY() == getY())
			trogol = true;
		return trogol;
	}
}
