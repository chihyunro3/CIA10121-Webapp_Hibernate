package com.chihyun.coupon.service;

import com.chihyun.coupon.dao.CouponDAO;
import com.chihyun.coupon.dao.CouponDAOImpl;
import com.chihyun.coupon.model.CouponVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.chihyun.util.Constants.PAGE_MAX_RESULT;

public class CouponServiceImpl implements CouponService {

    private CouponDAO dao;

    public CouponServiceImpl() {
        dao = new CouponDAOImpl();
    }

    @Override
    public CouponVO addCouponVO(CouponVO couponVO) {
        return null;
    }

    @Override
    public CouponVO updateCouponVO(CouponVO couponVO) {
        return null;
    }

    @Override
    public void deleteCouponVO(Integer coupNo) {

    }

    @Override
    public CouponVO getCouponVOByCoupNo(Integer coupNo) {
        return null;
    }

    @Override
    public List<CouponVO> getAllCoupon(int currentPage) {
        return dao.getAll(currentPage);
    }

    @Override
    public int getPageTotal() {
        long total = dao.getTotal();

        int pageQty = (int) (total % PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
        return pageQty;
    }

    @Override
    public List<CouponVO> getCouponsByCompositeQuery(Map<String, String[]> map) {
        Map<String, String> query = new HashMap<>();
        // Map.Entry即代表一組key-value
        Set<Map.Entry<String, String[]>> entry = map.entrySet();

        for (Map.Entry<String, String[]> row : entry) {
            String key = row.getKey();
            // 因為請求參數裡包含了action，做個去除動作
            if ("action".equals(key)) {
                continue;
            }
            // 若是value為空即代表沒有查詢條件，做個去除動作
            String value = row.getValue()[0]; // getValue拿到一個String陣列, 接著[0]取得第一個元素檢查
            if (value == null || value.isEmpty()) {
                continue;
            }
            query.put(key, value);
        }

        System.out.println(query);

        return dao.getByCompositeQuery(query);
    }
}
