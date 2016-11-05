package modelo_proyecto;

import bean_proyecto.*;
import datos_proyecto.cado_proyecto;
import java.util.ArrayList;

public class m_tesis {

    cado_proyecto ocado_pro = new cado_proyecto();

    public String insertar_tesis(bean_tesis tesis) {
        try {
            String sql = "INSERT INTO tesis VALUES(0,'" + tesis.getNumero() + "', '" + tesis.getTitulo() + "', '" + tesis.getFecha() + "', '" + tesis.getTipo() + "', 1," + tesis.getId_docente() + ")";
            if (ocado_pro.ejecutar(sql)) {
                return "tesis registrado correctamente";
            } else {
                return "incorrectoinser_tesis";
            }
        } catch (Exception e) {
            return "incorrectodocccc";
        }
    }

    public String insertar_jurado(bean_jurado jurado, String funcion) {
        try {
            String sql = "INSERT INTO jurado_tesis VALUES (0, '" + funcion + "', 0, '1000-01-01', 0, '1000-01-01', " + jurado.getId_docente() + ","
                    + Integer.parseInt(ocado_pro.UltimoRegistro("id_tesis", "tesis")) + ")";
            if (ocado_pro.ejecutar(sql)) {
                return "jurado registrado correctamente";
            } else {
                return "incorrectojurado";
            }
        } catch (Exception e) {
            return "incorrectodocccc";
        }
    }

    public String insertar_tesista(bean_tesistas tesista) {
        try {
            String sql = "INSERT INTO alumno_tesis VALUES (" + 0 + ",1," + tesista.getId_alumno() + ","
                    + Integer.parseInt(ocado_pro.UltimoRegistro("id_tesis", "tesis")) + ")";
            if (ocado_pro.ejecutar(sql)) {
                return "tesista registrado correctamente";
            } else {
                return "incorrectoDOC";
            }
        } catch (Exception e) {
            return "incorrectodocccc";
        }
    }

    public String insertar_proceso() {
        try {
            String sql = "INSERT INTO proceso (id_proceso, proceso_1, proceso_2, proceso_3, proceso_4, id_tesis ) VALUES (0,1,1,1,1, " + Integer.parseInt(ocado_pro.UltimoRegistro("id_tesis", "tesis")) + ")";
            if (ocado_pro.ejecutar(sql)) {
                return "PROCESO DE TESIS REGISTRADO CORRECTAMENTE";
            } else {
                return "incorrectoTESIS";
            }
        } catch (Exception e) {
            return "incorrectesss";
        }
    }

