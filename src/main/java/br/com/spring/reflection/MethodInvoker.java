package br.com.spring.reflection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class MethodInvoker {

	@Autowired
	private ApplicationContext applicationContext;

	public void invokeMyMethod() {
		try {
			// Obtenha o bean
			Object bean = applicationContext.getBean("myService");

			// Obtenha o método desejado
			Method method = bean.getClass().getMethod("myMethod");

			// Chame o método
			method.invoke(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}