import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test {

    public static void main(String[] args){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();


        tx.commit();
        session.close();
        factory.close();
    }
}
