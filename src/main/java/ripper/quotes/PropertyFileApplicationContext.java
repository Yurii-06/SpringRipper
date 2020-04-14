package ripper.quotes;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class PropertyFileApplicationContext extends GenericApplicationContext {
    public PropertyFileApplicationContext(String fileName) {
        final PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
        final int i = reader.loadBeanDefinitions(fileName);
        System.out.println("found " + i + " beans");
        refresh();
    }


}
