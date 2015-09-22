import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class InvokeClass {

	@SuppressWarnings("rawtypes")
	public static void main (String[] args) throws MalformedURLException, 
												ClassNotFoundException, 
												InstantiationException, 
												IllegalAccessException, 
												IllegalArgumentException, 
												InvocationTargetException, 
												NoSuchMethodException, 
												SecurityException{
		Class c = DataClassLoader.loadClass("http://127.0.0.1:9090/", "RemoteData");

		Class[] parameterTypes = {String.class, String.class};
		Constructor cons = c.getConstructor(parameterTypes);
		Object[] initargs = new Object[]{"teacher", "Seoul"};
		Object obj = cons.newInstance(initargs);
		System.out.println(obj);
		
		Method m  = c.getMethod("SayHello",  null);
		m.invoke(obj, null);
	}
}