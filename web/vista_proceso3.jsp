<jsp:useBean id="pro_03" scope="request" type="java.util.ArrayList<bean_proyecto.bean_auxiliar2>" class="java.util.ArrayList"></jsp:useBean>
<jsp:useBean id="pro_03_1" scope="request" type="java.util.ArrayList<bean_proyecto.bean_auxiliar2>" class="java.util.ArrayList"></jsp:useBean>
<jsp:useBean id="cargar3" scope="request" class="java.lang.String"></jsp:useBean>

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
            if (!cargar3.isEmpty()) {
        %> <script>cerrar();</script> 
        <%}%>
        
    <center>
        <header>
            <h1>OBSERVACIONES PROCESO 3</h1>
        </header>
        <section>
            <form>
                <%
                    if (!pro_03.isEmpty()) {
                        int idj = pro_03.get(1).getPid_jurado();
                %>
                <table border="1px">
                    <tr>
                        <th>NOMBRE JURADO</th>
                        <th>FUNCION</th>
                        <th>ESTADO</th>
                        <th>FECHA_ENTREGA</th>
                        <th colspan="2">MODIFICAR</th>
                    </tr>
                    <% int datos[] = new int[3];
                        for (int i = 0; i < pro_03.size(); i++) {
                            int valor2 = pro_03.get(i).getPid_jurado();
                            if (pro_03.get(i).getPfecha().equals("1000-01-01")) {
                                pro_03.get(i).setPfecha(" ");
                            }
                    %>
                    <tr>
                        <td><%out.println(pro_03.get(i).getPjurado());%></td>
                        <td><%out.println(pro_03.get(i).getPfuncion());%></td>

                        <td><%if (pro_03.get(i).getPestado() == 0) {%>

                            <%} else if (pro_03.get(i).getPestado() == 1) {%>
                            <img src="imagenes/icono1.gif" width="40" height="40" alt="malo"/>
                            <%  datos[i] = pro_03.get(i).getPestado(); %>
                            <input type="hidden" name="estadoAcep" value="<%out.print(datos[i]);%>" />
                            <%} else {%>
                            <img src="imagenes/icono2.gif" width="40" height="40" alt="bueno"/>
                            <%  datos[i] = pro_03.get(i).getPestado(); %>
                            <input type="hidden" name="estadoAcep" value="<%out.print(datos[i]);%>" />
                            <%}%>
                        </td>

                        <td><%out.println(pro_03.get(i).getPfecha());%></td>

                        <td><a href="servlet_obs_act_p3?val2=<%=valor2%>&id=bien">BIEN</a></td>
                        <td><a href="servlet_obs_act_p3?val1=<%=valor2%>&id=mal">MAL</a></td>
                    </tr>
                    <%}%>
                    <tr>
                        <% if (datos[0] == 2 && datos[1] == 2 && datos[2] == 2) {%>
                        <th colspan="6"><a href="servlet_proc3_act?valj=<%=idj%>">GUARDAR OBSERVACIONES</a></th>
                            <% } else {%>
                        <th colspan="6"><a href="" onclick="window.close();">GUARDAR</a><th>
                            <%}%>
                    </tr>
                </table>
                <%}%>
                
                
                
                
                <%
                    if (!pro_03_1.isEmpty()) {
                        int idj = pro_03_1.get(1).getPid_jurado();
                %>
                <table border="1px">
                    <tr>
                        <th>NOMBRE JURADO</th>
                        <th>FUNCION</th>
                        <th>ESTADO</th>
                        <th>FECHA_ENTREGA</th>
                    </tr>
                    <% int datos[] = new int[3];
                        for (int i = 0; i < pro_03_1.size(); i++) {
                            int valor2 = pro_03_1.get(i).getPid_jurado();
                            if (pro_03_1.get(i).getPfecha().equals("1000-01-01")) {
                                pro_03_1.get(i).setPfecha(" ");
                            }
                    %>
                    <tr>
                        <td><%out.println(pro_03_1.get(i).getPjurado());%></td>
                        <td><%out.println(pro_03_1.get(i).getPfuncion());%></td>
                        
                        <td><%if (pro_03_1.get(i).getPestado() == 0) {%>

                            <%} else if (pro_03_1.get(i).getPestado() == 1) {%>
                            <img src="imagenes/icono1.gif" width="40" height="40" alt="malo"/>
                            <%  datos[i] = pro_03_1.get(i).getPestado(); %>
                            <input type="hidden" name="estadoAcep" value="<%out.print(datos[i]);%>" />
                            <%} else {%>
                            <img src="imagenes/icono2.gif" width="40" height="40" alt="bueno"/>
                            <%  datos[i] = pro_03_1.get(i).getPestado(); %>
                            <input type="hidden" name="estadoAcep" value="<%out.print(datos[i]);%>" />
                            <%}%>
                        </td>
                        <td><%out.println(pro_03_1.get(i).getPfecha());%></td>
                    </tr>
                    <%}%>
                    <tr>
                        <th colspan="4"><a href="#" onclick="window.close();">GUARDAR</a><th>
                    </tr>
                </table>
                <%}%>
            </form>
        </section>
    </center>
</body>
</html>
