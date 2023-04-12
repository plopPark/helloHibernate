package kr.ac.hansung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
       /*
       Configuration conf = new Configuration();
       conf.configure(); //hibernate.cfg.xml는 default값으로 굳이 지정 x
        SessionFactory sessionFactory = conf.buildSessionFactory();
        */
        Category category1 = new Category();
        category1.setName("컴퓨터");

        Category category2 = new Category();
        category2.setName("자동차");

        Product product1 = new Product();
        product1.setName("노트북1");
        product1.setPrice(2000);
        product1.setDescription("캡 성능");
        product1.setCategory(category1);

        Product product2 = new Product();
        product2.setName("노트북2");
        product2.setPrice(3000);
        product2.setDescription("왕 캡 성능");
        product2.setCategory(category1);

        Product product3 = new Product();
        product3.setName("소나타");
        product3.setPrice(20000);
        product3.setDescription("아이비가 좋아함");
        product3.setCategory(category2);
        //생성
        SessionFactory  sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session =  sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        //저장
        System.out.println("*********************************HelloHibernate : " + "saving Products***************************");
        session.save(product1); //database 반영 x , cache에 반영
        session.save(product2);
        session.save(product3);
        System.out.println("*********************************HelloHibernate : " + "saved Products****************************");

        product1.setCategory(null);
        session.delete(product1); // product -> category?
        //get()실습
        /*
        Product savedProduct = session.get(Product.class, product1.getId());
        System.out.println("##########################################################################################");
        System.out.println("Saved Product : " + savedProduct);
        System.out.println("##########################################################################################");
         */

        //query
        Query<Product> aQuery = session.createQuery("from Product order by name", Product.class);
        List<Product> products = aQuery.getResultList();
        System.out.println("##########################################################################################");
        System.out.println(products);
        System.out.println("##########################################################################################");
        //닫기
        tx.commit(); //db에 실질적 반영
        session.close();
        sessionFactory.close();
    }
}
