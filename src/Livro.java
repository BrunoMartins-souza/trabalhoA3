import java.util.Scanner;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int quantidadeEstoque;
    private Estoque estoque;

    public Livro(Estoque estoque){
        this.estoque = estoque;
    }

    public Livro(){

    }

    public Livro(String titulo, String autor, String isbn, int quantidadeEstoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    //menu Livro
    public void menuLivro(){
        Scanner input = new Scanner(System.in);

        int opcaoLivro = 0;

        do{
            System.out.println("\nEscolha uma opção:");
            System.out.println(" 1 - Adicionar um livro ao estoque");
            System.out.println(" 2 - Remover um livro do estoque");
            System.out.println(" 3 - Exibir um livro");
            System.out.println(" 4 - Exibir todos os livros");
            System.out.println(" 5 - Voltar ao menu anterior");
            opcaoLivro = input.nextInt();
            input.nextLine();

            switch (opcaoLivro) {
                case 1:
                    cadastrarNovoLivro();
                    break;
                case 2:

                    break;
                case 3:
                    exibirLivros();
                    break;
                case 4:
                    exibirTodosLivros();
                    break;
                default:
                    break;
            }
            
        }while(opcaoLivro != 5);
    }

    public void cadastrarNovoLivro(){
        Scanner input = new Scanner(System.in);

        System.out.println();

        System.out.print("Digite o título do livro: ");
        String titulo = input.nextLine();

        System.out.print("Digite o autor do livro: ");
        String autor = input.nextLine();

        System.out.print("Digite o ISBN do livro: ");
        String isbn = input.nextLine();

        System.out.print("Digite a quantidade de exemplares no estoque: ");
        int quantidadeEstoque = input.nextInt();

        Livro novoLivro = new Livro(titulo, autor, isbn, quantidadeEstoque);
        estoque.adicionarLivro(novoLivro);
        System.out.println("\nLivro adicionado ao estoque com sucesso!");
    }

    public void exibirLivros(){
        Scanner input = new Scanner (System.in);

        System.out.print("\nInforme o ISBN do livro que deseja exibir: ");
        String isbn = input.nextLine();

        estoque.exibirLivro(isbn);
    }

    public void exibirTodosLivros(){

        estoque.exibirTodosLivros();
    }

    //Getters e Setters
    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public String getIsbn(){
        return isbn;
    }

    public int getQuantidadeEstoque(){
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque){
        this.quantidadeEstoque = quantidadeEstoque;
    }

    //Metodo para adicionar quantidades a estoque 
    public void adicionarEstoque(int quantidade){
        this.quantidadeEstoque += quantidade;
    }

    //Metodo para remover quantidade do estoque
    public void removerEstoque(int quantidade){
        if (this.quantidadeEstoque >= quantidade){
            this.quantidadeEstoque -= quantidade;
        }else{
            System.out.println("Estoque insuficiente!");
        }
    }
}
