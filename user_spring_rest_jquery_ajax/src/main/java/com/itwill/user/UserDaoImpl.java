package com.itwill.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.user.mapper.UserMapper;
@Repository(value = "userDaoImplMyBatisMapperInterface")
public class UserDaoImpl implements UserDao {
	
	@Autowired(required = false)
	private UserMapper userMapper;

	public UserDaoImpl() {
	}
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public int create(User user) throws Exception {

		return userMapper.create(user);
	}

	@Override
	public int update(User user) throws Exception {
		return userMapper.update(user);
	}

	@Override
	public int remove(String userId) throws Exception {
		return userMapper.remove(userId);
	}

	@Override
	public User findUser(String userId) throws Exception {
		return userMapper.findUser(userId);
	}

	@Override
	public List<User> findUserList() throws Exception {
		return userMapper.findUserList();
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		int count=userMapper.existedUser(userId);
		if(count==1) {
			return true;
		}else {
			return false;
		}
		
	}

}