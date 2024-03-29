package com.itwill.ilhajob.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.ilhajob.common.entity.RecruitTag;

public interface RecruitTagRepository extends JpaRepository<RecruitTag, Long>{
	public List<RecruitTag> findByRecruitId(long recruitId);
}
