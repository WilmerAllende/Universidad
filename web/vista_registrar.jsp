<jsp:useBean id="nuevo_Reg" scope="request" class="java.lang.String"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css_proyecto.css" rel="stylesheet"/>
    </head>
    <body>
    <center>
        <header>
            <h1>REGISTRAR</h1>
        </header>
        <nav>
                <ul>
                    <li><a href="vista_principal.jsp">INICIO</a></li>
                    <li><a href="servlet_tesis">GESTIÓN DE TESIS</a></li>
                    <li><a href="#">GESTION DE PRACTICAS PRE PROFESIONALES</a></li>
                    <li><a href="#">GESTION DE PROYECCION SOCIAL</a></li>
                    <li><a href="#">CONSULTAS</a></li>
                    <li><a href="#">REGISTRAR</a></li>                 
                </ul>
        </nav>
        <section>
            <a href="nuevo_alumno.jsp">REGISTRAR ALUMNO</a>
            <br/><br/>
            <a href="nuevo_docente.jsp">REGISTRAR DOCENTE</a>
            <br/><br/>
            <%
                if (!nuevo_Reg.isEmpty()) {
                    out.println(nuevo_Reg);
                }
            %>
        </section>
    </center>
</body>
</html>
