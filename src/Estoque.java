import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<String, Livro> livros;

    //Construtor que inicializa o map
    public Estoque(){
        this.livros = new HashMap<>();
    }

    //metodo para adicionar livro ao estoque
    public void adicionarLivro(Livro livro){
        if (livros.containsKey(livro.getIsbn())){
            //atualizar a quantidade e o livro já existir
            livros.get(livro.getIsbn()).adicionarEstoque(livro.getQuantidadeEstoque());
        }else{
            //adicionar um novo livro ao estoque
            livros.put(livro.getIsbn(), livro);
        }
    }

    //metodo para remover uma quantidade específica de um livro do estoque
    public void removerLivro(String isbn, int quantidade){
        if (livros.containsKey(isbn)) {
            livros.get(isbn).removerEstoque(quantidade);
            //remover do estoque se a quantiade chegar a zero
            if (livros.get(isbn).getQuantidadeEstoque() <= 0) {
                livros.remove(isbn);
                System.out.println("Livro removido do estoque! Quantidade zero.");
            }
        }else {
            System.out.println("Livro não cadastrado no estoque.");
        }
    } 

    //metodo para exibir informações do livros pelo isbn
    public void exibirLivro(String isbn){
        if(livros.containsKey(isbn)){
            System.out.println();
            System.out.println("Titulo: " + livros.get(isbn).getTitulo());
            System.out.println("Autor: " + livros.get(isbn).getAutor());
            System.out.println("ISBN: " + livros.get(isbn).getIsbn());
            System.out.println("Quantidade em Estoque: " + livros.get(isbn).getQuantidadeEstoque());
        }else{
            System.out.println("\nLivro não encontrado no estoque.\n");
        }
    }

    //metodo para exibir todos os livros no estoque
    public void exibirTodosLivros(){
        if (livros.isEmpty()) {
            System.out.println("\nO estoque está vazio.\n");
        }else{    
            String separacao = "-";
            String tracos = separacao.repeat(100);

            System.out.printf("%-16s | %-16s | %-10s | %-16s", "Titulo", "Autor", "ISBN", "Estoque");
            System.out.println("\n" + tracos);

            for(Livro livros : livros.values()){
                System.out.printf("\n%-16s | %-16s | %-10s | %-16s",livros.getTitulo(), livros.getAutor(), livros.getIsbn(), livros.getQuantidadeEstoque()); //comando para preencher a tabela com os dados.
            }
            System.out.println();
        }
    }
}