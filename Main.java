Fazendo ainda!! (não finalizada)

import java.util.ArrayList;
import java.util.Scanner;

//Lara Galvao – 10746133
//Sara Souza – 10746137
//Gabriel Bandeira – 10748004
//Filipe Mizael – 10748000

public class Mainn {

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    public static ArrayList<Livro> livros = new ArrayList<>();
    // public static ArrayList<Exemplar> exemplares = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        inicio();

        int opcao;

        do {

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

                    buscarLivro();

                    break;

                case 6:

                    buscarExemplar();

                    break;

                case 7:

                    listarUsuarios();

                    break;

                case 8:

                    listarExemplaresLivro();

                    break;

                default:
                    break;
            }
        } while (opcao != 0);

        input.close();

    }

    // Seção de buscas

    // Buscar livro

    public static void buscarLivro() {
        System.out.println("\n Buscar livro (pelo código): ");

        System.out.print("Digite o código do livro que deseja buscar: ");
        int cdg_livro = input.nextInt();

        boolean encontrado = false;

        for (Livro l : livros) {
            if (l.getCodigoLivro() == cdg_livro) {
                System.out.println("\n----Informações do livro----\n");
                l.mostrarLivro();
                System.out.println("\n");
            }
        }

        if (encontrado == false) {
            System.out.println("Livro respectivo não encontrado!");
        }

        input.nextLine();

    }

    // Buscar exemplar

    public static void buscarExemplar() {

        System.out.println("\n Buscar exemplar (pelo código): ");

        System.out.print("Digite o código do exemplar que deseja buscar: ");
        int cdg_exemplar = input.nextInt();

        boolean encontrado = false;

        for (Livro l : livros) {
            for (Exemplar e : l.getExemplares()) {
                if (e.getcodigoExemplar() == cdg_exemplar) {
                    System.out.println("\n----Informações do exemplar----\n");
                    e.mostrarExemplar();
                    System.out.println("\n");
                }
            }
        }

        if (encontrado == false) {
            System.out.println("Exemplar não encontrado!");
        }

        input.nextLine();

    }

    // Listar usuários

    public static void listarUsuarios() {

        for (Usuario u : usuarios) {
            System.out.println("\n----Informações do usuário----\n");
            System.out.println(u.toString());
        }

    }

    // Listar exemplares de um livro

    public static void listarExemplaresLivro() {

        System.out.println("Deseja listar os exemplares de qual livro? (Digite o código): ");
        int cdg_livro = input.nextInt();

        boolean encontrado = false;

        for (Livro l : livros) {
            if (l.getCodigoLivro() == cdg_livro) {
                encontrado = true;

                System.out.println("\n----Livro----\n");
                l.mostrarLivro();

            }
        }

        if (encontrado == false) {
            System.out.println("Exemplar não encontrado!");
        }

    }

    // Seção de cadastros

    // Usuario

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

    // Funcionario
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

    // Livro
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

    // Exemplar
    public static void cadastrarExemplar() {

        System.out.println("\n Cadastro de Exemplar: ");

        System.out.print("Código do livro: ");
        int cdg_livro = input.nextInt();

        boolean encontrado = false;

        for (Livro l : livros) {
            if (l.getCodigoLivro() == cdg_livro) {
                encontrado = true;
                System.out.println("Livro encontrado! Digite o código do exemplar: ");
                int cdg_exemplar = input.nextInt();

                Exemplar exemplar = new Exemplar(cdg_exemplar, true);
                l.adicionarExemplar(exemplar);

                System.out.println("Exemplar do livro cadastrado com sucesso!");
            }
        }

        if (!encontrado) {
            System.out.println("Livro respectivo não encontrado!");
        }

        input.nextLine();

    }

    // Dados iniciais

    public static void inicio() {

        Usuario usuario = new Usuario("Alex", "1995", "11912345678", 1);
        Funcionario funcionario = new Funcionario("Fernanda", "1998", "11912345678", 2);
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 1889, 1);
        Exemplar exemplar = new Exemplar(1, true);

        livro.adicionarExemplar(exemplar);
        livro.adicionarExemplar(exemplar);

        usuarios.add(usuario);
        funcionarios.add(funcionario);
        livros.add(livro);

    }

}
