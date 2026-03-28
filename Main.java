Fazendo ainda!! (não finalizada)

import java.util.ArrayList;
import java.util.Scanner;

public class Mainn {

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    public static ArrayList<Livro> livros = new ArrayList<>();
    public static ArrayList<Exemplar> exemplares = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args){

        int opcao;

        do{

        System.out.println("-----MENU-----");
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Cadastrar funcionário");
        System.out.println("3 - Cadastrar Livro");
        System.out.println("4 - Cadastrar Exemplar");
        System.out.println("5 - Buscar Livro");
        System.out.println("6 - Buscar Exemplar");
        System.out.println("7 - Listar todos os usuários");
        System.out.println("8 - Listar todos os exemplares disponíveis de um livro");
        System.out.println("9 - Registrar um empréstimo de livro");
        System.out.println("10 - Registrar uma devolução de livro");
        System.out.println("-----DIGITE 0 PARA SAIR-----");

        opcao = input.nextInt();
        input.nextLine();

        switch (opcao) {
            case 1:

                cadastrarUsuario();
                
                break;

            case 2:

                cadastrarFuncionario();

                break;

            case 3:

                cadastrarLivro();

                break;
        
            case 4:

                cadastrarExemplar();

                break;

            
            case 5:

                BuscarLivro();

                break;
        
        
            default:
                break;
        }
    }while (opcao != 0);
        
        input.close();

    }

    //Seção de buscas

    public static void BuscarLivro() {
        System.out.println("\n Buscar livro (pelo código): ");

        System.out.print("Digite o código do livro que deseja buscar: ");
        String nome = input.nextLine();
        
        
        System.out.println("\n Informações do livro: ");
        input.nextLine();

        Usuario usuario = new Usuario(nome, data_nasc, telefone, id);
        usuarios.add(usuario);

        System.out.println("Usuário cadastrado com sucesso!");

    }





    // Seção de cadastros

    //Usuario

    public static void cadastrarUsuario() {
        System.out.println("\n Cadastro de Usuário: ");

        System.out.print("Nome completo: ");
        String nome = input.nextLine();
        System.out.print("Data de nascimento: ");
        String data_nasc = input.nextLine();
        System.out.print("Telefone: ");
        String telefone = input.nextLine();
        System.out.print("Registro de usuário (ID único): ");
        int id = input.nextInt();
        input.nextLine();

        Usuario usuario = new Usuario(nome, data_nasc, telefone, id);
        usuarios.add(usuario);

        System.out.println("Usuário cadastrado com sucesso!");

    }

    //Funcionario
    public static void cadastrarFuncionario() {
        System.out.println("\n Cadastro de Funcionário: ");

        System.out.print("Nome completo: ");
        String nome = input.nextLine();
        System.out.print("Data de nascimento: ");
        String data_nasc = input.nextLine();
        System.out.print("Telefone: ");
        String telefone = input.nextLine();
        System.out.print("Registro de Funcionário (ID único): ");
        int id = input.nextInt();
        input.nextLine();

        Funcionario funcionario = new Funcionario(nome, data_nasc, telefone, id);
        funcionarios.add(funcionario);

        System.out.println("Funcionário cadastrado com sucesso!");

    }

    //Livro
    public static void cadastrarLivro() {

        System.out.println("\n Cadastro de Livro: ");

        System.out.print("Título: ");
        String titulo = input.nextLine();
        System.out.print("Autor: ");
        String autor = input.nextLine();
        System.out.print("Ano de publicação: ");
        int ano_publicacao = input.nextInt();
        System.out.print("Código do livro: ");
        int cdg_livro = input.nextInt();
        input.nextLine();

        Livro livro = new Livro(titulo, autor, ano_publicacao, cdg_livro);
        livros.add(livro);

        System.out.println("Livro cadastrado com sucesso!");

    }

    //Exemplar
    public static void cadastrarExemplar() {

        System.out.println("\n Cadastro de Exemplar: ");

        System.out.print("Código do livro: ");
        int cdg_livro = input.nextInt();

        boolean encontrado = false;

        for (Livro l : livros){
            if(l.getCodigoLivro() == cdg_livro){
                encontrado = true;
                System.out.println("Livro encontrado! Digite o código do exemplar: ");
                int cdg_exemplar = input.nextInt();

                Exemplar exemplar = new Exemplar(cdg_exemplar, true);
                l.adicionarExemplar(exemplar);
                
                System.out.println("Exemplar do livro cadastrado com sucesso!");
            }
        }

        if(!encontrado){
            System.out.println("Livro respectivo não encontrado!");
        }
        
        input.nextLine();

    }

}
