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

    // Método estático para criar uma instância de MetodoPagamento
    public static MetodoPagamento criar(int pId, String pNome) {
        MetodoPagamento objeto = new MetodoPagamento();
        objeto.id = pId;
        objeto.nome = pNome;
        return objeto;
    }

    // Método estático para carregar métodos de pagamento a partir de uma API
    public static ArrayList<MetodoPagamento> carregarMetodos() {

        // Lista para armazenar os métodos de pagamento
        ArrayList<MetodoPagamento> metodoPagamento = new ArrayList<>();
        try {
            // URL da API de métodos de pagamento
            URL url = new URL("https://api-eventos-unicv.azurewebsites.net/api/metodos-pagamento");

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

                    // Obter o objeto JSON correspondente a um método de pagamento
                    JSONObject jsonMetodoPagamento = jsonArray.getJSONObject(i);

                    // Obter o ID do método de pagamento
                    int id = jsonMetodoPagamento.getInt("id");

                    // Obter o nome do método de pagamento
                    String nome = jsonMetodoPagamento.getString("name");

                    // Exibir o nome e o ID do método de pagamento no console
                    System.out.println("Nome MetodoPagamento: " + nome + ", ID: " + id);

                    // Criar uma instância de MetodoPagamento e adicionar à lista
                    MetodoPagamento metodoPagamentos = MetodoPagamento.criar(id, nome);
                    metodoPagamento.add(metodoPagamentos);
                }
            } else {
                // Se a requisição não foi bem-sucedida, exibir uma mensagem de erro
                System.out.println("GET request not worked");
            }
        } catch (Exception e) {
            // Tratar exceções e exibir a stack trace
            e.printStackTrace();
        }
        // Retornar a lista de métodos de pagamento
        return metodoPagamento;
    }
}
