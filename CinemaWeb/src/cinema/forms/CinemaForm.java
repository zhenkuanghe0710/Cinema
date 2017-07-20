package cinema.forms;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import cinema.services.MailData;
import cinema.services.MovInfData;
import cinema.services.TicketData;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


public class CinemaForm extends ActionForm{

	
	private int id;
	private String title;
	private String screen;
	private int price;
	private String result;
	

	private int seats;
	private List<MovInfData> movinfList;
	

	private String name;
	private int quantity;
	private int cquantity;
	private int total;
	private List<TicketData> ticketList;
	

	private String password;
	private String receiver;
	private String content;
	private String timestamp;
    private List<MailData> mailList;	
    
    
	public int getCquantity() {
		return cquantity;
	}

	public void setCquantity(int cquantity) {
		this.cquantity = cquantity;
	}

	public List<MailData> getMailList() {
				return mailList;
	}

	public void setMailList(List<MailData> mailList) {
				this.mailList = mailList;
	}
	
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		try {
			this.content = new String( content.getBytes("ISO-8859-1"),"UTF-8" );
		} 
		catch (UnsupportedEncodingException e) {
				e.printStackTrace();
		}
	}

	public String getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		try {
			this.title = new String( title.getBytes("ISO-8859-1"),"UTF-8" );
		} 
		catch (UnsupportedEncodingException e) {
				e.printStackTrace();
		}
	}
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		try {
			this.screen = new String( screen.getBytes("ISO-8859-1"),"UTF-8" );
		} 
		catch (UnsupportedEncodingException e) {
				e.printStackTrace();
		}
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	
	public List<MovInfData> getMovinfList() {
		return movinfList;
	}
	public void setMovinfList(List<MovInfData> movinfList) {
		this.movinfList = movinfList;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		try {
			this.name = new String( name.getBytes("ISO-8859-1"),"UTF-8" );
		} 
		catch (UnsupportedEncodingException e) {
				e.printStackTrace();
		}
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
public List<TicketData> getTicketList() {
		return ticketList;
	}
	public void setTicketList(List<TicketData> ticketList) {
		this.ticketList = ticketList;
	}
	
	

}
