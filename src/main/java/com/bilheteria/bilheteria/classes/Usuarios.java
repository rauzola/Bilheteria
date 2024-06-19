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
                    JSONObject jsonEstado = jsonArray.getJSONObject(i);

                    // Obter o ID do usuario
                    int id = jsonEstado.getInt("id");

                    // Obter o nome do usuario
                    String nome = jsonEstado.getString("name");

                    // Obter a email do usuario
                    String email = jsonEstado.getString("email");

                    // Obter a cpf do usuario
                    String cpf = jsonEstado.getString("cpf");

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

   
}
