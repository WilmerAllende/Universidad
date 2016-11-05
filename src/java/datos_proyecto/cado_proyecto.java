package datos_proyecto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import bean_proyecto.*;

public class cado_proyecto {

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "");
            return miconexion;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean ejecutar(String sql) {
        try {
            Statement st = this.conectar().createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String cargarFechaYYYYMMdd() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date(System.currentTimeMillis());
        return dateFormat.format(date);

    }

    public String UltimoRegistro(String id, String tabla) {
        Statement sentencia;
        ResultSet registros;

        String ultimo = null;
        try {
            String sql = "SELECT MAX(" + id + ") AS ultimo FROM " + tabla + "";
            sentencia = this.conectar().createStatement();
            registros = sentencia.executeQuery(sql);
            registros.beforeFirst();
            if (registros.next()) {
                ultimo = registros.getString("ultimo");

            } else {
                ultimo = "1";

            }
            if (ultimo == null) {
                ultimo = "1";
            }

        } catch (Exception e) {

        }

        return ultimo;

    }

    public ArrayList<String> listar_alumno(String sql) {
        Statement st;
        ResultSet rs;
        try {
            ArrayList<String> alumno = new ArrayList<>();
            ArrayList<String> alumno_id = new ArrayList<>();
            st = this.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                alumno.add(rs.getString(1));
            }
            return alumno;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<String> listar_alumno_id(String sql) {
        Statement st;
        ResultSet rs;
        try {
            ArrayList<String> alumno = new ArrayList<>();
            ArrayList<String> alumno_id = new ArrayList<>();
            st = this.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                alumno.add(rs.getString(1));
            }
            return alumno;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<String> listar_docente(String sql) {
        Statement st;
        ResultSet rs;
        try {
            ArrayList<String> docente = new ArrayList<>();
            st = this.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                docente.add(rs.getString(1));
            }

            return docente;
        } catch (Exception e) {
            return null;
        }

    }

    public ArrayList<String> listar_docente_id(String sql) {
        Statement st;
        ResultSet rs;
        try {
            ArrayList<String> docente = new ArrayList<>();
            st = this.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                docente.add(rs.getString(1));
            }

            return docente;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<bean_auxiliar> listar_tabla(String sql) {
        Statement st, st2;
        ResultSet rs, rs2;
        try {
            ArrayList<bean_auxiliar> tabla = new ArrayList<>();
            st = this.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            st2 = this.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            rs.beforeFirst();
            //agregar los nombres y apellidos de los tesistas
            while (rs.next()) {
                String sql2 = "SELECT persona.nombre, persona.apellido FROM persona INNER JOIN alumno ON persona.id_persona = alumno.id_persona INNER JOIN alumno_tesis ON alumno.id_alumno = alumno_tesis.id_alumno INNER JOIN tesis ON tesis.id_tesis = alumno_tesis.id_tesis WHERE tesis.id_tesis=" + rs.getInt(1);
                rs2 = st2.executeQuery(sql2);
                String tesistas = "";

                rs2.beforeFirst();
                while (rs2.next()) {
                    tesistas = tesistas + rs2.getString(1) + " " + rs2.getString(2) + ", ";
                }
                tabla.add(new bean_auxiliar(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), tesistas));
            }
            return tabla;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<bean_auxiliar2> listar_obser(String sql) {
        Statement st;
        ResultSet rs;
        try {
            ArrayList<bean_auxiliar2> tabla2 = new ArrayList<>();
            st = this.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                tabla2.add(new bean_auxiliar2(rs.getInt(1), rs.getString(2) + "  " + rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7)));
            }
            return tabla2;
        } catch (Exception e) {
            return null;
        }
    }

    public int operacion(String sql) {
        Statement st;
        ResultSet rs;
        try {
            int a = 0;
            st = this.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                a = rs.getInt(1);
            }
            return a;
        } catch (Exception e) {
            return 0;
        }
    }

    public int estados(String sql) {
        Statement st;
        ResultSet rs;
        try {
            int a = 0;
            st = this.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                if(rs.getInt(1)==2){
                a++;
                }
            }
            return a;
        } catch (Exception e) {
            return 0;
        }
    }
    
    
    //LLENAR EL PDF
    public String listar_titulo(String sql) {
        Statement st;
        ResultSet rs;
        String titulo="";
        try {
            st = this.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                titulo=rs.getString(1);
            }
            return titulo;
        } catch (Exception e) {
            return null;
        }
    }
    
    public String listar_asesor(String sql) {
        Statement st;
        ResultSet rs;
        String asesor="";
        try {
            st = this.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                asesor=rs.getString(1) + " " + rs.getString(2);
            }
            return asesor;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ArrayList<String> listar_jurado(String sql) {
        Statement st;
        ResultSet rs;
        ArrayList<String> jurado = new ArrayList<>();
        try {
            st = this.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                jurado.add(rs.getString(1) + " " + rs.getString(2));
            }
            return jurado;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ArrayList<String> listar_autor(String sql) {
        Statement st;
        ResultSet rs;
        ArrayList<String> autor = new ArrayList<>();
        try {
            st = this.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                autor.add(rs.getString(1) + " " + rs.getString(2));
            }
            return autor;
        } catch (Exception e) {
            return null;
        }
    }
    
    public String listar_fecha(String sql) {
        Statement st;
        ResultSet rs;
        String asesor="";
        try {
            st = this.conectar().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                asesor=rs.getString(1);
            }
            return asesor;
        } catch (Exception e) {
            return null;
        }
    }

}
