class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;

    public Pessoa(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

class Membro extends Pessoa {
    private int numeroMembro;

    public Membro(String nome, String endereco, String telefone, int numeroMembro) {
        super(nome, endereco, telefone);
        this.numeroMembro = numeroMembro;
    }

    public int getNumeroMembro() {
        return numeroMembro;
    }

    public void emprestarLivro(Livro livro) {
        livro.setEmprestado(true);
    }
}

class Funcionario extends Pessoa {
    private String idFuncionario;

    public Funcionario(String nome, String endereco, String telefone, String idFuncionario) {
        super(nome, endereco, telefone);
        this.idFuncionario = idFuncionario;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void registrarLivro(Livro livro) {
        System.out.println("Livro '" + livro.getTitulo() + "' registrado com sucesso.");
    }
}

class Livro {
    private String titulo;
    private String autor;
    private boolean emprestado;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean Emprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
}

public class BibliotecaDemo {
    public static void main(String[] args) {
        Membro membro = new Membro("John Doe", "123 Maple St", "555-0199", 1);
        Funcionario funcionario = new Funcionario("Jane Smith", "123 Oak St", "555-0200", "F001");
        Livro livro = new Livro("Hamlet", "William Shakespeare");

        funcionario.registrarLivro(livro);
        membro.emprestarLivro(livro);
        System.out.println("O livro '" + livro.getTitulo() + "' está emprestado? " + livro.isEmprestado());
    }
}
