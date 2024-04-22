package com.chihyun.mycoupon.model;

import com.chihyun.coupon.model.CouponVO;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "Mycoupon")
@IdClass(MycouponVO.CompositeMycoupon.class)
public class MycouponVO {
    @Id
    @Column(name = "coupNo", updatable = false, insertable = false)
    private Integer coupNo;
    
    @Id
    private Integer memNo;
    
    @Column(name = "coupUsedStat", columnDefinition = "TINYINT")
    private Integer coupUsedStat;
    
    private String coupInfo;
    
    private Timestamp coupExpDate;

    @ManyToOne
    @JoinColumn(name = "coupNo", referencedColumnName = "coupNo")
    private CouponVO couponVO;

//    @ManyToOne
//    @JoinColumn(name = "memNO", referencedColumnName = "memNo")
//    private MemberVO memberVO;

    public CompositeMycoupon getCompositekey() {
        return new CompositeMycoupon(coupNo, memNo);
    }

    public void setCompositekey(CompositeMycoupon key) {

        this.coupNo = key.getCoupNo();
        this.memNo = key.getMemNo();
    }

    public Integer getCoupNo() {
        return coupNo;
    }

    public void setCoupNo(Integer coupNo) {
        this.coupNo = coupNo;
    }

    public Integer getMemNo() {
        return memNo;
    }

    public void setMemNo(Integer memNo) {
        this.memNo = memNo;
    }

    public Integer getCoupUsedStat() {
        return coupUsedStat;
    }

    public void setCoupUsedStat(Integer coupUsedStat) {
        this.coupUsedStat = coupUsedStat;
    }

    public String getCoupInfo() {
        return coupInfo;
    }

    public void setCoupInfo(String coupInfo) {
        this.coupInfo = coupInfo;
    }

    public Timestamp getCoupExpDate() {
        return coupExpDate;
    }

    public void setCoupExpDate(Timestamp coupExpDate) {
        this.coupExpDate = coupExpDate;
    }


    public static class CompositeMycoupon implements Serializable {
        private static final long serialVersionUID = 1L;

        private Integer coupNo;
        private Integer memNo;

        public CompositeMycoupon() {
            super();
        }

        public CompositeMycoupon(Integer coupNo, Integer memNo) {
            super();
            this.coupNo = coupNo;
            this.memNo = memNo;
        }

        public Integer getCoupNo() {
            return coupNo;
        }

        public void setCoupNo(Integer coupNo) {
            this.coupNo = coupNo;
        }

        public Integer getMemNo() {
            return memNo;
        }

        public void setMemNo(Integer memNo) {
            this.memNo = memNo;
        }

        // 一定要 override 此類別的 hashCode() 與 equals() 方法！ //複合主鍵設定6.
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((memNo == null) ? 0 : memNo.hashCode());
            result = prime * result + ((coupNo == null) ? 0 : coupNo.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            if (obj != null && getClass() == obj.getClass()) {
                CompositeMycoupon compositeKey = (CompositeMycoupon) obj;
                if (coupNo.equals(compositeKey.coupNo) && memNo.equals(compositeKey.memNo)) {
                    return true;
                }
            }

            return false;
        }

    }
}
