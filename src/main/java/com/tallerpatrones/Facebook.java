package com.tallerpatrones;

public class Facebook extends Mensaje {
    private final int id;

    public Facebook(NotificadorInterface wrapped) {
        super(wrapped);
        this.id = super.getUsuario();
    }

    public void enviar(String msg) {
        super.enviar(msg);
        String Facebook = jsonManager.getUserData("facebook", id);
        String name = jsonManager.getUserData("name", id);
        System.out.println("Enviando: " + msg + " a " + name + " por Facebook: " + Facebook);

    }
}
