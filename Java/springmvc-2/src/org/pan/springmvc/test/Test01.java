package org.pan.springmvc.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.pan.springmvc.dao.EmployeeDao;
import org.pan.springmvc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test01 {
	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping(value = "/testInit", method = RequestMethod.GET)
	public String testInit() {
		return "ok";
	}

	@ResponseBody
	@RequestMapping(value = "/testJson", method = RequestMethod.POST)
	public Collection<Employee> testJson() {
		return employeeDao.getAll();
	}

	/**
	 * 通过 HttpMessageConverter 接口的实现
	 * org.springframework.http.converter.StringHttpMessageConverter
	 * 来完成页面各种入参转换为String类型，
	 * 
	 * @param content
	 * @return
	 */
	@RequestMapping(value = "/testRequestBody", method = RequestMethod.POST)
	public String testRequestBody(@RequestBody String content) {

		System.out.println(content);

		return "ok";
	}

	/**
	 * ResponseEntity<T>，下载功能
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/testResponseEntity", method = RequestMethod.GET)
	public ResponseEntity<byte[]> testResponseEntity() throws IOException {

		byte[] body = null;
		InputStream inputStream = new FileInputStream("E:\\推拿治疗学总结.doc");
		body = new byte[inputStream.available()];
		inputStream.read(body);
		inputStream.close();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","attachment;filename=推拿治疗学总结.doc");

		HttpStatus statusCode = HttpStatus.OK;
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(body, headers, statusCode);

		return responseEntity;
	}
	
	/**
	 * HttpEntity 和 RequestBody 功能性是相同
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/testHttpEntity", method = RequestMethod.POST)
	public String testHttpEntity(HttpEntity<String> entity) {
		System.out.println(entity.getBody());
		return "ok";
	}

}
