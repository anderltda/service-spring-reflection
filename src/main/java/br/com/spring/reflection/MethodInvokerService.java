package br.com.spring.reflection;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MethodInvokerService {

	@Autowired
	private ApplicationContext applicationContext;

	@Transactional
	public void invokeMethodWithParameters(String beanName, String methodName, Object... params) {
		try {
			// Obtenha o bean
			Object bean = applicationContext.getBean(beanName);

			// Obtenha os tipos dos parâmetros
			Class<?>[] paramTypes = new Class[params.length];
			for (int i = 0; i < params.length; i++) {
				paramTypes[i] = params[i].getClass();
			}

			// Obtenha o método desejado, especificando os tipos de parâmetros
			Method method = bean.getClass().getMethod(methodName, paramTypes);

			// Chame o método passando os valores dos parâmetros
			method.invoke(bean, params);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
