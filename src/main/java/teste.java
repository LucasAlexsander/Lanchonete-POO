
import Entidades.*;
import Repositorio.RepositorioAdmin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("admin.json"));

            List<Admin> admin = gson.fromJson(br, List.class);

            System.out.println(admin);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }

    }
}
