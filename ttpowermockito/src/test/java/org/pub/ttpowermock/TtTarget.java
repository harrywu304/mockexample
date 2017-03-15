package org.pub.ttpowermock;

import java.io.File;

public class TtTarget {
	//测试目标代码：
	public boolean callArgumentInstance(File file) {
	    return file.exists();
	}
	
	//测试目标代码：
	public boolean callInternalInstance(String path) {
	    File file = new File(path);
	    return file.exists();
	}
	  
	
	//测试目标代码：
	public String getNowStr(){
		return "now:"+System.currentTimeMillis();
	}
	
	//测试目标代码：
	public boolean callPrivateMethod() {
	    return isExist();
	}
	 
	private boolean isExist() {
	    return false;
	}
	
	public String doAuth(){
		return HttpClientUtil.post("http://www.baidu.com", null);
	}
}
