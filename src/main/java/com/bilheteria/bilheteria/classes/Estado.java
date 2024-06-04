package com.bilheteria.bilheteria.classes;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author raul_
 */

public class Estado {

    public int id;
    public String sigla;
    public String nome;

    public static Estado criar(int pId, String pNome, String pSigla) {
        Estado objeto = new Estado();
        objeto.id = pId;
        objeto.nome = pNome;
        objeto.sigla = pSigla;

        return objeto;
    }

    public static ArrayList<Estado> carregarEstados() {
        ArrayList<Estado> estados = new ArrayList<>();
        try {
            URL url = new URL("https://api-eventos-unicv.azurewebsites.net/api/estados");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Processar resposta JSON
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
            } else {
                System.out.println("GET request not worked");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estados;
    }
}
