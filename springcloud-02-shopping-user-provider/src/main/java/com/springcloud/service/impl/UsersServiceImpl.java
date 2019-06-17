package com.springcloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springcloud.common.PageUtils;
import com.springcloud.entity.Users;
import com.springcloud.repository.UsersRepository;
import com.springcloud.service.UsersService;
/**
 * ģ�Ͳ��ʵ���࣬ʵ���û�ģ��ķ���
 * @author bai
 *
 */

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersRepository UsersRepository;

	@Override
	public Users login(Integer userId, String userPwd, Integer permissionId) {
		
		return this.UsersRepository.login(userId, userPwd, permissionId);
	}
	@Transactional
	@Override
	public Users insert(Users users) {
		
		return this.UsersRepository.save(users);
	}
	@Override
	public Page<Users> select(Users users, Integer pageNumber) {
		//���ݲ�ѯ���ݣ�������̬����
		@SuppressWarnings("serial")
		Specification<Users> specification = new Specification<Users>() {

			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				//����List���ϣ����ڱ������е�where����
				List<Predicate> whereList = new ArrayList<>();
				//����Users�еĲ�ѯ���ݣ���̬������ѯ����
				if(users.getUserName()!=null && !users.getUserName().trim().equals("")) {
					whereList.add(criteriaBuilder.like(root.get("userName"), "%" + users.getUserName() + "%"));
				}
				if(users.getUserStatus()!=-1) {
					whereList.add(criteriaBuilder.equal(root.get("userStatus"), users.getUserStatus()));
					
				}
				//�����е�������and��ϵ������һ�𣬲�����
				return criteriaBuilder.and(whereList.toArray(new Predicate[whereList.size()]));
			}
		};
		//����JPA�ķ�ҳ��Ϣ
		PageRequest of = PageRequest.of(pageNumber, PageUtils.PAGE_ROW_COUNT);
		return this.UsersRepository.findAll(specification,of);
	}
	@Transactional
	@Override
	public Integer updateStarus(Integer userId, Integer userStatus) {
		
		return this.UsersRepository.updateStatus(userId, userStatus);
	}
	@Override
	public Users selectById(Integer userId) {
		return this.UsersRepository.findById(userId).get();
	}
	@Transactional
	@Override
	public Integer update(Users users) {
		
		return this.UsersRepository.update(users);
	}
	@Transactional
	@Override
	public Integer updateMessage(Users users) {
		if(users.getUserImage() !=null && !users.getUserImage().equals("")) {
			return this.UsersRepository.updateImg(users);
			
		}else if(users.getUserName() != null && !users.getUserName().equals("")) {
			return this.UsersRepository.updateName(users);
		
		}else if(users.getUserPwd() != null && !users.getUserPwd().equals("")) {
			return this.UsersRepository.updatePwd(users);
		}
		return 0;
	}

}