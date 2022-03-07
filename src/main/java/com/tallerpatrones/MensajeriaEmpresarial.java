package com.tallerpatrones;

public class MensajeriaEmpresarial extends Mensaje {

    private final int id; // Corresponde al id del usuario en el archivo JSON

    public MensajeriaEmpresarial(NotificadorInterface wrapped) {
        super(wrapped);
        this.id = super.getUsuario();
    }

    /**
     * @param msg: corresponde al mensaje que se desea enviar al usuario.
     */
    public void enviar(String msg) {
        String empresarial = jsonManager.getUserData("empresarial", id);
        String name = jsonManager.getUserData("name", id);
        System.out.println("Enviando:  " + msg + " a " + name + " por Mensajeria Empresarial: " + empresarial);
    }
}
