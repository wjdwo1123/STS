package kr.co.insaPrj5.hr.attd.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

 
import kr.co.insaPrj5.hr.attd.to.RestAttdTO;
@Mapper
public interface RestAttdDAO {
	public ArrayList<RestAttdTO> selectRestAttdListByToday(String empCode, String toDay);
	
	public ArrayList<RestAttdTO> selectRestAttdList(HashMap<String,Object> map);
	
	public ArrayList<RestAttdTO> selectRestAttdListCode(HashMap<String,Object> map);
	
	public ArrayList<RestAttdTO> selectRestAttdListByDept(HashMap<String,Object> map);
	
	public ArrayList<RestAttdTO> selectRestAttdListByAllDept(String applyDay);
	
	public void insertRestAttd(RestAttdTO restAttd);
	
	public void updateRestAttd(RestAttdTO restAttd);
	
	public void deleteRestAttd(RestAttdTO restAttd);
	
}
