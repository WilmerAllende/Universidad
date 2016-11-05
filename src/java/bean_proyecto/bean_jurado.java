package bean_proyecto;

public class bean_jurado {

    private int id_jurado;
    private String funcion;
    private int estado;
    private String fecha;
    private int id_docente;
    private int id_tesis;
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_jurado() {
        return id_jurado;
    }

    public void setId_jurado(int id_jurado) {
        this.id_jurado = id_jurado;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public int getId_tesis() {
        return id_tesis;
    }

    public void setId_tesis(int id_tesis) {
        this.id_tesis = id_tesis;
    }
    
    

}
