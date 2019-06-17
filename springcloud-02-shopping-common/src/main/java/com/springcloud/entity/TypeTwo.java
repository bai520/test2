package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TYPE_TWO表对应的实体类，用于保存一行二级类别的信息
 * @author admin
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeTwo {
	/**
	 * 类型二编号
	 */
	private Integer typeTwoId;

	/**
	 * 类型二名称
	 */
	private String typeTwoName;

	/**
	 * 类型一编号
	 */
	private Integer typeOneId;

	/**
	 * 备注
	 */
	private String typeTwoRemark;

	public Integer getTypeTwoId() {
		return typeTwoId;
	}

	public void setTypeTwoId(Integer typeTwoId) {
		this.typeTwoId = typeTwoId;
	}

	public String getTypeTwoName() {
		return typeTwoName;
	}

	public void setTypeTwoName(String typeTwoName) {
		this.typeTwoName = typeTwoName;
	}

	public Integer getTypeOneId() {
		return typeOneId;
	}

	public void setTypeOneId(Integer typeOneId) {
		this.typeOneId = typeOneId;
	}

	public String getTypeTwoRemark() {
		return typeTwoRemark;
	}

	public void setTypeTwoRemark(String typeTwoRemark) {
		this.typeTwoRemark = typeTwoRemark;
	}
}