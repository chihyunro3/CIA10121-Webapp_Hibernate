package com.chihyun.coupon.dao;

import com.chihyun.coupon.model.CouponVO;

import java.util.List;
import java.util.Map;

public interface CouponDAO {

    int insert(CouponVO entity);
    int update(CouponVO entity);
    int delete(Integer id);
    CouponVO getbyID(Integer id);

    List<CouponVO> getAll();
    List<CouponVO> getByCompositeQuery(Map<String, String>map);
    List<CouponVO> getAll(int currentPage);
    long getTotal();
}
