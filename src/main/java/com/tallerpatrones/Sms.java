package com.tallerpatrones;

public class Sms extends Mensaje {

    private final int id;

    public Sms(NotificadorInterface wrapped) {
        super(wrapped);
        this.id = super.getUsuario();
    }

    /**
     * @param msg
     */
    public void enviar(String msg) {
        String sms = jsonManager.getUserData("sms", id);
        String name = jsonManager.getUserData("name", id);
        System.out.println("Enviando: '" + msg + "' a " + name + " por Sms al número: " + sms);
    }
}
