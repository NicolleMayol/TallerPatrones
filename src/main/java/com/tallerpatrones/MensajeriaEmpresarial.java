package com.tallerpatrones;

public class MensajeriaEmpresarial extends Mensaje {

    private final int id;

    public MensajeriaEmpresarial(NotificadorInterface wrapped) {
        super(wrapped);
        this.id = super.getUsuario();
    }

    public void enviar(String msg) {
        super.enviar(msg);
        String empresarial = jsonManager.getUserData("empresarial", id);
        String name = jsonManager.getUserData("name", id);
        System.out.println("Enviando:  " + msg + " a " + name + "por Mensajeria Empresarial: " + empresarial);
    }
}
