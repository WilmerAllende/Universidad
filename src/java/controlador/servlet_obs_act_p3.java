package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo_proyecto.m_tesis;

public class servlet_obs_act_p3 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            m_tesis omodelo_tesis = new m_tesis();
            String id = request.getParameter("id");

            if (id.equals("bien")) {
                int datojurado = Integer.parseInt(request.getParameter("val2"));
                int id_tesis = omodelo_tesis.op_id_tesis(datojurado);
                omodelo_tesis.update_obser_buena_p3(datojurado);
                request.setAttribute("pro_03", omodelo_tesis.selct_proceso3(id_tesis));
                RequestDispatcher aa = request.getRequestDispatcher("vista_proceso3.jsp");
                aa.forward(request, response);
            }
            if (id.equals("mal")) {
                int datojurado = Integer.parseInt(request.getParameter("val1"));
                int id_tesis = omodelo_tesis.op_id_tesis(datojurado);
                omodelo_tesis.update_obser_mala_p3(datojurado);
                request.setAttribute("pro_03", omodelo_tesis.selct_proceso3(id_tesis));
                RequestDispatcher aa = request.getRequestDispatcher("vista_proceso3.jsp");
                aa.forward(request, response);
            }
            
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
