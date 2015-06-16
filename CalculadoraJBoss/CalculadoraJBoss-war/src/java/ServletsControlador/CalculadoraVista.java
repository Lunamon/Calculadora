/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletsControlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alejandro
 */
public class CalculadoraVista extends HttpServlet {

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
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        String v1="",v2="",res="";
        if(session.getAttribute("v1")!=null) {
            v1=String.valueOf( session.getAttribute("v1")); 
        }
        if(session.getAttribute("v2")!=null) {
            v2=String.valueOf( session.getAttribute("v2")); 
        }
        if(session.getAttribute("resultado")!=null) {
            res=String.valueOf( session.getAttribute("resultado")); 
        }
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>\n" +
                "    <head>\n" +
                "        <style type=\"text/css\">\n" +
                "            table, th, td {\n" +
                "	border: 1px solid #D4E0EE;\n" +
                "	border-collapse: collapse;\n" +
                "	font-family: \"Trebuchet MS\", Arial, sans-serif;\n" +
                "	color: #555;\n" +
                "        }\n" +
                "\n" +
                "        caption {\n" +
                "                font-size: 150%;\n" +
                "                font-weight: bold;\n" +
                "                margin: 5px;\n" +
                "        }\n" +
                "\n" +
                "        td, th {\n" +
                "                padding: 4px;\n" +
                "        }\n" +
                "\n" +
                "        thead th {\n" +
                "                text-align: center;\n" +
                "                background: #E6EDF5;\n" +
                "                color: #4F76A3;\n" +
                "                font-size: 100% !important;\n" +
                "        }\n" +
                "\n" +
                "        tbody th {\n" +
                "                font-weight: bold;\n" +
                "        }\n" +
                "\n" +
                "        tbody tr { background: #FCFDFE; }\n" +
                "\n" +
                "        tbody tr.odd { background: #F7F9FC; }\n" +
                "\n" +
                "        table a:link {\n" +
                "                color: #718ABE;\n" +
                "                text-decoration: none;\n" +
                "        }\n" +
                "\n" +
                "        table a:visited {\n" +
                "                color: #718ABE;\n" +
                "                text-decoration: none;\n" +
                "        }\n" +
                "\n" +
                "        table a:hover {\n" +
                "                color: #718ABE;\n" +
                "                text-decoration: underline !important;\n" +
                "        }\n" +
                "\n" +
                "        tfoot th, tfoot td {\n" +
                "                font-size: 85%;\n" +
                "        }\n" +
                "        #btnEnviar {\n" +
                "        font-weight: bold;\n" +
                "        cursor: pointer;\n" +
                "        padding: 5px;\n" +
                "        margin: 0 10px 20px 0;\n" +
                "        border: 1px solid #ccc;\n" +
                "        background: #eee;\n" +
                "        border-radius: 8px 8px 8px 8px;\n" +
                "        }\n" +
                "\n" +
                "        #btnEnviar:hover {\n" +
                "            background: #ddd;\n" +
                "        }\n" +
                "        </style>\n" +
                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "        <title>Calculadora</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>Calculadora EJB</h1>\n" +
                "        <br>\n" +
                "        \n" +
                "        <div>\n" +
                "            <form action = \"Controlador\">\n" +
                "                <table>\n" +
                "                    <tr>\n" +
                "                        <td><label>Valor 1 </label></td>\n" +
                "                        <td><label>Valor 2 </label></td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td><label><input type=\"text\" name=\"txtValor1\" id=\"txtValor1\" required placeholder=\"Valor aqui :)\" value=\""  + v1 +  "\"/> </label></td>\n" +
                "                        <td><label><input type=\"text\" name=\"txtValor2\" id=\"txtValor2\"  placeholder=\"Valor aqui :)\" value=\"" + v2 + "\"/> </label></td>\n" +
                "                    </tr>\n" +
                "                </table>                \n" +
                "                <br>\n" +
                "                <br>\n" +
                "                <select name=\"cmbOperacion\" id=\"cmbOperacion\">\n" +
                "                    <option value=\"1\">Suma</option>\n" +
                "                    <option value=\"2\">Resta</option>\n" +
                "                    <option value=\"3\">Multiplicación</option>\n" +
                "                    <option value=\"4\">División</option>\n" +
                "                    <option value=\"5\">Potencia</option>\n" +
                "                    <option value=\"6\">Modulo</option>                    \n" +
                "                    <option value=\"7\">Raíz Cuadrada</option>\n" +
                "                    <option value=\"8\">Logaritmo base 10</option>\n" +
                "                    <option value=\"9\">Logaritmo base n</option>\n" +
                "                    <option value=\"10\">Factorial</option>\n" +
                "                    <option value=\"11\">Ordenar Numeros</option>\n" +
                "                    <option value=\"12\">Promedio de lista de numeros</option>\n" +
                "                    <option value=\"13\">Seno</option>\n" +
                "                    <option value=\"14\">Tangente</option>\n" +
                "                    <option value=\"15\">Coseno</option>\n" +
                "                </select>\n" +
                "                <br>\n" +
                "                <br>\n" +
                "                <label>Resultado: </label>\n" +
                "                <br>\n" +
                "                <br>\n" +
                "                <input type=\"text\" name=\"txtResultado\" id=\"txtResultado\"  placeholder=\"Resultado\" value=\""+res+"\"/>\n" +
                "                <br>\n" +
                "                <br>\n" +
                "                <input type=\"submit\" name=\"btnEnviar\" id=\"btnEnviar\" value=\"Calcular Operacion\"/>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "        \n" +
                "    </body>\n" +
                "</html>\n" +
                "");
            
        
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
