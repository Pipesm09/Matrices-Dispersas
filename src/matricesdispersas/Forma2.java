package matricesdispersas;

public class Forma2 {

    private Nodo2 Punta;
    private Nodo2[] nodos; //  Vector auxiliar
    private int cont;      // cantidad real de nodos

    public Forma2() {
        this.Punta = null;
    }

    public Nodo2 getPunta() {
        return Punta;
    }

    public void setPunta(Nodo2 Punta) {
        this.Punta = Punta;
    }

    public void LlenarMD(int[][] Mat) {
        Paso1(Mat);
        Paso2();
    }

    private void Paso1(int[][] Mat) {

        int n = Mat.length;
        int m = Mat[0].length;

        Punta = new Nodo2(n, m, 0);

        Punta.setLf(Punta);
        Punta.setLc(Punta);

        nodos = new Nodo2[n * m];
        cont = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (Mat[i][j] != 0) {

                    Nodo2 nuevo = crearNodo(i, j, Mat[i][j]);

                    nodos[cont] = nuevo;
                    cont++;
                }
            }
        }
    }

    private Nodo2 crearNodo(int i, int j, int d) {

        Nodo2 nuevo = new Nodo2(i, j, d);

        return nuevo;
    }

    private void Paso2() {

        if (cont == 0) {
            Punta.setLf(Punta);
            Punta.setLc(Punta);
            return;
        }

        // Enlaza por filas
        for (int i = 0; i < cont; i++) {

            Nodo2 p = nodos[i];
            Nodo2 q = null;

            // buscar siguiente en misma fila
            for (int j = i + 1; j < cont; j++) {
                if (nodos[j].getFila() == p.getFila()) {
                    q = nodos[j];
                    break;
                }
            }

            // si no hay en la misma fila, buscar siguiente fila
            if (q == null) {
                for (int j = 0; j < cont; j++) {
                    if (nodos[j].getFila() > p.getFila()) {
                        q = nodos[j];
                        break;
                    }
                }
            }

            // si no hay siguiente, cerrar circular con Punta
            if (q == null) {
                q = Punta;
            }

            p.setLf(q);
        }

        // Enlazar por columnas 
        for (int i = 0; i < cont; i++) {

        Nodo2 p = nodos[i];
        Nodo2 q = null;

        int menorFila = Integer.MAX_VALUE;

        for (int j = 0; j < cont; j++) {

            if (nodos[j].getCol() == p.getCol() &&
                nodos[j].getFila() > p.getFila()) {

                if (nodos[j].getFila() < menorFila) {
                    menorFila = nodos[j].getFila();
                    q = nodos[j];
                }
            }
        }

        // 🔹 si no hay → buscar q columna
        if (q == null) {
            int menorCol = Integer.MAX_VALUE;

            for (int j = 0; j < cont; j++) {
                if (nodos[j].getCol() > p.getCol()) {
                    if (nodos[j].getCol() < menorCol) {
                        menorCol = nodos[j].getCol();
                        q = nodos[j];
                    }
                }
            }
        }

        if (q == null) {
            q = Punta;
        }

        p.setLc(q);
    }

        // conectar Punta al primer nodo
        Punta.setLf(nodos[0]);
        Punta.setLc(nodos[0]);
    }

    public void MostrarPorFilas() {

        if (Punta == null || Punta.getLf() == Punta) {
            System.out.println("Matriz vacía");
            return;
        }

        Nodo2 p = Punta.getLf(); // primer nodo real

        System.out.println("Mostrar por filas\n");
        while (p != Punta) {
            System.out.println(
                    "Fila: " + p.getFila()
                    + " Col: " + p.getCol()
                    + " Dato: " + p.getDato()
            );

            p = p.getLf();
        }
        System.out.println("\n");
    }

    public void MostrarPorColumnas() {

        if (Punta == null || Punta.getLc() == Punta) {
            System.out.println("Matriz vacía");
            return;
        }

        Nodo2 p = Punta.getLc();

        System.out.println("Mostrar por columnas\n");
        while (p != Punta) {
            

            System.out.println(
                    "Fila: " + p.getFila()
                    + " Col: " + p.getCol()
                    + " Dato: " + p.getDato()
            );

            p = p.getLc();
        }
        System.out.println("\n");
    }

}
