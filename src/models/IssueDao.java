package models;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class IssueDao extends MybatisDao {

	public IssueDao() throws IOException {
		super();
	}

	public int addOne(Map m) {
		SqlSession sql = factory.openSession();
		try {
			int i = sql.insert("issue.addOne", m);
			if (i == 1) {
				sql.commit();
			}
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			sql.close();
		}
	}

	public List<Map> getAllIssue() {
		SqlSession sql = factory.openSession();
		try {
			List<Map> list = sql.selectList("issue.getAllIssue");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sql.close();
		}
	}
	public List<Map> getSomeRecent() {
		SqlSession sql = factory.openSession();
		try {
			List<Map> list = sql.selectList("issue.getSomeRecent");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sql.close();
		}
	}

	
	public Map getOneHot() {
		SqlSession sql = factory.openSession();
		try {
			Map map = sql.selectOne("issue.getOneHot");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sql.close();
		}
	}
	
	
	public Map getOneByNo(Number no) {
		SqlSession sql = factory.openSession();
		try {
			Map map = sql.selectOne("issue.getOneByNo", no);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sql.close();
		}
	}

}
