/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilheteria.bilheteria;

/**
 *
 * @author raul_
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class Estado {
    public void obterEstados() {
        
        String nome; 
        String sigla;
        int id;
        
        try {
            URL url = new URL("https://servicodados.ibge.gov.br/api/v1/localidades/estados");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Processar a resposta JSON
                JSONArray estadosArray = new JSONArray(response.toString());

                for (int i = 0; i < estadosArray.length(); i++) {
                    JSONObject estadoObj = estadosArray.getJSONObject(i);
                    nome = estadoObj.getString("nome");
                    sigla = estadoObj.getString("sigla");
                    id = estadoObj.getInt("id");

                    // Exibir os detalhes do estado
                    System.out.println("Estado: " + nome + ", Sigla: " + sigla + ", ID: " + id);
                }
            } else {
                System.out.println("Erro ao obter a lista de estados. Código de resposta: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
