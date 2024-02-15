package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
@ManytoOne
@OneToMany 쓸때, 앞의 many와 one의 기준은 ERD에서 본인이 기준임!
*/
public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Order order = new Order();
            order.addOrderItem(new OrderItem()); // Order에 public void add 보세연

            /* 이렇게 짜도 가능함. 문제가 없음 (단방향)
            Order order = new Order();
            em.persist(order);
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            em.persist(orderItem);
            */

            tx.commit();

        } catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
