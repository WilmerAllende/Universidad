<jsp:useBean id="abc" scope="request" type="java.util.ArrayList<bean_proyecto.bean_auxiliar>" class="java.util.ArrayList"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/datatables.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link href="css_proyecto.css" rel="stylesheet"/>
        <script>
            var miPopup
            function abreVentana(url, name) {
                miPopup = window.open(url, name, 'width=800 height=400, top=200, left=200');
            }
        </script>
    </head>
    <body>
    <center>
        <header>
            <h1>GESTION DE TESIS</h1>
        </header>
        <nav>
            <ul>
                <li><a href="vista_principal.jsp">INICIO</a></li>
                <li><a href="#">GESTIÓN DE TESIS</a></li>
                <li><a href="#">GESTION DE PRACTICAS PRE PROFESIONALES</a></li>
                <li><a href="#">GESTION DE PROYECCION SOCIAL</a></li>
                <li><a href="#">CONSULTAS</a></li>
                <li><a href="vista_registrar.jsp" >REGISTRAR</a></li>
            </ul>
        </nav>
    </center>

    <form action="servlet_proyecto">
        <table border="1px" style="margin-left:  80%;">
            <tr>
                <td ><input type="submit" name="btnproyecto" value="AGREGAR NUEVA TESIS"/></td>
            </tr>
        </table>
    </form>
    <br/>

    <form>
        <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <%if (!abc.isEmpty()) { %>
            <thead>
                <tr>
                    <%--<th>NUMERO</th>--%>
                    <th>TESISTA(S)</th>
                    <th>TITULO</th>
                    <th>R ANTEPROYECTO</th>
                    <th>A ANTEPROYECTO</th>
                    <th>REVISION FINAL</th>
                    <th>APROVA FINAL</th>
                </tr>
            </thead>
            <tfoot>
                <tr>
                    <%--<th>NUMERO</th>--%>
                    <th>TESISTA(S)</th>
                    <th>TITULO</th>
                    <th>R ANTEPROYECTO</th>
                    <th>A ANTEPROYECTO</th>
                    <th>REVISION FINAL</th>
                    <th>APROVA FINAL</th>
                </tr>
            </tfoot>
            <tbody>
                <%for (int i = 0; i < abc.size(); i++) {
                        String a = abc.get(i).getPnombre1();
                        String b[] = a.split(",");
                        int valor = abc.get(i).getPid_tesis();
                        String num = abc.get(i).getPnumero();
                        String tit = abc.get(i).getPtitulo();
                %>
                <tr>
                    <%--<td>
                        <%out.println(abc.get(i).getPnumero());%>
                    </td>--%>
                    <td>
                        <%out.println("  " + b[0] + "<br/>" + "  " + b[1]);%>                
                    </td>
                    <td>
                        <%out.println(abc.get(i).getPtitulo());%>
                    </td>
                    <td>
                        <%if (abc.get(i).getPp1().equals("1")) {%>
                        <a href="servlet_observaciones?val=<%=valor%>&id=proceso" target="miventana" onclick="abreVentana(this.href, this.target);" >
                            EN PROCESO</a>
                            <%} else {%>
                        <a href="servlet_observaciones?val=<%=valor%>&id=terminado" target="miventana" onclick="abreVentana(this.href, this.target);" >
                            TERMINADO</a>
                            <%}%>
                    </td>
                    <td>
                        <%if (abc.get(i).getPp2().equals("1")) {%>
                        -----
                        <%} else if (abc.get(i).getPp2().equals("2")) {%>
                        <a href="servlet_pdf?val=<%=valor%>" target="_blank" style="float: left">VER ACTA</a>
                        <a href="vista_proceso2.jsp?val=<%=valor%>&val2=<%=num%>&val3=<%=tit%>" target="miventana2" onclick="abreVentana(this.href, this.target)">EDITAR</a>
                        <%} else {%>
                        <a href="servlet_pdf?val=<%=valor%>" target="_blank">VER ACTA</a>
                        <%}%>
                    </td>
                    <td>
                        <%if (abc.get(i).getPp3().equals("1")) {%>
                        -----
                        <%} else if (abc.get(i).getPp3().equals("2")) {%>
                        <a href="servlet_proceso3?val=<%=valor%>&id=proceso" target="miventana" onclick="abreVentana(this.href, this.target);" >
                            EN PROCESO</a>
                        <%} else {%>
                        <a href="servlet_proceso3?val=<%=valor%>&id=terminado" target="miventana" onclick="abreVentana(this.href, this.target);" >
                            TERMINADO</a>
                        <%}%>
                    </td>
                    <td>
                        <%if (abc.get(i).getPp4().equals("1")) {%>
                        -----
                        <%} else if (abc.get(i).getPp4().equals("2")) {%>
                        <a href="servlet_pdf_2?val=<%=valor%>" target="_blank" style="float: left">VER ACTA</a>
                        <a href="vista_proceso4.jsp?val=<%=valor%>&val2=<%=num%>&val3=<%=tit%>" target="miventana2" onclick="abreVentana(this.href, this.target)">EDITAR</a>
                        <%} else {%>
                        <a href="servlet_pdf_2?val=<%=valor%>" target="_blank">VER ACTA</a>
                        <%}%>
                    </td>
                </tr>
                <%}%>
            </tbody>
            <%}%>
        </table>
    </form>

    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/datatables.min.js"></script>
    <script type="text/javascript" charset="utf-8">
                            $(document).ready(function () {
                                $('#example').DataTable();
                            });
    </script>
</body>
</html>
