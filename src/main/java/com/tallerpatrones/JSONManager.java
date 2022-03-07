package com.tallerpatrones;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
*  Esta clase se encarga de gestionar el archivo JSON que contiene 
*  la información de los usuarios (userlist.JSON)
*/
public final class JSONManager {
    /*
     * Método encargado de la lectura y parseo del archivo a un Arreglo JSON
     */
    private JSONArray jsonArray = new JSONArray();

    /**
     * @return JSONArray
     */
    public JSONArray readFile() {
        String first = "/Users/nicollemayol/Documents/UNIVERSIDAD/2022-1/Patrones de Diseño de Software/tallerpatrones/src/main/java/com/tallerpatrones/userlist.json";
        try {
            String contents = new String((Files.readAllBytes(Paths.get(first)))); // Convierte la información del
                                                                                  // archivo JSON en un String
            JSONObject o = new JSONObject(contents); // A partir del String, crea un objeto JSON
            this.jsonArray = o.getJSONArray("users"); // Obtiene el arreglo JSON del objeto
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonArray;

    }

    /**
     * @param key // Es la clave del campo que se desea obtener del archivo
     * @param id: //Corresponde al id del usuario en el archivo JSON
     * @return String: La información del usuario según el id y la clave.
     */
    public String getUserData(String key, int id) {
        JSONArray jsonArray = readFile();
        List<String> list = IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optString(key))
                .collect(Collectors.toList()); // Convierte el arreglo JSON en unas listas dependiendo de la clave
                                               // (key)
        String data = list.get(id);
        return data;

    }

}
