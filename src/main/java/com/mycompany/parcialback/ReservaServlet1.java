package com.mycompany.parcialback;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logicaJava.claseReservasJava;
import logicaJava.controladoraJava;

@WebServlet(name = "ReservaServlet1", urlPatterns = {"/ReservaServlet1"})
public class ReservaServlet1 extends HttpServlet {

    controladoraJava control = new controladoraJava();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReservaServlet1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReservaServlet1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /* En este método POST, rescatamos todos los datos que fueron enviados desde nuestro form en el frontend
            Y hacemos unas validaciones para evitar problemas (Horas suficientes y fecha correcta)
            para luego instanciar nuestra clase de java y enviar todos nuestro datos con los setters
        
            y llamamos nuestro controlador de java para pasar la instancia de la clase que acabamos de crear
        */
        String nombre = request.getParameter("nombre");
        String fecha = request.getParameter("fecha");
        String espacio = request.getParameter("espacio");
        int horas = Integer.parseInt(request.getParameter("horas"));

        if (horas >= 1 && horas <= 14) {
            if (Integer.parseInt(fecha.substring(fecha.length()-2)) >= 12 && Integer.parseInt(fecha.substring(5, 7)) >=03 && Integer.parseInt(fecha.substring(0, 4)) >= 2025) {
                //Si los datos son correctos, instanciamos la clase y guardamos los datos
                claseReservasJava reserva = new claseReservasJava();
                reserva.setNombre(nombre);
                reserva.setFecha(fecha);
                reserva.setEspacio(espacio);
                reserva.setHoras(horas);
                //Pasamos los datos a el método de crearReserva que pertenece a nuestro controlador
                control.crearReserva(reserva);
                //Recargamos la página
                response.sendRedirect("index.jsp");
            }else{
                //Si los datos estan mal, nos arroja error
                response.sendError(821, "FECHA NO VALIDA");
            }

        } else {
            response.sendError(820, "HORAS NO VALIDAS");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
