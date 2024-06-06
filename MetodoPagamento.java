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

public class MetodoPagamento {

    public int id;
    public String nome;

    public static MetodoPagamento criar(int pId, String pNome) {
        MetodoPagamento objeto = new MetodoPagamento();
        objeto.id = pId;
        objeto.nome = pNome;
        

        return objeto;
    }

    public static ArrayList<MetodoPagamento> carregarMetodos() {
        ArrayList<MetodoPagamento> metodoPagamento = new ArrayList<>();
        try {
            URL url = new URL("https://api-eventos-unicv.azurewebsites.net/api/metodos-pagamento");
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
                JSONObject jsonMetodoPagamento = jsonArray.getJSONObject(i);
                int id = jsonMetodoPagamento.getInt("id");
                String nome = jsonMetodoPagamento.getString("name");
                
                
               // System.out.println("Nome MetodoPagamento: " + nome + " ", ID: " + id);
                
                MetodoPagamento metodoPagamentos = MetodoPagamento.criar(id, nome);
                metodoPagamento.add(metodoPagamentos);
            }
            } else {
                System.out.println("GET request not worked");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return metodoPagamento;
    }
}
