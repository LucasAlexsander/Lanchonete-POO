
import Entidades.*;

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
        
        Produto p = new Produto();
        p.setNomeProduto("Lucas");
        p.setDescProduto("descrição1");
        p.setPreco(0.4);
        p.setIdProduto(1);
        
        Produto p1 = new Produto();
        p1.setNomeProduto("Alguma coisa");
        p1.setDescProduto("descrição2");
        p1.setPreco(0.4);
        p1.setIdProduto(1);
        
        Produto p2 = new Produto();
        p2.setNomeProduto("Thai");
        p2.setDescProduto("descrição3");
        p2.setPreco(0.4);
        p2.setIdProduto(1);
        
        Colaboradores[0] = p;
        Colaboradores[1] = p1;
        Colaboradores[2] = p2;
        
        
        for (Produto colab : Colaboradores) {
            if(colab.getNomeProduto().equals("Thai")){
                System.out.println("Encontrado!");
                System.out.println("Nome: " + colab.getNomeProduto());
                System.out.println("Descrição: " + colab.getDescProduto());
                System.out.println("Preço: " + colab.getPreco());
                System.out.println("id: " + colab.getIdProduto());
                break;
            }
        }
    }
}
