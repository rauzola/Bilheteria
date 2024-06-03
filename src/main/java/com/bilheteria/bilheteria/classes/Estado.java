package com.bilheteria.bilheteria.Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Estado {
    public int id;
    public String sigla;
    public String nome;

    public static Estado criar(int pId, String pNome, String pSigla){
        Estado objeto = new Estado();
        objeto.id = pId;
        objeto.nome = pNome;
        objeto.sigla = pSigla;
        
        return objeto;
    }
    
    public static ArrayList<Estado> carregarEstadosFromAPI(String apiUrl) {
        ArrayList<Estado> estados = new ArrayList<>();
        
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder response = new StringBuilder();
            String output;
            
            while ((output = br.readLine()) != null) {
                response.append(output);
            }
            
            conn.disconnect();
            
            JSONArray jsonArray = new JSONArray(response.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonEstado = jsonArray.getJSONObject(i);
                int id = jsonEstado.getInt("id");
                String nome = jsonEstado.getString("name");
                String sigla = jsonEstado.getString("acronym");
                
                // Exibir os detalhes do estado
                System.out.println("Nome Estado: " + nome + ", Sigla: " + sigla + ", ID: " + id);
                
                Estado estado = Estado.criar(id, nome, sigla);
                estados.add(estado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return estados;
    }
}
