
import Entidades.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
/**
 *
 * @author Lucas Alexsander
 */
public class teste {

    private static Produto Colaboradores[] = new Produto[15];

    public static void main(String args[]) throws IOException {
        
        Gson gson = new Gson();
        
        gson.newJsonReader("produto");
        
        String jsonText = AbstracrReader.readJson("produto");

        /*Produto p = new Produto();

        p.setDescProduto("Descrição 1");
        p.setIdProduto(1);
        p.setNomeProduto("Produto 1");
        p.setPreco(3.4);

        Produto p2 = new Produto();

        p2.setDescProduto("Descrição 2");
        p2.setIdProduto(2);
        p2.setNomeProduto("Produto 2");
        p2.setPreco(14.34);

        Produto p3 = new Produto();

        p3.setDescProduto("Descrição 3");
        p3.setIdProduto(3);
        p3.setNomeProduto("Produto 3");
        p3.setPreco(9.99);
        
        Produto p4 = new Produto();

        p4.setDescProduto("Descrição 4");
        p4.setIdProduto(4);
        p4.setNomeProduto("Produto 4");
        p4.setPreco(91.99);

        List<Produto> listProduto = new ArrayList<>();

        listProduto.add(p);
        listProduto.add(p2);
        listProduto.add(p3);
        listProduto.add(p4);
        // Convertendo para Json
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        String jsonProduto = gson.toJson(listProduto);

        System.out.println(jsonProduto);
        
        System.out.println("_______________________\nConvertendo para obj");
        
        Type listType = new TypeToken<ArrayList<Produto>>(){}.getType();        
        List<Produto> listProduto2 = new ArrayList<>();
        // Convertendo
        listProduto2 = gson.fromJson(jsonProduto, listType);
        
        for (Produto produto : listProduto2) {
            System.out.println(produto.getNomeProduto());
        }
        
        // Criando o arquivo json e salvando
        FileWriter fileWrite = new FileWriter("teste");
        fileWrite.write(jsonProduto);
        fileWrite.flush();
        fileWrite.close();
        */
    }
}
