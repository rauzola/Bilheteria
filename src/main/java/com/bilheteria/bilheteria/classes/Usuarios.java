/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class Usuarios {

    public int id;
    public String email;
    public String nome;
    public String cpf;

    // Método estático para criar uma instância de Usuario
    public static Usuarios criar(int pId, String pNome, String pCpf, String pEmail) {
        Usuarios objeto = new Usuarios();
        objeto.id = pId;
        objeto.nome = pNome;
        objeto.cpf = pCpf;
        objeto.email = pEmail;
        return objeto;
    }

    // Método estático para carregar usuarios a partir de uma API
    public static ArrayList<Usuarios> carregarUsuarios() {

        // Lista para armazenar os usuarios
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        try {
            // URL da API de usuarios
            URL url = new URL("https://api-eventos-unicv.azurewebsites.net/api/usuarios");

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

                    // Obter o objeto JSON correspondente a um usuario
                    JSONObject jsonUsuario = jsonArray.getJSONObject(i);

                    // Obter o ID do usuario
                    int id = jsonUsuario.getInt("id");

                    // Obter o nome do usuario
                    String nome = jsonUsuario.getString("name");

                    // Obter a email do usuario
                    String email = jsonUsuario.getString("email");

                    // Obter a cpf do usuario
                    String cpf = jsonUsuario.getString("cpf");

                    // Exibir os detalhes do usuario no console
                    System.out.println("Usuario: " + nome + ", email: " + email + ", ID: " + id + ", cpf: " + cpf);

                    // Criar uma instância de Usuario e adicionar à lista
                    Usuarios usuario = Usuarios.criar(id, nome, email, cpf);
                    usuarios.add(usuario);
                }
            } else {
                // Se a requisição não foi bem-sucedida, exibir uma mensagem de erro
                System.out.println("GET request not worked");
            }
        } catch (Exception e) {
            // Tratar exceções e exibir a stack trace
            e.printStackTrace();
        }
        // Retornar a lista de usuarios
        return usuarios;
    }

    public void enviarUsuariosPost(String nome, String cpf, String email) {
        try {
            // URL da API de usuarios
            URL url = new URL("https://api-eventos-unicv.azurewebsites.net/api/usuarios");

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
            jsonBody.put("cpf", cpf);
            jsonBody.put("email", email);

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
            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                System.out.println("Usuarios criado com sucesso!");
            } else {
                // Se a resposta não for 201, exibir o código de resposta e o corpo da resposta
                System.out.println(responseCode);
                System.out.println("Resposta da API: " + response.toString());

            }
        } catch (Exception e) {
            // Tratar exceções e exibir a stack trace
            e.printStackTrace();
        }
    }

    // Método para editar um Usuarios via PUT e retornar a resposta da API como uma String
    public String editarUsuariosPUT(int id, String nome, String cpf, String email) {
        String responseStr = "";
        try {
            // URL da API de Usuarioss, incluindo o ID do Usuarios a ser editado
            URL url = new URL("https://api-eventos-unicv.azurewebsites.net/api/usuarios/?id=" + id);

            // Abrir uma conexão HTTP com a URL
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Definir o método de requisição como PUT
            con.setRequestMethod("PUT");

            // Definir o tipo de mídia como application/json
            con.setRequestProperty("Content-Type", "application/json");

            // Habilitar envio de dados
            con.setDoOutput(true);

            System.out.println("id: " + id + ", nome: " + nome + ", cpf: " + cpf + ", email");

            // Criar o corpo da requisição JSON
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("name", nome);
            jsonBody.put("email", email);
            jsonBody.put("cpf", cpf);

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
                System.out.println("Usuario atualizado com sucesso!");
            } else {
                in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                System.out.println("Erro ao atualizar o Usuarios!");
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

    // Método para editar um usuario via DELETE e retornar a resposta da API como uma String
    public String deletarUsuarioDELETE(int id) {
        String responseStr = "";
        try {
            // URL da API de usuarios, incluindo o ID do usuario a ser editado
            URL url = new URL("https://api-eventos-unicv.azurewebsites.net/api/usuarios/?id=" + id);

            // Abrir uma conexão HTTP com a URL
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Definir o método de requisição como PUT
            con.setRequestMethod("DELETE");

            // Definir o tipo de mídia como application/json
            con.setRequestProperty("Content-Type", "application/json");

            // Habilitar envio de dados
            con.setDoOutput(true);
            
          
            
            // Criar o corpo da requisição JSON
            JSONObject jsonBody = new JSONObject();
            

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
                System.out.println("Usuario atualizado com sucesso!");
            } else {
                in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                System.out.println("Erro ao atualizar o usuario!");
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
