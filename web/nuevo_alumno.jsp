<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <center>
                <h2>DATOS DEL ALUMNO</h2>
            </center>
        </header>
        <section style="text-align: right">
            <center>
                <form action="servlet_registrar">
                    <table border = 1px>
                        <tr>
                            <th>NOMBRE : </th>
                            <td><input type="text" name="txtnombre" placeholder="ingrese sus nombres" required/></td>
                        </tr>
                        <tr>
                            <th>APELLIDO : </th>
                            <td><input type="text" name="txtapellido" placeholder="ingrese sus apellidos" required/></td>
                        </tr>
                        <tr>
                            <th>DNI : </th>
                            <td><input type="text" name="txtdni" placeholder="ingrese su dni" required/></td>
                        </tr>
                        <tr>
                            <th>CORREO : </th>
                            <td><input type="text" name="txtcorreo" placeholder="ingrese su correo" required/></td>
                        </tr>
                        <tr>
                            <th>SEXO : </th>
                            <td><select name="cbosexo">
                                    <option value="MASCULINO">MASCULINO</option>
                                    <option value="FEMENINO">FEMENINO</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>FECHA NACIMIENTO : </th>
                            <td><input type="text" name="txtfecha_nac" placeholder="ingrese su fecha_nac" required/></td>
                        </tr>
                        <tr>
                            <th>TELEFONO : </th>
                            <td><input type="text" name="txttelefono" placeholder="ingrese su telefono" required/></td>
                        </tr>
                        <tr>
                            <th>CODIGO : </th>
                            <td><input type="text" name="txtcodigo" placeholder="ingrese su codigo" required/></td>
                        </tr>
                        <tr>
                            <th colspan="2"><input type="submit" name="btnregistrar" value="GUARDAR DATOS DEL ALUMNO"/></th>
                        </tr>   
                    </table>
                    <br/>
                    <br/>
                    <a href="vista_registrar.jsp">REGRESAR</a>
                </form>
            </center>
        </section>
    </body>
</html>
