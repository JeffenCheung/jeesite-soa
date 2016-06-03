package com.pactera.jeesite.modules.soa;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <b>function:</b> RESTful风格WebService client for oa-core project
 * 
 * @author jeffen
 * @createDate 2015-12-24
 * @file RSETServiceClientOaCore.java
 * @package com.pactera.jeesite.modules.soa
 * @project crsc-ccip
 * @blog http://
 * @email jeffencheung@gmail.com
 * @version 0.1
 */
public class RSETServiceClientOaCore {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	private static WebClient client;
	private static String req;

	@Before
	public void init() {
		// 手动创建webClient对象，注意这里的地址是发布的那个/rest地址
		String url = "http://localhost:8080/pactera-jeesite/restService/actservice/0.1/";
		client = WebClient.create(url);

		// 从Spring Ioc容器中拿webClient对象
		//ApplicationContext ctx = new ClassPathXmlApplicationContext(
		//		"spring-context-cxf-client.xml");
		//String webClient = "webClient_0.2";
		//client = ctx.getBean(webClient, WebClient.class);
		//logger.info("init()" + webClient);
	}

	@After
	public void destory() {
	}

	@Test
	public void testGetHistoicFlowListInfo() {
		req = client.path("taskservice/doGetHistoicFlowListInfo/5f1dabc72855447a92d89c69d4eb0873")
				.accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println("testGetHistoicFlowListInfo().response=" + req);
	}

	@Test
	public void testGetTraceProcessInfo() {
		req = client.path("taskservice/doGetTraceProcessInfo/4b396fa8920e43f7b5641e67e2792bdb")
				.accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println("testGetTraceProcessInfo().response=" + req);
	}

}
