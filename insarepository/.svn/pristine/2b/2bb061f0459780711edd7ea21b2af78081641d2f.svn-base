package kr.co.insaPrj5.hr.emp.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.insaPrj5.hr.emp.to.WorkInfoTO;

@Mapper
public interface WorkInfoDAO {
	public ArrayList<WorkInfoTO> selectWorkList(String empCode);

	public void insertWorkInfo(WorkInfoTO workInfo);;
	public void updateWorkInfo(WorkInfoTO workInfo);
	public void deleteWorkInfo(WorkInfoTO workInfo);
}
