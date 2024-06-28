package br.com.spring.reflection;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandlerController {

	@Autowired
	private ApplicationContext applicationContext;

	@GetMapping("/health-check")
	public ResponseEntity<String> customHealthCheck() {
		
		String message = "Testing my healh check na port " + invokeMyMethod_();
		
		invokeMyMethod();
		
		
		return new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
	}
	
	@Transactional
	public String invokeMyMethod_() {
		try {
			
			Object bean = applicationContext.getBean("handlerService");

			Method method = bean.getClass().getMethod("getPort");

			String port = (String) method.invoke(bean);
			
			return (port);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Transactional
	public void invokeMyMethod() {
		try {
			
			Object bean = applicationContext.getBean("handlerService");
			
			Class<?>[] paramClass_ = { String.class };
			Object[] paramValue_ = { "Mel" };

			Method method = bean.getClass().getMethod("listNames", paramClass_);

			List<Dog> list = (List<Dog>) method.invoke(bean, paramValue_);
			
			System.out.println(list.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
