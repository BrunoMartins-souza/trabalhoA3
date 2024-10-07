import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int opc;

        do {
            System.out.println(" 1 - para Administrador.");
            System.out.println(" 2 - para Leitor.");
            System.out.println(" 3 - Sair.");
            System.out.print("Escolha uma opção: ");
            opc = input.nextInt();

            switch (opc) {
                case 1:
                    Administrador adm = new Administrador();
                    adm.administrador(input);
                    break;
                case 2:
                    System.out.println("Leitor.");
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        } while (opc != 3);
    }
}
