package models;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
	@Autowired
	SqlSessionFactory factory;
	
	@Autowired
	SqlSessionTemplate template;
	
	public List<Map> getAllMovies(){
		return template.selectList("movie.getAllMovies");
	}
	public List<Map> getMoviesSchedule(String s){
		return template.selectList("movie.getMovieSchedule", s);
	}
	
	public int makeReservation(Map map) {
		return template.insert("movie.makeReservation", map);
	}
	
	public List<Map> getSeatsByScheduleAndTitle(Map map){
		return template.selectList("movie.getSeatsByTitleAndSchedule", map);
	}
}
