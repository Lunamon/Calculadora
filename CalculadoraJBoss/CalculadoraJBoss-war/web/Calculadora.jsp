<%-- 
    Document   : Calculadora
    Created on : 12/06/2015, 02:38:20 AM
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            table, th, td {
	border: 1px solid #D4E0EE;
	border-collapse: collapse;
	font-family: "Trebuchet MS", Arial, sans-serif;
	color: #555;
        }

        caption {
                font-size: 150%;
                font-weight: bold;
                margin: 5px;
        }

        td, th {
                padding: 4px;
        }

        thead th {
                text-align: center;
                background: #E6EDF5;
                color: #4F76A3;
                font-size: 100% !important;
        }

        tbody th {
                font-weight: bold;
        }

        tbody tr { background: #FCFDFE; }

        tbody tr.odd { background: #F7F9FC; }

        table a:link {
                color: #718ABE;
                text-decoration: none;
        }

        table a:visited {
                color: #718ABE;
                text-decoration: none;
        }

        table a:hover {
                color: #718ABE;
                text-decoration: underline !important;
        }

        tfoot th, tfoot td {
                font-size: 85%;
        }
        #btnEnviar {
        font-weight: bold;
        cursor: pointer;
        padding: 5px;
        margin: 0 10px 20px 0;
        border: 1px solid #ccc;
        background: #eee;
        border-radius: 8px 8px 8px 8px;
        }

        #btnEnviar:hover {
            background: #ddd;
        }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>
    </head>
    <body>
        <h1>Calculadora EJB</h1>
        <br>
        
        <div>
            <form action = "Controlador">
                <table>
                    <tr>
                        <td><label>Valor 1 </label></td>
                        <td><label>Valor 2 </label></td>
                    </tr>
                    <tr>
                        <td><label><input type="text" name="txtValor1" id="txtValor1" required placeholder="Valor aqui :)" value="<%if(session.getAttribute("v1")!=null) {out.print(session.getAttribute("v1"));} %>"/> </label></td>
                        <td><label><input type="text" name="txtValor2" id="txtValor2"  placeholder="Valor aqui :)" value="<%if(session.getAttribute("v2")!=null) {out.print(session.getAttribute("v2"));} %>"/> </label></td>
                    </tr>
                </table>                
                <br>
                <br>
                <select name="cmbOperacion" id="cmbOperacion">
                    <option value="1">Suma</option>
                    <option value="2">Resta</option>
                    <option value="3">Multiplicación</option>
                    <option value="4">División</option>
                    <option value="5">Potencia</option>
                    <option value="6">Modulo</option>                    
                    <option value="7">Raíz Cuadrada</option>
                    <option value="8">Logaritmo base 10</option>
                    <option value="9">Logaritmo base n</option>
                    <option value="10">Factorial</option>
                    <option value="11">Ordenar Numeros</option>
                    <option value="12">Promedio de lista de numeros</option>
                    <option value="13">Seno</option>
                    <option value="14">Tangente</option>
                    <option value="15">Coseno</option>
                </select>
                <br>
                <br>
                <label>Resultado: </label>
                <br>
                <br>
                <input type="text" name="txtResultado" id="txtResultado"  placeholder="Resultado" value="<%if(session.getAttribute("resultado")!=null) {out.print(session.getAttribute("resultado"));} %>"/>
                <br>
                <br>
                <input type="submit" name="btnEnviar" id="btnEnviar" value="Calcular"/>
            </form>
        </div>
        
    </body>
</html>
