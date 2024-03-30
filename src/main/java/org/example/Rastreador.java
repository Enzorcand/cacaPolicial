package org.example;

public class Rastreador {
    private char[][] mapa;
    private int valorTotal;

    public Rastreador(char[][] mapa){
        this.mapa = mapa;
        valorTotal = 0;
    }

    public void iniciaRastreio(){
        boolean canContinue = true;
        
        do{
            if ()
        }while(true);
    }
    
    public int searchStart(){
        for (int i = 0; i < mapa[0].length ; i++) {
            if (mapa[0][i] == '-'){
                return i;
            }
        }
        return -1;-
    }
}
