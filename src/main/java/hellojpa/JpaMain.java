package hellojpa;

import jakarta.persistence.*;

import javax.sound.midi.MetaMessage;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            //영속
            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ===");

            tx.commit();


        } catch (Exception e) {
            System.out.println("rollback");
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
