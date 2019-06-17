package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TYPE_ONE表对于的实体类，用于保存一行一级类别的信息
 * @author admin
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeOne {
	/**
	 * 类型一编号
	 */
	private Integer typeOneId;

	/**
	 * 类型一名称
	 */
	private String typeOneName;

	/**
	 * 序号
	 */
	private Integer typeOneNum;

	/**
	 * 备注
	 */
	private String typeOneRemark;

	public Integer getTypeOneId() {
		return typeOneId;
	}

	public void setTypeOneId(Integer typeOneId) {
		this.typeOneId = typeOneId;
	}

	public String getTypeOneName() {
		return typeOneName;
	}

	public void setType01Name(String typeOneName) {
		this.typeOneName = typeOneName;
	}

	public Integer getTypeOneNum() {
		return typeOneNum;
	}

	public void setType01Num(Integer typeOneNum) {
		this.typeOneNum = typeOneNum;
	}

	public String getTypeOneRemark() {
		return typeOneRemark;
	}

	public void setType01Remark(String typeOneRemark) {
		this.typeOneRemark = typeOneRemark;
	}
}