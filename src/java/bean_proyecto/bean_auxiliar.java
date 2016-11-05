package bean_proyecto;
public class bean_auxiliar {
    private int pid_tesis;
    private String pnumero;
    private String ptitulo;
    private String pp1;
    private String pp2;
    private String pp3;
    private String pp4;
    private String pnombre1;

    public bean_auxiliar() {
    }

    public bean_auxiliar(int pid_tesis, String pnumero, String ptitulo, String pp1, String pp2, String pp3, String pp4, String pnombre1) {
        this.pid_tesis = pid_tesis;
        this.pnumero = pnumero;
        this.ptitulo = ptitulo;
        this.pp1 = pp1;
        this.pp2 = pp2;
        this.pp3 = pp3;
        this.pp4 = pp4;
        this.pnombre1 = pnombre1;
    }

    public String getPnumero() {
        return pnumero;
    }

    public void setPnumero(String pnumeor) {
        this.pnumero = pnumeor;
    }
    
    

    public int getPid_tesis() {
        return pid_tesis;
    }

    public void setPid_tesis(int pid_tesis) {
        this.pid_tesis = pid_tesis;
    }

    public String getPtitulo() {
        return ptitulo;
    }

    public void setPtitulo(String ptitulo) {
        this.ptitulo = ptitulo;
    }

    public String getPp1() {
        return pp1;
    }

    public void setPp1(String pp1) {
        this.pp1 = pp1;
    }

    public String getPp2() {
        return pp2;
    }

    public void setPp2(String pp2) {
        this.pp2 = pp2;
    }

    public String getPp3() {
        return pp3;
    }

    public void setPp3(String pp3) {
        this.pp3 = pp3;
    }

    public String getPp4() {
        return pp4;
    }

    public void setPp4(String pp4) {
        this.pp4 = pp4;
    }

    public String getPnombre1() {
        return pnombre1;
    }

    public void setPnombre1(String pnombre1) {
        this.pnombre1 = pnombre1;
    }   
    
}
