package ripper.quotes.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import ripper.quotes.annotations.DeprecatedClass;

public class DeprecationHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    // iterate over every bean definition, get class name (String), then get actual Class istance, check if class have
    // annotation - DeprecatedClass.class, if yes => replace class name in bean definition to the class name set in the annotation
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {

            final BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
            final String beanClassName = beanDefinition.getBeanClassName();
            try {
                final Class<?> aClass = Class.forName(beanClassName);
                final DeprecatedClass annotation = aClass.getAnnotation(DeprecatedClass.class);
                if (annotation != null) {
                    beanDefinition.setBeanClassName(annotation.newImpl().getName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
