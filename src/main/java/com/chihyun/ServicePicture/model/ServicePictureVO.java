package com.chihyun.servicePicture.model;

import com.chihyun.serviceRecord.model.ServiceRecordVO;

import javax.persistence.*;

@Entity
@Table(name = "ServicePicture")
public class ServicePictureVO {

    @Id
    private Integer servicePicNo;

    @Column(columnDefinition = "longblob")
    private Byte[] servicePic;

    @ManyToOne
    @JoinColumn(name = "recordNo", referencedColumnName = "recordNo")
    private ServiceRecordVO serviceRecordVO;

    public Integer getServicePicNo() {
        return servicePicNo;
    }

    public void setServicePicNo(Integer servicePicNo) {
        this.servicePicNo = servicePicNo;
    }


    public ServiceRecordVO getServiceRecordVO() {
		return serviceRecordVO;
	}

	public void setServiceRecordVO(ServiceRecordVO serviceRecordVO) {
		this.serviceRecordVO = serviceRecordVO;
	}

	public Byte[] getServicePic() {
        return servicePic;
    }

    public void setServicePic(Byte[] servicePic) {
        this.servicePic = servicePic;
    }
}
