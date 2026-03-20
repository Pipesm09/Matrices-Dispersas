package matricesdispersas;

import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class MatricesDispersas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc = 0;

        int Mat[][] = CrearMatriz();

        int N = ContarDatos(Mat);

        Tripleta T1 = new Tripleta(N);
        T1.LlenarTripleta(Mat);
        T1.Mostrar();

        //Tripleta T1 = new Tripleta(ContarDatos(Mat));
        do {
            opc = menu();
            switch (opc) {
                case 1:

                    break;
            }

        } while (opc != 0);
    }

    public static int menu() {

        int opc = Integer.parseInt(JOptionPane.showInputDialog("*Menu pricipal*\n"
                + "1. Mostar\n" + "2. Insertar\n" + "3. Sumar\n" + "4. Multiplicar\n" + "5. Salir"));
        return opc;
    }

    public static int[][] CrearMatriz() {
        Scanner sc = new Scanner(System.in);
        Random valores = new Random();

        System.out.print("Ingrese número de filas: ");
        int filas = sc.nextInt();

        System.out.print("Ingrese número de columnas: ");
        int columnas = sc.nextInt();

        int[][] Mat = new int[filas][columnas];

        // Llenar la matriz
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (valores.nextInt(2) == 0)  { //Si el valor aleatorio entre 1 y 0 es 0
                    Mat[i][j] = 0; // se queda en cero
                } else { //Si el valor aleatorio entre 1 y 0 es 1
                    int valor = valores.nextInt(21) - 10; // 

                    // decidir si es positivo o negativo
                    if (valores.nextBoolean()) {
                        valor = -valor;
                    }

                    Mat[i][j] = valor;
                }
            }
        }

        return Mat;
    }

    public static int ContarDatos(int Mat[][]) {
        int N = 0;

        for (int i = 0; i < Mat.length; i++) {
            for (int j = 0; j < Mat[0].length; j++) {
                if (Mat[i][j] != 0) {
                    N++;
                }
            }
        }

        return N;
    }
}
