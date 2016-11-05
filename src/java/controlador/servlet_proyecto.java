package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import modelo_proyecto.m_tesis;
import bean_proyecto.*;
import jdk.nashorn.internal.ir.BreakNode;

public class servlet_proyecto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            m_tesis omodelo_tesis = new m_tesis();
            bean_persona opersona = new bean_persona();
            bean_telefono otelefono = new bean_telefono();
            bean_alumno oalumno = new bean_alumno();
            bean_docente odocente = new bean_docente();

            request.setAttribute("alumno", omodelo_tesis.selct_alumno());
            request.setAttribute("id_alumno", omodelo_tesis.selct_alumno_id());
            request.setAttribute("docente", omodelo_tesis.selct_docente());
            request.setAttribute("id_docente", omodelo_tesis.selct_docente_id());
            RequestDispatcher aa = request.getRequestDispatcher("nueva_tesis.jsp");
            aa.forward(request, response);

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
