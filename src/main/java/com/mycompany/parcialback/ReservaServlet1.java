package com.mycompany.parcialback;

import java.io.IOException;
import java.io.PrintWriter;
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
        String nombre = request.getParameter("nombre");
        String fecha = request.getParameter("fecha");
        String espacio = request.getParameter("espacio");
        int horas = Integer.parseInt(request.getParameter("horas"));
        
        claseReservasJava reserva = new claseReservasJava();
        reserva.setNombre(nombre);
        reserva.setFecha(fecha);
        reserva.setEspacio(espacio);
        reserva.setHoras(horas);
        
        control.crearReserva(reserva);
        
        response.sendRedirect("index.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
