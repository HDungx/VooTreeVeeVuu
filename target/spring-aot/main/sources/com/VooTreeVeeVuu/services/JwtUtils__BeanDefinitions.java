package com.VooTreeVeeVuu.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JwtUtils}.
 */
@Generated
public class JwtUtils__BeanDefinitions {
  /**
   * Get the bean definition for 'jwtUtils'.
   */
  public static BeanDefinition getJwtUtilsBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JwtUtils.class);
    beanDefinition.setInstanceSupplier(JwtUtils::new);
    return beanDefinition;
  }
}
