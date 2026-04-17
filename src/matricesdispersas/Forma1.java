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
                if (Mat[i][j] != 0) {
                    x = new Nodo(i, j, Mat[i][j]);
                    q.setLf(x);
                    q = x;
                }
                q.setLf(p);
                p = p.getLiga();
                q = p;
            }
        }
    }
    

    

private void Paso3() {
        // 1. Obtenemos las dimensiones (depende de cómo se llamen tus métodos)
        int totalFilas = Punta.getFila(); 
        int totalCols = Punta.getCol();
        
        // 2. Empezamos en el primer Nodo Cabeza (de la lista circular de cabezas)
        Nodo cabezaCol = Punta.getLiga(); 
        
        // 3. Recorremos columna por columna (j)
        for (int j = 0; j < totalCols; j++) {
            Nodo ultimo = cabezaCol; // 'ultimo' es el que va a tejer hacia abajo
            Nodo cabezaFila = Punta.getLiga(); // Para buscar, recorremos fila por fila
            
            for (int i = 0; i < totalFilas; i++) {
                Nodo actual = cabezaFila.getLf(); // Entramos a los datos de la fila 'i'
                
                // Caminamos por la fila 'i' buscando nodos que pertenezcan a la columna 'j'
                while (actual != cabezaFila) {
                    if (actual.getCol() == j) {
                        ultimo.setLc(actual); // ¡Lo encontramos! Lo enganchamos verticalmente
                        ultimo = actual;      // 'ultimo' baja al nuevo nodo
                        break;                // Saltamos a la siguiente fila (i)
                    }
                    actual = actual.getLf(); // Si no es, seguimos buscando en la fila
                }
                cabezaFila = cabezaFila.getLiga(); // Pasamos a la siguiente fila
            }
            
            // 4. Cerrar el círculo vertical
            ultimo.setLc(cabezaCol); // El último de la columna se conecta con la cabeza
            
            // 5. Movernos al Nodo Cabeza de la siguiente columna
            cabezaCol = cabezaCol.getLiga();
        }
    }
}
