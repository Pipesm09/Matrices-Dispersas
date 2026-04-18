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
        if (n > m) {
            May = n;
        } else {
            May = m;
        }

        if (Punta == null) {
            Punta = new Nodo(n, m, 0);
        }
        Punta.setLf(Punta);
        Punta.setLc(Punta);
        p = Punta;
        while (i < May) {
            x = new Nodo(i, i, 0);
            x.setLf(x);
            x.setLc(x);
            p.setLiga(x);
            p = x;
            i++;
        }
        p.setLiga(Punta);
    }

    private void Paso2(int[][] Mat) {
        Nodo p = Punta.getLiga();
        for (int i = 0; i < Mat.length; i++) {
            Nodo q = p;
            for (int j = 0; j < Mat[0].length; j++) {
                if (Mat[i][j] != 0) {
                    Nodo x = new Nodo(i, j, Mat[i][j]);
                    q.setLf(x);
                    q = x;
                }
            }
            q.setLf(p);
            p = p.getLiga();
        }
    }

    private void Paso3() {
        Nodo RC = Punta.getLiga();

        while (RC != Punta) {
            Nodo a = RC;
            Nodo p = Punta.getLiga();
            Nodo ultimo = a;
            while (p != Punta) {
                Nodo q = p.getLf();
                while (p != q) {
                    if (q.getCol() == a.getCol()) {
                        ultimo.setLc(q);
                        ultimo = q;
                    }
                    q = q.getLf();
                }
                p = p.getLiga();
            }
            ultimo.setLc(a);
            RC = RC.getLiga();
        }
    }

    public void MostrarPorFilas() {

        if (Punta == null || Punta.getLiga() == Punta) {
            System.out.println("Matriz vacía");
            return;
        }

        Nodo p = Punta.getLiga(); // primer nodo cabeza

        System.out.println("Mostrar por filas:\n");

        while (p != Punta) {

            Nodo q = p.getLf();

            while (q != p) {

                System.out.println(
                        "Fila: " + q.getFila()
                        + " Col: " + q.getCol()
                        + " Dato: " + q.getDato()
                );

                q = q.getLf();
            }

            p = p.getLiga();
        }

        System.out.println();
    }

    public void MostrarPorColumnas() {

        if (Punta == null || Punta.getLiga() == Punta) {
            System.out.println("Matriz vacía");
            return;
        }

        Nodo RC = Punta.getLiga(); // recorrer cabezas

        System.out.println("Mostrar por columnas:\n");

        while (RC != Punta) {

            Nodo q = RC.getLc();

            while (q != RC) {

                System.out.println(
                        "Fila: " + q.getFila()
                        + " Col: " + q.getCol()
                        + " Dato: " + q.getDato()
                );

                q = q.getLc();
            }

            RC = RC.getLiga();
        }

        System.out.println();
    }
    
    

}
