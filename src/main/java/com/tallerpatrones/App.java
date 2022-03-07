package com.tallerpatrones;

/**
 * 
 */
public final class App {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Creador builder = new Creador(1);

        NotificadorInterface notificador = builder.crearNotificador();
        notificador.enviar("msg");

        builder = builder.enviarPorFacebook("msg")
                .enviarPorMensajeriaEmpresarial("msg");

    }
}