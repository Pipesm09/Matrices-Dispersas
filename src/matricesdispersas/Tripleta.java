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
        System.out.println("\n");
    }

    private void insertarEnPos(int pos, int i, int j, int d) {

        int[][] Ma = new int[this.Mtri[0][2] + 2][3];

        Ma[0][0] = this.Mtri[0][0];
        Ma[0][1] = this.Mtri[0][1];
        Ma[0][2] = this.Mtri[0][2] + 1;

        int p = 1;

        for (int q = 1; q <= Ma[0][2]; q++) {

            if (q == pos) {
                // insertar el nuevo dato
                Ma[q][0] = i;
                Ma[q][1] = j;
                Ma[q][2] = d;
            } else {
                // copiar datos ya existentes
                Ma[q][0] = this.Mtri[p][0];
                Ma[q][1] = this.Mtri[p][1];
                Ma[q][2] = this.Mtri[p][2];
                p++;
            }
        }
        //Actualizar la tripleta con la auxiliar
        this.Mtri = Ma;

    }

    public void Insertar(int i, int j, int d) {
        if (i < 0 || i >= this.Mtri[0][0] || j < 0 || j >= this.Mtri[0][1]) {
            JOptionPane.showMessageDialog(null,
                    "Error: la posición (" + i + "," + j + ") está fuera de la matriz.\n"
                    + "Indices válidos de filas: 0 a " + (this.Mtri[0][0] - 1) + "\n"
                    + "Indices válidos de columnas: 0 a " + (this.Mtri[0][1] - 1));
            return;
        }
        if (i >= 0 && i < this.Mtri[0][0] && j >= 0 && j < this.Mtri[0][1]) {
            for (int k = 1; k <= this.Mtri[0][2]; k++) {
                if (this.Mtri[k][0] == i && this.Mtri[k][1] == j){

                    int opc = Integer.parseInt(JOptionPane.showInputDialog("Qué desea hacer con el dato encontrado:\n" + 
                            "1. Sumar ambos datos\n" + "2. Reemplazar el actual por el nuevo\n" + "3. Dejar el dato actual\n"));
                    boolean menu = true;
                    do {

                        switch (opc) {
                            case 1:
                                this.Mtri[k][2] = d + this.Mtri[k][2];
                                menu = false;
                                break;
                            case 2:
                                this.Mtri[k][2] = d;
                                menu = false;
                                break;
                            case 3:
                                menu = false;
                                break;
                        }

                    } while (menu);
                    return;
                }
                if (this.Mtri[k][0] == i && j < this.Mtri[k][1]) { //En este caso se inserta ANTES respecto a la posicion actual de la tripleta
                    insertarEnPos(k, i, j, d);
                    return;
                }
                if (i < this.Mtri[k][0]) {
                    insertarEnPos(k, i, j, d);
                    return;
                }
            }
        }
    }

    public void Eliminar(int i, int j) {
        if (i < 0 || i >= this.Mtri[0][0] || j < 0 || j >= this.Mtri[0][1]) {
            JOptionPane.showMessageDialog(null,
                    "Posición inválida\n\n"
                    + "Intentaste eliminar en (" + i + "," + j + ")\n"
                    + "Indices validos de filas: 0 a " + (this.Mtri[0][0] - 1) + "\n"
                    + "Indices validos de columnas: 0 a " + (this.Mtri[0][1] - 1));
            return;
        }

        if (i >= 0 && i < this.Mtri[0][0] && j >= 0 && j < this.Mtri[0][1]) {
            for (int k = 1; k <= this.Mtri[0][2]; k++) {
                if (this.Mtri[k][0] == i && this.Mtri[k][1] == j){
                    
                    // Crear nueva tripleta con un dato menos
                    int[][] Ma = new int[this.Mtri[0][2] + 1][3];

                    // copiar información de la matriz
                    Ma[0][0] = this.Mtri[0][0]; // filas
                    Ma[0][1] = this.Mtri[0][1]; // columnas
                    Ma[0][2] = this.Mtri[0][2] - 1; // nueva cantidad

                    int p = 1;

                    for (int q = 1; q <= this.Mtri[0][2]; q++) {
                        int pos = k;
                        if (q == pos) {
                            // No se copia el dato que el usuario dio
                            continue;
                        }

                        // copiar los otros datos
                        Ma[p][0] = this.Mtri[q][0];
                        Ma[p][1] = this.Mtri[q][1];
                        Ma[p][2] = this.Mtri[q][2];
                        p++;
                    }

                    // Actualizar la tripleta original
                    this.Mtri = Ma;
                }
            }
        }
    }
        public Tripleta SumarTripleta(Tripleta A, Tripleta B, Tripleta C) {
        int i = 1, j = 1, k = 1;
        while (i <= A.getMtri(0, 2) || j <= B.getMtri(0, 2)) {
            if (i <= A.getMtri(0, 2) && j <= B.getMtri(0, 2)) {
                if (A.getMtri(i, 0) == B.getMtri(j, 0) && A.getMtri(i, 1) == B.getMtri(j, 1)) {
                    int dato = A.getMtri(i, 2) + B.getMtri(j, 2);
                    if (dato != 0) {
                        // modifico la tripleta C con el primer lugar (dando la posicion) el segundo donde quiero inserta (columna, fila o dato) el tercero con el valor qeu quiero insertar
                        //ingreso la fila que se supone sumo
                        C.setMtri(k, 0, A.getMtri(i, 0));
                        //ingreso la columna
                        C.setMtri(k, 1, A.getMtri(i, 1));
                        //ingreso el dato != de 0
                        C.setMtri(k, 2, dato);
                        i++;
                        j++;
                        k++;
                    } else {
                        i++;
                        j++;
                    }
                } else if (A.getMtri(i, 0) < B.getMtri(j, 0) || (A.getMtri(i, 0) == B.getMtri(j, 0) && A.getMtri(i, 1) < B.getMtri(j, 1))) {
                    //ingreso la fila que se supone sumo
                    C.setMtri(k, 0, A.getMtri(i, 0));
                    //ingreso la columna
                    C.setMtri(k, 1, A.getMtri(i, 1));
                    //ingreso el dato != de 0
                    C.setMtri(k, 2, A.getMtri(i, 2));
                    i++;
                    k++;
                } else {
                    //ingreso la fila
                    C.setMtri(k, 0, B.getMtri(j, 0));
                    //ingreso la columna
                    C.setMtri(k, 1, B.getMtri(j, 1));
                    //ingreso el dato != de 0
                    C.setMtri(k, 2, B.getMtri(j, 2));
                    j++;
                    k++;
                }
            } else {
                //si la tripleta A todavia tiene datos
                if (i <= A.getMtri(0, 2)) {
                    //ingreso la fila que se supone sumo
                    C.setMtri(k, 0, A.getMtri(i, 0));
                    //ingreso la columna
                    C.setMtri(k, 1, A.getMtri(i, 1));
                    //ingreso el dato != de 0
                    C.setMtri(k, 2, A.getMtri(i, 2));
                    i++;
                    k++;
                }
                if (j <= B.getMtri(0, 2)) {
                    //ingreso la fila que se supone sumo
                    C.setMtri(k, 0, B.getMtri(j, 0));
                    //ingreso la columna
                    C.setMtri(k, 1, B.getMtri(j, 1));
                    //ingreso el dato != de 0
                    C.setMtri(k, 2, B.getMtri(j, 2));
                    j++;
                    k++;
                }
            }
        }
        // k-1 porque k avanzó una última vez antes de salir del ciclo
        C.setMtri(0, 2, k - 1);
        return C;
    }

    public Tripleta MultiplicarTri(Tripleta A, Tripleta B, Tripleta C) {
        //Valido si el numero de columans de la primera=al numero de filas de la segunda
        if (A.getMtri(0, 1) != B.getMtri(0, 0)) {
            System.out.println("No se pueden multiplicar las tripletas");
        }
        int i = 1; //me ayudara a cambiar de filas
        int k = 1; //me ayudara a llenar la matriz con los datos ya multiplicados
        int[] acumulador = new int[B.getMtri(0, 1)]; //recogera los datos ya multiplicados
        //para saber cuando cambiar de fila, mientras A tenga datos
        while (i <= A.getMtri(0, 2)) {
            int posFactual = A.getMtri(i, 0);//indica donde esta la fila en este momento
            int posFfinal = i; //indica hasta donde ira la fila para poder pasar a la otra
            while (posFfinal + 1 <= A.getMtri(0, 2) && A.getMtri(posFfinal + 1, 0) == posFactual) {
                posFfinal++;//hace que confirme si se esta en la misma fila fila
            }
            //inicia donde terminen la fila, o sea si la fila 0 termino en la posicion 3, ahi inicia y termnia hasta que se llegue al final de la fila
            for (int pos = i; pos <= posFfinal; pos++) {
                //recorre escaniando cada espacio de B hasta encontrar la condicion de columnas de A= filas de B
                for (int j = 1; j <= B.getMtri(0, 2); j++) {
                    if (B.getMtri(j, 0) == A.getMtri(pos, 1)) {
                        //multiplica lo que sean igual en columna con fila y lo guarda en un array
                        acumulador[B.getMtri(j, 1)] += A.getMtri(pos, 2) * B.getMtri(j, 2);
                    }
                }
            }
            //se llena la nueva tripleta con las multiplicaciones. Va desde 0 porque los arreglos comeinzan en 0
            //y va hasta el numero de columnas de B, porque como esta en el while ya se sabe la fila en la que esta cada dato
            for (int c = 0; c < B.getMtri(0, 1); c++) {
                //verifica que una multipliacion no sea 0, por si las moscas XDXdxdxddXDXxdXDxd
                if (acumulador[c] != 0) {
                    C.setMtri(k, 0, posFactual);//posicion fila
                    C.setMtri(k, 1, c);//posicion de columnas B
                    C.setMtri(k, 2, acumulador[c]);//dato multiplicado
                    k++;
                    acumulador[c]=0;
                }
            }
            i=posFfinal+1;
            //se setea la posicion 0 de la nueva tirpleta c
            C.setMtri(0, 0, A.getMtri(0, 0));
            C.setMtri(0, 1, B.getMtri(0, 1));
            C.setMtri(0, 2, k - 1);//la k termina una posicion adelante
        }
        return C;
    }
    public void SumarColumnas() {
        int[] acumulador = new int[this.Matriz[0][1]]; //recogera los datos ya multiplicados
        //recorre y suma los datos de igual columna
        for (int k=1; k<=this.Matriz[0][2];k++){
            //saco el numero de columnas donde comienza
            int ColumnaActual=this.Matriz[k][1];
            acumulador[ColumnaActual]+=this.Matriz[k][1];
        }
        System.out.println("Total de la suma");
        for (int i=1;i<this.Matriz[0][1];i++){
            System.out.println(" de la columna "+i+"es ="+acumulador[i]);
        }
    }
    public int[] SumarFilas(){
        int[] suma = new int[this.Mtri[0][0]];
        
        
        return suma;
    }
}
