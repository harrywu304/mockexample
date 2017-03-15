package org.pub.ttmockito.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.pub.ttmockito.dao.UserDao;
import org.pub.ttmockito.service.UserService;
import org.springframework.test.util.ReflectionTestUtils;

import base.BaseJunit4Test;

public class UserServiceImplTest extends BaseJunit4Test{
	
	@Mock
	UserDao userDao;
	
	@InjectMocks 
	@Resource
	UserService userService;
	
    @Before
    public void initMocks() throws Exception {
    	//使用mock annotation一定要先init
    	//另一个替换init的方法是在class加 @RunWith(MockitoJUnit44Runner.class)  
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testGetUserNameById() {
		when(userDao.selectUserNameById("123")).thenReturn("harry");
		String userName = userService.getUserNameById("123");
		assertEquals("harry",userName);
	}
	
	@Test
	public void testMockitVerify(){
		 //mock creation
		 List mockedList = mock(List.class);

		 //using mock object
		 mockedList.add("one");
		 mockedList.clear();

		 //verification
		 verify(mockedList).add("one");
		 verify(mockedList).clear();
	}

}
