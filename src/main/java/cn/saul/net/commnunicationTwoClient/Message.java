package cn.saul.net.commnunicationTwoClient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Message {
	//the client who send the message
	private String from; 
	//the client to who that this message send
	private String to;
	//the type of this message
	private int type;
	//the content of this message
	private String info;
	
	public Message(String from, String to, int type, String info) {
		super();
		this.from = from;
		this.to = to;
		this.type = type;
		this.info = info;
	}

	public Message() {
		super();
	}
	
}
