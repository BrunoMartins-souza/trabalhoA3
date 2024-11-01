import java.util.Scanner;

public class Usuario {
    public enum TipoUsuario{
        ADMIN, CLIENTE
    }

    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipo;
    private GerenciamentoUsuario gerenciamentoUsuario;

    public Usuario(GerenciamentoUsuario gerenciamentoUsuario){
        this.gerenciamentoUsuario = gerenciamentoUsuario;
    }

    public Usuario(String nome, String email, String senha, TipoUsuario tipo){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public void menuUsuario(){
        Scanner input = new Scanner(System.in);

        int opcao;

        do{
            System.out.println("\n");
            System.out.println("1 - Fazer login");
            System.out.println("2 - Cadastrar novo usuário");
            System.out.println("3 - Retornar ao menu anterior");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            System.out.println("\n");

            input.nextLine();

            switch (opcao){
                case 1:
                    login();
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    System.out.println("Retornando ao menu anterior... ");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(opcao != 3);
    }

    private void login(){
        Scanner input = new Scanner(System.in);

        System.out.println("\n");
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Senha: ");
        String senha = input.nextLine();

        Usuario usuario = gerenciamentoUsuario.autenticarUsuario(email, senha);

        if(usuario != null){
            if(usuario.getTipo() == Usuario.TipoUsuario.ADMIN){
                menuAdmin();
            }else{
                menuCliente();
            }
        }
    }

    private void cadastrarUsuario(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("\n");
        System.out.print("Nome: ");
        String nome = input.nextLine();

        System.out.print("Email: ");
        String email = input.nextLine();

        System.out.print("Senha: ");
        String senha = input.nextLine();

        System.out.print("Tipo de usuário (1 para ADMIN, 2 para CLIENTE): ");
        int tipoOpcao = input.nextInt();

        TipoUsuario tipo = (tipoOpcao == 1) ? TipoUsuario.ADMIN : TipoUsuario.CLIENTE;

        Usuario novoUsuario = new Usuario(nome, email, senha, tipo);
        gerenciamentoUsuario.adicionarUsuario(novoUsuario);

        System.out.println("\n");
    }

    private void menuAdmin(){
        Scanner input = new Scanner(System.in);

        int opcao;
        do{
            System.out.println("\n");
            System.out.println("\n=== Menu Administrador ===");
            System.out.println("1 - Gerenciar livros");
            System.out.println("2 - Exibir todos os usuários");
            System.out.println("3 - Retornar ao menu anterior");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            input.nextLine();

            switch (opcao) {
                case 1:
                    
                    break;
                case 2: 
                    gerenciamentoUsuario.exibirTodosUsuarios();
                    break;
                case 3:
                    System.out.println("Retornano ao menu anterior...");
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(opcao != 3);

        System.out.println("\n");
    }

    private void menuCliente(){
        Scanner input = new Scanner(System.in);
        
        int opcao;

        do{
            System.out.println("\n");
            System.out.println("\n=== Menu Cliente ===");
            System.out.println("1 - Adicionar livro ao carrinho");
            System.out.println("2 - Adicionar livro à lista de desejos");
            System.out.println("3 - Retornar ao menu anterior");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Adicionando livro ao carrinho...");
                    break;
                case 2:
                    System.out.println("Adicionando livro à lista de desejos...");
                    break;
                case 3:
                    System.out.println("Retornano ao menu anterior...");
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(opcao != 3);
    }

    //Getters e Setters
    public String getEmail(){
        return email;
    }

    public String getSenha(){
        return senha;
    }

    public String getNome(){
        return nome;
    }

    public TipoUsuario getTipo(){
        return tipo;
    }
    //getEmail, getSenha e getNome são usados para acessar informações do usuário.
}
