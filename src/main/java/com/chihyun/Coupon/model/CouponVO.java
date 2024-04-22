package com.chihyun.coupon.model;

import com.chihyun.mycoupon.model.MycouponVO;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "Coupon")
public class CouponVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coupNo", updatable = false)
	private Integer coupNo;
	private String coupName;
	private String coupCond;
	private BigDecimal coupDisc;

	@Column(name = "coupAddDate", nullable = true, length = 19)
	private Timestamp coupAddDate;

	private Timestamp coupExpDate;

	private Timestamp coupRelDate;

	@Column(name = "coupRelStat", columnDefinition = "TINYINT")
	private Integer coupRelStat;

	@OneToMany(mappedBy = "couponVO", cascade = CascadeType.ALL)
	@OrderBy("coupNo asc")
	private Set<MycouponVO> mycoupons;

	public Integer getCoupNo() {
		return coupNo;
	}

	public void setCoupNo(Integer coupNo) {
		this.coupNo = coupNo;
	}

	public String getCoupName() {
		return coupName;
	}

	public void setCoupName(String coupName) {
		this.coupName = coupName;
	}

	public String getCoupCond() {
		return coupCond;
	}

	public void setCoupCond(String coupCond) {
		this.coupCond = coupCond;
	}

	public BigDecimal getCoupDisc() {
		return coupDisc;
	}

	public void setCoupDisc(BigDecimal coupDisc) {
		this.coupDisc = coupDisc;
	}

	public Timestamp getCoupAddDate() {
		return coupAddDate;
	}

	public void setCoupAddDate(Timestamp coupAddDate) {
		this.coupAddDate = coupAddDate;
	}

	public Timestamp getCoupExpDate() {
		return coupExpDate;
	}

	public void setCoupExpDate(Timestamp coupExpDate) {
		this.coupExpDate = coupExpDate;
	}

	public Timestamp getCoupRelDate() {
		return coupRelDate;
	}

	public void setCoupRelDate(Timestamp coupRelDate) {
		this.coupRelDate = coupRelDate;
	}

	public Integer getCoupRelStat() {
		return coupRelStat;
	}

	public void setCoupRelStat(Integer coupRelStat) {
		this.coupRelStat = coupRelStat;
	}

}
