package Repositorio;

import Entidades.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RepositorioAdmin implements InterAdmin {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static List<Admin> listAdmin = new ArrayList<>();
    private static Funcionario listFunc[] = new Funcionario[15];
    private static List<Cliente> listClientesAdmin = new ArrayList<>();
    private static List<Produto> listProduto = new ArrayList<>();

    List<Perfil> listTodos = new ArrayList<>();

    public List<Admin> getListAdmin() {
        return listAdmin;
    }

    public void setListAdmin(List<Admin> listAdmin) {
        this.listAdmin = listAdmin;
    }

    public List<Cliente> getListClientes() {
        return listClientesAdmin;
    }

    public void setListClientes(List<Cliente> listClientesAdmin) {
        this.listClientesAdmin = listClientesAdmin;
    }

    public List<Produto> getListProduto() {
        return listProduto;
    }

    public void setListProduto(List<Produto> listProduto) {
        this.listProduto = listProduto;
    }

    RepositorioSistema sistema = new RepositorioSistema();

    public static Funcionario[] getListFunc() {

        return listFunc;
    }

    public static void setListFunc(Funcionario[] listFunc) {
        RepositorioAdmin.listFunc = listFunc;
    }

    @Override
    public boolean criarAdmin(Admin admin) {

        try {
            System.out.println("Chegamos aqui");
            listAdmin.add(admin);

            HandlerJson.saveToJSON();

            System.out.println("Admin criado!");
        } catch (Exception e) {
            Object ex = null;
            Logger.getLogger(RepositorioAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void alterarSenha(String senha, int id) {
        for (Admin admin : listAdmin) {
            if (admin.getIdAdministrador() == id) {
                admin.setSenha(senha);
                Admin aux = new Admin();
                aux = admin;
                listAdmin.remove(admin);
                listAdmin.add(aux);
                System.out.println("Senha atualizada com sucesso.\n");
            }
        }
        HandlerJson.saveToJSON();
    }

    @Override
    public List<Admin> buscarDados(long id) {

        for (Admin admin : listAdmin) {
            if (admin.getIdAdministrador() == id) {
                System.out.println("ID: " + admin.getIdAdministrador());
                System.out.println("Nome: " + admin.getNome());
                System.out.println("CPF: " + admin.getCpf());
                System.out.println("Nível de usuário: " + admin.getTipo_usuario());
                System.out.println("Login: " + admin.getLogin());
                System.out.println("Telefone: " + admin.getTelefone());
                System.out.println("Endereço: " + admin.getEndereco());
                System.out.println("______________________________");
            }
        }
        return null;
    }

    @Override
    public boolean criarProduto(Produto produto) {
        try {
            listProduto.add(produto);

            HandlerJson.saveToJSON();

            System.out.println("\nProduto criado com sucesso!\n");
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void alterarProduto(Produto protudo, int id) {
        
        for (Produto protudo1 : listProduto) {
            if (protudo1.getIdProduto() == id) {
                listProduto.remove(protudo1);
                listProduto.add(protudo);
                
                System.out.println("\nNome: " + protudo1.getNomeProduto());

                break;
            }
        }
        
        HandlerJson.saveToJSON();
        System.out.println("\nProduto atualizado com sucesso.\n");
    }

    @Override
    public void deletarProduto(int id) {
        for (Produto produto : listProduto) {
            if (produto.getIdProduto() == id) {
                listProduto.remove(produto);

                HandlerJson.saveToJSON();

                System.out.println("Produto deletado com sucesso!");
                break;
            }
        }
    }

    @Override
    public boolean criarFuncionario(Funcionario func) {

        try {

            for (int i = 0; i < 15; i++) {
                if (RepositorioAdmin.listFunc[i] == null) {
                    RepositorioAdmin.listFunc[i] = func;

                    HandlerJson.saveToJSON();

                    break;
                }
            }

            System.out.println("\nFuncionário criado com sucesso!\n");
        } catch (Exception e) {
            return false;
        }

        return true;

    }

    @Override
    public void alterarDadosFuncionario(Funcionario func, int id) {

        for (int i = 0; i < listFunc.length; i++) {
            if (listFunc[i].getIdFuncionario() == id) {
                listFunc[i] = func;
                HandlerJson.saveToJSON();

                System.out.println("Funcionário deletado com sucesso!");
                break;
            }
        }

        HandlerJson.saveToJSON();
        System.out.println("\nFuncionário atualizado com sucesso.\n");
    }

    @Override
    public void deletarFuncionario(int id) {

        for (int i = 0; i < listFunc.length; i++) {
            if (listFunc[i].getIdFuncionario() == id) {
                listFunc[i] = null;
                HandlerJson.saveToJSON();

                System.out.println("Funcionário deletado com sucesso!");
                break;
            }
        }
    }

    @Override
    public void listarAdmin() {
        System.out.println("Admin:");
        for (Admin admin : listAdmin) {
            System.out.println("ID: " + admin.getIdAdministrador());
            System.out.println("Nome: " + admin.getNome());
            System.out.println("CPF: " + admin.getCpf());
            System.out.println("Nível de usuário: " + admin.getTipo_usuario());
            System.out.println("Login: " + admin.getLogin());
            System.out.println("Telefone: " + admin.getTelefone());
            System.out.println("Endereço: " + admin.getEndereco() + "\n");
        }
        System.out.println("______________________________");
    }

    @Override
    public void listarFuncionarios() {
        System.out.println("Funcionarios:");
        for (Funcionario funcionario : listFunc) {
            System.out.println("ID: " + funcionario.getIdFuncionario());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("CPF: " + funcionario.getCpf());
            System.out.println("Nível de usuário: " + funcionario.getTipo_usuario());
            System.out.println("Login: " + funcionario.getLogin());
            System.out.println("Telefone: " + funcionario.getTelefone());
            System.out.println("Endereço: " + funcionario.getEndereco() + "\n");
        }
        System.out.println("______________________________");
    }

    @Override
    public void listarProdutos() {
        System.out.println("Produtos:");
        for (Produto produto : listProduto) {
            System.out.println("ID: " + produto.getIdProduto());
            System.out.println("Nome: " + produto.getNomeProduto());
            System.out.println("Descrição: " + produto.getDescProduto());
            System.out.println("Preço: " + produto.getPreco() + "\n");
        }
        System.out.println("______________________________");
    }

    @Override
    public void buscar(String enditade, int id) {
        if (enditade.equalsIgnoreCase("admin")) {
            for (Admin admin : listAdmin) {
                if (admin.getIdAdministrador() == id) {
                    System.out.println("ID: " + admin.getIdAdministrador());
                    System.out.println("Nome: " + admin.getNome());
                    System.out.println("CPF: " + admin.getCpf());
                    System.out.println("Nível de usuário: " + admin.getTipo_usuario());
                    System.out.println("Login: " + admin.getLogin());
                    System.out.println("Telefone: " + admin.getTelefone());
                    System.out.println("Endereço: " + admin.getEndereco() + "\n");
                }
            }
        } else if (enditade.equalsIgnoreCase("produto")) {
            for (Produto produto : listProduto) {
                if (produto.getIdProduto() == id) {
                    System.out.println("ID: " + produto.getIdProduto());
                    System.out.println("Nome: " + produto.getNomeProduto());
                    System.out.println("Descrição: " + produto.getDescProduto());
                    System.out.println("Preço: " + produto.getPreco());
                }
            }
        } else {
            for (Funcionario funcionario : listFunc) {
                if (funcionario.getIdFuncionario() == id) {
                    System.out.println("ID: " + funcionario.getIdFuncionario());
                    System.out.println("Nome: " + funcionario.getNome());
                    System.out.println("CPF: " + funcionario.getCpf());
                    System.out.println("Nível de usuário: " + funcionario.getTipo_usuario());
                    System.out.println("Login: " + funcionario.getLogin());
                    System.out.println("Telefone: " + funcionario.getTelefone());
                    System.out.println("Endereço: " + funcionario.getEndereco() + "\n");
                    break;
                }
            }
        }
        System.out.println("\n");
    }

    @Override
    public List<Admin> arrayAdmin() {
        return listAdmin;
    }

    @Override
    public Funcionario[] arrayFuncionario() {
        return listFunc;
    }
}
