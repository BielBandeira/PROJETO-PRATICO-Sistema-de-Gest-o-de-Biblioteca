Fazendo ainda!! (não finalizada)

import java.time.LocalDate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public static ArrayList<Emprestimo> emprestimos = new ArrayList<>();
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
            System.out.println("11 - Prolongar um empréstimo");
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

                case 9:

                    registrarEmprestimo();

                    break;

                case 10:

                    registrarDevolucaoLivro();

                    break;

                case 11:

                    prolongarEmprestimo();

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

    // Registrar emprestimo de Livro

    public static void registrarEmprestimo() {

        // Selecionar exemplar do empréstimo
        Exemplar exemplar = null;

        System.out.println("\nRegistrar novo empréstimo: ");
        System.out.print("\n");
        System.out.print("---Deseja registrar um empréstimo de qual exemplar:---");
        System.out.print("\n");
        System.out.print("\n");
        do {
            for (int i = 0; i < livros.size(); i++) {
                System.out.println(i + " - " + livros.get(i).getTitulo());
                if (i == (livros.size() - 1)) {
                    System.out.print("\n");
                }
            }

            System.out.print("Livro: ");
            int escolhaL = input.nextInt();
            Livro emp_livro = livros.get(escolhaL);

            for (Exemplar e : emp_livro.getExemplares()) {
                if (e.getDisponivel()) {
                    exemplar = e;
                    break;
                }
            }

            if (exemplar == null) {
                System.out.println("Este livro não possui exemplares disponíveis!");
            }

        } while (exemplar == null);

        // Selecionar usuário do empréstimo

        System.out.print("---O empréstimo será para qual usuário:---");
        System.out.print("\n");
        System.out.print("\n");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(i + " - " + usuarios.get(i).getNome());
            if (i == (usuarios.size() - 1)) {
                System.out.print("\n");
            }
        }
        System.out.print("Usuário: ");
        int escolhaU = input.nextInt();
        Usuario emp_user = usuarios.get(escolhaU);

        // Selecionar data do empréstimo

        input.nextLine();

        System.out.print("Digite a data do empréstimo: ");
        String data_emp_string = input.nextLine();
        DateTimeFormatter formatador_data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataEmprestimo = LocalDate.parse(data_emp_string, formatador_data);

        Emprestimo emprestimo = new Emprestimo(exemplar, emp_user, dataEmprestimo);
        emprestimos.add(emprestimo);

    }

    // Registrar devolução de livro

    public static void registrarDevolucaoLivro(){
        
        System.out.print("---Deseja realizar e devolução de qual empréstimo?:---");
        System.out.print("\n");
        System.out.print("\n");
        for (int i = 0; i < emprestimos.size(); i++) {

            Exemplar exemplarEmprestimo = emprestimos.get(i).getExemplar();
            String tituloLivroEmp = null;

            for(Livro l : livros){
                for(Exemplar e : l.getExemplares()){
                    if (e == exemplarEmprestimo) {
                        tituloLivroEmp = l.getTitulo();
                        break;
                    }
                }
            }

            Usuario usuario_emprestimo = emprestimos.get(i).getUsuario();
            LocalDate data_do_emprestimo = emprestimos.get(i).getDataEmprestimo();
            LocalDate data_p_devolucao = emprestimos.get(i).getDataPrevistaDevolucao();

            System.out.println(i + " - Livro: " + tituloLivroEmp + " / " + usuario_emprestimo + " / Data do empréstimo: " + data_do_emprestimo + " / Data da devolução: " + data_p_devolucao);

            if (i == (emprestimos.size() - 1)) {
                System.out.print("\n");
            }
        }
        System.out.print("Emprestimo: ");
        int escolhaE = input.nextInt();
        Emprestimo emp_escolhido = emprestimos.get(escolhaE);

        emp_escolhido.devolver();
        System.out.println("Devolução realizada!");

    }

    // Prolongar empréstimo

    public static void prolongarEmprestimo(){

        System.out.print("---Deseja prolongar a data de devolução de qual empréstimo?:---");
        System.out.print("\n");
        System.out.print("\n");
        for (int i = 0; i < emprestimos.size(); i++) {

            Exemplar exemplarEmprestimo = emprestimos.get(i).getExemplar();
            String tituloLivroEmp = null;

            for(Livro l : livros){
                for(Exemplar e : l.getExemplares()){
                    if (e == exemplarEmprestimo) {
                        tituloLivroEmp = l.getTitulo();
                        break;
                    }
                }
            }

            Usuario usuario_emprestimo = emprestimos.get(i).getUsuario();
            LocalDate data_do_emprestimo = emprestimos.get(i).getDataEmprestimo();
            LocalDate data_p_devolucao = emprestimos.get(i).getDataPrevistaDevolucao();

            System.out.println(i + " - Livro: " + tituloLivroEmp + " / " + usuario_emprestimo + " / Data do empréstimo: " + data_do_emprestimo + " / Data da devolução: " + data_p_devolucao);

            if (i == (emprestimos.size() - 1)) {
                System.out.print("\n");
            }
        }
        System.out.print("Emprestimo: ");
        int escolhaE = input.nextInt();
        Emprestimo emp_escolhido = emprestimos.get(escolhaE);

        System.out.println("Em quantos dias?: ");
        int diasAProlongar = input.nextInt();

        emp_escolhido.prolongarDataDevEmprestimo(diasAProlongar);
        System.out.println("Data de devolução do empréstimo" + escolhaE + "alterada para: " + emp_escolhido.getDataPrevistaDevolucao());

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

        Usuario usuario1 = new Usuario("Alex", "1995", "11912345678", 1);
        Usuario usuario2 = new Usuario("Arthur", "2001", "11912345678", 2);
        Usuario usuario3 = new Usuario("Camila", "1997", "11912345678", 3);
        Funcionario funcionario = new Funcionario("Fernanda", "1998", "11912345678", 2);
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 1899, 1);
        Livro livro2 = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943, 2);
        Livro livro3 = new Livro("Dom Quixote", "Miguel de Cervantes", 1605, 3);
        Exemplar exemplar = new Exemplar(1, true);
        Emprestimo emprestimo1 = new Emprestimo(exemplar, usuario2, LocalDate.now());
        Emprestimo emprestimo2 = new Emprestimo(exemplar, usuario1, LocalDate.now());
        Emprestimo emprestimo3 = new Emprestimo(exemplar, usuario3, LocalDate.now());

        livro1.adicionarExemplar(exemplar);
        livro1.adicionarExemplar(exemplar);

        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        funcionarios.add(funcionario);
        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);
        emprestimos.add(emprestimo1);
        emprestimos.add(emprestimo2);
        emprestimos.add(emprestimo3);

    }

}
