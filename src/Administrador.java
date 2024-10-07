import java.util.Scanner;
//import java.util.ArrayList;

public class Administrador {

    String nomeAdm;
    String matriculaAdm;

    public void administrador(Scanner input){
        //Scanner input = new Scanner(System.in);
        
        
        int opc;
        
        do{
            System.out.println(" 1 - Cadastrar Administrador.");
            System.out.println(" 2 - Consultar Administrador.");
            System.out.println(" 3 - Voltar ao menu anterior.");
            opc = input.nextInt();
            //input.skip("[\r\n]");

            switch (opc) {
                case 1:
                    cadastrarAdm(input);
                    break;
                case 2:
                    consultaAdm(input);
                    break;
                case 3:
                System.out.println("Retornando ao menu anterior...");
                    break;
            
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }while(opc != 3);
    }

    public void cadastrarAdm(Scanner input){

        this.nomeAdm = nomeAdm;
        this.matriculaAdm = matriculaAdm;
        int opcao;

        do{
            System.out.print("Informe o nome completo do adm: ");
            nomeAdm = input.nextLine();
            //input.skip("[\r\n]");
            System.out.print("Informe a matrícula do adm: ");
            matriculaAdm = input.nextLine();

            System.out.println("Deseja cadastrar mais administradores? ");
            System.out.print(" 0 - Sim. ");
            System.out.print(" 1 - Não. ");
            opcao = input.nextInt();
        } while(opcao != 1);
    }

    public void consultaAdm(Scanner input){

        System.out.println(this.nomeAdm + " | Matricula: " + this.matriculaAdm);
    }
}
