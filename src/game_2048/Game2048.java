package game_2048;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Game2048 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game2048 window = new Game2048();
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
	public Game2048() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 521, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTituloPrincipal = new JLabel("Juego 2048");
		lblTituloPrincipal.setForeground(new Color(255, 255, 255));
		lblTituloPrincipal.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
		lblTituloPrincipal.setBounds(18, 10, 181, 43);
		frame.getContentPane().add(lblTituloPrincipal);
		
		//grillado
		JLabel lblCuad1 = new JLabel("2048");
		lblCuad1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuad1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuad1.setForeground(Color.BLACK);
		lblCuad1.setBackground(SystemColor.window);
		lblCuad1.setBounds(135, 111, 53, 43);
		frame.getContentPane().add(lblCuad1);
		
		// Cambiar el color de fondo del JLabel
		lblCuad1.setBackground(Color.white); // Cambia el color aquí
		lblCuad1.setOpaque(true); // Asegura que el JLabel sea opaco
		
		JLabel lblCuad2 = new JLabel("256");
		lblCuad2.setOpaque(true);
		lblCuad2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuad2.setForeground(Color.BLACK);
		lblCuad2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuad2.setBackground(SystemColor.window);
		lblCuad2.setBounds(196, 111, 53, 43);
		frame.getContentPane().add(lblCuad2);
		
		JLabel lblCuad3 = new JLabel("256");
		lblCuad3.setOpaque(true);
		lblCuad3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuad3.setForeground(Color.BLACK);
		lblCuad3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuad3.setBackground(SystemColor.window);
		lblCuad3.setBounds(257, 111, 53, 43);
		frame.getContentPane().add(lblCuad3);
		
		JLabel lblCuad4 = new JLabel("256");
		lblCuad4.setOpaque(true);
		lblCuad4.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuad4.setForeground(Color.BLACK);
		lblCuad4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuad4.setBackground(SystemColor.window);
		lblCuad4.setBounds(318, 111, 53, 43);
		frame.getContentPane().add(lblCuad4);
		
		JLabel lblCuad5 = new JLabel("256");
		lblCuad5.setOpaque(true);
		lblCuad5.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuad5.setForeground(Color.BLACK);
		lblCuad5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuad5.setBackground(SystemColor.window);
		lblCuad5.setBounds(135, 164, 53, 43);
		frame.getContentPane().add(lblCuad5);
		
		JLabel lblCuad6 = new JLabel("256");
		lblCuad6.setOpaque(true);
		lblCuad6.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuad6.setForeground(Color.BLACK);
		lblCuad6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuad6.setBackground(SystemColor.window);
		lblCuad6.setBounds(196, 164, 53, 43);
		frame.getContentPane().add(lblCuad6);
		
		JLabel lblCuad7 = new JLabel("256");
		lblCuad7.setOpaque(true);
		lblCuad7.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuad7.setForeground(Color.BLACK);
		lblCuad7.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuad7.setBackground(SystemColor.window);
		lblCuad7.setBounds(257, 164, 53, 43);
		frame.getContentPane().add(lblCuad7);
		
		JLabel lblCuad8 = new JLabel("256");
		lblCuad8.setOpaque(true);
		lblCuad8.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuad8.setForeground(Color.BLACK);
		lblCuad8.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuad8.setBackground(SystemColor.window);
		lblCuad8.setBounds(318, 164, 53, 43);
		frame.getContentPane().add(lblCuad8);
		
		JLabel lblCuad9 = new JLabel("256");
		lblCuad9.setOpaque(true);
		lblCuad9.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuad9.setForeground(Color.BLACK);
		lblCuad9.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuad9.setBackground(SystemColor.window);
		lblCuad9.setBounds(135, 217, 53, 43);
		frame.getContentPane().add(lblCuad9);
		
		JLabel lblCuad10 = new JLabel("256");
		lblCuad10.setOpaque(true);
		lblCuad10.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuad10.setForeground(Color.BLACK);
		lblCuad10.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuad10.setBackground(SystemColor.window);
		lblCuad10.setBounds(196, 217, 53, 43);
		frame.getContentPane().add(lblCuad10);
		
		JLabel lblCuad11 = new JLabel("256");
		lblCuad11.setOpaque(true);
		lblCuad11.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuad11.setForeground(Color.BLACK);
		lblCuad11.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuad11.setBackground(SystemColor.window);
		lblCuad11.setBounds(257, 217, 53, 43);
		frame.getContentPane().add(lblCuad11);
		
		JLabel lblCuad12 = new JLabel("256");
		lblCuad12.setOpaque(true);
		lblCuad12.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuad12.setForeground(Color.BLACK);
		lblCuad12.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuad12.setBackground(SystemColor.window);
		lblCuad12.setBounds(318, 217, 53, 43);
		frame.getContentPane().add(lblCuad12);
		
		JLabel lblCuad13 = new JLabel("256");
		lblCuad13.setOpaque(true);
		lblCuad13.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuad13.setForeground(Color.BLACK);
		lblCuad13.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuad13.setBackground(SystemColor.window);
		lblCuad13.setBounds(135, 270, 53, 43);
		frame.getContentPane().add(lblCuad13);
		
		JLabel lblCuad14 = new JLabel("256");
		lblCuad14.setOpaque(true);
		lblCuad14.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuad14.setForeground(Color.BLACK);
		lblCuad14.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuad14.setBackground(SystemColor.window);
		lblCuad14.setBounds(196, 270, 53, 43);
		frame.getContentPane().add(lblCuad14);
		
		JLabel lblCuad15 = new JLabel("256");
		lblCuad15.setOpaque(true);
		lblCuad15.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuad15.setForeground(Color.BLACK);
		lblCuad15.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuad15.setBackground(SystemColor.window);
		lblCuad15.setBounds(257, 270, 53, 43);
		frame.getContentPane().add(lblCuad15);
		
		JLabel lblCuad16 = new JLabel("256");
		lblCuad16.setOpaque(true);
		lblCuad16.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuad16.setForeground(Color.BLACK);
		lblCuad16.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuad16.setBackground(SystemColor.window);
		lblCuad16.setBounds(318, 270, 53, 43);
		frame.getContentPane().add(lblCuad16);
		
		JLabel lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setForeground(SystemColor.inactiveCaptionBorder);
		lblPuntaje.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPuntaje.setBounds(301, 10, 70, 30);
		frame.getContentPane().add(lblPuntaje);
		
		JLabel lblPuntajeTotal = new JLabel("");
		lblPuntajeTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPuntajeTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPuntajeTotal.setBounds(367, 10, 75, 25);
		frame.getContentPane().add(lblPuntajeTotal);
		lblPuntajeTotal.setBackground(Color.white); // Cambia el color aquí
		lblPuntajeTotal.setOpaque(true); // Asegura que el JLabel sea opaco
		
		JButton btnNuevoJuego = new JButton("Nuevo Juego");
		btnNuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevoJuego.setBounds(318, 51, 91, 21);
		frame.getContentPane().add(btnNuevoJuego);
		btnNuevoJuego.setBackground(Color.GREEN);
		// Asegúrate de llamar a revalidate() y repaint()
		btnNuevoJuego.revalidate();
		btnNuevoJuego.repaint();
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setForeground(SystemColor.controlHighlight);
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Josy\\Documents\\GitHub\\progra3_2048\\figura2.jpg"));
		lblFondo.setBounds(0, 0, 507, 345);
		frame.getContentPane().add(lblFondo);
	}
}
