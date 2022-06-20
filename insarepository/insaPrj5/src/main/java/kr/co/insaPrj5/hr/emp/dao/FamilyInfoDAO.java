package kr.co.insaPrj5.hr.emp.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.insaPrj5.hr.emp.to.FamilyInfoTO;
@Mapper
public interface FamilyInfoDAO {
	public ArrayList<FamilyInfoTO> selectFamilyList(String code);

	public void insertFamilyInfo(FamilyInfoTO familyInfo);
	public void updateFamilyInfo(FamilyInfoTO familyInfo);
	public void deleteFamilyInfo(FamilyInfoTO familyInfo);
}
