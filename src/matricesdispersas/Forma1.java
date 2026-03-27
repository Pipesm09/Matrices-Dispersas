package matricesdispersas;

/**
 *
 * @author ASUS
 */
public class Forma1 {

    private Nodo Punta;

    public Forma1() {
        this.Punta = null;
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo Punta) {
        this.Punta = Punta;
    }

    public void LlenarMD(int[][] Mat) {
        Paso1(Mat.length, Mat[0].length);
        Paso2(Mat);
        Paso3();
    }

    private void Paso1(int n, int m) {
        Nodo p, x;
        int i = 0, May;
        if (n < m) {
            May = n;
        } else {
            May = m;
        }

        if (Punta == null) {
            x = new Nodo(n, m, 0);
        }
        p = Punta;
        while (i < May) {
            x = new Nodo(i, i, 0);
            p.setLiga(x);
            p = x;
            i++;
        }
        p.setLiga(Punta);

    }

    private void Paso2(int[][] Mat) {
        Nodo p = Punta.getLiga(), q = p, x;
        for (int i = 0; i < Mat.length; i++) {
            for (int j = 0; j < Mat[0].length; j++) {
                if(Mat[i][j]!=0){
                   x = new Nodo(i ,j ,Mat[i][j]); 
                   q.setLf(x);
                   q = x;
                }
                q.setLf(p);
                p = p.getLiga();
                q = p;
            }
        }

    

    private void Paso3() {

    }
}
