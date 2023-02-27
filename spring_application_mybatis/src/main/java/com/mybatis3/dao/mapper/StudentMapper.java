package com.mybatis3.dao.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.mybatis3.domain.Student;

@Mapper
public interface StudentMapper {
	/*
	 * 인터페이스의 풀네임은 StudentMapper.xml의 namespace와일치
	 * StudentMapper 인터페이스와 같은위치에 StudentMapper.xml을 위치시킨다.
	 * 메쏘드이름은 	StudentMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 StudentMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 StudentMapper.xml 파일의 resultType 와일치(ResultSet이 1개이상일경우는 List)
	 */
	public Student findStudentById(Integer studId);
	
	public List<Student> findAllStudents();
	
	public String findStudentNameById(int studId);
	
	public List<String> findStudentNameList();
	
	public int insertStudent(Student student);
	
	public int insertStudentBySequence1(Student student);
	
	@SelectKey(resultType = Integer.class, keyProperty = "studId", before = true,
			   statement = "select students_stud_id_seq.nextval from dual")
	@Insert("insert into students(stud_id,name,email,dob) values (#{studId},#{name},#{email},#{dob})")
	public int insertStudentBySequence2(Student student);
	
	public int updateStudentById(Student student);
	
	public int deleteStudentById(int studId);
	public int deleteStudentByName(String name);
	public int deleteStudentById(Student student);

	public Student findStudentByIdWithAddress(Integer studId);

	public Student findStudentByIdWithAddressWithCourses(Integer studId);
	
	
	public Student findStudentByIdWithCourses(Integer studId);
	
	public Student findStudentByIdResultMap(Integer studId);

	public List<Student> findAllStudentsResultMap();

	public List<Student> findStudentByIdRangeParamMap(HashMap idRangeMap);

	public List<Student> findStudentsThreeParamMap(HashMap studentsMap);
	
	public int updateStudentParamMap(Map studentMap);

	public Map findStudentByIdMap(Integer studId);

	public List<Map> findAllStudentsMapList();
}
