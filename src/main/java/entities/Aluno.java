package entities;

import entities.Curso;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="TABELA_ALUNO")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String matricula;
    @Column(nullable = false)
    private String nome;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="TABELA_ALUNO_CURSO",
    joinColumns=
            {@JoinColumn(name="aluno_matricula",referencedColumnName = "matricula")},
    inverseJoinColumns=
            {@JoinColumn(name="codigo_curso",referencedColumnName = "cod_curso")})
    private Set<Curso> listaCursos = new HashSet<>();


    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public Set<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}