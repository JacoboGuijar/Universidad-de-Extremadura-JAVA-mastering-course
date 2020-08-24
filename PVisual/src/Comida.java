import java.util.Random;

import javax.swing.JSpinner;

public class Comida extends Personaje{
	Comida(String ruta) {
		super(ruta);
	}

	//Comprueba si el personaje ha caido en una casilla donde haya comida
	public boolean EsComidaLaComida(int xTrogol, int yTrogol) {
		boolean esComida = false;
		
		if(xTrogol==getX() && yTrogol==getY()) 
			esComida = true;						
		return esComida;
	}
	
	//Genera un valor entre 1-10 y se suma a la energía al pisar una comida
	public void updatecomida(JSpinner spinner) {
		Random r = new Random();
		int energia = r.nextInt(10);
		
		spinner.setValue((int)spinner.getValue() + energia);
	}
}
