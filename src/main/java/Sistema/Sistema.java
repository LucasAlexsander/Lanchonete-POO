package Sistema;

import Entidades.*;
import Repositorio.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Sistema {
    // Instanciando algumas classes

    static RepositorioAdmin ra = new RepositorioAdmin();
    static RepositorioSistema rs = new RepositorioSistema();
    static Scanner sc = new Scanner(System.in);
    static Perfil usuario = new Perfil();

    // Pegando as datas
    static Calendar calendar = new GregorianCalendar();
    static int mes = calendar.get(Calendar.MONTH);

    static boolean logado = false;

    public static void main(String[] args) {

        criandoAdmin();
        criandoFuncionarios();
        criandoClientes();

        login();
        funcoes();
    }

    // Métodos para Cliente        
    public static void criandoClientes() {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setCpf("999.999.999-99");
        cliente.setEndereco("Macau de Cima, 223");
        cliente.setNome("Rafael Lucas");
        cliente.setSenha("cliente");
        cliente.setTelefone("(38) 99999-9999");
        cliente.setLogin("cliente");
        cliente.setUltPedidos("ALsdasjdalsjkda");
        cliente.setTipo_usuario(-1);
        rs.criarCliente(cliente);
    }

    public static void crudCliente() {
        int acao = 0;

        do {
            System.out.println("TELA DE CRUD CLIENTE\n\n");
            System.out.println("Olá, " + usuario.getNome() + ". Selecione a ação que deseja");
            // Apresentar as opções do que pode ser feito
            System.out.println("1 - Criar Cliente");
            System.out.println("2 - Dados do Cliente");
            System.out.println("3 - Atualizar Cliente");

            System.out.println("0 - Voltar\n");

            System.out.print("Entre com uma ação: ");
            acao = Integer.parseInt(sc.nextLine());
            System.out.println("______________________________");

            switch (acao) {
                case 1 -> {
                    System.out.print("CRIANDO CLIENTE\n\n");

                    Cliente nCliente = new Cliente();

                    System.out.print("Nome: ");
                    nCliente.setNome(sc.nextLine());

                    System.out.print("CPF: ");
                    nCliente.setCpf(sc.nextLine());

                    System.out.print("Id: ");
                    nCliente.setId(Integer.parseInt(sc.nextLine()));

                    System.out.print("Endereço: ");
                    nCliente.setEndereco(sc.nextLine());

                    System.out.print("Telefone: ");
                    nCliente.setTelefone(sc.nextLine());

                    System.out.print("Pedido: ");
                    nCliente.setUltPedidos(sc.nextLine());

                    rs.criarCliente(nCliente);
                }
                case 2 -> {
                    System.out.print("DADOS DO CLIENTE\n\n");

                    System.out.print("Entre com o id do cliente: ");
                    int id = Integer.parseInt(sc.nextLine());
                    // Pegar o método para buscar o cliente
                    rs.buscar("cliente", id);
                }
                case 3 -> {
                    // Alterar dados do cliente
                    System.out.print("ALTERAR DADOS DO CLIENTE\n\n");

                    System.out.print("Entre com o id do cliente: ");
                    int idDados = Integer.parseInt(sc.nextLine());
                    System.out.println("Dados do cliente");
                    rs.buscar("cliente", idDados);

                    Cliente aCliente = new Cliente();

                    System.out.print("Id: ");
                    aCliente.setIdCliente(Integer.parseInt(sc.nextLine()));

                    System.out.print("Nome: ");
                    aCliente.setNome(sc.nextLine());

                    System.out.print("CPF: ");
                    aCliente.setCpf(sc.nextLine());

                    System.out.print("Endereço: ");
                    aCliente.setEndereco(sc.nextLine());

                    System.out.print("Telefone: ");
                    aCliente.setTelefone(sc.nextLine());

                    System.out.print("Pedido: ");
                    aCliente.setUltPedidos(sc.nextLine());

                    rs.alterarCliente(aCliente, idDados);
                }
                case 0 ->
                    funcoes();
                default ->
                    throw new AssertionError();
            }
        } while (logado != false);
    }

    // Métodos para Admin
    public static void criandoAdmin() {
        Admin admin = new Admin();
        admin.setIdAdministrador(1);
        admin.setCpf("999.999.999-99");
        admin.setEndereco("Algum ai, 655");
        admin.setNome("Lucas Alexsander");
        admin.setSenha("admin");
        admin.setTelefone("(38) 99999-9999");
        admin.setLogin("admin");
        admin.setTipo_usuario(1);

        ra.criarAdmin(admin);
        //ra.buscarDados(admin.getIdAdministrador());
    }

    public static void painelAdmin() {
        int acao = 0;

        do {
            System.out.println("TELA DE ADMIN");
            System.out.println("Olá, " + usuario.getNome() + ". Selecione a ação que deseja");
            // Apresentar as opções do que pode ser feito
            System.out.println("1 - Alterações em Funcionario");
            System.out.println("2 - Alterações em Produtos");
            System.out.println("3 - Pedidos realizados em um dia");
            System.out.println("4 - Alterar minha senha");

            System.out.println("0 - Voltar\n");

            System.out.print("Entre com uma ação: ");
            acao = Integer.parseInt(sc.nextLine());
            System.out.println("______________________________");

            switch (acao) {
                case 1 -> {
                    crudFuncionario();
                }
                case 2 -> {
                    crudProdutos();
                }
                case 3 -> {

                    boolean aux = false;

                    do {
                        System.out.print("Entre com o mês (Digito): ");
                        int mesCal = (Integer.parseInt(sc.nextLine())) - 1;

                        if (-1 < mesCal && mesCal < 12) {
                            rs.pedidosRealizados(mesCal);
                            aux = true;
                        }
                    } while (aux != true);
                }
                case 4 -> {
                    System.out.print("Entre com sua nova senha: ");
                    usuario.setSenha(sc.nextLine());

                    ra.alterarSenha(usuario.getSenha(), usuario.getId());
                }
                case 0 ->
                    funcoes();
                default ->
                    throw new AssertionError();
            }
            // Método para fazer o crud do funcionario
            //rp.buscarPessoa(usuario.getId());
        } while (logado != false);
    }

    // Métodos para Funcionário
    public static void criandoFuncionarios() {

        Funcionario func = new Funcionario();
        func.setIdFuncionario(1);
        func.setCpf("999.999.999-99");
        func.setEndereco("Aquele lá, 2");
        func.setNome("Thais Nascimento");
        func.setSenha("func1");
        func.setTelefone("(38) 99999-9999");
        func.setLogin("func1");
        func.setTipo_usuario(0);
        ra.criarFuncionario(func);

        Funcionario func1 = new Funcionario();
        func1.setIdFuncionario(2);
        func1.setCpf("999.999.999-99");
        func1.setEndereco("Na casa de cima, 5");
        func1.setNome("Jose Ribeiro");
        func1.setSenha("func2");
        func1.setTelefone("(38) 99999-9999");
        func1.setLogin("func2");
        func1.setTipo_usuario(0);
        ra.criarFuncionario(func1);

        Funcionario func2 = new Funcionario();
        func2.setIdFuncionario(3);
        func2.setCpf("999.999.999-99");
        func2.setEndereco("Na rua ao lado, 13");
        func2.setNome("Aberto Carlos");
        func2.setSenha("func2");
        func2.setTelefone("(38) 99999-9999");
        func2.setLogin("func2");
        func2.setTipo_usuario(0);
        ra.criarFuncionario(func2);

    }

    public static void crudFuncionario() {
        int acao = 0;

        do {
            System.out.println("TELA DE FUNCIONARIO\n\n");
            System.out.println("Olá, " + usuario.getNome() + ". Selecione a ação que deseja");
            // Apresentar as opções do que pode ser feito
            System.out.println("1 - Criar Funcionario");
            System.out.println("2 - Dados do Funcionario");
            System.out.println("3 - Atualizar Funcionario");
            System.out.println("4 - Deletar Funcionario");

            System.out.println("0 - Voltar\n");

            System.out.print("Entre com uma ação: ");
            acao = Integer.parseInt(sc.nextLine());
            System.out.println("______________________________");

            switch (acao) {
                case 1 -> {
                    System.out.print("CRIANDO FUNCIONÁRIO\n\n");

                    Funcionario nFuncionario = new Funcionario();

                    System.out.print("Id: ");
                    nFuncionario.setIdFuncionario(Integer.parseInt(sc.nextLine()));

                    System.out.print("Nome: ");
                    nFuncionario.setNome(sc.nextLine());

                    System.out.print("CPF: ");
                    nFuncionario.setCpf(sc.nextLine());

                    System.out.print("Login: ");
                    nFuncionario.setLogin(sc.nextLine());

                    System.out.print("Senha: ");
                    nFuncionario.setSenha(sc.nextLine());

                    System.out.print("Endereço: ");
                    nFuncionario.setEndereco(sc.nextLine());

                    System.out.print("Telefone: ");
                    nFuncionario.setTelefone(sc.nextLine());

                    System.out.print("Tipo de usuário: ");
                    nFuncionario.setTipo_usuario(Integer.parseInt(sc.nextLine()));

                    ra.criarFuncionario(nFuncionario);
                }
                case 2 -> {
                    System.out.print("DADOS DO FUNCIONÁRIO\n\n");

                    System.out.print("Entre com o id do funcionário: ");
                    int id = Integer.parseInt(sc.nextLine());
                    // Pegar o método para buscar o funcionário

                    ra.buscar("funcionario", id);
                }
                case 3 -> {
                    // Alterar dados do funcionário
                    System.out.print("ALTERAR DADOS DO FUNCIONÁRIO\n\n");

                    System.out.print("Entre com o id do funcionário: ");
                    int idDados = Integer.parseInt(sc.nextLine());
                    System.out.println("Dados do funcionário");
                    rs.buscar("funcionario", idDados);

                    Funcionario aFuncionario = new Funcionario();

                    System.out.print("Id: ");
                    aFuncionario.setIdFuncionario(Integer.parseInt(sc.nextLine()));

                    System.out.print("Nome: ");
                    aFuncionario.setNome(sc.nextLine());

                    System.out.print("CPF: ");
                    aFuncionario.setCpf(sc.nextLine());

                    System.out.print("Login: ");
                    aFuncionario.setLogin(sc.nextLine());

                    System.out.print("Senha: ");
                    aFuncionario.setSenha(sc.nextLine());

                    System.out.print("Endereço: ");
                    aFuncionario.setEndereco(sc.nextLine());

                    System.out.print("Telefone: ");
                    aFuncionario.setTelefone(sc.nextLine());

                    System.out.print("Tipo de usuário: ");
                    aFuncionario.setTipo_usuario(Integer.parseInt(sc.nextLine()));

                    ra.alterarDadosFuncionario(aFuncionario, idDados);
                }
                case 4 -> {
                    // Deletar usuário
                    System.out.println("Entre com o id do funcionário para ser deletado: ");
                    int idDel = sc.nextInt();

                    ra.deletarFuncionario(idDel);
                }
                case 5 -> {
                    System.out.println("Listar todos os funcionários: ");
                    ra.listarFuncionarios();
                }
                case 0 ->
                    funcoes();
                default ->
                    throw new AssertionError();
            }
        } while (logado != false);
    }

    // Mètodos Gerais
    public static void listandoTodos() {
        ra.listarAdmin();
        ra.listarFuncionarios();
        rs.listarClientes();
    }

    public static void login() {
        List<Admin> arrayAdmin = new ArrayList<>();
        arrayAdmin = ra.arrayAdmin();
        Funcionario arrayFunc[] = RepositorioAdmin.getListFunc();
        

        do {
            System.out.print("Entre com o login: ");
            String login = sc.nextLine();
            System.out.print("Entre com a senha: ");
            String senha = sc.nextLine();

            // Verificando se o login é no admin
            for (Admin admin : arrayAdmin) {
                if (admin.getLogin().equals(login) && admin.getSenha().equals(senha)) {
                    // Passando todos os dados para um "session" da pessoa
                    usuario = admin;

                    logado = true;
                    break;
                }
            }
            if (logado == false) {
                System.out.println("Chegamos aqui");
                // Verificando se o login é no funcionario
                for (Funcionario func : arrayFunc) {
                    if (func.getLogin().equals(login) && func.getSenha().equals(senha)) {
                        usuario = func;

                        logado = true;
                        break;
                    }
                }
            }

            if (logado == false) {
                System.out.println("Login ou senha inválidos. Tente novamente...\n");
            }

        } while (logado != true);

        System.out.println("\nLogado com sucesso!\n\n");
    }

    public static void funcoes() {
        int acao = 0;

        do {

            System.out.println("Olá, " + usuario.getNome() + ". Selecione a ação que deseja");
            // Apresentar as opções do que pode ser feito
            System.out.println("1 - Consultar Pedidos");
            System.out.println("2 - Alterações em Cliente");
            System.out.println("3 - Alterações em Pedido");
            System.out.println("4 - Meus dados");

            // Caso o usuário for admin ele tera opções a mais
            if (usuario.getTipo_usuario() == 1) {
                System.out.println("10 - Painel admin");
            }

            System.out.println("0 - Sair\n");
            System.out.print("Entre com uma ação: ");
            acao = Integer.parseInt(sc.nextLine());
            System.out.println("______________________________");

            switch (acao) {
                case 1 ->
                    rs.buscarPedidos();
                case 2 -> // Entrar no métodos de crud cliente
                    crudCliente();
                case 3 -> // Entrar no métodos de crud pedido
                    crudPedido();
                case 4 -> // Meus dados
                    meusDados();
                case 10 -> {
                    // Caso o usuário for admin ele tera opções a mais
                    if (usuario.getTipo_usuario() == 1) {
                        painelAdmin();
                        //break;
                    }
                }
                case 0 ->
                    logado = false;
                default ->
                    throw new AssertionError();
            }
        } while (logado != false);
        System.out.println("Você deslogou do sistema.");
        System.out.print("______________________________\n");
    }

    public static void meusDados() {
        System.out.println("ID: " + usuario.getId());
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("CPF: " + usuario.getCpf());
        System.out.println("Nível de usuário: " + usuario.getTipo_usuario());
        System.out.println("Login: " + usuario.getLogin());
        System.out.println("Telefone: " + usuario.getTelefone());
        System.out.println("Endereço: " + usuario.getEndereco() + "\n");
    }

    // Métodos para Protudos
    public static void crudProdutos() {
        int acao = 0;

        do {
            System.out.println("TELA DE PRODUTOS\n\n");
            System.out.println("Olá, " + usuario.getNome() + ". Selecione a ação que deseja");
            // Apresentar as opções do que pode ser feito
            System.out.println("1 - Criar Produto");
            System.out.println("2 - Dados do Produto");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Deletar Produto");

            System.out.println("0 - Voltar\n");

            System.out.print("Entre com uma ação: ");
            acao = Integer.parseInt(sc.nextLine());
            System.out.println("______________________________");

            switch (acao) {
                case 1 -> {
                    System.out.print("CRIANDO PEDIDO\n\n");

                    Produto nProduto = new Produto();

                    System.out.print("Id: ");
                    nProduto.setIdProduto(Integer.parseInt(sc.nextLine()));

                    System.out.print("Nome: ");
                    nProduto.setNomeProduto(sc.nextLine());

                    System.out.print("Descrição produto: ");
                    nProduto.setDescProduto(sc.nextLine());

                    System.out.print("Preço: ");
                    nProduto.setPreco(Double.parseDouble(sc.nextLine()));

                    ra.criarProduto(nProduto);
                }
                case 2 -> {
                    // Buscando os dados do pedido
                    System.out.print("DADOS DO PRODUTO\n\n");

                    System.out.print("Entre com o id do produto: ");
                    int id = Integer.parseInt(sc.nextLine());

                    // Pegar o método para buscar o pedido
                    ra.buscar("produto", id);
                }
                case 3 -> {
                    // Alterar dados do pedido
                    System.out.print("ALTERAR DADOS DO PRODUTO\n\n");

                    System.out.print("Entre com o id do produto: ");
                    int idDados = Integer.parseInt(sc.nextLine());
                    System.out.println("Dados do produto");
                    ra.buscar("pedido", idDados);

                    Produto aProduto = new Produto();

                    System.out.print("Id: ");
                    aProduto.setIdProduto(Integer.parseInt(sc.nextLine()));

                    System.out.print("Nome: ");
                    aProduto.setNomeProduto(sc.nextLine());

                    System.out.print("Descrição do Produto: ");
                    aProduto.setDescProduto(sc.nextLine());

                    System.out.print("Preço: ");
                    aProduto.setPreco(sc.nextDouble());

                    ra.alterarProduto(aProduto, idDados);
                }
                case 4 -> {
                    System.out.print("Entre com o id do produto: ");
                    int idDell = Integer.parseInt(sc.nextLine());

                    ra.deletarProduto(idDell);
                }
                case 5 -> {
                    System.out.print("Todos os produtos: ");
                    ra.listarProdutos();
                }
                case 0 ->
                    funcoes();
                default ->
                    throw new AssertionError();
            }
        } while (logado != false);
    }

    // Métodos para Pedido
    public static void crudPedido() {
        int acao = 0;

        do {
            System.out.println("TELA DE PEDIDOS\n\n");
            System.out.println("Olá, " + usuario.getNome() + ". Selecione a ação que deseja");
            // Apresentar as opções do que pode ser feito
            System.out.println("1 - Criar Pedido");
            System.out.println("2 - Dados do Pedido");
            System.out.println("3 - Atualizar Pedido");

            System.out.println("0 - Voltar\n");

            System.out.print("Entre com uma ação: ");
            acao = Integer.parseInt(sc.nextLine());
            System.out.println("______________________________");

            switch (acao) {
                case 1 -> {
                    System.out.print("CRIANDO PEDIDO\n\n");

                    Pedido nPedido = new Pedido();

                    System.out.print("Id: ");
                    nPedido.setIdPedido(Integer.parseInt(sc.nextLine()));

                    System.out.print("Nome: ");
                    nPedido.setNome(sc.nextLine());

                    System.out.print("Cliente: ");
                    nPedido.setCliente(sc.nextLine());

                    System.out.print("Adicionais: ");
                    nPedido.setAdicionais(sc.nextLine());

                    System.out.print("Descrição: ");
                    nPedido.setDescPedido(sc.nextLine());

                    System.out.print("Tipo de pagamento: ");
                    nPedido.setPagamento(sc.nextLine());

                    System.out.print("Previsao de Entrega: ");
                    nPedido.setPrevisaoEntrega(sc.nextLine());

                    System.out.print("Status: ");
                    nPedido.setStatus(sc.nextLine());

                    System.out.println(mes);
                    rs.criarPedido(nPedido, mes);
                }
                case 2 -> {
                    // Buscando os dados do pedido
                    System.out.print("DADOS DO PEDIDO\n\n");

                    System.out.print("Entre com o id do pedido: ");
                    int id = Integer.parseInt(sc.nextLine());

                    // Pegar o método para buscar o pedido
                    rs.buscar("pedido", id);
                }
                case 3 -> {
                    // Alterar dados do pedido
                    System.out.print("ALTERAR DADOS DO PEDIDO\n\n");

                    System.out.print("Entre com o id do pedido: ");
                    int idDados = Integer.parseInt(sc.nextLine());
                    System.out.println("Dados do pedido");
                    rs.buscar("pedido", idDados);

                    Pedido aPedido = new Pedido();

                    System.out.print("Id: ");
                    aPedido.setIdPedido(Integer.parseInt(sc.nextLine()));

                    System.out.print("Nome: ");
                    aPedido.setNome(sc.nextLine());

                    System.out.print("Cliente: ");
                    aPedido.setCliente(sc.nextLine());

                    System.out.print("Adicionais: ");
                    aPedido.setAdicionais(sc.nextLine());

                    System.out.print("Descrição: ");
                    aPedido.setDescPedido(sc.nextLine());

                    System.out.print("Tipo de pagamento: ");
                    aPedido.setPagamento(sc.nextLine());

                    System.out.print("Previsao de Entrega: ");
                    aPedido.setPrevisaoEntrega(sc.nextLine());

                    System.out.print("Status: ");
                    aPedido.setStatus(sc.nextLine());

                    rs.alterarPedido(aPedido, idDados);
                }
                case 0 ->
                    funcoes();
                default ->
                    throw new AssertionError();
            }
        } while (logado != false);

    }
}
