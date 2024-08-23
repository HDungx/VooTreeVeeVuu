package com.VooTreeVeeVuu;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link VooTreeVeeVuuApplication}.
 */
@Generated
public class VooTreeVeeVuuApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'vooTreeVeeVuuApplication'.
   */
  public static BeanDefinition getVooTreeVeeVuuApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VooTreeVeeVuuApplication.class);
    beanDefinition.setTargetType(VooTreeVeeVuuApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(VooTreeVeeVuuApplication.class);
    beanDefinition.setInstanceSupplier(VooTreeVeeVuuApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
