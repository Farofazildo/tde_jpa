package repository;

import entities.Aluno;
import entities.Curso;

import javax.persistence.*;
import java.util.List;

public class AlunoRepository {
    public static void inserirAluno(EntityManagerFactory emf, Aluno aluno){

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(aluno);

            em.getTransaction().commit();


        } finally {
            em.close();
        }
    }

    public static void removerAluno(EntityManagerFactory emf, Aluno aluno){
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.remove(aluno);

            em.getTransaction().commit();


        } finally {
            em.close();
        }
    }

    public static void consultarCurso(EntityManagerFactory emf) {


        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Query query = em.createQuery("SELECT a FROM Aluno a JOIN a.cursos c");
            List<Aluno> resultList = query.getResultList();

            Query query2 = em.createQuery("SELECT c.nome FROM Aluno a JOIN a.cursos c");
            List<String> resultList2 = query2.getResultList();

            int i = 0;
            for(Aluno x: resultList){

                System.out.print(x);
                System.out.println(" {" + resultList2.get(i) + "}");
                i = i+1;

            }

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }

    }
}
