import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import javax.swing.SpinnerNumberModel;

public class Juego extends JFrame {

	private JPanel contentPane;
	private VentanaInformacion VentanaInfo = new VentanaInformacion(); 
	public JLabel lblUsuario;
	
	public static int MAXCOMIDAS = 5;
	public static int MAXFANTASMAS = 3;
	private Personaje P = null;
	private Comida [] C = new Comida[MAXCOMIDAS];
	private Fantasma [] F = new Fantasma[MAXFANTASMAS];
	private FinDelJuego GameOver = new FinDelJuego();
	public static JPanel panel;
	private JSpinner spinner;
	public JSpinner spinner_1;
	private JButton btnHiperespacio;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego frame = new Juego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 133, 550, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTrogols = new JLabel("Trogols");
		lblTrogols.setFont(new Font("Dutch801 XBd BT", Font.BOLD, 30));
		lblTrogols.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrogols.setBounds(10, 11, 578, 86);
		contentPane.add(lblTrogols);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(10, 96, 578, 14);
		contentPane.add(lblUsuario);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(598, 86, 196, 234);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDatos = new JLabel("Informacion");
		lblDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatos.setBounds(52, 11, 197, 14);
		panel_1.add(lblDatos);
		
		JLabel lblPuntos = new JLabel("Puntos");
		lblPuntos.setBounds(24, 63, 46, 14);
		panel_1.add(lblPuntos);
		
