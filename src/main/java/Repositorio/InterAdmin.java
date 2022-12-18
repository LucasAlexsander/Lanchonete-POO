package Repositorio;

import java.util.List;
import Entidades.*;

public interface InterAdmin {
    // Métodos para admin
    public boolean criarAdmin(Admin admin); 
    public void alterarSenha(String senha, int id);
    public List<Admin> buscarDados(long id);
    public void listarAdmin();
    public List<Admin> arrayAdmin();
    
    // Métodos para Produto
    public boolean criarProduto(Produto produto);
    public void alterarProduto(Produto protudo, int id);
    public void deletarProduto(int id);
    public void listarProdutos();
    
    // Métodos para Funcionario
    public boolean criarFuncionario(Funcionario func);
    public void alterarDadosFuncionario(Funcionario func, int id);
    public void deletarFuncionario(int id);
    public void listarFuncionarios();
    public Funcionario[] arrayFuncionario();
    
    // Geral
    public void buscar(String entidade, int id);

}
