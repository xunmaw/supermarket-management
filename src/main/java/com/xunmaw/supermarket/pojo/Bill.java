package com.xunmaw.supermarket.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 功能说明
 */
@Component
@Data
public class Bill {
	private Integer id;   //id
	@NotEmpty(message = "账单编码不能为空！")
	private String billCode; //账单编码
	@NotEmpty(message = "商品名称不能为空！")
	private String productName; //商品名称
	private String productDesc; //商品描述
	@NotEmpty(message = "商品单位不能为空！")
	private String productUnit; //商品单位
	@NotEmpty(message = "商品数量不能为空！")
	@Size(min = 0, message = "商品数量输入不符合规范，请重新输入")
	private BigDecimal productCount; //商品数量
	@NotEmpty(message = "总金额不能为空！")
	@Size(min = 0, message = "总金额输入不符合规范，请重新输入")
	private BigDecimal totalPrice; //总金额
	private Integer isPayment; //是否支付
	private Integer providerId; //供应商ID
	private Integer createdBy; //创建者
	private Date creationDate; //创建时间
	private Integer modifyBy; //更新者
	private Date modifyDate;//更新时间
	
	private String providerName;//供应商名称
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getBillCode() {
		return billCode;
	}
	
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductDesc() {
		return productDesc;
	}
	
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	
	public String getProductUnit() {
		return productUnit;
	}
	
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	
	public BigDecimal getProductCount() {
		return productCount;
	}
	
	public void setProductCount(BigDecimal productCount) {
		this.productCount = productCount;
	}
	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Integer getIsPayment() {
		return isPayment;
	}
	
	public void setIsPayment(Integer isPayment) {
		this.isPayment = isPayment;
	}
	
	public Integer getProviderId() {
		return providerId;
	}
	
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	
	public Integer getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Integer getModifyBy() {
		return modifyBy;
	}
	
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	
	public Date getModifyDate() {
		return modifyDate;
	}
	
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public String getProviderName() {
		return providerName;
	}
	
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
}
