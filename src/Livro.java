import java.util.ArrayList;
import java.util.Scanner;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int quantidadeEstoque;

    public Livro(){
    }   

    public Livro(String titulo, String autor, String isbn, int quantidadeEstoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    //menu Livro
    public  void menuLivro(){
        Scanner input = new Scanner(System.in);
        Estoque estoque = new Estoque();

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
   						 System.out.print("Digite o ISBN do livro que deseja exibir: ");
    					 String isbn = input.nextLine();
    					 exibirLivroPorISBN(isbn);
    				break;

	
				
                
                case 4:
					MostrarLivros();
					break;
            
                default:
                    break;
            }
            
        }while(opcaoLivro != 5);
    }
	private static ArrayList<Livro> listaLivros = new ArrayList<Livro>();
    public void cadastrarNovoLivro(){
        Scanner input = new Scanner(System.in);
        Estoque estoque = new Estoque();

        System.out.print("Digite o título do livro: ");
        String titulo = input.nextLine();

        System.out.print("Digite o autor do livro: ");
        String autor = input.nextLine();

        System.out.print("Digite o ISBN do livro: ");
        isbn = input.nextLine();
		    for (Livro livro : listaLivros) {
        if (livro.getIsbn().equals(isbn)) {
            System.out.println("Erro: Um livro com este ISBN já está cadastrado!");
        	return;
        }

    }//verifica se o ISBN ja foi cadastrado
		


        System.out.print("Digite a quantidade de exemplares no estoque: ");
        int quantidadeEstoque = input.nextInt();

        Livro novoLivro = new Livro(titulo, autor, isbn, quantidadeEstoque);
        estoque.adicionarLivro(novoLivro);
		listaLivros.add(novoLivro);
        System.out.println("Livro adicionado ao estoque com sucesso!");
  		
      
      
    }


  //MOSTRAR LIVROS
		public static void MostrarLivros(){
		System.out.print("Livros Cadastrados: ");
		System.out.println(listaLivros.size());

 		for(int i=0; i < listaLivros.size(); i++){
		System.out.println("Titulo livro: " + listaLivros.get(i).titulo + "\nAutor do Livro: " + listaLivros.get(i).autor + "\nIsbn: " + listaLivros.get(i).isbn + "\nQuantidade em estoque: " + listaLivros.get(i).quantidadeEstoque);
		System.out.println("---------------");
		

        }
		System.out.println("Voltando ao menu...");


}
		

 	public static void exibirLivroPorISBN(String isbn) {
    boolean livroEncontrado = false;
    
    for (Livro livro : listaLivros) {
        if (livro.getIsbn().equals(isbn)) {
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("ISBN: " + livro.getIsbn());
            System.out.println("Quantidade em estoque: " + livro.getQuantidadeEstoque());
			System.out.println("Voltando ao menu...");
            livroEncontrado = true;
            break;
        }
    }
    
    if (!livroEncontrado) {
        System.out.println("Livro com ISBN " + isbn + " não encontrado.");
		System.out.println("Voltando ao menu...");
    }
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
