package com.tallerpatrones;

public interface NotificadorInterface {
    void enviar(String mensaje);

    int getUsuario();
    
    public final JSONManager jsonManager = new JSONManager();
}
