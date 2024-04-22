package com.chihyun.serviceRecord.model;

import com.chihyun.servicePicture.model.ServicePictureVO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "ServiceRecord")
public class ServiceRecordVO {

	@Id
	private Integer recordNo;
    
    private Timestamp recordTime;
    
    private String recordContent;
    
    @Column(name = "speaker", columnDefinition = "TINYINT")
    private Integer speaker;

    @OneToMany(mappedBy = "serviceRecordVO")
    @OrderBy("servicePicNo asc")
    private Set<ServicePictureVO> ServicePictures;
    
//    @ManyToOne
//    @JoinColumn(name = "admNo", referencedColumnName = "admNo")
//    private AdministratorVO Administrator;
    
    public Set<ServicePictureVO> getServicePictures() {
		return ServicePictures;
	}

	public void setServicePictures(Set<ServicePictureVO> servicePictures) {
		ServicePictures = servicePictures;
	}

//	public AdministratorVO getAdministrator() {
//		return Administrator;
//	}
//
//	public void setAdministrator(AdministratorVO administrator) {
//		Administrator = administrator;
//	}
//
//	public MemberVO getMemberVO() {
//		return memberVO;
//	}
//
//	public void setMemberVO(MemberVO memberVO) {
//		this.memberVO = memberVO;
//	}
//
//	@ManyToOne
//    @JoinColumn(name = "memNo", referencedColumnName = "memNo")
//    private MemberVO memberVO;

    public Integer getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(Integer recordNo) {
        this.recordNo = recordNo;
    }

    public Timestamp getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecordContent() {
        return recordContent;
    }

    public void setRecordContent(String recordContent) {
        this.recordContent = recordContent;
    }

    public Integer getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Integer speaker) {
        this.speaker = speaker;
    }
}
