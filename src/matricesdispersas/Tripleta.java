/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        Mtri = new int[N][3];
    }

    public int[][] getMtri() {
        return Mtri;
    }

    public void setMtri(int[][] Mtri) {
        this.Mtri = Mtri;
    }
    
    public int getMtri(int k,int i) {
        return Mtri[k][i];
    }

    public void setMtri(int k,int i,int d) {
        Mtri[k][i] = d;
    }
    
    public void LlenarTripleta(int Mat[][]){
        
        
        for (int i = 0; i < Mat.length; i++) {
            for (int j = 0; j < Mat[0].length; j++) {
                if (Mat[i][j] != 0) {
                    //Ingresar a tripleta
                }
            }
        }
    }
    
    public void Mostrar(){
        
        for (int k = 0; k < Mtri[0][2]; k++) {
            System.out.println("|"+Mtri[k][0]+"|"+Mtri[k][1]+"|"+Mtri[k][2]+"|");
        }
    }
}
