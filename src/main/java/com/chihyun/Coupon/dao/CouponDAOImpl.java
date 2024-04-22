package com.chihyun.coupon.dao;

import com.chihyun.coupon.model.CouponVO;
import com.chihyun.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.chihyun.util.Constants.PAGE_MAX_RESULT;

public class CouponDAOImpl implements CouponDAO {

    private SessionFactory factory;

    public CouponDAOImpl() {
        factory = HibernateUtil.getSessionFactory();
    }

    private Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public int insert(CouponVO entity) {
        return (Integer) getSession().save(entity);
    }

    @Override
    public int update(CouponVO entity) {
        try {
            getSession().update(entity);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int delete(Integer id) {
        CouponVO couponVO = getSession().get(CouponVO.class, id);
        if (couponVO != null) {
            getSession().delete(couponVO);
            return 1;
        } else {
            return -1;
        }

    }

    @Override
    public CouponVO getbyID(Integer id) {
        return getSession().get(CouponVO.class, id);
    }

    @Override
    public List<CouponVO> getAll() {
        return getSession().createQuery("from CouponVO", CouponVO.class).list();
    }

    @Override
    public List<CouponVO> getByCompositeQuery(Map<String, String> map) {
        if (map.size() == 0) return getAll();

        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<CouponVO> criteria = builder.createQuery(CouponVO.class);
        Root<CouponVO> root = criteria.from(CouponVO.class);

        List<Predicate> predicates = new ArrayList<>();

        for (Map.Entry<String, String> row : map.entrySet()) {
            if ("coupName".equals(row.getKey())) {
                predicates.add(builder.like(root.get("coupName"), "%" + row.getValue() + "%"));
            }
            if ("coupNo".equals(row.getKey())){
                predicates.add(builder.equal(root.get("coupNo"), row.getValue()));
            }
            if("coupDisc".equals(row.getKey())){
                predicates.add(builder.equal(root.get("coupDisc"), new BigDecimal(row.getValue())));
            }
            if("coupRealStat".equals(row.getKey())){
                predicates.add(builder.equal(root.get("coupRealStat"), row.getValue()));
            }
        }

        criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
        criteria.orderBy(builder.asc(root.get("coupNo")));
        TypedQuery<CouponVO> query = getSession().createQuery(criteria);
        return query.getResultList();
    }

    @Override
    public List<CouponVO> getAll(int currentPage) {
        int first = (currentPage - 1) * PAGE_MAX_RESULT;
        return getSession().createQuery("from CouponVO ", CouponVO.class)
                .setFirstResult(first)
                .setMaxResults(PAGE_MAX_RESULT)
                .list();
    }

    @Override
    public long getTotal() {
        return getSession().createQuery("select count(*) from CouponVO", Long.class).uniqueResult();
    }
}
