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

    // Método estático para criar uma instância de Estado
    public static Estado criar(int pId, String pNome, String pSigla) {
        Estado objeto = new Estado();
        objeto.id = pId;
        objeto.nome = pNome;
        objeto.sigla = pSigla;
        return objeto;
    }

    // Método estático para carregar estados a partir de uma API
    public static ArrayList<Estado> carregarEstados() {

        // Lista para armazenar os estados
        ArrayList<Estado> estados = new ArrayList<>();
        try {
            // URL da API de estados
            URL url = new URL("https://api-eventos-unicv.azurewebsites.net/api/estados");

            // Abrir uma conexão HTTP com a URL
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Definir o método de requisição como GET
            con.setRequestMethod("GET");

            // Obter o código de resposta da requisição
            int responseCode = con.getResponseCode();

            // Verificar se a resposta é HTTP OK (código 200)
            if (responseCode == HttpURLConnection.HTTP_OK) {

                // Criar um BufferedReader para ler a resposta da requisição
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;

                // StringBuffer para acumular a resposta
                StringBuffer response = new StringBuffer();

                // Ler a resposta linha por linha
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                // Fechar o BufferedReader
                in.close();

                // Converter a resposta em um array JSON
                JSONArray jsonArray = new JSONArray(response.toString());

                // Iterar sobre cada objeto no array JSON
                for (int i = 0; i < jsonArray.length(); i++) {

                    // Obter o objeto JSON correspondente a um estado
                    JSONObject jsonEstado = jsonArray.getJSONObject(i);

                    // Obter o ID do estado
                    int id = jsonEstado.getInt("id");

                    // Obter o nome do estado
                    String nome = jsonEstado.getString("name");

                    // Obter a sigla do estado
                    String sigla = jsonEstado.getString("acronym");

                    // Exibir os detalhes do estado no console
                    System.out.println("Nome Estado: " + nome + ", Sigla: " + sigla + ", ID: " + id);

                    // Criar uma instância de Estado e adicionar à lista
                    Estado estado = Estado.criar(id, nome, sigla);
                    estados.add(estado);
                }
            } else {
                // Se a requisição não foi bem-sucedida, exibir uma mensagem de erro
                System.out.println("GET request not worked");
            }
        } catch (Exception e) {
            // Tratar exceções e exibir a stack trace
            e.printStackTrace();
        }
        // Retornar a lista de estados
        return estados;
    }
}
