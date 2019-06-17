package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TYPE_ONE����ڵ�ʵ���࣬���ڱ���һ��һ��������Ϣ
 * @author admin
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeOne {
	/**
	 * ����һ���
	 */
	private Integer typeOneId;

	/**
	 * ����һ����
	 */
	private String typeOneName;

	/**
	 * ���
	 */
	private Integer typeOneNum;

	/**
	 * ��ע
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