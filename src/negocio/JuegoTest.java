package negocio;

public class JuegoTest {

  public static void main (String[] args) {
      Juego negocio = new Juego();

      negocio.IniciarMatriz();
      int [][] matriz = negocio.ObtenerMatriz();

      int lado = matriz.length;
      for (int i = 0; i < lado; i++) {
          for (int j = 0; j < lado; j++) {
              System.out.print(matriz[i][j] + " ");
          }
          System.out.println();
      }
  }
}