		JLabel lblEnerga = new JLabel("Energ\u00EDa");
		lblEnerga.setBounds(24, 134, 46, 14);
		panel_1.add(lblEnerga);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(97, 60, 89, 20);
		panel_1.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(100, 0, 100, 1));
		spinner_1.setBounds(97, 131, 89, 20);
		panel_1.add(spinner_1);
		
		JButton btnEmpezar = new JButton("Empezar");
		btnEmpezar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(P==null) {
					start();				
				
				}}});
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEmpezar.setBounds(659, 11, 89, 23);
		contentPane.add(btnEmpezar);
		
		JButton btnInfo = new JButton("Info");
		btnInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaInfo.setVisible(true);
			}
		});
		btnInfo.setBounds(659, 45, 89, 23);
		contentPane.add(btnInfo);
		
		JButton btnArriba = new JButton("Arriba");
		btnArriba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Graphics negro = panel.getGraphics();
				P.Ocultar(negro);
				P.Subir(0);
				P.Mostrar(negro);
				btns(spinner_1, spinner);
				
			}
		});
		btnArriba.setBounds(659, 331, 89, 23);
		contentPane.add(btnArriba);
		
		JButton btnDerecha = new JButton("Derecha");
		btnDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				P.Ocultar(panel.getGraphics());
				P.Derecha(panel.getWidth());
				P.Mostrar(panel.getGraphics());
				btns(spinner_1, spinner);
			}
		});
		btnDerecha.setBounds(705, 365, 89, 23);
		contentPane.add(btnDerecha);
		
		JButton btnIzquierda = new JButton("Izquierda");
		btnIzquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				P.Ocultar(panel.getGraphics());
				P.Izquierda(10);
				P.Mostrar(panel.getGraphics());
				btns(spinner_1, spinner);
				
				
			}
		});
		btnIzquierda.setBounds(606, 365, 89, 23);
		contentPane.add(btnIzquierda);
		
		JButton btnAbajo = new JButton("Abajo");
		btnAbajo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
				P.Ocultar(panel.getGraphics());
				P.Bajar(panel.getHeight());
				P.Mostrar(panel.getGraphics());
				btns(spinner_1, spinner);
			}
		});
		btnAbajo.setBounds(659, 399, 89, 23);
		contentPane.add(btnAbajo);
		
		btnHiperespacio = new JButton("Hiperespacio");
		btnHiperespacio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				P.Ocultar(panel.getGraphics());
				P.ColocarAleatorio(panel.getWidth(), panel.getWidth());
				P.Mostrar(panel.getGraphics());
			}
		});
		btnHiperespacio.setBounds(606, 440, 188, 23);
		contentPane.add(btnHiperespacio);
	}
	
	//METODOS DE JUEGO
	
	//Se ejecuta al darle al botón de EMPEZAR, inicia la comida, el jugador y borra la pantalla de fin del juego
	void start() {
		
		P = new Personaje("Imagenes/monster.jpg");
		P.ColocarAleatorio(panel.getWidth(), panel.getHeight());
		spinner.setValue(0);
		spinner_1.setValue(10);
		setcomidas();
		setfantasmas();
		mostrarcomidas(panel.getGraphics());
		mostrarfantasmas();
		P.Mostrar(panel.getGraphics());

		
	}
	
	//Inicia las 5 comidas
	void setcomidas() {
		for (int i = 0; i < MAXCOMIDAS; i++) {
			C[i] = new Comida("Imagenes/Hamburguesa.jpg");
			C[i].ColocarAleatorio(panel.getWidth(), panel.getHeight());
				if(C[i].getX() == P.getX() && C[i].getY() == P.getY())
					C[i].ColocarAleatorio(panel.getWidth(), panel.getHeight());
	    } 
	  }
	  

	//Enseña las 5 comidas
	void mostrarcomidas(Graphics g) {
	    for (int i = 0; i < MAXCOMIDAS; i++)
	    	C[i].Mostrar(g); 
	  }
	
	//Realiza el metodo escomidalacomida en todo el array COMIDAS
	void versisehacomido(int x, int y) {
		for(int i = 0; i<MAXCOMIDAS; i++) {
			C[i].EsComidaLaComida(x,y);
		}
	}
	
	//devuelve la posición de la comida que se acaba de comer
	 int dondeestalacomidacomida() {
		int coords = MAXCOMIDAS;
		for(int i = 0; i<MAXCOMIDAS; i++)
			if(C[i].getX() == P.getX() && C[i].getY() == P.getY())
				coords = i;
		
		
		return coords;
	}
	
	 //Restaura la comida que acaba de desaparecer
	 void restaurarcomida(int n) {
		 //int i = 0;
		 
		 C[n] = new Comida("Imagenes/Hamburguesa.jpg");
		 C[n].ColocarAleatorio(panel.getWidth(), panel.getHeight());
		 C[n].Mostrar(panel.getGraphics());
	 }
	 
	 //Inicia el array de fantasmas
	 void setfantasmas() {
		 for(int i = 0;i<MAXFANTASMAS; i++) {
			 F[i] = new Fantasma("Imagenes/fantasma.jpg", panel, C, P, spinner_1);
		 	 F[i].ColocarAleatorio(panel.getWidth(), panel.getHeight());
		 }
	 }
	 //Muestra el array de fantasmas
	 void mostrarfantasmas() {
		 for(int i = 0;i<MAXFANTASMAS; i++)	 
			 F[i].Mostrar(panel.getGraphics());
	 }
	 
	//cada vez que se mueve aumenta +1 un punto y resta uno de energía.
	void btns(JSpinner spinnerEnergia, JSpinner spinnerPuntos) {
		spinnerPuntos.setValue((int)spinnerPuntos.getValue() + 1);
		spinnerEnergia.setValue((int)spinnerEnergia.getValue() - 1);
		
		//Comprobar si se está en una casilla de comida y cambiar la comida de sitio
		for(int i = 0; i<MAXCOMIDAS; i++) {
			if(C[i].EsComidaLaComida(P.getX(), P.getY())) {
				C[i].updatecomida(spinnerEnergia);
				C[i].ColocarAleatorio(panel.getWidth(), panel.getHeight());
				C[i].Mostrar(panel.getGraphics());
			}
			
		}
		
		//Comprueba si se ha acabado el juego, puede darse el caso de que te muevas a la posición de un Fantasma y sin este IF no sería detectado
		if((int)spinnerEnergia.getValue() < 1) {
			for(int i = 0; i<MAXCOMIDAS; i++)
				C[i].Ocultar(panel.getGraphics());
			GameOver.setVisible(true);		
		}
		P.Mostrar(panel.getGraphics());
		
	}
}
