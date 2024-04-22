package com.chihyun.coupon.service;

import com.chihyun.coupon.model.CouponVO;

import java.util.List;
import java.util.Map;

public interface CouponService {
    CouponVO addCouponVO(CouponVO couponVO);

    CouponVO updateCouponVO(CouponVO couponVO);

    void deleteCouponVO(Integer coupNo);

    CouponVO getCouponVOByCoupNo(Integer coupNo);

    List<CouponVO> getAllCoupon(int currentPage);

    int getPageTotal();

    List<CouponVO> getCouponsByCompositeQuery(Map<String, String[]> map);
}
