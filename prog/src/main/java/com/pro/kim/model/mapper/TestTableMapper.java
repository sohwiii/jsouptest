package com.pro.kim.model.mapper;

import java.util.List;
import java.util.Map;
 
import org.apache.ibatis.annotations.Mapper;
 
@Mapper
public interface TestTableMapper {
    
    
    //select * from Test_Table
    public List<Map<String, Object>> SelectAllList() throws Exception;
 

}
