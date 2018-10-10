package models;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
	@Autowired
	SqlSessionFactory factory;
	
	@Autowired
	SqlSessionTemplate template;
	
	public String getEmployeeSeq(){
		int i = template.selectOne("employee.getEmployeeSeq");
		String id="em"+i;
		return id;
	} 
	public List<Map> getDepartments(){
		return template.selectList("employee.getDepartments");
	}
	
	public List<Map> getPositions(){
		return template.selectList("employee.getPositions");
	}
	public int addEmployee(Map map) {
		return template.insert("employee.addEmployee", map);
	}
	
}
