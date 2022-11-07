package com.tallerpatrones;

public class Creador {
    private final Notificador notificador;
    private Facebook facebook;
    private Sms sms;
    private MensajeriaEmpresarial mensajeriaEmpresarial;

    public Creador(int id) {
        this.notificador = new Notificador(id);
        /* ay no */

    }

    /**
     * @return Notificador
     */
    public Notificador crearNotificador() {
        return notificador;
    }

    /**
     * @param msg
     * @return Creador
     */
    public Creador enviarPorFacebook(String msg) {
        this.facebook = new Facebook(notificador);
        facebook.enviar(msg);
        return this;
    }

    /**
     * @param msg
     * @return Creador
     */
    public Creador enviarPorSms(String msg) {
        this.sms = new Sms(notificador);
        sms.enviar(msg);
        return this;
    }

    /**
     * @param msg
     * @return Creador
     */
    public Creador enviarPorMensajeriaEmpresarial(String msg) {
        this.mensajeriaEmpresarial = new MensajeriaEmpresarial(notificador);
        mensajeriaEmpresarial.enviar(msg);
        return this;
    }
}
