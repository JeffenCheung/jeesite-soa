package com.pactera.jeesite.modules.soa;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pactera.jeesite.modules.soa.entity.UserVO;

/**
 * <b>function:</b> RESTful风格WebService client for soa project
 * 
 * @author jeffen
 * @createDate 2015-12-24
 * @file RSETServiceClient.java
 * @package com.pactera.jeesite.modules.soa
 * @project pactera-jeesite
 * @blog http://
 * @email jeffencheung@gmail.com
 * @version 0.1
 */
public class RSETServiceClient {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	private static WebClient client;

	@Before
	public void init() {
		// 手动创建webClient对象，注意这里的地址是发布的那个/rest地址
		// String url = "http://localhost:8000/CXFWebService/rest/";
		// client = WebClient.create(url);

		// 从Spring Ioc容器中拿webClient对象
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-context-cxf-client.xml");
		String webClient = "webClient_0.2";
		client = ctx.getBean(webClient, WebClient.class);
		logger.info("init()" + webClient);
	}

	@After
	public void destory() {
	}

	@Test
	public void testGet() {
		String str = client.path("user/sayHello/jeffentest")
				.accept(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println(str);
	}

	// @Test
	public void testRequest() {
		System.out.println(client.path("user/request/234234")
				.accept(MediaType.TEXT_PLAIN).get(String.class));
	}

	// @Test
	public void testBean() {
		UserVO user = client.path("user/bean/{id}", 25)
				.accept(MediaType.APPLICATION_XML).get(UserVO.class);
		System.out.println(user);
	}

	// @Test
	public void testList() {
		System.out.println(client.path("user/list")
				.accept(MediaType.APPLICATION_XML).get(UserVO.class)
				.getUserVO());
	}

	// @Test
	public void testDeleteData() {
		client.path("user/removeData/23").delete();
	}

	// @Test
	public void testPostData() {
		UserVO user = new UserVO();
		user.setName("jeffen");
		user.setAge(33);
		System.out.println(client.path("user/postData")
				.accept(MediaType.APPLICATION_XML).post(user, UserVO.class));
	}

	// @Test
	public void testPutData() {
		UserVO user = new UserVO();
		user.setName("jeffentest-测试");
		System.out.println(client.path("user/putData/1")
				.accept(MediaType.APPLICATION_XML).put(user).getEntity());
	}

}
