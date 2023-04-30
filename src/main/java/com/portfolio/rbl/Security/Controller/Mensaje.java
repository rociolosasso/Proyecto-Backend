
package com.portfolio.rbl.Security.Controller;


public class Mensaje {
    private String mensaje;
    
    //const

    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    //G&S

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
