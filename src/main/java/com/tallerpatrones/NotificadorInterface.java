package com.tallerpatrones;

/*
*  Este componente define las operaciones enviar y getUsuario, las cuales serán alteradas por los decoradores
*  (Facebook, Sms, Mensaje y MensajeríaEmpresarial). Asimismo, crea un objeto 
*  JSONManager que, tal como lo explica se nombre, se encarga de manejar la lectura 
*  y postereor parseo del objeto JSON donde se encuentran definidos los datos de los usuarios.
* 
*  Las clases Mensaje y Notificador implementan esta interfaz.
*/

public interface NotificadorInterface {
    void enviar(String mensaje);

    int getUsuario();

    public final JSONManager jsonManager = new JSONManager();
}
