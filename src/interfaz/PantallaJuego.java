package interfaz;

import negocio.Juego;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.border.MatteBorder;
import javax.swing.JTextField;

public class PantallaJuego extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Juego juego = new Juego();
	private JButton[][] botones;
	private JPanel panelTablero;
	private JTextField textPuntajeActual;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaJuego window = new PantallaJuego();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PantallaJuego() {
		initialize();
		setResizable(false); // Para que no se redimencione el alto y ancho
	}

	private void initialize() {

		// Configuraciones de la ventana

		setTitle("2048");
		setBounds(300, 20, 602, 530);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(224, 255, 255));

		getContentPane().setLayout(null);

		panelTablero = new JPanel();
		panelTablero.setBackground(new Color(176, 224, 230));
		panelTablero.setBounds(88, 82, 414, 337);
		getContentPane().add(panelTablero);
		panelTablero.setLayout(new GridLayout(4, 4));
		
	    // Mantiene el foco siempre en panelTablero
	    panelTablero.addFocusListener(new FocusAdapter() {
	        @Override
	        public void focusLost(FocusEvent e) {
	            panelTablero.requestFocusInWindow(); // Solicitar el foco nuevamente si se pierde
	        }
	    });
		

		// Crea y posiciona los botones del tablero 4x4
		botones = new JButton[4][4];
		for (int fila = 0; fila < 4; fila++) {
			for (int columna = 0; columna < 4; columna++) {
				botones[fila][columna] = new JButton();
				botones[fila][columna].setBackground(new Color(210, 180, 140));
				botones[fila][columna].setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
				panelTablero.add(botones[fila][columna]);
				//botones[fila][columna].setEnabled(false); // Deshabilita boton
			}
		}

		// Título "2048"
		JLabel lbl2048 = new JLabel("2048");
		lbl2048.setIcon(new ImageIcon("2048_log.png"));
		lbl2048.setForeground(new Color(210, 180, 140));
		lbl2048.setFont(new Font("Segoe UI Black", Font.PLAIN, 43));
		lbl2048.setBounds(56, 15, 175, 48);
		getContentPane().add(lbl2048);

		// Puntaje
		JLabel lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setForeground(Color.CYAN);
		lblPuntaje.setFont(new Font("Segoe UI Black", Font.BOLD, 22));
		lblPuntaje.setBounds(306, 31, 114, 33);
		getContentPane().add(lblPuntaje);

		textPuntajeActual = new JTextField();
		textPuntajeActual.setEditable(false);
		textPuntajeActual.setHorizontalAlignment(SwingConstants.CENTER);
		textPuntajeActual.setBackground(new Color(255, 248, 220));
		textPuntajeActual.setForeground(new Color(153, 50, 204));
		textPuntajeActual.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		textPuntajeActual.setBounds(409, 33, 114, 32);
		getContentPane().add(textPuntajeActual);
		textPuntajeActual.setColumns(10);

		// Fondo
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("figura3.png"));
		lblFondo.setBounds(0, 0, 588, 493);
		getContentPane().add(lblFondo);

		addKeyListener(this); // escucha eventos de teclado
		setFocusable(true); // recibe los eventos, la ventana es el foco
		setFocusTraversalKeysEnabled(false); // desactiva teclas que me puedan cambiar que el foco de la ventana
		


		actualizarTablero();

	}

	// Nexo entre logica e interfaz
	private void actualizarTablero() { // Actualizo el tablero con metodo que busca los valores que hay en cada celda.
										// Me los traigo de la logica
		int[][] matriz = juego.obtenerMatriz();
		for (int fila = 0; fila < 4; fila++) {
			for (int columna = 0; columna < 4; columna++) {
				int valor = matriz[fila][columna];
				botones[fila][columna].setText(valor == 0 ? "" : String.valueOf(valor)); // muestra el nro unicamente si
																							// es distinto de 0

				// Cambiar el color según el valor usando el metodo cambiaColorCelda
				botones[fila][columna].setBackground(cambiaColorCelda(valor));

				// Cambiar el color de la fuente según el valor usando el metodo
				// obtenerColorTexto
				botones[fila][columna].setForeground(obtenerColorTexto(valor));

			}
		}
		actualizarPuntaje();
	}

	// cambia de color el fondo de la celda segùn el valor resultado de la suma
	private Color cambiaColorCelda(int valor) {
		switch (valor) {
			case 2:
				return new Color(209, 196, 177); // Marrón claro
			case 4:
				return new Color(237, 224, 200); // Naranja claro
			case 8:
				return new Color(245, 149, 99); // Naranja más oscuro
			case 16:
				return new Color(245, 124, 95); // Naranja medio
			case 32:
				return new Color(246, 94, 59); // Naranja
			case 64:
				return new Color(246, 76, 47); // Naranja más fuerte
			case 128:
				return new Color(236, 203, 118); // Rojo claro
			case 256:
				return new Color(236, 188, 97); // Rojo medio
			case 512:
				return new Color(236, 152, 80); // Rojo
			case 1024:
				return new Color(236, 133, 63); // Rojo oscuro
			case 2048:
				return new Color(236, 99, 46); // Rojo más oscuro
			default:
				return new Color(0, 250, 250); // celeste
		}
	}

	// para cambiar el texto cuando la suma da mas de 8
	private Color obtenerColorTexto(int valor) {
		// Si el valor es mayor q 8 el color del texto será blanco, de lo contrario,
		// será negro
		if (valor >= 8) {
			return Color.WHITE;
		} else {
			return Color.BLACK;
		}
	}

	// para actualizar el puntaje NO ESTA TERMINADO y VER SI SIRVE
	private void actualizarPuntaje() {
		int puntaje = juego.obtenerPuntaje();
		textPuntajeActual.setText(String.valueOf(puntaje));
	}

	// Verifica si el juego esta ganado o perdido
	public void verificarEstadoJuego() {
		if (juego.juegoGanado()) {
			JOptionPane.showMessageDialog(this, "JUEGO GANADO!", "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
			juego.limpiarMatriz();
			mostrarPantallaInicial();

		} else if (juego.juegoPerdido()) {
			JOptionPane.showMessageDialog(this, "JUEGO PERDIDO!", "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
			juego.limpiarMatriz();
			mostrarPantallaInicial();
		}
	}

	private void mostrarPantallaInicial() {
		PantallaInicial pantallaInicial = new PantallaInicial();
		pantallaInicial.getFrame().setVisible(true); // Hace visible la ventana PantallaInicial
		this.dispose(); // Cerrar la ventana actual
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// ...
	}

	// Nexo entre logica e interfaz
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
			case KeyEvent.VK_UP:
				juego.moverArriba();
				break;
			case KeyEvent.VK_DOWN:
				juego.moverAbajo();
				break;
			case KeyEvent.VK_LEFT:
				juego.moverIzquierda();
				break;
			case KeyEvent.VK_RIGHT:
				juego.moverDerecha();
				break;
		}
		actualizarTablero();
		verificarEstadoJuego();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// ...
	}
}
