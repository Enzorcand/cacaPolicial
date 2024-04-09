package org.example;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.ArrayList;
@Data
public class Rastreador {
    private char[][] mapa;
    private double valorTotal;

    public Rastreador(){
        valorTotal = 0;
    }

    public boolean iniciaRastreio(){
        boolean canContinue = true;
        int j = 0;
        int i = searchStart();
        int direction = 3;
        do{
            ArrayList<Character> array = new ArrayList<>();
            while(isANumber(mapa[i][j])) {
                array.add(mapa[i][j]);
                mapa[i][j] = '-';
                switch (direction) {
                    case 1 -> i++;
                    case 2 -> i--;
                    case 3 -> j++;
                    case 4 -> j--;
                }
            }
            if(!array.isEmpty()){
                calculaValor(array);
            }
            direction = getDirection(i, j, direction);
            if(mapa[i][j] == '#'){
                canContinue = false;
            }
            switch (direction) {
                case 1 -> i++;
                case 2 -> i--;
                case 3 -> j++;
                case 4 -> j--;
            }
        }while(canContinue);
        return true;
    }
    private void calculaValor(ArrayList<Character> array) {
        double totalRoubado = 0;
        for (int i = 0; i < array.size(); i++) {
            int numero = Integer.parseInt(String.valueOf(array.get(i)));
            totalRoubado += numero*(Math.pow(10,(array.size() - (i+1))));
        }
        valorTotal += totalRoubado;
    }

    private int getDirection(int i, int j, int direction) {
        if(mapa[i][j] == '/'){
            if (direction == 1){
                direction = 4;
            } else if (direction == 4) {
                direction = 1;
            }
            if (direction == 3){
                direction = 2;
            } else if(direction == 2){
                direction = 3;
            }
        }
        if(mapa[i][j] == '\\'){
            if (direction == 1){
                direction = 3;
            } else if (direction == 3){
                direction = 1;
            }
            if (direction == 2){
                direction = 4;
            } else if (direction == 4){
                direction = 2;
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

    public int searchStart(){
        for (int i = 0; i < mapa.length ; i++) {
            if (mapa[i][0] == '-'){
                return i;
            }
        }
        return -1;
    }
}
