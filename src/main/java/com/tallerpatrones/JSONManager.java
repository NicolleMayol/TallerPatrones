package com.tallerpatrones;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class JSONManager {

    public static JSONArray readFile() {
        String first = "/Users/nicollemayol/Documents/UNIVERSIDAD/2022-1/Patrones de Diseño de Software/tallerpatrones/src/main/java/com/tallerpatrones/userlist.json";
        JSONArray jsonArray = new JSONArray();
        try {
            String contents = new String((Files.readAllBytes(Paths.get(first))));
            JSONObject o = new JSONObject(contents);
            jsonArray = o.getJSONArray("users");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonArray;

    }

    public String getUserData(String type, int id) {
        JSONArray jsonArray = readFile();
        List<String> list = IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optString(type))
                .collect(Collectors.toList());
        // System.out.println(list);
        String data = list.get(id);
        return data;

    }

}
