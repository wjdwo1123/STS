package kr.co.insaPrj5.hr.emp.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.insaPrj5.hr.emp.to.EducationInfoTO;
@Mapper
public interface EducationInfoDAO {
	public ArrayList<EducationInfoTO> selectEducationList(String code);

	public void insertEducationInfo(EducationInfoTO educationInfo);
	public void updateEducationInfo(EducationInfoTO educationInfo);
	public void deleteEducationInfo(EducationInfoTO educationInfo);
}
