package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo_proyecto.m_tesis;

public class servlet_pdf_2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/pdf");
        
        try (OutputStream out = response.getOutputStream()) {
            m_tesis omodelo = new m_tesis();
            int dato = Integer.parseInt(request.getParameter("val"));
            String titulo = omodelo.selct_titulo(dato);
            String asesor = omodelo.selct_asesor(dato);
            String fecha = omodelo.selct_fecha(dato);
            ArrayList<String> jurado = omodelo.selct_jurado(dato);
            ArrayList<String> autor = omodelo.selct_autor(dato);

            try {
                Document documento = new Document();
                PdfWriter writer = PdfWriter.getInstance(documento, out);
                documento.open();

                Image imaunprg = Image.getInstance("C:\\Users\\PC\\Documents\\NetBeansProjects\\proyecto_02\\imagenes\\logo_unprg.gif");
                imaunprg.setAlignment(Element.ALIGN_LEFT);
                imaunprg.scaleToFit(80, 80);
                imaunprg.setAbsolutePosition(60, 720);

                Paragraph par1 = new Paragraph();
                par1.add(new Phrase(Chunk.NEWLINE));
                Font ftitulo = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL, BaseColor.BLACK);
                par1.add(new Phrase("UNIVERSIDAD NACIONAL PEDRO RUIZ GALLO\n FACULTAD DE INGENIERIA DE SISTEMAS Y ARQUITECTURA"
                        + "\n ESCUELA PROFESIONAL DE INGENIERIA DE SISTEMAS", ftitulo));
                par1.setAlignment(Element.ALIGN_CENTER);
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));

                Paragraph par2 = new Paragraph();
                Font fdescr = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.BLACK);
                par2.add(new Phrase("SISTEMA DE EVALUACION DEL TRABAJO FINAL DE CARRERA PROFESIONAL", fdescr));
                par2.setAlignment(Element.ALIGN_CENTER);
                par2.setSpacingAfter(-8);

                Paragraph par3 = new Paragraph();
                Font fdescr2 = new Font(Font.FontFamily.HELVETICA, 6, Font.NORMAL, BaseColor.BLACK);
                par3.add(new Phrase("(Basado en el Modelo de Calidad para la acreditacion de las carreras profesionales de "
                        + "Ingenieria y Arquitectura - Dimension II - Factor 3 - Esatndar 47)", fdescr2));
                par3.setAlignment(Element.ALIGN_CENTER);
                par3.add(new Phrase(Chunk.NEWLINE));
                par3.add(new Phrase(Chunk.NEWLINE));

                Image imagenes3 = Image.getInstance("C:\\Users\\PC\\Documents\\NetBeansProjects\\proyecto_02\\imagenes\\logo_epis.gif");
                imagenes3.setAlignment(Element.ALIGN_RIGHT);
                imagenes3.scaleToFit(60, 60);
                imagenes3.setAbsolutePosition(480, 720);

                Paragraph par4 = new Paragraph();
                Font fdescr3 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK);
                par4.add(new Phrase("FORMATO B\n ACTA DE APROBACION Y FECHA DE SUSTENTACIONDE TESIS/\n INFORME DE TITULACION", fdescr3));
                par4.setAlignment(Element.ALIGN_CENTER);
                par4.add(new Phrase(Chunk.NEWLINE));
                par4.add(new Phrase(Chunk.NEWLINE));

                documento.add(par1);
                documento.add(par2);
                documento.add(par3);
                documento.add(par4);
                documento.add(imaunprg);
                documento.add(imagenes3);

                //DATOS DEL PROYECTO DE TESIS
                Paragraph par31 = new Paragraph();
                Font fdescr31 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK);
                par31.add(new Phrase("NOMBRE DEL PROYECTO:", fdescr31));
                par31.setAlignment(Element.ALIGN_JUSTIFIED);
                par31.setIndentationLeft(36);
                par31.setIndentationRight(36);
                par31.add(new Phrase(Chunk.NEWLINE));
                documento.add(par31);

                Paragraph par32 = new Paragraph();
                Font fdescr32 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                par32.add(new Phrase(titulo, fdescr32));
                par32.setAlignment(Element.ALIGN_JUSTIFIED);
                par32.setIndentationLeft(36);
                par32.setIndentationRight(36);
                par32.add(new Phrase(Chunk.NEWLINE));
                par32.add(new Phrase(Chunk.NEWLINE));
                documento.add(par32);

                Paragraph par33 = new Paragraph();
                Font fdescr33 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK);
                par33.add(new Phrase("CODIGO DEL PROYECTO: IS-", fdescr33));
                par33.setAlignment(Element.ALIGN_JUSTIFIED);
                par33.setIndentationLeft(36);
                par33.setIndentationRight(36);
                par33.add(new Phrase(Chunk.NEWLINE));
                par33.add(new Phrase(Chunk.NEWLINE));
                documento.add(par33);

                //DATOS DEL AUTOR
                Paragraph par41 = new Paragraph();
                Font fdescr41 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK);
                par41.add(new Phrase("AUTOR(ES):", fdescr41));
                par41.setAlignment(Element.ALIGN_JUSTIFIED);
                par41.setIndentationLeft(36);
                par41.setIndentationRight(36);
                par41.add(new Phrase(Chunk.NEWLINE));
                documento.add(par41);

                if (autor.size() == 2) {
                    Paragraph par5 = new Paragraph();
                    Font fdescr5 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                    par5.add(new Phrase(autor.get(0), fdescr5));
                    par5.add(new Phrase(Chunk.NEWLINE));
                    par5.add(new Phrase(autor.get(1), fdescr5));
                    par5.setAlignment(Element.ALIGN_JUSTIFIED);
                    par5.setIndentationLeft(36);
                    par5.setIndentationRight(36);
                    par5.add(new Phrase(Chunk.NEWLINE));
                    par5.add(new Phrase(Chunk.NEWLINE));
                    documento.add(par5);
                } else {
                    Paragraph par5 = new Paragraph();
                    Font fdescr5 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                    par5.add(new Phrase(autor.get(0), fdescr5));
                    par5.setAlignment(Element.ALIGN_JUSTIFIED);
                    par5.setIndentationLeft(36);
                    par5.setIndentationRight(36);
                    par5.add(new Phrase(Chunk.NEWLINE));
                    par5.add(new Phrase(Chunk.NEWLINE));
                    documento.add(par5);
                }

                //DATOS DEL ASESOR
                Paragraph par6 = new Paragraph();
                Font fdescr6 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK);
                par6.add(new Phrase("ASESOR:", fdescr6));
                par6.setAlignment(Element.ALIGN_JUSTIFIED);
                par6.setIndentationLeft(36);
                par6.setIndentationRight(36);
                par6.add(new Phrase(Chunk.NEWLINE));
                documento.add(par6);

                Paragraph par7 = new Paragraph();
                Font fdescr7 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                par7.add(new Phrase(asesor, fdescr7));
                par7.setAlignment(Element.ALIGN_JUSTIFIED);
                par7.setIndentationLeft(36);
                par7.setIndentationRight(36);
                par7.add(new Phrase(Chunk.NEWLINE));
                par7.add(new Phrase(Chunk.NEWLINE));
                documento.add(par7);

                //DATOS DEL JURADO
                Paragraph par8 = new Paragraph();
                Font fdescr8 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK);
                par8.add(new Phrase("JURADO:", fdescr8));
                par8.setAlignment(Element.ALIGN_JUSTIFIED);
                par8.setIndentationLeft(36);
                par8.setIndentationRight(36);
                par8.add(new Phrase(Chunk.NEWLINE));
                documento.add(par8);

                Paragraph par9 = new Paragraph();
                Font fdescr9 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                par9.add(new Phrase("Presidente  : " + jurado.get(0), fdescr9));
                par9.add(new Phrase(Chunk.NEWLINE));
                par9.add(new Phrase("1 miembro  : " + jurado.get(1), fdescr9));
                par9.add(new Phrase(Chunk.NEWLINE));
                par9.add(new Phrase("2 miembro  : " + jurado.get(2), fdescr9));
                par9.setAlignment(Element.ALIGN_JUSTIFIED);
                par9.setIndentationLeft(36);
                par9.setIndentationRight(36);
                par9.add(new Phrase(Chunk.NEWLINE));
                par9.add(new Phrase(Chunk.NEWLINE));
                documento.add(par9);

                //DICTAMEN
                Paragraph par10 = new Paragraph();
                Font fdescr10 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK);
                par10.add(new Phrase("DICTAMEN:", fdescr10));
                par10.setAlignment(Element.ALIGN_JUSTIFIED);
                par10.setIndentationLeft(36);
                par10.setIndentationRight(36);
                par10.add(new Phrase(Chunk.NEWLINE));
                documento.add(par10);

                Paragraph par11 = new Paragraph();
                Font fdescr11 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                par11.add(new Phrase("El jurado dictamina que el contenido del desarrollo del proyecto esta conforme por lo"
                        + "que se podra sustentar de acuerdo al siguiente detalle: ", fdescr11));
                par11.setAlignment(Element.ALIGN_JUSTIFIED);
                par11.setIndentationLeft(36);
                par11.setIndentationRight(36);
                par11.add(new Phrase(Chunk.NEWLINE));
                par11.add(new Phrase(Chunk.NEWLINE));
                documento.add(par11);
                
                Paragraph par12 = new Paragraph();
                Font fdescr12 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                par12.add(new Phrase("FECHA DE SUSTENTACION: ", fdescr12));
                par12.setAlignment(Element.ALIGN_JUSTIFIED);
                par12.setIndentationLeft(36);
                par12.setIndentationRight(36);
                par12.add(new Phrase(Chunk.NEWLINE));
                par12.add(new Phrase(Chunk.NEWLINE));
                documento.add(par12);
                
                Paragraph par13 = new Paragraph();
                Font fdescr13 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                par13.add(new Phrase("HORA: ", fdescr13));
                par13.setAlignment(Element.ALIGN_JUSTIFIED);
                par13.setIndentationLeft(36);
                par13.setIndentationRight(36);
                par13.add(new Phrase(Chunk.NEWLINE));
                par13.add(new Phrase(Chunk.NEWLINE));
                documento.add(par13);
                
                Paragraph par21 = new Paragraph();
                Font fdescr21 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                par21.add(new Phrase("Presidente del Jurado", fdescr21));
                par21.setAlignment(Element.ALIGN_JUSTIFIED);
                par21.setIndentationLeft(95);
                par21.setSpacingBefore(42);
                documento.add(par21);
                
                Paragraph par22 = new Paragraph();
                Font fdescr22 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                par22.add(new Phrase("Primer Miembro", fdescr22));
                par22.setAlignment(Element.ALIGN_RIGHT);
                par22.setIndentationRight(100);
                par22.setSpacingBefore(-17);
                documento.add(par22);
                
                Paragraph par23 = new Paragraph();
                Font fdescr23 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
                par23.add(new Phrase("Segundo Miembro", fdescr23));
                par23.setAlignment(Element.ALIGN_JUSTIFIED);
                par23.setIndentationLeft(220);
                par23.setSpacingBefore(35);
                documento.add(par23);

                PdfContentByte canvas = writer.getDirectContent();
                canvas.setColorStroke(BaseColor.BLACK);
                canvas.moveTo(230, 177);
                canvas.lineTo(130, 177);
                canvas.closePathStroke();

                canvas.moveTo(470, 177);
                canvas.lineTo(370, 177);
                canvas.closePathStroke();
                
                canvas.moveTo(250, 127);
                canvas.lineTo(350, 127);
                canvas.closePathStroke();

                documento.close();
            } catch (Exception ex) {
                ex.getMessage();
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
