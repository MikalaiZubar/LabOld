package com.epam;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import com.epam.loader.OwnLoader;

public class Demo {

	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
		
		String classPath = "C:/D/workspace/Test1/bin";
			
		File dir = new File(classPath);
		
		URL url = dir.toURI().toURL();
		URL[] urls = {url};
		URLClassLoader urlLoader = new URLClassLoader(urls);
		
		Class p = urlLoader.loadClass("Parent");
		
		System.out.println(p.getCanonicalName());	
		System.out.println(p.getClassLoader());
				
		OwnLoader loader = new OwnLoader(classPath, ClassLoader.getSystemClassLoader());
		
		String[] classes = dir.list();
		
		ArrayList<Class> cl = new ArrayList<>();
		
		for(String c : classes){
			try{
				if(c.contains(".class")){
					String className = c.split(".class")[0];
					Class loadedClass = loader.loadClass(className);
					cl.add(loadedClass);
					System.out.println(loadedClass.getCanonicalName());
					System.out.println(loadedClass.getClassLoader());
				}
			}catch (ClassNotFoundException e) {
					e.printStackTrace();
			} 
		}
		
		Class ch = null;
		Class pa = null;
		for(Class c : cl){
			if(c.getCanonicalName().equals("Parent")){
				System.out.println(p.equals(c));
				pa = c;
			}
			if(c.getCanonicalName().equals("Child")){
				System.out.println(p.isInstance(c));
				ch = c;
			}
			
		}
		
		System.out.println(pa.isInstance(ch));
		
		ArrayList<Integer> ints = new ArrayList<>();
		System.out.println(ints.size());

			
	}

}
