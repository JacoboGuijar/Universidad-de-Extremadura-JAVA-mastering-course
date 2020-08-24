import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblBienvenido;
	private Juego JuegoTrogol = new Juego();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(userpassfilled(textField.getText(), textField_1.getText())) {
					
					JuegoTrogol.lblUsuario.setText(textField.getText());
					JuegoTrogol.setVisible(true);
					
				}
			}});
		btnEntrar.setBounds(170, 179, 89, 23);
		frame.getContentPane().add(btnEntrar);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(47, 139, 63, 14);
		frame.getContentPane().add(lblContrasea);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setBounds(47, 89, 63, 14);
		frame.getContentPane().add(lblUser);
		
		textField = new JTextField();
		textField.setBounds(120, 86, 200, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(120, 136, 200, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblJuegoTrogols = new JLabel("Juego Trogols");
		lblJuegoTrogols.setHorizontalAlignment(SwingConstants.CENTER);
		lblJuegoTrogols.setBounds(120, 11, 200, 44);
		frame.getContentPane().add(lblJuegoTrogols);
		
		JLabel lblJacoboJoseGuijarro = new JLabel("Jacobo Jose Guijarro Villalba");
		lblJacoboJoseGuijarro.setHorizontalAlignment(SwingConstants.CENTER);
		lblJacoboJoseGuijarro.setBounds(120, 66, 200, 14);
		frame.getContentPane().add(lblJacoboJoseGuijarro);
		
		lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setBounds(120, 213, 200, 14);
		frame.getContentPane().add(lblBienvenido);
	}
	
	boolean userpassfilled(String user, String pass) {
		boolean x = false;
		if(user.length()==0 || pass.length()==0)
			lblBienvenido.setText("Usuario o contraseña erróneos");
		
		else {
			lblBienvenido.setText("Bienvenido "+user);
			x =  true;
		}
		return x;
	}
	
}
