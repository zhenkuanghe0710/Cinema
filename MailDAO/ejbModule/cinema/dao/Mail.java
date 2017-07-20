package cinema.dao;

import java.util.List;

import cinema.datas.MailData;


public interface Mail {

			MailData sendMail(MailData data) throws Exception;
	
			void createMail(MailData data) throws Exception;
			
			List<MailData> getMailList(MailData data) throws Exception;
	
}