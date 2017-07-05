package com.epam.loader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class OwnLoader extends ClassLoader{
	
	private String path;
	
	public OwnLoader(String path, ClassLoader parent){
		super(parent);
		this.path = path;
	}
	
	@Override
	public Class<?> findClass(String className) throws ClassNotFoundException{
		try{
			byte[] b = loadClassFromStream(path + "/"+ className + ".class");
			return defineClass(className, b, 0, b.length);
	    } catch (FileNotFoundException ex) {
	      return super.findClass(className);
	    } catch (IOException ex) {
	      return super.findClass(className);
	    }
	}
	
	
	  private byte[] loadClassFromStream(String path) throws FileNotFoundException, IOException {
	    InputStream is = new FileInputStream(new File(path));
	    
	    long length = new File(path).length();
	 	  
	    if (length > Integer.MAX_VALUE) {
	      System.out.println("File is too large");    // File is too big
	    }
	    
	    ByteArrayOutputStream os = new ByteArrayOutputStream();
	  
	    byte[] bytes = new byte[(int)length];
	  
	    int read = 0;
	 	    
	    while((read = is.read(bytes)) != -1){
	    	os.write(bytes, 0, read);
	    }
	
	    is.close();
	    os.close();
	    System.out.println(os.toByteArray().length);
	    return os.toByteArray();

	  }

}
