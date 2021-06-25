package com.dithok.myCommerce.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dithok.myCommerce.Repo.GroupUserRepository;
import com.dithok.myCommerce.model.GroupUserModel;
import com.dithok.myCommerce.model.UserModel;
import com.dithok.myCommerce.service.GroupUserService;

@Service
public class GroupUserServiceImpl implements GroupUserService {
	
	@Autowired
	private GroupUserRepository repo;

	@Override
	public GroupUserModel addGroupUser(GroupUserModel groupUser) {
		return repo.save(groupUser);
		
	}

	@Override
	public GroupUserModel findByUserId(long id) {
		return repo.findByUserId(id);
	}

	@Override
	public List<GroupUserModel> findByGroupId(long id) {
		return repo.findByGroupId(id);
	}

	@Override
	public String findUserByGroupId(long id) {
		List<GroupUserModel> listGroupUser = repo.findByGroupId(id);
		String listUser = "";
		for(int i=0; i<listGroupUser.size();i++) {
			GroupUserModel groupUser = listGroupUser.get(i);
			UserModel user = groupUser.getUser();
			listUser.concat(user.getEmail());
			listUser.trim();
		}
		return listUser;
	}

}
