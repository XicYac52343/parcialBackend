package com.mycompany.parcialback;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logicaJava.controladoraJava;

@WebServlet(name = "EliminarReservaServletJava", urlPatterns = {"/EliminarReservaServletJava"})
public class EliminarReservaServletJava extends HttpServlet {
    controladoraJava control = new controladoraJava();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EliminarReservaServletJava</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EliminarReservaServletJava at " + request.getContextPath() + "</h1>");
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
    @Override
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    /*
        En el método POST, vamos a rescatar el valor del input el cual pertenece al ID del usuario a eliminar
        y llamamos el método de elimar Reserva, le pasamos como parámetro el ID del usuario y redireccionamos al index
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Rescatamos el valor del front
        int id = Integer.parseInt(request.getParameter("id_Eliminar"));
        //Pasamos el id al método de eliminar reserva para que se pueda lograr la eliminación
        control.eliminarReserva(id);
        response.sendRedirect("index.jsp");
        
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
