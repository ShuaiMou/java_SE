package cn.saul.xmlAndJson;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class ResolveAndGenerateXml {
	/**
	 * DOM4J解析XML
	 * 基于树形结构，第三方组件
	 * 解析速度块，效率高，使用java中的迭代器实现数据读取，在web框架中使用较多（Hibernate）
	 */
	@Test
	public void resolveByDom4j() {
		List<Person> list = new ArrayList<Person>();
		Person p = null;
		SAXReader saxReader = new SAXReader();
		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/saul/xmlAndJson/person.xml");
		try {
			Document doc = saxReader.read(stream);
			Element rootElement = doc.getRootElement();
			@SuppressWarnings("unchecked")
			Iterator<Element> elementIterator = rootElement.elementIterator();
			while(elementIterator.hasNext()) {
				p = new Person();
				Element next = elementIterator.next();
				p.setPersonId(next.attributeValue("personId"));
				@SuppressWarnings("unchecked")
				Iterator<Element> elementIterator2 = next.elementIterator();
				while(elementIterator2.hasNext()) {
					Element next2 = elementIterator2.next();
					String text = next2.getText();
					if (next2.getName().equals("name")) {
						p.setName(text);
					}else if(next2.getName().equals("address")) {
						p.setAddress(text);
					}else if(next2.getName().equals("tel")) {
						p.setTel(text);
					}else if(next2.getName().equals("email")) {
						p.setEmail(text);
					}	
				}
				list.add(p);	
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		list.forEach(System.out::println);	
	}
	
	/**
	 * 使用第三方XStream组件实现 XML 的解析与生成
	 */
	@Test
	public void xStream() {
		Person person = new Person();
		person.setPersonId("10011");
		person.setName("saul");
		person.setAddress("2001/668 Bourke ST");
		person.setEmail("saul@gmail.com");
		person.setTel("28732883234");
		
		XStream xStream = new XStream();
		xStream.alias("Person", Person.class);
		xStream.useAttributeFor(Person.class, "personId");
		String xml = xStream.toXML(person);
		System.out.println(xml);
		
		//解析xml
		Person fromXMLPerson = (Person) xStream.fromXML(xml);
		System.out.println(fromXMLPerson);
	}
}
