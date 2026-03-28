import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public Usuario buscarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public Exemplar buscarExemplar(int codigoExemplar) {
        for (Livro livro : livros) {
            for (Exemplar exemplar : livro.getExemplares()) {
                if (exemplar.getcodigoExemplar() == codigoExemplar) {
                    return exemplar;
                }
            }
        }
        return null;
    }

    public void emprestar(int codigoExemplar, int idUsuario) {
        Exemplar exemplar = buscarExemplar(codigoExemplar);
        Usuario usuario = buscarUsuario(idUsuario);

        if (exemplar != null && usuario != null && exemplar.getDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(exemplar, usuario);
            emprestimos.add(emprestimo);
        } else {
            System.out.println("Não foi possivel realizar o empréstimo");
        }
    }

    public void devolver(Emprestimo emprestimo) {
        if (emprestimo != null) {
            emprestimo.devolver();
        }
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getId() + " - " + usuario.getNome());
        }
    }

    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println(livro.getCodigoLivro() + " - " + livro.getTitulo());
        }
    }

    public void listarExemplares(int codigoLivro) {
        for (Livro livro : livros) {
            if (livro.getCodigoLivro() == codigoLivro) {
                for (Exemplar exemplar : livro.getExemplares()) {
                    if (exemplar.getDisponivel()) {
                        System.out.println("Exemplar: " + exemplar.getcodigoExemplar());
                    }
                }
            }
        }
    }
}