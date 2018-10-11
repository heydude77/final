package controllers.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

import models.AlertService;

/*
 *    ws ��û �޴� ��Ʈ�ѷ��� http ��û�޴� ��Ʈ�ѷ� �� �ۼ� ����� �ٸ���.
 *  1.TextWebSocketHandler �� extends
 *  
 *  2.Mapping ������ ������̼�(@GetMapping / @RequestMapping) �̷� ���°� �ƴ϶� �������� �����ؾ� �ȴ�.
 *    
 */

@Controller
public class ZuluController extends TextWebSocketHandler{
   @Autowired
   Gson gson;

   @Autowired
   AlertService service;

   @Override
   public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      // Ŭ���̾�Ʈ ������ WebSocket ��ü�� �����ؼ� ������ �ɶ�
      service.addSocket(session);
      System.out.println("afterConnectionEstablished..\n"+session+" / "+ service.totalSize());

      Map data = new HashMap();
      data.put("mode", "welcome");
      data.put("count", service.totalSize() );
      
      service.sendAll(data);

   }

   @Override
   public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
      // Ŭ���̾�Ʈ ������ ������� WebSocket �� ���� �ɶ�   
      System.out.println("afterConnectionClosed..");
      service.removeSocket(session);
   }

   @Override
   protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
      // Ŭ���̾�Ʈ ������ Websocket ��ü�� ���� �����͸� ����������.
      String payload=message.getPayload();
      System.out.println("handleTextMessage >> "+payload);

      Map data = new HashMap();
      data.put("mode", "login");
      data.put("actor", "�����");
      TextMessage msg=new TextMessage(gson.toJson(data));
      session.sendMessage(msg);

   }

}