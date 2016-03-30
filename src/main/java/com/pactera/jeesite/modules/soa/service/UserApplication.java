package com.pactera.jeesite.modules.soa.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pactera.jeesite.modules.soa.entity.UserVO;

@Path(value = "/user")
public interface UserApplication {

	@GET
	@Path("/sayHello/{name}")
	@Produces({ MediaType.TEXT_PLAIN })
	public String sayHello(@PathParam("name") String name);

	@GET
	@Path("/findList/{user}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<UserVO> findList(@PathParam("user") UserVO user);

	@PUT
	@Path("/putData/{user}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void save(UserVO user);

	@DELETE
	@Path("/removeData/{user}")
	public void delete(UserVO user);
}