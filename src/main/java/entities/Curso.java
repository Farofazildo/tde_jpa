package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TABELA_CURSO")
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cod_curso;
    @Column(nullable = false)
    private String nome_curso;
    @Column(nullable = false)
    private int carga_horaria;

    @ManyToMany(mappedBy = "listaCursos",fetch = FetchType.LAZY)

    private Set<Aluno> listaAlunos = new HashSet<>();


    public Curso(String cod_curso, String nome_curso, int carga_horaria) {
        this.cod_curso = cod_curso;
        this.nome_curso = nome_curso;
        this.carga_horaria = carga_horaria;
    }

    public String getCodigo() {
        return cod_curso;
    }

    public String getNome() {
        return nome_curso;
    }

    public int getCargaHoraria() {
        return carga_horaria;
    }

    public Set<Aluno> getAlunos() {
        return listaAlunos;
    }

    public void setCodigo(String codigo) {
        this.cod_curso = codigo;
    }

    public void setNome(String nome) {
        this.nome_curso = nome;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.carga_horaria = cargaHoraria;
    }

}
