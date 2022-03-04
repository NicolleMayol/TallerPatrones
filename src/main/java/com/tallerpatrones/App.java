package com.tallerpatrones;

/**
 * Hello world!
 */
public final class App {
    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        NotificadorInterface facebook = new Sms(new Notificador(0));
        facebook.enviar("Hello World!");
    }
}
