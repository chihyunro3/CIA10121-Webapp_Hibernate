package com.chihyun.coupon.controller;

import com.chihyun.coupon.model.CouponVO;
import com.chihyun.coupon.service.CouponService;
import com.chihyun.coupon.service.CouponServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/coupon/coupon.do")
public class CouponServlet extends HttpServlet {

    private CouponService couponService;

    public void init() throws ServletException {
        couponService = new CouponServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        String forwardPath = "";
        switch (action) {
            case "getAll":
                forwardPath = getAllCoupon(req, res);
                break;
            case "compositeQuery":
                forwardPath = getCompositeCouponQuery(req, res);
                break;
            default:
                forwardPath = "/coupon/index.jsp";
        }
        res.setContentType("text/html; charset=UTF-8");
        RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
        dispatcher.forward(req, res);
    }


    private String getAllCoupon(HttpServletRequest req, HttpServletResponse res) {
        String page = req.getParameter("page");
        int currentPage = (page == null) ? 1 : Integer.parseInt(page);
        List<CouponVO> couponVOList = couponService.getAllCoupon(currentPage);

        if (req.getSession().getAttribute("couponPageQty") == null) {
            int couponPageQty = couponService.getPageTotal();
            req.getSession().setAttribute("couponPageQty", couponPageQty);
        }

        req.setAttribute("couponVOList", couponVOList);
        req.setAttribute("currenPage", currentPage);

        return "/coupon/listAllcoupon.jsp";
    }

    private String getCompositeCouponQuery(HttpServletRequest req, HttpServletResponse res) {
        Map<String, String[]> map = req.getParameterMap();

        if (map != null) {
            List<CouponVO> couponVOList = couponService.getCouponsByCompositeQuery(map);
            req.setAttribute("couponVOList", couponVOList);
        } else {
            return "/coupon/index.jsp";
        }
        return "/coupon/listCompositeQueryCoupon.jsp";
    }


}
