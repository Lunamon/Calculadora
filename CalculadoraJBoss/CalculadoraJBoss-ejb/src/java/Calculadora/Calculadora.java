/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

import java.util.ArrayList;
import java.util.Collections;
import javax.ejb.Stateless;

/**
 *
 * @author Alejandro
 */
@Stateless
public class Calculadora implements CalculadoraRemote {
@Override
    public double suma(double x, double y){
        return x+y;
    }
    @Override
    public double resta(double x, double y){
        return x-y;
    }
    @Override
    public double multiplicacion(double x, double y){
        return x*y;
    }
    @Override
    public double division(double x, double y){
        return x/y;
    }
    @Override
    public double potencia(double x, int y){
        return Math.pow(x,y);
    }
    @Override
    public int modulo(double x, double y){
        return (int) (x-((int)(x/y)*y));
    }
    @Override
    public double raiz(double x){
        return Math.sqrt(x);
    }
    @Override
    public double log10(double x){
        return Math.log10(x);
    }
    @Override
    public double logn(double x, double y){
        return Math.log(x)/Math.log(y);
    }
    @Override
    public int factorial(int x){
         if (x == 1 || x==0)
            return 1; 
	else 
            return x * factorial(x - 1); 
    }
    @Override
    public ArrayList<Double> ordernarLista(ArrayList<Double> lista){
        Collections.sort(lista);
        return lista;
    }
    @Override
    public double promedioLista(ArrayList<Double> lista){
        double y=0;
        for(Double d: lista){
            y=y+Math.abs(d);
        }
        return y/lista.size();
    }
    @Override
    public double seno(double y){
        return Math.sin(y);
    }
    @Override
    public double tangente(double y){
        return Math.tan(y);
    }
    @Override
    public double coseno(double y){
        return Math.cos(y);
    }
}
