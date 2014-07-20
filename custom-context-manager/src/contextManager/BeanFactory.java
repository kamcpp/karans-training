package contextManager;

public interface BeanFactory {
	public Object create(BeanDescription beanDesc) throws BeanCreationException;
}
