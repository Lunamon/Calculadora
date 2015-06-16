/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletsControlador;

import Calculadora.CalculadoraRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class Controlador extends HttpServlet {
    @EJB
    private CalculadoraRemote calculadoraRemota;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        int tipop = Integer.parseInt(request.getParameter("cmbOperacion"));
            System.out.println(tipop);
            System.out.println(request.getParameter("btnEnviar"));
            
            if(request.getParameter("txtValor1")!=null || !request.getParameter("txtValor1").isEmpty())
            {
                sesion.setAttribute("v1",request.getParameter("txtValor1"));
            }
            if(request.getParameter("txtValor2")!=null || !request.getParameter("txtValor2").isEmpty())
            {
                sesion.setAttribute("v2",request.getParameter("txtValor2"));
            }
            if(tipop==1){
                double x=Double.parseDouble(request.getParameter("txtValor1"));
                double y = Double.parseDouble(request.getParameter("txtValor2"));                
                sesion.setAttribute("resultado", String.valueOf(calculadoraRemota.suma(x,y)));
                if(request.getParameter("btnEnviar").compareTo("Calcular Operacion")==0){
                    response.sendRedirect("CalculadoraVista");
                    
                }
                else{
                    response.sendRedirect("Calculadora.jsp");
                }
                
            }
            if(tipop==2){
                double x=Double.parseDouble(request.getParameter("txtValor1"));
                double y = Double.parseDouble(request.getParameter("txtValor2"));                
                sesion.setAttribute("resultado", String.valueOf(calculadoraRemota.resta(x,y)));
                if(request.getParameter("btnEnviar").compareTo("Calcular Operacion")==0){
                    response.sendRedirect("CalculadoraVista");
                }
                response.sendRedirect("Calculadora.jsp");
                
            }
            if(tipop==3){
                double x=Double.parseDouble(request.getParameter("txtValor1"));
                double y = Double.parseDouble(request.getParameter("txtValor2"));                
                sesion.setAttribute("resultado", String.valueOf(calculadoraRemota.multiplicacion(x,y)));
                if(request.getParameter("btnEnviar").compareTo("Calcular Operacion")==0){
                    response.sendRedirect("CalculadoraVista");
                }
                response.sendRedirect("Calculadora.jsp");
                
            }
            if(tipop==4){
                double x=Double.parseDouble(request.getParameter("txtValor1"));
                double y = Double.parseDouble(request.getParameter("txtValor2"));                
                sesion.setAttribute("resultado", String.valueOf(calculadoraRemota.division(x,y)));
                if(request.getParameter("btnEnviar").compareTo("Calcular Operacion")==0){
                    response.sendRedirect("CalculadoraVista");
                }
                response.sendRedirect("Calculadora.jsp");
                
            }
            if(tipop==5){
                double x=Double.parseDouble(request.getParameter("txtValor1"));
                int y = Integer.parseInt(request.getParameter("txtValor2"));                
                sesion.setAttribute("resultado", String.valueOf(calculadoraRemota.potencia(x,y)));
                if(request.getParameter("btnEnviar").compareTo("Calcular Operacion")==0){
                    response.sendRedirect("CalculadoraVista");
                }
                response.sendRedirect("Calculadora.jsp");
                
            }
            if(tipop==6){
                double x=Double.parseDouble(request.getParameter("txtValor1"));
                double y = Double.parseDouble(request.getParameter("txtValor2"));                
                sesion.setAttribute("resultado", String.valueOf(calculadoraRemota.modulo(x,y)));
                if(request.getParameter("btnEnviar").compareTo("Calcular Operacion")==0){
                    response.sendRedirect("CalculadoraVista");
                }
                response.sendRedirect("Calculadora.jsp");
            }
            if(tipop==7){
                double x=Double.parseDouble(request.getParameter("txtValor1"));                
                sesion.setAttribute("resultado", String.valueOf(calculadoraRemota.raiz(x)));
                if(request.getParameter("btnEnviar").compareTo("Calcular Operacion")==0){
                    response.sendRedirect("CalculadoraVista");
                }
                response.sendRedirect("Calculadora.jsp");
                
            }
            if(tipop==8){
                double x=Double.parseDouble(request.getParameter("txtValor1"));       
                sesion.setAttribute("resultado", String.valueOf(calculadoraRemota.log10(x)));
                if(request.getParameter("btnEnviar").compareTo("Calcular Operacion")==0){
                    response.sendRedirect("CalculadoraVista");
                }
                response.sendRedirect("Calculadora.jsp");
                
            }
            if(tipop==9){
                double x=Double.parseDouble(request.getParameter("txtValor1"));
                double y = Double.parseDouble(request.getParameter("txtValor2"));                
                sesion.setAttribute("resultado", String.valueOf(calculadoraRemota.logn(x,y)));
                if(request.getParameter("btnEnviar").compareTo("Calcular Operacion")==0){
                    response.sendRedirect("CalculadoraVista");
                }
                response.sendRedirect("Calculadora.jsp");
                
            }
            if(tipop==10){
                int x=Integer.parseInt(request.getParameter("txtValor1"));  
                sesion.setAttribute("resultado", String.valueOf(calculadoraRemota.factorial(x)));
                if(request.getParameter("btnEnviar").compareTo("Calcular Operacion")==0){
                    response.sendRedirect("CalculadoraVista");
                }
                response.sendRedirect("Calculadora.jsp");
            }
            if(tipop==11){
                String []aux = request.getParameter("txtValor1").split(",");
                ArrayList<Double> lista= new ArrayList<Double>(); 
                for(String d: aux){
                    try{
                        lista.add(Double.parseDouble(d));
                    }catch(Error e){
                        JOptionPane.showMessageDialog(null, "La lista esta mal.","Error", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                lista = calculadoraRemota.ordernarLista(lista);
                String res="";
                for(double a: lista){
                        System.out.println(a);                    
                         res = res + a+" , ";
                }
                sesion.setAttribute("resultado", res);
                if(request.getParameter("btnEnviar").compareTo("Calcular Operacion")==0){
                    response.sendRedirect("CalculadoraVista");
                }
                response.sendRedirect("Calculadora.jsp");
            }
            if(tipop==12){
                String []aux = request.getParameter("txtValor1").split(",");
                ArrayList<Double> lista= new ArrayList<Double>(); 
                for(String d: aux){
                    try{
                        lista.add(Double.parseDouble(d));
                    }catch(Error e){
                        JOptionPane.showMessageDialog(null, "La lista esta mal.","Error", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                 sesion.setAttribute("resultado",calculadoraRemota.promedioLista(lista));
                if(request.getParameter("btnEnviar").compareTo("Calcular Operacion")==0){
                    response.sendRedirect("CalculadoraVista");
                }
                 response.sendRedirect("Calculadora.jsp");
            }
            if(tipop==13){
                double x=Double.parseDouble(request.getParameter("txtValor1"));  
                sesion.setAttribute("resultado", String.valueOf(calculadoraRemota.seno(x)));
                response.sendRedirect("Calculadora.jsp");
                
            }
            if(tipop==14){
                double x=Double.parseDouble(request.getParameter("txtValor1"));  
                sesion.setAttribute("resultado", String.valueOf(calculadoraRemota.tangente(x)));
                if(request.getParameter("btnEnviar").compareTo("Calcular Operacion")==0){
                    response.sendRedirect("CalculadoraVista");
                }
                response.sendRedirect("Calculadora.jsp");
                
            }
            if(tipop==15){
                double x=Double.parseDouble(request.getParameter("txtValor1"));  
                sesion.setAttribute("resultado", String.valueOf(calculadoraRemota.coseno(x)));
                if(request.getParameter("btnEnviar").compareTo("Calcular Operacion")==1){
                    response.sendRedirect("CalculadoraVista");
                }
                response.sendRedirect("Calculadora.jsp");
                
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
