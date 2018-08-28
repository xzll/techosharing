package notice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import bean.User;

public class SpringWebSocketHandler extends TextWebSocketHandler{
	
	private static Map<Long, WebSocketSession> sessionMap = new HashMap<Long,WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Long userId = ( (User)session.getAttributes().get("user") ).getId();
		sessionMap.put(userId, session);
		//TODO ֪ͨ������Ϣ
		
		
	}


	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionMap.remove(session.getAttributes().get("user"));
		
	
	}
    /**
     * ��ĳ���û�������Ϣ
     *
     * @param userName
     * @param message
     */
    public void sendMessageToUser(Long userId, TextMessage message) {
    	WebSocketSession webSocketSession = sessionMap.get(userId);
       if(webSocketSession != null) {
    	   try {  
    		   if(webSocketSession.isOpen()) {
					webSocketSession.sendMessage(message);
					}
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
    	  
       }

        
    }
    /**
     * �����������û�������Ϣ
     *
     * @param userName
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
    	for(Long key:sessionMap.keySet()){
    		WebSocketSession webSocketSession = sessionMap.get(key);
    		if(webSocketSession != null) {
    			try {  
    				if(webSocketSession.isOpen()) {
    					webSocketSession.sendMessage(message);
    				}
    			} catch (IOException e) {
    				// TODO �Զ����ɵ� catch ��
    				e.printStackTrace();
    			}
    			
    		}
    		
    	}

        
    }
    public void logout(Long userId){
    	sessionMap.remove(userId);
    }

}
