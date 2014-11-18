package jmx_test;

public interface HelloMBean {
    String getMessage();

    void setMessage(String message);

    boolean isChecked();

    void setChecked(boolean checked);

    void sayHello();

    void sayHello(String name);

    void sayHelloToPerson(Person person);
}
