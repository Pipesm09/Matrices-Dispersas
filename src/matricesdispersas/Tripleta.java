package matricesdispersas;

import javax.swing.JOptionPane;

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

    public void Insertar(int i, int j, int d) {
        if (i < this.Mtri[0][0] && j < this.Mtri[0][1]) {
            if (i >= 0 && j >= 0) {
                for (int k = 1; k < this.Mtri[0][2]; k++) {
                    if (this.Mtri[k][0] == i && this.Mtri[k][0] == j) {

                        boolean menu;
                        int opc = Integer.parseInt(JOptionPane.showInputDialog("Qué desea hacer con el dato encontrado:\n" + "1. Sumar ambos datos\n" + "2. Reemplazar el actual por el nuevo\n" + "3. Dejar el dato actual\n"));
                        do {
                            switch (opc) {
                                case 1:
                                    this.Mtri[i][j] = d + this.Mtri[i][j];
                                    menu = false;
                                    break;
                                case 2:
                                    this.Mtri[i][j] = d;
                                    menu = false;
                                    break;
                                case 3:
                                    menu = false;
                                    break;
                            }

                        } while (menu = true);
                    }
                    else {
                        if(this.Mtri[k][0] == i && this.Mtri[k][0] != j){
                            
                        }
                    }
                }
            }
        }
    }
}
