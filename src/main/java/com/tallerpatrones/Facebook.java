package com.tallerpatrones;

public class Facebook extends Mensaje {
    private final int id; // Corresponde al id del usuario en el archivo JSON

    public Facebook(NotificadorInterface wrapped) {
        super(wrapped);
        this.id = super.getUsuario();
    }

    /**
     * @param msg
     */
    public void enviar(String msg) {
        String Facebook = jsonManager.getUserData("facebook", id);
        String name = jsonManager.getUserData("name", id);
        System.out.println("Enviando: " + msg + " a " + name + " por Facebook: " + Facebook);

    }
}
