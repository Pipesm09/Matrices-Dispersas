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
        Forma2 F2 = new Forma2();
        F2.LlenarMD(Mat);

        do {
            opc = menu();
            switch (opc) {
                case 1:
                    T1.Mostrar();
                    break;
                case 2:
                    int i;
                    i = Integer.parseInt(JOptionPane.showInputDialog("Ingrese en que fila desea insertar el dato: "));
                    int j;
                    j = Integer.parseInt(JOptionPane.showInputDialog("Ingrese en que columna desea insertar el dato: "));
                    int d;
                    d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato que desea insertar en la tripleta: "));
                    T1.Insertar(i, j, d);
                    T1.Mostrar();
                    break;
                case 3:
                    i = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila del dato que desea eliminar: "));
                    j = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna del dato que desea eliminar: "));
                    T1.Eliminar(i, j);
                    T1.Mostrar();
                    break;

                case 4:
                    System.out.println("\n=== SUMAR MATRICES ===");
                    System.out.println("Para sumar, se necesita crear la SEGUNDA matriz:");

                    // Creamos la segunda matriz tradicional
                    int Mat2[][] = CrearMatriz();
                    int N2 = ContarDatos(Mat2);

                    // La convertimos a Tripleta
                    Tripleta T2 = new Tripleta(N2);
                    T2.LlenarTripleta(Mat2);
                    System.out.println("\n--- MATRIZ 2 (T2) ---");
                    T2.Mostrar();
                    // Creamos T3 con el tamaño máximo posible (Total de datos de T1 + Total de datos de T2)
                    int maxDatos = T1.getMtri(0, 2) + T2.getMtri(0, 2);
                    Tripleta T3 = new Tripleta(maxDatos);
                    T3.SumarTripleta(T1, T2, T3);
                    System.out.println("\n--- MATRIZ 3 (T3) ---");
                    T3.Mostrar();
                    break;

                case 5:
                    System.out.println("Para multiplicar, se necesita crear la SEGUNDA matriz:");
                    int Mat3[][] = CrearMatriz();
                    int N3 = ContarDatos(Mat3);
                    Tripleta T4 = new Tripleta(N3);
                    T4.LlenarTripleta(Mat3);
                    System.out.println("\n--- MATRIZ 2 (T2) ---");
                    T4.Mostrar();
                    //para el tamaño de la matriz ya multiplicada toca multiplicar los datos totales de cada tripleta
                    int maxDatosM = T1.getMtri(0, 2) * T4.getMtri(0, 2);
                    Tripleta T5 = new Tripleta(maxDatosM);
                    T5.MultiplicarTri(T1, T4, T5);
                    Tripleta resultado = T5.MultiplicarTri(T1, T4, T5);
                    if(resultado!=null){
                        System.out.println("\n--- MATRIZ 3 (T3) ---");
                    resultado.Mostrar();
                    } else{
                        System.out.println("Cancelada por no tener dimensiones iguales bobo");
                    }                  
                   
                    break;
                case 6:
                    T1.SumarColumnas();
                    break;
                case 7:
                    T1.SumarFilas();
                    break;
            }
        } while (opc != 0);
    }

    public static int menu() {

        int opc = Integer.parseInt(JOptionPane.showInputDialog("Menu pricipal\n"
                + "1. Mostar Tripleta\n" + "2. Insertar dato\n" + "3. Eliminar dato\n" + "4. Sumar matrices\n" + "5. Multiplicar matrices\n" 
                + "6. Sumar por columnas\n" + "7. Sumar por filas\n" + "8. Mostrar forma 1"+ "9. Sumar 2 formas 1\n"));
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
                if (valores.nextInt(2) == 0) { //Si el valor aleatorio entre 1 y 0 es 0
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
