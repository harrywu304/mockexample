https://github.com/powermock/powermock

当你需要使用PowerMock强大功能（Mock静态、final、私有方法等）的时候，就需要在测试方法加注解@PrepareForTest。
如果在测试方法中有时用到@PrepareForTest，在测试类就得使用注解：
@RunWith(PowerMockRunner.class)
需依赖（for junit4.4+版本）：
import org.powermock.modules.junit4.PowerMockRunner;

当需要mock final方法的时候，必须加注解@PrepareForTest和@RunWith。注解@PrepareForTest里写的类是final方法所在的类。 

示例中使用的PowerMock组件是依赖：mockito 1.x版本、junit4.4+的。
所以配置了PowerMock后也就可以直接使用mockito 1.x版本了。

当要mock的method带有参数时可以如下匹配任意参数或者特定参数：
import static org.mockito.Matchers.*;
Mockito.when(SomeClass.someMethod(anyMap(), anyString(), anyLong(), any(Log.class))).thenReturn(1L);

注意：
当需要mock static方法时，如果static方法是系统类的，如System类，需要@PrepareForTest的是使用这个系统类的类；
如果是非系统类就直接mock包含static方法的类； （见示例代码）
