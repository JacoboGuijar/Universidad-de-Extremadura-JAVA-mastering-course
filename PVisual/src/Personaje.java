import java.util.Random;

public class Personaje extends Imagen{
	Personaje(String ruta) {
		super(ruta);
	}
	
	
	//Coloca a la imagen en una posición aleatoria
	public void ColocarAleatorio(int panelanch, int panelalt){
		int numCol,numFil,x,y;
        Random numero;
           
        numCol=panelanch/getAncho();     // calcula el número de columnas
        numFil=panelalt/getAlto();               // calcula el número de filas
       
        numero=new Random();
        x=numero.nextInt(numCol);            // columna aleatoria
        y=numero.nextInt(numFil);              // fila aleatoria
       
        setX(x*getAncho());			// coloca la imagen en la columna aleatoria
        setY(y*getAlto()); 			// coloca la imagen en la fila aleatoria
 
	}
	
	//Los distintos movimientos, funcionan con coordenadas absolutas
	public void Subir(int min)
    {
		
        if(getY()>min) 
        	setY(getY()-getAlto());      
    }
   
    public void Bajar(int max)
    {

        if(getY()+getAlto()<max)
        	setY(getY()+getAlto());
    }
   
    public void Izquierda(int min)
    {

        if(getX()>min)
        	setX(getX()-getAncho());
    }
   
    public void Derecha(int max)
    {
        
    	if(getX()+getAncho()<max)
    		setX(getX()+getAncho());
    }
    
    
}
