import java.time.LocalDate;

public class Emprestimo {
    private Exemplar exemplar;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolvida;

    public Emprestimo(Exemplar exemplar, Usuario usuario) {
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = dataEmprestimo.plusDays(15);

        exemplar.setDisponivel(false);
        System.out.println("Exemplar emprestado.");
    }

    public void devolver() {
        this.dataDevolvida = LocalDate.now();
        exemplar.setDisponivel(true);

        System.out.println("Devolução realizada em: " + dataDevolvida);
        System.out.println("Exemplar disponível.");
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }
}
