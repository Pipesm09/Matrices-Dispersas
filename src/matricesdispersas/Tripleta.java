package matricesdispersas;

/**
 *
 * @author ASUS
 */
public class Tripleta {

    //Atributos
    private int Mtri[][];

    //Metodos
    public Tripleta(int N) {
        Mtri = new int[N + 1][3];
        this.Mtri[0][2] = N;
    }

    public int[][] getMtri() {
        return Mtri;
    }

    public void setMtri(int[][] Mtri) {
        this.Mtri = Mtri;
    }

    public int getMtri(int k, int i) {
        return Mtri[k][i];
    }

    public void setMtri(int k, int i, int d) {
        Mtri[k][i] = d;
    }

    public void LlenarTripleta(int Mat[][]) {
        this.Mtri[0][0] = Mat.length;
        this.Mtri[0][1] = Mat[0].length;
        int k = 1;
        for (int i = 0; i < Mat.length; i++) {
            for (int j = 0; j < Mat[0].length; j++) {
                if (Mat[i][j] != 0) {
                    if (Mat[i][j] != 0) {
                        this.Mtri[k][0] = i;
                        this.Mtri[k][1] = j;
                        this.Mtri[k][2] = Mat[i][j];
                        k++;
                    }
                }
            }
        }
    }

    public void Mostrar() {

        for (int k = 0; k < Mtri[0][2]; k++) {
            System.out.println("|" + Mtri[k][0] + "|" + Mtri[k][1] + "|" + Mtri[k][2] + "|");
        }
    }
}
