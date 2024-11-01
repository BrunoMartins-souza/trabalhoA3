import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Estoque estoque = new Estoque();
        Livro livro = new Livro(estoque);
        GerenciamentoUsuario gerenciamentoUsuario = new GerenciamentoUsuario();
        Usuario usuarios = new Usuario(gerenciamentoUsuario);

        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Usuários.");
            System.out.println("2. Livros");
            System.out.println("3. Sair");

            opcao = input.nextInt();
            input.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    usuarios.menuUsuario();
                    break;
                case 2:
                    livro.menuLivro();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }while (opcao != 3);

         
    }
}