package controlador;

import bean_proyecto.bean_alumno;
import bean_proyecto.bean_docente;
import bean_proyecto.bean_persona;
import bean_proyecto.bean_telefono;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo_proyecto.m_registrar;

public class servlet_registrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            m_registrar omodelo_registrar = new m_registrar();
            bean_persona opersona = new bean_persona();
            bean_telefono otelefono = new bean_telefono();
            bean_alumno oalumno = new bean_alumno();
            bean_docente odocente = new bean_docente();
            
            //INGRESAR DATOS A LA CLASE: PERSONA, TELEFONO, ALUMNO, DOCENTE. 
            opersona.setNombre(request.getParameter("txtnombre"));
            opersona.setApllido(request.getParameter("txtapellido"));
            opersona.setDni(request.getParameter("txtdni"));
            opersona.setCorreo(request.getParameter("txtcorreo"));
            opersona.setSexo(request.getParameter("cbosexo"));
            opersona.setFecha_nac(request.getParameter("txtfecha_nac"));
            otelefono.setNumero(request.getParameter("txttelefono"));
            oalumno.setCodigo(request.getParameter("txtcodigo"));
            odocente.setEspecialidad(request.getParameter("txtespecialidad"));

            String opc = request.getParameter("btnregistrar");
            //REGISTAR ALUMNO
            if (opc.contains("ALUMNO")) {
                omodelo_registrar.insertar_per(opersona);
                omodelo_registrar.insertar_tel(otelefono);
                request.setAttribute("nuevo_Reg", omodelo_registrar.insertar_alu(oalumno));
                RequestDispatcher aa = request.getRequestDispatcher("vista_registrar.jsp");
                aa.forward(request, response);
            }
            //REGISTAR DOCENTE
            if (opc.contains("DOCENTE")) {
                omodelo_registrar.insertar_per(opersona);
                omodelo_registrar.insertar_tel(otelefono);
                request.setAttribute("nuevo_Reg", omodelo_registrar.insertar_doc(odocente));
                RequestDispatcher aa = request.getRequestDispatcher("vista_registrar.jsp");
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
