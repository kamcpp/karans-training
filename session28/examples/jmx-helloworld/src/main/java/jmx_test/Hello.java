package jmx_test;

public class Hello implements HelloMBean {

    private static Hello instance;

    public static Hello getInstance() {
        if (instance == null) {
            instance = new Hello();
        }
        return instance;
    }

    private boolean checked;
    private String message;

    private Hello() {
        message = "Hello World!";
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayHello() {
        System.out.println(message);
    }

    @Override
    public void sayHello(String name) {
        System.out.println(name + ": " + message);
    }

    @Override
    public void sayHelloToPerson(Person person) {
        System.out.println(person.getName() + " " + person.getFamily() + ": " + message);
    }
}
