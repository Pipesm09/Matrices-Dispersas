package matricesdispersas;

import javax.swing.JOptionPane;

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

        int Mat[][] = {{8, 0, 5, 0, 3, 0},
                       {0, -11, 0, 0, -2, 0},
                       {1, 0, 0, 6, 0, 19}};

        int N = ContarDatos(Mat);

        Tripleta T1 = new Tripleta(N);
        T1.LlenarTripleta(Mat);
        T1.Mostrar();

        //Tripleta T1 = new Tripleta(ContarDatos(Mat));
        do{
            switch(opc){
                case 1:
                    
                    break;
            }
            
        }while(opc!=0);
    }
    
    public static int menu() {

        int opc = Integer.parseInt(JOptionPane.showInputDialog("*Menu pricipal*\n"
                + "1. Mostar\n" + "2. Insertar\n" + "3. Sumar\n" + "4. Multiplicar\n" + "5. Salir"));
        return opc;
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
