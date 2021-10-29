package com.example.proyecto2datos.IIStructure;

public class OperPila {

    int tam_cadena;
    char[] items;
    int i;

    OperPila(int tamaño){
        this.tam_cadena=tamaño;
        this.items=new char[tamaño];
        this.i=0;
    }
    public boolean push(char item){
        if (i<tam_cadena){
            items[i++]=item;
            return true;
        }
        return false;
    }
    public char pop(){
        if(i<=0)
            return 0;
        return items[--i];

    }

    // a b +
    public char nextPop(){
        if(i<=0)
            return 0;
        return items[i-1];
    }
}