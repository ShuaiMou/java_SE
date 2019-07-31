package cn.saul.xmlAndJson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

/**
 * 
 * @author moushuai
 *
 */
public class ResolveAndGenerateJson {
	
	/**
	 * 使用Gson解析复杂json文件
	 */
	@Test
	public void resolveJsonByGson() {
		InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/saul/xmlAndJson/message.json");
		Reader in = new InputStreamReader(resourceAsStream);
		JsonReader jsonReader = new JsonReader(in );
		ArrayList<Message> messages = readMessageArray(jsonReader);
		for(Message message : messages) {
			System.out.println(message);
		}
	}
	
	//读取 Message 数组
	private ArrayList<Message> readMessageArray(JsonReader jsonReader) {
		ArrayList<Message> messages = new ArrayList<Message>();
		try {
			jsonReader.beginArray();
			while(jsonReader.hasNext()) {
				messages.add(readMessage(jsonReader));
			}
			jsonReader.endArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return messages;
	}
	
	//解析一个 Message 对象
	private Message readMessage(JsonReader jsonReader) {
		Message message = null;
		try {
			jsonReader.beginObject();
			message = new Message();
			while(jsonReader.hasNext()) {
				String name = jsonReader.nextName();
				if ("id".equals(name)) {
					message.setId(jsonReader.nextInt());
				}else if ("text".equals(name)) {
					message.setText(jsonReader.nextString());
				}else if ("geo".equals(name) && jsonReader.peek() != JsonToken.NULL) {
					message.setGeo(readGeo(jsonReader));
				}else if ("user".equals(name)) {
					message.setUser(readUser(jsonReader));
				}else {
					jsonReader.skipValue();
				}
			}
			jsonReader.endObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	//解析 user
	private User readUser(JsonReader jsonReader) {
		User user = new User();
		try {
			jsonReader.beginObject();
			while(jsonReader.hasNext()) {
				String name = jsonReader.nextName();
				if("name".equals(name)) {
					user.setName(jsonReader.nextString());
				}else if ("followers_count".equals(name)) {
					user.setFollowers_count(jsonReader.nextInt());
				}
			}
			jsonReader.endObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	//解析 geo
	private ArrayList<Double> readGeo(JsonReader jsonReader) {
		ArrayList<Double> geo = new ArrayList<Double>();
		try {
			jsonReader.beginArray();
			while(jsonReader.hasNext()) {
				geo.add(jsonReader.nextDouble());
			}
			jsonReader.endArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return geo;
	}
	
	/**
	 * 一个java对象转换为JSON对象。
	 */
	@Test
	public void createJson() {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("1101", "jack", "88/bourke st.", "110", "jack@gamil.com"));
		list.add(new Person("1102", "marray", "334/william st.", "112", "marray@gmail.com"));
		JsonArray array = new JsonArray();
		for(Person person : list) {
			JsonObject object = new JsonObject();
			object.addProperty("id", person.getPersonId());
			object.addProperty("name", person.getName());
			object.addProperty("address", person.getAddress());
			object.addProperty("tel", person.getTel());
			object.addProperty("email", person.getEmail());
			array.add(object);
		}
		System.out.println(array.toString());
	}
	
	/**
	 * 把一个JSON对象转换为java对象,一个java对象转换为JSON对象。
	 */
	@Test
	public void gson1() {
		Gson gson = new Gson();
		InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/saul/xmlAndJson/person.json");
		InputStreamReader in = new InputStreamReader(resourceAsStream);
		Person fromJson = gson.fromJson(in, Person.class);
		System.out.println(fromJson);
		
		String jsonString = gson.toJson(fromJson);
		System.out.println(jsonString);
	}
	
	/**
	 * 把一组JSON对象转换为一个java对象集合，或者把一个java对象集合转换成JSON数组。
	 */
	@Test
	public void gson2() {
		Gson gson = new Gson();
		InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/saul/xmlAndJson/persons.json");
		InputStreamReader in = new InputStreamReader(resourceAsStream);
		Type type = new TypeToken<List<Person>>() {}.getType();
		List<Person> fromJsonList = gson.fromJson(in, type);
		fromJsonList.forEach(System.out::println);
		
		String json = gson.toJson(fromJsonList);
		System.out.println(json);
	}
}
