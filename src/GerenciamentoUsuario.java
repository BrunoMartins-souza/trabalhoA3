import java.util.HashMap;
import java.util.Map;

public class GerenciamentoUsuario {
    private Map<String, Usuario> usuarios;

    public GerenciamentoUsuario(){
        this.usuarios = new HashMap<>();
    }

    public void adicionarUsuario(Usuario usuario){
        if(usuarios.containsKey(usuario.getEmail())){
            System.out.println("Email já cadastrado!");
        }else{
            usuarios.put(usuario.getEmail(), usuario);
            System.out.println("Usuário cadastrado com sucesso.");
        }
    }

    //metodo para autenticar usuario com email e senha 
    public Usuario autenticarUsuario(String email, String senha){
        Usuario usuario = usuarios.get(email);
        if (usuario != null && usuario.getSenha().equals(senha)){
            return usuario;
        }else{
            System.out.println("Email ou senha inválidos.");
            return null;
        }
    }

    public void exibirTodosUsuarios(){
        if(usuarios.isEmpty()){
            System.out.println("Nenhum usuário cadastrado.");
        }else{
            for(Usuario usuario : usuarios.values()){
                System.out.println(usuario);
            }
        }
    }
}
