package cn.saul.xmlAndJson;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Message {
	private int id;
	private String text;
	private ArrayList<Double> geo;
	private User user;
	
}

@Getter
@Setter
@ToString
class User{
	String name;
	int followers_count;
}