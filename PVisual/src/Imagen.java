import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Imagen extends Figura{
	private Image foto = null;
	
	//Recibe la ruta de la imagen para crear el objeto
	Imagen(String ruta) {
	    super(0, 0, 0, 0);
	    this.foto = (new ImageIcon(getClass().getResource(ruta))).getImage();
	    setAlto(this.foto.getHeight(null));
	    setAncho(this.foto.getWidth(null));
	  }	
	
	//Muestra una imagen
	public void Mostrar(Graphics g) {
		g.drawImage(foto,getX(),getY(),null);
	
	}
	
}
