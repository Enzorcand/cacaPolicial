package org.example;

import java.util.ArrayList;

public class Rastreador {
    private char[][] mapa;
    private int valorTotal;

    public Rastreador(char[][] mapa){
        this.mapa = mapa;
        valorTotal = 0;
    }

    public void iniciaRastreio(){
        boolean canContinue = true;
        int i = 0;
        int j = searchStart();
        int direction = 1;
        do{
            ArrayList<Character> array = new ArrayList<>();
            while(isANumber(mapa[i][j])) {
                array.add(mapa[i][j]);
                switch (direction) {
                    case 1 -> i++;
                    case 2 -> i--;
                    case 3 -> j++;
                    case 4 -> j--;
                }
            }
            if(!array.isEmpty()){

            }
            direction = getDirection(i, j, direction);
            switch (direction) {
                case 1 -> i++;
                case 2 -> i--;
                case 3 -> j++;
                case 4 -> j--;
            }
        }while(true);
    }

    private int getDirection(int i, int j, int direction) {
        if(mapa[i][j] == '/'){
            if (direction == 1){
                direction = 4;
            }
            if (direction == 3){
                direction = 2;
            }
            if(direction == 2){
                direction = 3;
            }
            if (direction == 4) {
                direction = 2;
            }
        }
        if(mapa[i][j] == '\\'){
            if (direction == 1){
                direction = 3;
            }
            if (direction == 2){
                direction = 4;
            }
            if (direction == 3){
                direction = 2;
            }
            if (direction == 4){
                direction = 1;
            }
        }
        return direction;
    }

    private boolean isANumber(char a) {
        for (char c = '0'; c <= '9'; c++){
            if(c == a){
                return true;
            }
        }
        return false;
    }

    private int searchStart(){
        for (int i = 0; i < mapa[0].length ; i++) {
            if (mapa[0][i] == '-'){
                return i;
            }
        }
        return -1;
    }
}
