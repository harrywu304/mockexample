/**
 * 
 */
package base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wuhuoxin 2016年12月6日 下午2:27:46
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) 
//在spring-mvc中增加mvc:resources配置后需要@WebAppConfiguration
//@WebAppConfiguration(value = "src/main/webapp") 
@ContextConfiguration ({"/applicationContext.xml"})
public class BaseJunit4Test {
	
	@Test
	public void test(){
	}

}
