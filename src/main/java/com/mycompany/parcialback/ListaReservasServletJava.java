package com.mycompany.parcialback;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logicaJava.claseReservasJava;
import logicaJava.controladoraJava;


@WebServlet(name = "ListaReservasServletJava", urlPatterns = {"/ListaReservasServletJava"})
public class ListaReservasServletJava extends HttpServlet {
    controladoraJava control = new controladoraJava();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListaReservasServletJava</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListaReservasServletJava at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    /*
        En el método GET, creamos una nueva lista que va a contener datos de nuestro tipo de claseResevasJava
        
        y llenamos nuestra lista con los datos que nos retornará el método de "traerReservas" del controlador
    
        y creamos una nueva sessión en la cual vamos a guardar los datos y los vamos a pasar al front
    
    */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Creamos nuestra lista donde guardaremos las reservas traidas del back
        List<claseReservasJava> listaReservas = new ArrayList<>();
        //Llenamos nuestra lista con los datos retornados del método traerReservas del controlador
        listaReservas = control.traerReservas();
        
        //Guardamos los datos con un nombre específico para poder llamarlos en el front
        HttpSession misession = request.getSession();
        misession.setAttribute("listaReservas", listaReservas);
        
        response.sendRedirect("reservasJPAFront.jsp");
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
