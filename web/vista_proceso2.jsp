<jsp:useBean id="pro_02" scope="request" class="java.lang.String"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function cerrar()
            {
                opener.location.href = "servlet_tesis";
                opener.location.reload();
                window.close();
            }
        </script>
    </head>
    <body>
        <%
            if (!pro_02.isEmpty()) {
        %> <script>cerrar();</script> 
        <%}%>
    <center>
        <header>
            <h2>RESOLUCION DE APROBACION DEL ANTEPROYECTO</h2>
        </header>
        <%
            String id_tesis = request.getParameter("val");
            String numero = request.getParameter("val2");
            String titulo = request.getParameter("val3");
        %>
        <section>
            <p>EL NUMERO DE LA TESIS ES : <%=numero%></p>
            <p>EL TITULO DE LA TESIS ES : <%=titulo%></p>

            <form action="servlet_proceso2">
                <table>
                    <tr>
                        <th>Numero de Resolucion : </th>
                        <td><input type="text" name="txtnum_resol" required/></td>
                    </tr>
                    <tr>
                        <th>Fecha de Resolucion : </th>
                        <td><input type="text" name="txtfecha_resol" required/></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="id_tesis" value="<%=id_tesis%>"/></td>
                        <td colspan="2"><input type="submit" name="btnguardar" value="GUARDAR"/></td>
                    </tr>
                </table>
            </form>
        </section>
    </center>
</body>


</html>
