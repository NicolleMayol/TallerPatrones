package com.tallerpatrones;

public class Notificador implements NotificadorInterface {
    private final int id;

    public Notificador(int id) {
        this.id = id;
    }

    /**
     * @param msg
     */
    @Override
    public void enviar(String msg) {
        String mail = jsonManager.getUserData("email", id);
        String name = jsonManager.getUserData("name", id);
        System.out.println("Enviando:  " + msg + " a " + name + " por el email " + mail);
    }

    /**
     * @return int
     */
    @Override
    public int getUsuario() {
        return id;
    }
}