    public ArrayList<String> selct_alumno() {
        try {
            String sql = "SELECT p.nombre FROM persona p JOIN alumno a USING(id_persona)";
            return ocado_pro.listar_alumno(sql);
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<String> selct_alumno_id() {
        try {
            String sql = "SELECT a.id_alumno FROM persona p JOIN alumno a USING(id_persona)";
            return ocado_pro.listar_alumno(sql);
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<String> selct_docente() {
        try {
            String sql = "SELECT p.nombre FROM persona p JOIN docente d USING(id_persona)";
            return ocado_pro.listar_docente(sql);
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<String> selct_docente_id() {
        try {
            String sql = "SELECT d.id_docente FROM persona p JOIN docente d USING(id_persona)";
            return ocado_pro.listar_docente(sql);
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<bean_auxiliar> selct_proceso() {
        try {
            String sql = "SELECT tesis.id_tesis,tesis.numero, tesis.titulo,proceso.proceso_1,proceso.proceso_2,proceso.proceso_3,proceso.proceso_4 FROM tesis INNER JOIN proceso on tesis.id_tesis = proceso.id_tesis";
            return ocado_pro.listar_tabla(sql);
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<bean_auxiliar2> selct_obser(int dato) {
        try {
            String sql = "SELECT jurado_tesis.id_jurado, persona.nombre,persona.apellido, jurado_tesis.funcion,jurado_tesis.estado, proceso.proceso_1, jurado_tesis.fecha_entrega FROM persona \n"
                    + "INNER JOIN docente ON persona.id_persona=docente.id_persona \n"
                    + "INNER JOIN jurado_tesis ON docente.id_docente=jurado_tesis.id_docente \n"
                    + "INNER JOIN tesis on jurado_tesis.id_tesis=tesis.id_tesis \n"
                    + "INNER JOIN proceso ON proceso.id_tesis=tesis.id_tesis\n"
                    + "where tesis.id_tesis=" + dato;
            return ocado_pro.listar_obser(sql);
        } catch (Exception e) {
            return null;
        }
    }

    public String update_obser_mala(int datojurado) {
        try {
            String sql = "UPDATE jurado_tesis SET estado=1, fecha_entrega='" + ocado_pro.cargarFechaYYYYMMdd() + "' WHERE id_jurado=" + datojurado;
            if (ocado_pro.ejecutar(sql)) {
                return "actualizado mala";
            } else {
                return "incorrectoObse_mala";
            }
        } catch (Exception e) {
            return "incorrectobsermmm";
        }
    }

    public String update_obser_buena(int datojurado) {
        try {
            String sql = "UPDATE jurado_tesis SET estado=2, fecha_entrega='" + ocado_pro.cargarFechaYYYYMMdd() + "' WHERE id_jurado=" + datojurado;
            if (ocado_pro.ejecutar(sql)) {
                return "actualizado buena";
            } else {
                return "incorrectoObse_buena";
            }
        } catch (Exception e) {
            return "incorrectobserbbbb";
        }
    }

    public int op_id_tesis(int datojurado) {
        try {
            String sql = "SELECT id_tesis FROM jurado_tesis WHERE id_jurado=" + datojurado;
            return ocado_pro.operacion(sql);

        } catch (Exception e) {
            return 0;
        }
    }

    public int selct_estados(int id_tesis) {
        try {
            String sql = "SELECT estado from jurado_tesis WHERE id_tesis=" + id_tesis;
            return ocado_pro.estados(sql);
        } catch (Exception e) {
            return 0;
        }
    }

    public String update_estado_proceso(int datotesis) {
        try {
            String sql = "UPDATE proceso SET proceso_1 = 2, proceso_2 = 2, fecha_1='" + ocado_pro.cargarFechaYYYYMMdd() + "' WHERE id_tesis=" + datotesis;
            if (ocado_pro.ejecutar(sql)) {
                return "actualizado p1";
            } else {
                return "incorrectop1";
            }
        } catch (Exception e) {
            return "incorrectop111";
        }
    }

    //LLENAR EL PDF
    public String selct_titulo(int dato) {
        try {
            String sql = "SELECT tesis.titulo FROM tesis WHERE tesis.id_tesis=" + dato;
            return ocado_pro.listar_titulo(sql);
        } catch (Exception e) {
            return null;
        }
    }

    public String selct_asesor(int dato) {
        try {
            String sql = "SELECT persona.nombre, persona.apellido FROM tesis "
                    + "INNER JOIN docente ON tesis.id_docente=docente.id_docente "
                    + "INNER JOIN persona ON persona.id_persona=docente.id_persona "
                    + "WHERE tesis.id_tesis=" + dato;
            return ocado_pro.listar_asesor(sql);
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<String> selct_jurado(int dato) {
        try {
            String sql = "SELECT persona.nombre, persona.apellido FROM tesis "
                    + "INNER JOIN jurado_tesis ON jurado_tesis.id_tesis=tesis.id_tesis \n"
                    + "INNER JOIN docente ON docente.id_docente=jurado_tesis.id_docente\n"
                    + "INNER JOIN persona ON persona.id_persona=docente.id_persona WHERE tesis.id_tesis=" + dato;
            return ocado_pro.listar_jurado(sql);
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<String> selct_autor(int dato) {
        try {
            String sql = "SELECT persona.nombre, persona.apellido FROM tesis "
                    + "INNER JOIN alumno_tesis ON alumno_tesis.id_tesis=tesis.id_tesis "
                    + "INNER JOIN alumno ON alumno.id_alumno=alumno_tesis.id_alumno "
                    + "INNER JOIN persona ON persona.id_persona=alumno.id_persona WHERE tesis.id_tesis=" + dato;
            return ocado_pro.listar_autor(sql);
        } catch (Exception e) {
            return null;
        }
    }

    public String selct_fecha(int dato) {
        try {
            String sql = "SELECT proceso.fecha_1 FROM proceso "
                    + "INNER JOIN tesis ON tesis.id_tesis=proceso.id_tesis WHERE tesis.id_tesis=" + dato;
            return ocado_pro.listar_fecha(sql);
        } catch (Exception e) {
            return null;
        }
    }

    public String update_estado_proceso2(int id_tesis, String numero, String fecha) {
        try {
            String sql = "UPDATE proceso SET proceso_2 = 3, proceso_3 = 2, fecha_2='" + fecha + "', resolucion2='" + numero + "' WHERE id_tesis=" + id_tesis;
            if (ocado_pro.ejecutar(sql)) {
                return "actualizado p2";
            } else {
                return "incorrectop2";
            }
        } catch (Exception e) {
            return "incorrectop2";
        }
    }

    //REVISAR CONSULTA
    public ArrayList<bean_auxiliar2> selct_proceso3(int dato) {
        try {
            String sql = "SELECT jurado_tesis.id_jurado, persona.nombre,persona.apellido, jurado_tesis.funcion,jurado_tesis.estado2, proceso.proceso_3, jurado_tesis.fecha_entrega2 FROM persona \n"
                    + "INNER JOIN docente ON persona.id_persona=docente.id_persona \n"
                    + "INNER JOIN jurado_tesis ON docente.id_docente=jurado_tesis.id_docente \n"
                    + "INNER JOIN tesis on jurado_tesis.id_tesis=tesis.id_tesis \n"
                    + "INNER JOIN proceso ON proceso.id_tesis=tesis.id_tesis \n"
                    + "where tesis.id_tesis=" + dato;
            return ocado_pro.listar_obser(sql);
        } catch (Exception e) {
            return null;
        }
    }
    
    public String update_obser_mala_p3(int datojurado) {
        try {
            String sql = "UPDATE jurado_tesis SET estado2=1, fecha_entrega2='" + ocado_pro.cargarFechaYYYYMMdd() + "' WHERE id_jurado=" + datojurado;
            if (ocado_pro.ejecutar(sql)) {
                return "actualizado mala";
            } else {
                return "incorrectoObse_mala";
            }
        } catch (Exception e) {
            return "incorrectobsermmm";
        }
    }

    public String update_obser_buena_p3(int datojurado) {
        try {
            String sql = "UPDATE jurado_tesis SET estado2=2, fecha_entrega2='" + ocado_pro.cargarFechaYYYYMMdd() + "' WHERE id_jurado=" + datojurado;
            if (ocado_pro.ejecutar(sql)) {
                return "actualizado buena";
            } else {
                return "incorrectoObse_buena";
            }
        } catch (Exception e) {
            return "incorrectobserbbbb";
        }
    }
    
    public String update_estado_proceso3(int datotesis) {
        try {
            String sql = "UPDATE proceso SET proceso_3 = 3, proceso_4 = 2, fecha_3='" + ocado_pro.cargarFechaYYYYMMdd() + "' WHERE id_tesis=" + datotesis;
            if (ocado_pro.ejecutar(sql)) {
                return "actualizado p1";
            } else {
                return "incorrectop1";
            }
        } catch (Exception e) {
            return "incorrectop111";
        }
    }
    
    public String update_estado_proceso4(int id_tesis, String numero, String fecha) {
        try {
            String sql = "UPDATE proceso SET proceso_4 = 3, fecha_4='" + fecha + "', resolucion4='" + numero + "' WHERE id_tesis=" + id_tesis;
            if (ocado_pro.ejecutar(sql)) {
                return "actualizado p2";
            } else {
                return "incorrectop2";
            }
        } catch (Exception e) {
            return "incorrectop2";
        }
    }
}
