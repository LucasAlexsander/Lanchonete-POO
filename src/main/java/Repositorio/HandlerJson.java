package Repositorio;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import Entidades.*;
import com.google.gson.GsonBuilder;

/**
 * A classe <b>HandlerJson</b> é a classe responsável por agrupar todas as funcionalidades referentes à manipulação da babse de dados do sistema, que consiste em operações com arrays, vetores e arquivos json. 
 * 
 */
public class HandlerJson {
        /**
         * O método saveToJson serve para salvar as atualizações ocoridas em um arraylist em seu arquivo json correspondente.
         */
    
            
        static RepositorioAdmin ra = new RepositorioAdmin();
        static RepositorioSistema rs = new RepositorioSistema();
    
        public static void saveToJSON(){
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        
        String admins = gson.toJson(ra.getListAdmin());
        try{
            FileWriter escrever = new FileWriter("admin.json");
            escrever.write(admins);
            escrever.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        String funcionarios = gson.toJson(ra.getListFunc());
        try{
            FileWriter escrever = new FileWriter("funcionarios.json");
            escrever.write(funcionarios);
            escrever.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        String clientes = gson.toJson(rs.getListCliente());
        try{
            FileWriter escrever = new FileWriter("clientes.json");
            escrever.write(clientes);
            escrever.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        String pedidos = gson.toJson(rs.getListPedido());
        try{
            FileWriter escrever = new FileWriter("pedidos.json");
            escrever.write(pedidos);
            escrever.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        String produtos = gson.toJson(ra.getListProduto());
        try{
            FileWriter escrever = new FileWriter("produtos.json");
            escrever.write(produtos);
            escrever.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    /**
     * O método openAndReadJson serve para trazer ao sistema as informações atuais presentes nos arquivos json, assim o sistema sempre trabalha com informações atualizadas.
     * @throws IOException 
     */    
    
    public static void openAndReadJson() throws IOException{
        
        Gson gson = new Gson();
                
        File fileAdmin = new File("admin.json");
        String admData = new String(Files.readAllBytes(Paths.get(fileAdmin.toURI())));
        ArrayList<Admin> listAdmin = gson.fromJson(admData, new TypeToken<ArrayList<Admin>>(){}.getType());
        ra.setListAdmin(listAdmin);
       
        File fileFunc = new File("funcionarios.json");
        String funcionarioData = new String(Files.readAllBytes(Paths.get(fileFunc.toURI())));
        Funcionario[] funcionarios = gson.fromJson(funcionarioData, new TypeToken<Funcionario[]>(){}.getType());
        ra.setListFunc(funcionarios);
        
        File listProd = new File("produtos.json");
        String produtosData = new String(Files.readAllBytes(Paths.get(listProd.toURI())));
        ArrayList<Produto> produtos = gson.fromJson(produtosData, new TypeToken<ArrayList<Produto>>(){}.getType());
        ra.setListProduto(produtos);
        
        RepositorioSistema rs = new RepositorioSistema();
                
        File cliente = new File("clientes.json");
        String clientesData = new String(Files.readAllBytes(Paths.get(cliente.toURI())));
        ArrayList<Cliente> clientes = gson.fromJson(clientesData, new TypeToken<ArrayList<Cliente>>(){}.getType());
        rs.setListCliente(clientes);
        
        File pedido = new File("pedidos.json");
        String pedidosData = new String(Files.readAllBytes(Paths.get(pedido.toURI())));
        ArrayList<Pedido> pedidos = gson.fromJson(pedidosData, new TypeToken<ArrayList<Pedido>>(){}.getType());
        rs.setListPedido(pedidos);
        
    }
}
