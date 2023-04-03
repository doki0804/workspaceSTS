package com.itwill.ilhajob.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.ilhajob.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
