
import Entidades.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;

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
    
    
    
    
    public static void main(String args[]) {
        
        JSONObject programador1 = new JSONObject();
        
        programador1.put("nome", "Lucas Barbosa");
        programador1.put("idade", 33);
        programador1.put("signo", "Touro");
        programador1.put("CPF:", "133.133.133-31");
        
        //System.out.println(programador1.toJSONString());
        
        JSONObject programador2 = new JSONObject();
        
        programador2.put("nome", "Thai Barbosa");
        programador2.put("idade", 20);
        programador2.put("signo", "peixes");
        programador2.put("CPF:", "123.133.133-31");
        
        //System.out.println(programador2.toJSONString());
        
        JSONArray programadorLista = new JSONArray();
        programadorLista.add(programador1);
        programadorLista.add(programador2);
        //System.out.println(programadorLista.toJSONString());
        
        try(FileWriter arquivoJson = new FileWriter("programadores")) {
            
            arquivoJson.write(programadorLista.toJSONString());
            arquivoJson.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
