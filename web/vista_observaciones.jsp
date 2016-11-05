<%@page import="org.w3c.dom.events.Event"%>
<%@page import="javax.websocket.OnClose"%>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="obs" scope="request" type="java.util.ArrayList<bean_proyecto.bean_auxiliar2>" class="java.util.ArrayList"></jsp:useBean>
<jsp:useBean id="obs2" scope="request" type="java.util.ArrayList<bean_proyecto.bean_auxiliar2>" class="java.util.ArrayList"></jsp:useBean>
<jsp:useBean id="cargar" scope="request" class="java.lang.String"></jsp:useBean>
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
            if (!cargar.isEmpty()) {
        %> <script>cerrar();</script> 
        <%}%>
        
    <center>
        <header>
            <h1>OBSERVACIONES PROCESO 1</h1>
        </header>
        <section>
            <form>
                <%
                    if (!obs.isEmpty()) {
                        int idj = obs.get(1).getPid_jurado();
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
                        for (int i = 0; i < obs.size(); i++) {
                            int valor2 = obs.get(i).getPid_jurado();
                            if (obs.get(i).getPfecha().equals("1000-01-01")) {
                                obs.get(i).setPfecha(" ");
                            }
                    %>
                    <tr>
                        <td><%out.println(obs.get(i).getPjurado());%></td>
                        <td><%out.println(obs.get(i).getPfuncion());%></td>

                        <td><%if (obs.get(i).getPestado() == 0) {%>

                            <%} else if (obs.get(i).getPestado() == 1) {%>
                            <img src="imagenes/icono1.gif" width="40" height="40" alt="malo"/>
                            <%  datos[i] = obs.get(i).getPestado(); %>
                            <input type="hidden" name="estadoAcep" value="<%out.print(datos[i]);%>" />
                            <%} else {%>
                            <img src="imagenes/icono2.gif" width="40" height="40" alt="bueno"/>
                            <%  datos[i] = obs.get(i).getPestado(); %>
                            <input type="hidden" name="estadoAcep" value="<%out.print(datos[i]);%>" />
                            <%}%>
                        </td>

                        <td><%out.println(obs.get(i).getPfecha());%></td>

                        <td><a href="servlet_obs_act?val2=<%=valor2%>&id=bien">BIEN</a></td>
                        <td><a href="servlet_obs_act?val1=<%=valor2%>&id=mal">MAL</a></td>
                    </tr>
                    <%}%>
                    <tr>
                        <% if (datos[0] == 2 && datos[1] == 2 && datos[2] == 2) {%>
                        <th colspan="6"><a href="servlet_proc_act?valj=<%=idj%>">GUARDAR OBSERVACIONES</a></th>
                            <% } else {%>
                        <th colspan="6"><a href="" onclick="window.close();">GUARDAR</a><th>
                            <%}%>
                    </tr>

                </table>
                <%}%>




                <%
                    if (!obs2.isEmpty()) {
                        int idj = obs2.get(1).getPid_jurado();
                %>
                <table border="1px">
                    <tr>
                        <th>NOMBRE JURADO</th>
                        <th>FUNCION</th>
                        <th>ESTADO</th>
                        <th>FECHA_ENTREGA</th>
                    </tr>
                    <% int datos[] = new int[3];
                        for (int i = 0; i < obs2.size(); i++) {
                            int valor2 = obs2.get(i).getPid_jurado();
                            if (obs2.get(i).getPfecha().equals("1000-01-01")) {
                                obs2.get(i).setPfecha(" ");
                            }
                    %>
                    <tr>
                        <td><%out.println(obs2.get(i).getPjurado());%></td>
                        <td><%out.println(obs2.get(i).getPfuncion());%></td>
                        
                        <td><%if (obs2.get(i).getPestado() == 0) {%>

                            <%} else if (obs2.get(i).getPestado() == 1) {%>
                            <img src="imagenes/icono1.gif" width="40" height="40" alt="malo"/>
                            <%  datos[i] = obs2.get(i).getPestado(); %>
                            <input type="hidden" name="estadoAcep" value="<%out.print(datos[i]);%>" />
                            <%} else {%>
                            <img src="imagenes/icono2.gif" width="40" height="40" alt="bueno"/>
                            <%  datos[i] = obs2.get(i).getPestado(); %>
                            <input type="hidden" name="estadoAcep" value="<%out.print(datos[i]);%>" />
                            <%}%>
                        </td>
                        <td><%out.println(obs2.get(i).getPfecha());%></td>
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
