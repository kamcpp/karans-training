package abc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contextManager.BeanCreationException;
import contextManager.BeanFactory;
import contextManager.BeanNotFoundException;
import contextManager.ContextConfigurationReader;
import contextManager.ContextManager;
import contextManager.imp.DefaultBeanFactory;
import contextManager.imp.DefaultContextManager;
import contextManager.imp.InMemoryContextConfigReader;

public class ContextManagerTest {

	ContextConfigurationReader reader;	
	BeanFactory factory;
	ContextManager context;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		reader=new InMemoryContextConfigReader();
		factory=new DefaultBeanFactory();
		context=new DefaultContextManager();
		context.setBeanFactory(factory);
		context.setConfigReader(reader);
		context.loadConfig(null);
		
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGet() throws BeanNotFoundException, BeanCreationException {
		String mynr1 = (String)context.get("myNumber");
		
		

	}
	
	@Test
	public void testSingelton() throws BeanNotFoundException, BeanCreationException {
		String mynr1 = (String)context.get("myNumber");
		String mynr2 = (String)context.get("myNumber");
		Assert.assertEquals(mynr1, mynr2);
	}

}
