/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.karans.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author Ya Mahdi
 */
public class reflect {
    
    public void generateReflection(String basePackage, String packageName, String className, String methodName, String beforeName, String afterName ) throws InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
            Class<?> c = null;
            Class noparams[] = {};
            String fullClassPath = null;
            if(packageName!=null)
                 fullClassPath = basePackage+"."+packageName+"."+className;
            else
                 fullClassPath = basePackage+"."+className;
            try{
	            c =Class.forName(fullClassPath);
	        }catch(ClassNotFoundException e){
	               System.out.println("Hello"+e.getMessage());
	        }
    
           Object object;  // Instantiation Exception!
            object = c.newInstance();
            Object beforeObj;
            
            if(beforeName != ""){
                Method beforeMethod = c.getDeclaredMethod(beforeName,noparams);  // No such Method Exception
                beforeObj = beforeMethod.invoke(object, noparams);
            }
             Method method = c.getDeclaredMethod(methodName,noparams);  // No such Method Exception
             Object methodObj = method.invoke(object, noparams);
             
             if(afterName != ""){
                Method afterMethod = c.getDeclaredMethod(afterName,noparams);  // No such Method Exception
                Object afterObj = afterMethod.invoke(object, noparams);
             
             } 
    }
    
}
