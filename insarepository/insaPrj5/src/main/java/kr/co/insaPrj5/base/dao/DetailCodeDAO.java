package kr.co.insaPrj5.base.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.insaPrj5.base.to.DetailCodeTO;

@Mapper
public interface DetailCodeDAO {

	public ArrayList<DetailCodeTO> selectDetailCodeListRest(HashMap<String, Object> map);

}
  