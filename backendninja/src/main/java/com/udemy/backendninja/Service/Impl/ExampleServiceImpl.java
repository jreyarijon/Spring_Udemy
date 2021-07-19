package com.udemy.backendninja.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.Service.ExampleService;
import com.udemy.backendninja.model.Person;

@Service("ExampleService")
public class ExampleServiceImpl implements ExampleService {
	
	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList();
		people.add(new Person("Jon", 23));
		people.add(new Person("Mikel", 34));
		people.add(new Person("Pablo", 25));
		people.add(new Person("Paula", 62));
		people.add(new Person("Ana", 12));
		LOG.info(" --- HELLO FROM SERVICE");
		return people;
	}

}
