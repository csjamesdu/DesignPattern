package com.csjamesdu.dp.proxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class Proxy {
	public static Object newProxyInstance(Class<?> intfc, InvocationHandler h) { 
		String methodStr = "";
		String rt = "\r\n";
		Object m = null;
		URLClassLoader ul = null;
		
		Method[] methods= intfc.getMethods();
		
		for(Method meth : methods){
			methodStr += "@Override" + rt + 
						 "public void " + meth.getName() + "() {" + rt +
						 "	try{"+rt+
						 "	Method md = " + intfc.getName() +".class.getMethod(\""+ meth.getName()+"\");" + rt +
						 "	h.invoke(this, md);"+ rt +
						 "	}catch(Exception e){"+rt+
						 "	e.printStackTrace();"+rt+
						 "	}" +rt+
						
						 "}";
		}
		
		
		String src="package com.csjamesdu.dp.proxy;"+ rt +
				"import java.lang.reflect.Method;" +rt+
	
				"public class $Proxy1 implements "+intfc.getName()+"{"+ rt +
				
				"	com.csjamesdu.dp.proxy.InvocationHandler h;"+rt+
				
				"	public $Proxy1(InvocationHandler h) {"+ rt +
					"		super();"+ rt +
					"		this.h = h;"+ rt +
				"	}"+ rt +
				
				methodStr+ rt +
			"}";
		
		//write the generated proxy java file into the file system
		String fileName = "d:/tmp/src/com/csjamesdu/dp/proxy/$Proxy1.java";
		File f = new File(fileName);
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			fw.write(src);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		//compile the java file into the class file
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//System.out.println(compiler.getClass().getName());
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		try {
			fileMgr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//Load class file into memory and create instance
		URL[] urls;
		try {
			urls = new URL[]{new URL("file:/"+"d:/tmp/src/")};
			ul = new URLClassLoader(urls);
			Class c = ul.loadClass("com.csjamesdu.dp.proxy.$Proxy1");
			Constructor ctr = c.getConstructor(InvocationHandler.class);
			m = ctr.newInstance(h);			
		} catch (MalformedURLException | NoSuchMethodException | SecurityException | 
				ClassNotFoundException | InstantiationException | IllegalAccessException | 
				IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			try {
				ul.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return m;
	}
}


/*Dynamically generated Proxy File 
package com.csjamesdu.dp.proxy;
import java.lang.reflect.Method;
public class $Proxy1 implements com.csjamesdu.dp.proxy.Movable{
	com.csjamesdu.dp.proxy.InvocationHandler h;
	public $Proxy1(InvocationHandler h) {
		super();
		this.h = h;
	}
	@Override
	public void move() {
		try{
			Method md = com.csjamesdu.dp.proxy.Movable.class.getMethod("move");
			h.invoke(this, md);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}*/
