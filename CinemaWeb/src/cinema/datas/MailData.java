package cinema.datas;

import java.io.Serializable;

public class MailData implements Serializable {
	
				private int id;
				private String sender;
				private String receiver;
				private String subject;
				private String content;
				private String timestamp;
				
				public MailData() {
					
				}
				
				public int getId() {
							return id;
				}	
				public void setId(int id) {
							this.id = id;
				}
		
				public String getSender() {
							return sender;
				}
				public void setSender(String sender) {
							this.sender = sender;
				}
				
				public String getReceiver() {
							return receiver;
				}
				public void setReceiver(String receiver) {
							this.receiver = receiver;
				}
				
				public String getSubject() {
							return subject;
				}
				public void setSubject(String subject) {
							this.subject = subject;
				}
				
				public String getContent() {
							return content;
				}
				public void setContent(String content) {
							this.content = content;
				}
				
				public String getTimestamp() {
							return timestamp;
				}
				public void setTimestamp(String timestamp) {
							this.timestamp = timestamp;
				}

}