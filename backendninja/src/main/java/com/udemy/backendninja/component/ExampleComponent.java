package com.udemy.backendninja.component;

import org.apache.commons.logging.*;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponent {

	public static final Log LOG = LogFactory.getLog(ExampleComponent.class);
	
	public void sayHello() {
		LOG.info("HELLO FROM ExampleComponent");
	}
}
