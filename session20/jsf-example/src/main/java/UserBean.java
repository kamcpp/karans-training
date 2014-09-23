

/**
 * Created by morteza on 9/21/14.
 */

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UserBean {
    private  String name;
    private  Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
