import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class VentanaInformacion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInformacion frame = new VentanaInformacion();
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
	public VentanaInformacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformacin = new JLabel("Informaci\u00F3n");
		lblInformacin.setBounds(5, 5, 356, 22);
		lblInformacin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInformacin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblInformacin);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setHorizontalAlignment(SwingConstants.LEFT);
		lblAutor.setBounds(25, 74, 57, 22);
		contentPane.add(lblAutor);
		
		JLabel lblJacoboJosGuijarro = new JLabel("Jacobo Jos\u00E9 Guijarro Villalba");
		lblJacoboJosGuijarro.setBounds(112, 78, 230, 14);
		contentPane.add(lblJacoboJosGuijarro);
		
		JLabel lblVersin = new JLabel("Versi\u00F3n:");
		lblVersin.setHorizontalAlignment(SwingConstants.LEFT);
		lblVersin.setBounds(25, 107, 57, 14);
		contentPane.add(lblVersin);
		
		JLabel lblPrealfa = new JLabel("Pre-alfa 0.0.0.0");
		lblPrealfa.setBounds(107, 107, 230, 14);
		contentPane.add(lblPrealfa);
		
		JTextArea txtrPrcticaTrogolsDesarrollada = new JTextArea();
		txtrPrcticaTrogolsDesarrollada.setBackground(UIManager.getColor("Button.background"));
		txtrPrcticaTrogolsDesarrollada.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrPrcticaTrogolsDesarrollada.setText("Pr\u00E1ctica TROGOLS desarrollada para el curso de perfeccionamiento \r\nJAVA, impartido en la Universidad de Extremadura");
		txtrPrcticaTrogolsDesarrollada.setBounds(25, 132, 382, 32);
		contentPane.add(txtrPrcticaTrogolsDesarrollada);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(22, 224, 72, 14);
		contentPane.add(lblFecha);
		
		JLabel lblFebrerojunio = new JLabel("Febrero - Junio 2020");
		lblFebrerojunio.setBounds(112, 224, 236, 14);
		contentPane.add(lblFebrerojunio);
	}
}
