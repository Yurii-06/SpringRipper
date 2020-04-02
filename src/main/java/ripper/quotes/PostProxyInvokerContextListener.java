package ripper.quotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import ripper.quotes.annotations.PostProxy;

import java.lang.reflect.Method;

public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        final ApplicationContext context = event.getApplicationContext();
        final String[] beanDefinitionNames = context.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            final BeanDefinition beanDefinition = factory.getBeanDefinition(beanDefinitionName);
            final String originalClassName = beanDefinition.getBeanClassName();
            try {
                final Class<?> aClass = Class.forName(originalClassName);
                final Method[] methods = aClass.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(PostProxy.class)) {
                        final Object bean = context.getBean(beanDefinitionName); // proxy bean
                        final Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                        currentMethod.invoke(bean);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
