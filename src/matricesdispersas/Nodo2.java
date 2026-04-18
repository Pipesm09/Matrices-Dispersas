/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricesdispersas;

/**
 *
 * @author ASUS
 */
public class Nodo2 {
    //Atributos
    private int  Fila, Col, Dato;
    private Nodo2 Lf, Lc;
    
    //Constructor

    public Nodo2(int Fila, int Col, int Dato) {
        this.Fila = Fila;
        this.Col = Col;
        this.Dato = Dato;
        this.Lf = null;
        this.Lc = null;
    }

    public int getFila() {
        return Fila;
    }

    public void setFila(int Fila) {
        this.Fila = Fila;
    }

    public int getCol() {
        return Col;
    }

    public void setCol(int Col) {
        this.Col = Col;
    }

    public int getDato() {
        return Dato;
    }

    public void setDato(int Dato) {
        this.Dato = Dato;
    }

    public Nodo2 getLf() {
        return Lf;
    }

    public void setLf(Nodo2 Lf) {
        this.Lf = Lf;
    }

    public Nodo2 getLc() {
        return Lc;
    }

    public void setLc(Nodo2 Lc) {
        this.Lc = Lc;
    }
    
    
}
