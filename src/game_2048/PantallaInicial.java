
package game_2048;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PantallaInicial {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicial window = new PantallaInicial();
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
	public PantallaInicial() {
		initialize();


	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("2048"); //Titulo de la ventana
	//	frame.setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaInicial.class.getResource("/game_2048/2048icon.png"))); //Icono
		frame.getContentPane().setBackground(new Color(210, 180, 140));
		frame.setBounds(300, 20, 451, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl2048 = new JLabel("2048"); //Titulo de juego en medio de la pantalla
		lbl2048.setForeground(new Color(255, 255, 255));
		lbl2048.setFont(new Font("Segoe UI Black", Font.PLAIN, 82));
		lbl2048.setBounds(120, 28, 244, 187);
		frame.getContentPane().add(lbl2048);

		JButton botonPlay = new JButton("Play!");
		botonPlay.setForeground(new Color(255, 69, 0));
		botonPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPantallaJuego();
			}
		});
		botonPlay.setFont(new Font("Segoe UI Black", Font.PLAIN, 40));
		botonPlay.setBounds(139, 200, 150, 65);
		frame.getContentPane().add(botonPlay);
		
		botonPlay.setBackground(new Color(192,224,255));
		// llamar a revalidate() y repaint() sino no cambia el color de fondo...
		botonPlay.revalidate();
		botonPlay.repaint();
		
		//agregamos la figura de fondo
		JLabel lblFondo = new JLabel("");
		lblFondo.setForeground(SystemColor.controlHighlight);
		lblFondo.setIcon(new ImageIcon("fondo1.png"));
		lblFondo.setBounds(0, -100, 907, 480);
		frame.getContentPane().add(lblFondo);

	}
	protected void mostrarPantallaJuego() { //Crea la nueva ventana, la hace visible y cierra la primera
		PantallaJuego frame2 = new PantallaJuego();
		frame2.setVisible(true);
		frame.dispose();
	}
	
	
}
