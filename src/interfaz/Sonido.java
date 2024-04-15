package interfaz;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonido {
	
	public static void reproducirSonido(String rutaArchivo) {
	    try {
	        // Obtener el archivo de sonido
	        File archivoSonido = new File(rutaArchivo);

	        // Crear un clip de sonido
	        Clip clip = AudioSystem.getClip();
	        
	        // Cargar el archivo de sonido en el clip
	        AudioInputStream inputStream = AudioSystem.getAudioInputStream(archivoSonido);
	        clip.open(inputStream);
	        
	        // Reproducir el sonido
	        clip.start();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	
}
