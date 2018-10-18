package models;

import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.UpdateResult;

@Repository
public class ChatRepository {
	//db.create.insertOne
	
	//({"_id":"em1014", "name":"구구구", "text" : "채팅내용.","date": "14:31","read" :["em1040","em9999"]});
	
	@Autowired
	MongoTemplate template;
	
	public void insertOne(Map map) {
		Map ret = template.insert(map, "allchat");
		// Returns: the inserted object.
	}
	
	public List<Map> getAllChat() {
		return template.find(new Query(), Map.class, "allchat");
	}
	
	public List<Map> getUnreadChat(String id) {
		Criteria c = 
			Criteria.where("read").nin(id);
		
		//db.allchat.find({"read" : {"$elemMatch" : { "$eq": "em1040" }}}); 
		return template.find(new Query(c), Map.class, "chat");
	}
	
	/*public void insertReader(String id) {
		Criteria c = Criteria.where("read").
		template.insert(domainType)
		template.update(domainType)
	}*/
	public void updateSome() {
		Update u = new Update().set("avg", 10.0);
		UpdateResult rst =template.updateMulti(new Query(), u, "hero");
		// updateFirst  혹은 updateMulti 
		System.out.println(rst.getModifiedCount());
		
		Update u1 = new Update().inc("avg", 4);
		Update u2 = new Update().push("speciality", "공포");
		Update u3 = new Update().pull("speciality", "기절");
		
		Update u4 = new BasicUpdate(new Document());
	}
	
}
