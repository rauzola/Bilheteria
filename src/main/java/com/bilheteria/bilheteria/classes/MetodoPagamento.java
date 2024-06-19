package com.bilheteria.bilheteria.classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
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

    public boolean enviarMetodosPost(String nome) {
        boolean sucesso = true;

        try {
            // URL da API de métodos de pagamento
            URL url = new URL("https://api-eventos-unicv.azurewebsites.net/api/metodos-pagamento");

            // Abrir uma conexão HTTP com a URL
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Definir o método de requisição como POST
            con.setRequestMethod("POST");

            // Definir o tipo de mídia como application/json
            con.setRequestProperty("Content-Type", "application/json");

            // Habilitar envio de dados
            con.setDoOutput(true);

            // Criar o corpo da requisição JSON
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("name", nome);

            // Obter o OutputStream da conexão
            OutputStream os = con.getOutputStream();
            os.write(jsonBody.toString().getBytes());
            os.flush();
            os.close();

            // Obter o código de resposta da requisição
            int responseCode = con.getResponseCode();

            // Ler a resposta da API
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Verificar se a resposta é HTTP CREATED (código 201)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Método de Pagamento criado com sucesso!");
            } else if (responseCode == HttpURLConnection.HTTP_BAD_REQUEST) {
                // Se a resposta for 400, exibir a mensagem de erro
                System.out.println("Erro: Já existe um método de pagamento cadastrado com este nome");
                sucesso = false;
            } else {
                // Se a resposta não for 201 nem 400, exibir o código de resposta e o corpo da resposta
                System.out.println(responseCode);
                System.out.println("Resposta da API: " + response.toString());
                sucesso = false;
            }
        } catch (Exception e) {
            // Tratar exceções e exibir a stack trace
            sucesso = false;
            e.printStackTrace();
        }

        return sucesso;
    }

    // Método para editar Metodos de Pagamentos via PUT e retornar a resposta da API como uma String
    public String editarMetodoPUT(int id, String nome) {
        String responseStr = "";
        try {
            // URL da API de Metodos de Pagamentos, incluindo o ID do Metodos de Pagamentos a ser editado
            URL url = new URL("https://api-eventos-unicv.azurewebsites.net/api/metodos-pagamento/?id=" + id);

            // Abrir uma conexão HTTP com a URL
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Definir o método de requisição como PUT
            con.setRequestMethod("PUT");

            // Definir o tipo de mídia como application/json
            con.setRequestProperty("Content-Type", "application/json");

            // Habilitar envio de dados
            con.setDoOutput(true);
            
            System.out.println("id: " + id + " nome: " + nome );
            
            // Criar o corpo da requisição JSON
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("name", nome);
   

            // Obter o OutputStream da conexão
            OutputStream os = con.getOutputStream();
            os.write(jsonBody.toString().getBytes());
            os.flush();
            os.close();

            // Obter o código de resposta da requisição
            int responseCode = con.getResponseCode();

            // Verificar se a resposta é HTTP OK (código 200)
            BufferedReader in;
            if (responseCode == HttpURLConnection.HTTP_OK) {
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                System.out.println("Metodos de Pagamentos atualizado com sucesso!");
            } else {
                in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                System.out.println("Erro ao atualizar o Metodos de Pagamentos!");
                System.out.println("Código de resposta: " + responseCode);
            }
            
            // Ler a resposta da API
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            responseStr = response.toString();
            System.out.println("Resposta da API: " + responseStr);

        } catch (Exception e) {
            // Tratar exceções e exibir a stack trace
            e.printStackTrace();
        }
        return responseStr;
    }
    
    
}
