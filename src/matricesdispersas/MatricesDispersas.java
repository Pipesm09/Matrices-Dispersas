package matricesdispersas;

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

        int Mat[][] = {{8, 0, 5, 0, 3, 0}, {0,-11,0,0,-2,0}, {1,0,0,6,0,19}};
                
        int N = ContarDatos(Mat);
        
        Tripleta T1 = new Tripleta(N);
        
        //Tripleta T1 = new Tripleta(ContarDatos(Mat));
                
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
