/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Alejandro
 */
@Remote
public interface CalculadoraRemote {
    public double suma(double x, double y);
    public double resta(double x, double y);
    public double multiplicacion(double x, double y);
    public double division(double x, double y);
    public double potencia(double x, int y);
    public int modulo(double x, double y);
    public double raiz(double x);
    public double log10(double x);
    public double logn(double x, double y);
    public int factorial(int x);
    public ArrayList<Double> ordernarLista(ArrayList<Double> lista);
    public double promedioLista(ArrayList<Double> lista);
    public double seno(double y);
    public double tangente(double y);
    public double coseno(double y);
}
