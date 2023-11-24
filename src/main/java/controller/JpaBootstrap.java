package controller;

import entities.Aluno;
import entities.Curso;
import repository.AlunoRepository;
import repository.CursoRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class JpaBootstrap {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tde-jpa");

        //Criação do Scanner
        Scanner scanner = new Scanner(System.in);


        //Menu
        int menu = 0;

        while (menu != 5) {
            System.out.println("---------------MENU---------------");
            System.out.println("1 - Inserir Curso");
            System.out.println("2 - Inserir Aluno");
            System.out.println("3 - Mostrar curso de aluno");
            System.out.println("4 - Listar alunos de curso");
            System.out.println("5 - Sair");
            System.out.println("-----------------------------------");
            menu = scanner.nextInt();
            scanner.nextLine();

            if (menu == 1) {
                //Variáveis a serem inseridas no banco de dados
                String cod_curso;
                String nome_curso;
                int carga_horaria;

                //Pedido ao usuário
                System.out.println("Insira o nome do curso: ");
                nome_curso = scanner.nextLine();
                System.out.println("Insira a carga horária do curso: ");
                carga_horaria = scanner.nextInt();
                scanner.nextLine();

                Curso cu = new Curso(null,nome_curso,carga_horaria);
                CursoRepository.inserirCurso(emf,cu);

            } else if (menu == 2) {
                //Variavéis a serem inseridas no banco de dados
                String matricula;
                String nome_aluno;
                String cod_curso;

                //Pedido ao usuário


                System.out.println("Insira o nome do aluno:");
                nome_aluno = scanner.nextLine();

                System.out.println("Insira o curso do aluno: ");
                cod_curso = scanner.nextLine();

                Aluno al = new Aluno(null,nome_aluno);
                AlunoRepository.inserirAluno(emf,al);

            } else if (menu == 3) {

                AlunoRepository.consultarCurso(emf);


            } else if (menu == 4) {
                //Curso a ser pesquisado
                String curso;

                System.out.println("Digite o nome do curso que você deseja listar os alunos: ");
                curso = scanner.nextLine();

                CursoRepository.consultarAlunos(emf,curso);

            } else if (menu == 5) {
                emf.close();
            }
        }

    }
}


