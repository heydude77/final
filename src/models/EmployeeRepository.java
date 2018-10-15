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
	public boolean getPasswordById(Map map) {		
		return  map.get("pw").equals(template.selectOne("employee.getPasswordById", map.get("id")));
	}
	
	public Map getEmployee(String id){
		return template.selectOne("employee.getEmployee", id);
	}
	public int changePassword(Map map) {		
		return template.update("employee.chagePassword", map);
	}
	public List<Map> getEmployeeByDep(Map map){
		return template.selectList("employee.getEmployeeByDep", map);
	}
	
}
