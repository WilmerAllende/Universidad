package bean_proyecto;

public class bean_auxiliar2 {
    
    private int pid_jurado;
    private String pjurado;
    private String pfuncion;
    private int pestado;
    private int pproceso1;
    private String pfecha;

    public bean_auxiliar2() {
    }

    public bean_auxiliar2(int pid_jurado, String pjurado, String pfuncion, int pestado, int pproceso1, String pfecha) {
        this.pid_jurado = pid_jurado;
        this.pjurado = pjurado;
        this.pfuncion = pfuncion;
        this.pestado = pestado;
        this.pproceso1 = pproceso1;
        this.pfecha = pfecha;
    }

    public int getPid_jurado() {
        return pid_jurado;
    }

    public void setPid_jurado(int pid_jurado) {
        this.pid_jurado = pid_jurado;
    }

    public String getPjurado() {
        return pjurado;
    }

    public void setPjurado(String pjurado) {
        this.pjurado = pjurado;
    }

    public String getPfuncion() {
        return pfuncion;
    }

    public void setPfuncion(String pfuncion) {
        this.pfuncion = pfuncion;
    }

    public int getPestado() {
        return pestado;
    }

    public void setPestado(int pestado) {
        this.pestado = pestado;
    }

    public int getPproceso1() {
        return pproceso1;
    }

    public void setPproceso1(int pproceso1) {
        this.pproceso1 = pproceso1;
    }

    public String getPfecha() {
        return pfecha;
    }

    public void setPfecha(String pfecha) {
        this.pfecha = pfecha;
    }

    
    
}
