package Repositorio;

import Entidades.*;
import java.util.List;

public interface InterSistema {
    // Métodos para Pedidos
    public boolean criarPedido(Pedido pedido, int mes);
    public void alterarPedido(Pedido pedido, int id);
    public void buscarPedidos();
    public void pedidosRealizados(int mes);
    
    // Métodos para Clientes
    public boolean criarCliente(Cliente cliente);
    public void alterarCliente(Cliente cliente, int id);
    public void listarClientes();
    
    // Métodos gerais
    public boolean deletar(String endidade, int id);
    public void buscar(String enditade, int id);
    // public void buscarLogin();
}
