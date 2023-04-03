package com.itwill.ilhajob.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.ilhajob.user.entity.App;

public interface AppRepository extends JpaRepository<App, Long> {

}
