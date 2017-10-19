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

import com.csjamesdu.dp.proxy.intfc.InvocationHandler;

public class ProxyRefactor {
	static String fileName = "d:/tmp/src/com/csjamesdu/dp/proxy/$Proxy1.java";
	
	public static Object newProxyInstance(Class<?> intfc, InvocationHandler h){
		Object proxy = null;
		String srcStr = null;
			
		srcStr = FileGen(intfc);
		WriteToFS(srcStr);
		CompileFile(fileName);
		
		proxy = InstantiateProxy(h);
		
		return proxy;		
	}
	
	public static String FileGen(Class<?> intfc){
		String src = null;
		String methodStr="";
		String rt = "\r\n";
		Method [] methods = intfc.getMethods();
		
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
		
		src="package com.csjamesdu.dp.proxy;"+ rt +
				"import java.lang.reflect.Method;" +rt+
				
				"import com.csjamesdu.dp.proxy.intfc.InvocationHandler;" + rt +
	
				"public class $Proxy1 implements "+intfc.getName()+"{"+ rt +
				
				"	com.csjamesdu.dp.proxy.intfc.InvocationHandler h;"+rt+
				
				"	public $Proxy1(InvocationHandler h) {"+ rt +
					"		super();"+ rt +
					"		this.h = h;"+ rt +
				"	}"+ rt +
				
				methodStr+ rt +
		"}";
		
		return src;
	}

	public static void WriteToFS(String preStr){
		File f = new File(fileName);
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			fw.write(preStr);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public static void CompileFile(String FileName){
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
		
	}

	public static Object InstantiateProxy(InvocationHandler h){
		Object instanceProxy = null;
		URLClassLoader ul = null;
		URL[] urls;
		try {
			urls = new URL[]{new URL("file:/"+"d:/tmp/src/")};
			ul = new URLClassLoader(urls);
			Class c = ul.loadClass("com.csjamesdu.dp.proxy.$Proxy1");
			Constructor ctr = c.getConstructor(InvocationHandler.class);
			instanceProxy = ctr.newInstance(h);			
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
		return instanceProxy;
	}
}
