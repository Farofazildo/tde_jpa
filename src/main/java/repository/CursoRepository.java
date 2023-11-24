package repository;

import entities.Aluno;
import entities.Curso;
import org.jboss.logging.Param;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class CursoRepository {
    public static void inserirCurso(EntityManagerFactory emf, Curso curso){

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(curso);

            em.getTransaction().commit();


        } finally {
            em.close();
        }
    }

    public static void removerCurso(EntityManagerFactory emf, Curso curso){
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.remove(curso);

            em.getTransaction().commit();


        } finally {
            em.close();
        }
    }



    public static void consultarAlunos(EntityManagerFactory emf, String nome_curso) {


        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Query query = em.createQuery("SELECT a FROM Aluno a JOIN a.cursos c WHERE c.nome = :nome_curso");
            query.setParameter("nomeCurso", nome_curso);
            List<Aluno> resultList = query.getResultList();


            for (Aluno x : resultList) {

                System.out.print(x);

            }

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }


    }
}
