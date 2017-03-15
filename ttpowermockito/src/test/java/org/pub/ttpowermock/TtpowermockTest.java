package org.pub.ttpowermock;

import static org.mockito.Matchers.*;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.management.*")
public class TtpowermockTest {
	
	//测试用例代码：
	@Test
	public void testCallArgumentInstance() {
	    File file = PowerMockito.mock(File.class);
	    TtTarget underTest = new TtTarget();
	    PowerMockito.when(file.exists()).thenReturn(true);
	    Assert.assertTrue(underTest.callArgumentInstance(file));
	}
	
	//mock 系统类的静态方法   
	@Test
	@PrepareForTest(TtTarget.class)
	public void testCallInternalInstance() throws Exception
	{
	    File file = PowerMockito.mock(File.class);
	    TtTarget underTest = new TtTarget();
	    PowerMockito.whenNew(File.class).withArguments("bbb").thenReturn(file);
	    PowerMockito.when(file.exists()).thenReturn(true);
	    Assert.assertTrue(underTest.callInternalInstance("bbb"));
	}

	
	//mock 系统类的静态方法（注意@PrepareForTest后面的类的不同）
	@Test
	@PrepareForTest(TtTarget.class)
	public void testGetNowStr() {
		PowerMockito.mockStatic(System.class);
	    PowerMockito.when(System.currentTimeMillis()).thenReturn(3424134523L);
	    TtTarget underTest = new TtTarget();
	    Assert.assertEquals("now:3424134523",underTest.getNowStr());
	}
	
	//测试用例代码： 
	@Test
	@PrepareForTest(TtTarget.class)
	public void testCallPrivateMethod() throws Exception
	{
		TtTarget underTest = PowerMockito.mock(TtTarget.class);
	    PowerMockito.when(underTest.callPrivateMethod()).thenCallRealMethod();
	    PowerMockito.when(underTest, "isExist").thenReturn(true);
	    Assert.assertTrue(underTest.callPrivateMethod());
	}
	
	//mock 非系统类的静态方法（注意@PrepareForTest后面的类的不同）
	@Test
	@PrepareForTest(HttpClientUtil.class)
	public void testDoAuth(){
		PowerMockito.mockStatic(HttpClientUtil.class);
	    PowerMockito.when(HttpClientUtil.post(anyString(), anyMap())).thenReturn("ok");
	    TtTarget underTest = new TtTarget();
	    underTest.doAuth();
	}


}
