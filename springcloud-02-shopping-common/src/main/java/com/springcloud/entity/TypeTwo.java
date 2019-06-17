package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TYPE_TWO���Ӧ��ʵ���࣬���ڱ���һ�ж���������Ϣ
 * @author admin
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeTwo {
	/**
	 * ���Ͷ����
	 */
	private Integer typeTwoId;

	/**
	 * ���Ͷ�����
	 */
	private String typeTwoName;

	/**
	 * ����һ���
	 */
	private Integer typeOneId;

	/**
	 * ��ע
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