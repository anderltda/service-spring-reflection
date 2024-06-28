package br.com.spring.reflection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HandlerService {

	@Value("${server.port}")
	private String port;

	@Autowired
	private HandlerRepository repository;

	public List<Dog> list() {
		return (List<Dog>) repository.findAll();
	}

	public List<Dog> listNames(String name) {
		return (List<Dog>) repository.findByNames(name);
	}

	public String getPort() {
		return port;
	}
}
