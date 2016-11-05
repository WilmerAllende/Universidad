<jsp:useBean id="alumno" scope="request" class="java.util.ArrayList"></jsp:useBean>
<jsp:useBean id="id_alumno" scope="request" class="java.util.ArrayList"></jsp:useBean>
<jsp:useBean id="docente" scope="request" class="java.util.ArrayList"></jsp:useBean>
<jsp:useBean id="id_docente" scope="request" class="java.util.ArrayList"></jsp:useBean>
<jsp:useBean id="proceso" scope="request" class="java.lang.String"></jsp:useBean>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            th{ text-align: right}
        </style>
    </head>
    <body>
    <center>
        <header>
            <h2>AÑADIR TESIS</h2>
            <%
                if (!proceso.isEmpty()) {
                    out.println(proceso);
                }
            %>
        </header>
        <section>
            <form action="servlet_nueva_tesis">
                <table>
                    <tr>
                        <th>TITULO :</th>
                        <td><input type="text" name="txttitulo" placeholder="ingrese titulo tesis" required/></td>
                    </tr>
                    <tr>
                        <th>NUMERO :</th>
                        <td><input type="text" name="txtnumero" placeholder="ingrese numero tesis" required/></td>
                    </tr>
                    <tr>
                        <th>FECHA :</th>
                        <td><input type="text" name="txtfecha" placeholder="ingrese fecha" required/></td>
                    </tr>
                    <tr>
                        <th>TIPO :</th>
                        <td><input type="text" name="txttipo" placeholder="ingrese tipo de tesis" required/></td>
                    </tr>
                    <tr>
                        <th>TESISTA 1 :</th>
                        <td>
                            <%
                                if (!alumno.isEmpty()) {
                            %>
                            <select name="cbotesista1">
                                <%for (int i = 0; i < alumno.size(); i++) { %>    
                                <option value="<%out.print(id_alumno.get(i));%>"><%out.println(alumno.get(i));%></option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>TESISTA 2 :</th>
                        <td>
                            <%
                                if (!alumno.isEmpty()) {
                            %>
                            <select name="cbotesista2" >
                                <option value="seleccionar">seleccionar</option>
                                <%for (int i = 0; i < alumno.size(); i++) {  %>
                                <option value="<%out.print(id_alumno.get(i));%>"><%out.println(alumno.get(i));%></option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>ASESOR :</th>
                        <td>
                            <%
                                if (!docente.isEmpty()) {
                            %>
                            <select name="cboasesor">
                                <%for (int i = 0; i < docente.size(); i++) {  %>
                                <option value="<%out.print(id_docente.get(i));%>"><%out.println(docente.get(i));%></option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>PRESIDENTE :</th>
                        <td>
                            <%
                                if (!docente.isEmpty()) {
                            %>
                            <select name="cbojurado1">
                                <%for (int i = 0; i < docente.size(); i++) {  %>
                                <option value="<%out.print(id_docente.get(i));%>"><%out.println(docente.get(i));%></option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>1 MIEMBRO :</th>
                        <td>
                            <%
                                if (!docente.isEmpty()) {
                            %>
                            <select name="cbojurado2">
                                <%for (int i = 0; i < docente.size(); i++) {  %>
                                <option value="<%out.print(id_docente.get(i));%>"><%out.println(docente.get(i));%></option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>2 MIENBRO :</th>
                        <td>
                            <%
                                if (!docente.isEmpty()) {
                            %>
                            <select name="cbojurado3">
                                <%for (int i = 0; i < docente.size(); i++) {  %>
                                <option value="<%out.print(id_docente.get(i));%>"><%out.println(docente.get(i));%></option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                </table>
                <br/><br/>
                <input type="submit" name="btn_nueva_t" value="GUARDAR"/>
                <br/><br/>
            </form>
            <a href="servlet_tesis">REGRESAR</a>
        </section>
    </center>
</body>
</html>
