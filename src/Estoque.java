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
            System.out.println(livros.get(isbn).getTitulo());
            System.out.println(livros.get(isbn).getAutor());
            System.out.println(livros.get(isbn).getIsbn());
        }else{
            System.out.println("Livro não encontrado no estoque.");
        }
    }

    //metodo para exibir todos os livros no estoque
    public void exibirTodosLivros(){
        if (livros.isEmpty()) {
            System.out.println("O estoque está vazio.");
        }else{
            for(Livro livro : livros.values()){
                System.out.println(livro);
            }
        }
    }
    
}
