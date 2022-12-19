package Repositorio;

import Entidades.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RepositorioSistema implements InterSistema {

    private static List<Cliente> listCliente = new ArrayList<>();
    private static List<Pedido> listPedido = new ArrayList<>();

    public List<Cliente> getListCliente() {
        return listCliente;
    }

    public void setListCliente(List<Cliente> listCliente) {
        this.listCliente = listCliente;
    }

    public List<Pedido> getListPedido() {
        return listPedido;
    }

    public void setListPedido(List<Pedido> listPedido) {
        this.listPedido = listPedido;
    }

    int[][] calendario = new int[1][13];
    String[] mesCalendario = {"Janeiro", "fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

    @Override
    public void pedidosRealizados(int mes) {
        System.out.println("\nEm " + mesCalendario[mes] + " foi vendido " + calendario[0][mes] + " produtos.\n");
    }

    @Override
    public boolean criarPedido(Pedido pedido, int mes) {
        try {
            calendario[0][mes] += 1;
            listPedido.add(pedido);

            HandlerJson.saveToJSON();
            System.out.println("\nPedido realizado com sucesso!\n");
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void alterarPedido(Pedido pedido, int id) {
        for (Pedido pedido1 : listPedido) {
            if (pedido1.getIdPedido() == id) {
                listPedido.remove(pedido1);
                listPedido.add(pedido);
                HandlerJson.saveToJSON();
                break;
            }
        }
        System.out.println("\nPedido atualizado com sucesso.\n");
    }

    @Override
    public boolean criarCliente(Cliente cliente) {
        try {
            listCliente.add(cliente);

            HandlerJson.saveToJSON();
            System.out.println("\nCliente criado com sucesso!\n");
        } catch (Exception e) {
            Object ex = null;
            Logger.getLogger(RepositorioAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Cliente cliente1 : listCliente) {
            System.out.println("nome: " + cliente1.getNome());
        }
        
        return true;
    }

    @Override
    public void alterarCliente(Cliente cliente, int id) {

        for (Cliente cliente1 : listCliente) {
            if (cliente1.getIdCliente() == id) {
                listCliente.remove(cliente1);
                listCliente.add(cliente);
                HandlerJson.saveToJSON();
                break;
            }
        }
        System.out.println("\nCliente atualizado com sucesso.\n");
    }

    @Override
    public boolean deletar(String endidade, int id) {
        if (endidade == "cliente") {
            for (Cliente cliente : listCliente) {
                if (cliente.getIdCliente() == id) {
                    listCliente.remove(cliente);
                    break;
                }
            }
        } else {
            for (Pedido pedido : listPedido) {
                if (pedido.getIdPedido() == id) {
                    listPedido.remove(pedido);
                    HandlerJson.saveToJSON();
                    break;
                }
            }
        } 
        
        HandlerJson.saveToJSON();
        return false;
    }

    @Override
    public void buscar(String enditade, int id) {
        if (enditade.equalsIgnoreCase("cliente")) {
            for (Cliente cliente : listCliente) {
                if (cliente.getIdCliente() == id) {
                    System.out.println("\nId: " + cliente.getIdCliente());
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("CPF: " + cliente.getCpf());
                    System.out.println("Enrereço: " + cliente.getEndereco());
                    System.out.println("Telefone: " + cliente.getTelefone());
                    System.out.println("Pedidos: " + cliente.getUltPedidos());
                }
            }
        } else {
            for (Pedido pedido : listPedido) {
                if (pedido.getIdPedido() == id) {
                    System.out.println("\nId: " + pedido.getIdPedido());
                    System.out.println("Nome: " + pedido.getNome());
                    System.out.println("Cliente: " + pedido.getCliente());
                    System.out.println("Adicinais: " + pedido.getAdicionais());
                    System.out.println("Descrição: " + pedido.getDescPedido());
                    System.out.println("Tipo de pagamento: " + pedido.getPagamento());
                    System.out.println("Previsao de Entrega: " + pedido.getPrevisaoEntrega());
                    System.out.println("Status: " + pedido.getStatus());
                }
            }
        }
        System.out.println("\n");
    }

    @Override
    public void listarClientes() {
        System.out.println("Clientes:");
        for (Cliente cliente : listCliente) {
            System.out.println("ID: " + cliente.getIdCliente());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Nível de usuário: " + cliente.getTipo_usuario());
            System.out.println("Login: " + cliente.getLogin());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Endereço: " + cliente.getEndereco() + "\n");
        }
        System.out.println("______________________________");
    }

    @Override
    public void buscarPedidos() {
        for (Pedido pedido : listPedido) {
            System.out.println("\nId: " + pedido.getIdPedido());
            System.out.println("Nome: " + pedido.getNome());
            System.out.println("Cliente: " + pedido.getCliente());
            System.out.println("Adicionais: " + pedido.getAdicionais());
            System.out.println("Descrição: " + pedido.getDescPedido());
            System.out.println("Tipo de pagamento: " + pedido.getPagamento());
            System.out.println("Previsão de entrega: " + pedido.getPrevisaoEntrega());
            System.out.println("Status: " + pedido.getStatus());
        }
        System.out.println("\n");
    }

}
