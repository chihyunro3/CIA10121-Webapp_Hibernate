import com.chihyun.coupon.model.CouponVO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

        CouponVO coupon = new CouponVO();
        coupon.setCoupName("驚喜大禮test");
        coupon.setCoupCond("滿萬送千");
        coupon.setCoupDisc(BigDecimal.valueOf(0.5));
        coupon.setCoupAddDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
        coupon.setCoupExpDate(java.sql.Timestamp.valueOf("2024-04-30 00:00:00"));
        coupon.setCoupRelDate(java.sql.Timestamp.valueOf("2024-05-01 00:00:00"));
        coupon.setCoupRelStat(0);

        session.save(coupon);

        tx.commit();
        session.close();
        factory.close();
    }
}
