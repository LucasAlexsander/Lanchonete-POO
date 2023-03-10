package Repositorio;

import Entidades.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioAdmin implements InterAdmin {

    List<Admin> listAdmin = new ArrayList<>();
    // List<Funcionario> listFunc = new ArrayList<>();
    private static Funcionario listFunc[] = new Funcionario[15];
    List<Perfil> listTodos = new ArrayList<>();
    List<Cliente> listClientesAdmin = new ArrayList<>();
    List<Produto> listProduto = new ArrayList<>();
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
            listAdmin.add(admin);
        } catch (Exception e) {
            return false;
        }
        return true;
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
            }
        }
        System.out.println("\nProduto atualizado com sucesso.\n");
    }

    @Override
    public void deletarProduto(int id) {
        for (Produto produto : listProduto) {
            if (produto.getIdProduto() == id) {
                listProduto.remove(produto);
                System.out.println("Produto deletado com sucesso!");
                break;
            }
        }
    }

    @Override
    public boolean criarFuncionario(Funcionario func) {
        try {
            
            for(int i = 0; i < 15; i++) {
                if(RepositorioAdmin.listFunc[i] == null) {
                    RepositorioAdmin.listFunc[i] = func;
                    break;
                }
            }
            
            /* for (Funcionario func1 : listFunc) {
                if (func1 == null) {
                    func1 = func;
                    System.out.println("\nFuncionário criado com sucesso!\n");
                    break;
                }                
            }*/
            System.out.println("\nFuncionário criado com sucesso!\n");
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    @Override
    public void alterarDadosFuncionario(Funcionario func, int id) {

        for (Funcionario func1 : listFunc) {
            if (func1.getIdFuncionario() == id) {
                //listFunc.remove(func1);
                func1 = func;
            }
        }
        System.out.println("\nFuncionário atualizado com sucesso.\n");
    }

    @Override
    public void deletarFuncionario(int id) {
        for (Funcionario func : listFunc) {
            if (func.getIdFuncionario() == id) {
                func = null;
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
