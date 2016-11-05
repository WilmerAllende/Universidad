package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo_proyecto.m_tesis;
import bean_proyecto.*;

public class servlet_nueva_tesis extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            m_tesis omodelo_tesis = new m_tesis();
            bean_tesis otesis = new bean_tesis();
            bean_jurado ojurado1 = new bean_jurado();
            bean_jurado ojurado2 = new bean_jurado();
            bean_jurado ojurado3 = new bean_jurado();
            bean_tesistas otesista1 = new bean_tesistas();
            bean_tesistas otesista2 = new bean_tesistas();

            otesis.setTitulo(request.getParameter("txttitulo"));
            otesis.setNumero(request.getParameter("txtnumero"));
            otesis.setFecha(request.getParameter("txtfecha"));
            otesis.setTipo(request.getParameter("txttipo"));
            otesis.setId_docente(Integer.parseInt(request.getParameter("cboasesor")));
            ojurado1.setId_docente(Integer.parseInt(request.getParameter("cbojurado1")));
            ojurado2.setId_docente(Integer.parseInt(request.getParameter("cbojurado2")));
            ojurado3.setId_docente(Integer.parseInt(request.getParameter("cbojurado3")));
            otesista1.setId_alumno(Integer.parseInt(request.getParameter("cbotesista1")));

            omodelo_tesis.insertar_tesis(otesis);
            omodelo_tesis.insertar_jurado(ojurado1, "PRESIDENTE");
            omodelo_tesis.insertar_jurado(ojurado2, "PRIMER MIEMBRO");
            omodelo_tesis.insertar_jurado(ojurado3, "SEGUNDO MIEMBRO");
            omodelo_tesis.insertar_tesista(otesista1);
            if (!(request.getParameter("cbotesista2").equals("seleccionar"))) {
                otesista2.setId_alumno(Integer.parseInt(request.getParameter("cbotesista2")));
                omodelo_tesis.insertar_tesista(otesista2);
            }
            request.setAttribute("proceso", omodelo_tesis.insertar_proceso());
            RequestDispatcher aa = request.getRequestDispatcher("servlet_proyecto");
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
