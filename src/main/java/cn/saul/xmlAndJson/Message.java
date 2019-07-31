package cn.saul.xmlAndJson;

import java.util.ArrayList;


public class Message {
	private int id;
	private String text;
	private ArrayList<Double> geo;
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ArrayList<Double> getGeo() {
		return geo;
	}
	public void setGeo(ArrayList<Double> geo) {
		this.geo = geo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + ", geo=" + geo + ", user=" + user + "]";
	}
	
	
}


class User{
	String name;
	int followers_count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFollowers_count() {
		return followers_count;
	}
	public void setFollowers_count(int followers_count) {
		this.followers_count = followers_count;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", followers_count=" + followers_count + "]";
	}
	
	
}