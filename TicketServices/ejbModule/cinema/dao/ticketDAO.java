package cinema.dao;

import java.util.List;

import cinema.datas.TicketData;

public interface ticketDAO {
	
	void createMessage(TicketData data) throws Exception;

	void deleteMessage(TicketData data) throws Exception;
	
	TicketData retrieveMessage(TicketData data) throws Exception;
	
	void updateMessage(TicketData data) throws Exception;

	List<TicketData> getMessageList(TicketData data) throws Exception;

}
