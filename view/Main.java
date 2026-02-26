package view;
import model.Pedido;
import service.Service;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
        System.out.println("Bem vindo(a)! Oque deseja? \n1 - Cadastrar produto\n" +
                "2 - Cadastrar cliente\n" +
                "3 - Criar pedido\n" +
                "4 - Adicionar produto ao pedido\n" +
                "5 - Listar pedidos\n" +
                "6 - Buscar pedido por ID\n" +
                "7 - Alterar status do pedido\n" +
                "8 - Sair");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        switch (escolha){
            case 1:
                try {
                    System.out.println("digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.println("digite o preço do produto usando o ',' : ");
                    Double preco = scanner.nextDouble();
                    scanner.nextLine();
                    String id = service.cadastrarProduto(nome, preco);
                    System.out.println("id do produto: " + id);
                    System.out.println("Produto cadastrado!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } break;
            case 2:
                try {
                    System.out.println("Digite o nome do Cliente: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o email: ");
                    String email = scanner.nextLine();
                    String id = service.cadastrarUsuario(nome,email);
                    System.out.println("id do usuario " + id);
                    System.out.println("Cliente cadastrado com sucesso");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } break;
            case 3:
                try {
                    System.out.println("digite o id do usuario: ");
                    String idUsuario = scanner.nextLine();
                    LocalDateTime localDateTime = LocalDateTime.now();
                    String idPedido = service.criarPedido(idUsuario, localDateTime);
                    System.out.println(idPedido + "id do pedido");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } break;
            case 4:
                try {
                    System.out.println("Digite id do pedido: ");
                    String pedidoID = scanner.nextLine();
                    System.out.println("Escolha um produto com o id correspondente: ");
                    service.mostrarProdutos();
                    String produtoID = scanner.nextLine();
                    service.adicionarProdutoAoPedido(pedidoID, produtoID);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } break;
            case 5:
                try {
                    service.listarPedidos();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } break;
            case 6:
                try {
                    System.out.println("Digite o id do pedido: ");
                    String pedidoID = scanner.nextLine();
                    Pedido pedido = service.buscarPedidoPorId(pedidoID);
                    System.out.println(pedido.getCliente().getNome() + " " + pedido.getStatus() + "  Valor total: " + pedido.valorTotal());
                    pedido.mostrarProdutos();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } break;
            case 7:
                try {
                    System.out.println("Digite o id do pedido: ");
                    String pedidoID = scanner.nextLine();
                    System.out.println("Digite 1 para CONCLUIR e 2 para CANCELAR");
                    int escolhaCancelarOuConcluir = scanner.nextInt();
                    scanner.nextLine();
                    if (escolhaCancelarOuConcluir == 1) {
                        service.statusDoPedidoConcluido(pedidoID);
                    } else if (escolhaCancelarOuConcluir == 2) {
                        service.statusDoPedidoCancelado(pedidoID);
                    } else {
                        System.out.println("Escolha uma opção");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } break;
            case 8:
                scanner.close();
                executando = false;
                break;
        }

    }
    }
}