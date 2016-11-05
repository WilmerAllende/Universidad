package modelo_proyecto;

import bean_proyecto.*;
import datos_proyecto.cado_proyecto;

public class m_registrar {

    cado_proyecto ocado_registrar = new cado_proyecto();

    public String insertar_per(bean_persona persona) {
        try {
            String sql = "INSERT INTO persona VALUES (0, '" + persona.getNombre() + "', '" + persona.getApllido()
                    + "', '" + persona.getDni() + "', '" + persona.getCorreo() + "', '" + persona.getSexo() + "', '" + persona.getFecha_nac()
                    + "', '" + ocado_registrar.cargarFechaYYYYMMdd() + "'," + " '1000-01-01')";
            if (ocado_registrar.ejecutar(sql)) {
                return "persona guardado correctamente";
            } else {
                return "incorrectoPER";
            }
        } catch (Exception e) {
            return "incorrectoPERRR";
        }
    }

    public String insertar_tel(bean_telefono telefono) {
        try {
            String sql = "INSERT INTO telefono VALUES (0, '" + telefono.getNumero() + "', "
                    + Integer.parseInt(ocado_registrar.UltimoRegistro("id_persona", "persona")) + ")";
            if (ocado_registrar.ejecutar(sql)) {
                return "telefono guardado correctamente";
            } else {
                return "incorrectoTEL";
            }
        } catch (Exception e) {
            return "incorrectoTELL";
        }
    }

    public String insertar_alu(bean_alumno alumno) {
        try {
            String sql = "INSERT INTO alumno VALUES (" + 0 + ", '" + alumno.getCodigo() + "', 1, "
                    + Integer.parseInt(ocado_registrar.UltimoRegistro("id_persona", "persona")) + ")";
            if (ocado_registrar.ejecutar(sql)) {
                return "alumno registrado correctamente";
            } else {
                return "incorrectoALU";
            }
        } catch (Exception e) {
            return "incorrectoalummm";
        }
    }

    public String insertar_doc(bean_docente docente) {
        try {
            String sql = "INSERT INTO docente VALUES (0, '" + docente.getEspecialidad() + "', "
                    + Integer.parseInt(ocado_registrar.UltimoRegistro("id_persona", "persona")) + ",1)";
            if (ocado_registrar.ejecutar(sql)) {
                return "docente registrado correctamente";
            } else {
                return "incorrectoDOC";
            }
        } catch (Exception e) {
            return "incorrectodocccc";
        }
    }

}
