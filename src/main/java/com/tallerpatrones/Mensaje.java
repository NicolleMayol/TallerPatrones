package com.tallerpatrones;

public abstract class Mensaje implements NotificadorInterface {

    private final NotificadorInterface wrapped;

    Mensaje(NotificadorInterface wrapped) {
        this.wrapped = wrapped;
    }

    /**
     * @param msg
     */
    @Override
    public void enviar(String msg) {
        wrapped.enviar(msg);
    }

    /**
     * @return int
     */
    @Override
    public int getUsuario() {
        return wrapped.getUsuario();
    }
}
