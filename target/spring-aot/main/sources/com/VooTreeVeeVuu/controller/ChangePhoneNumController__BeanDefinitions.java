package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ChangePhoneNumController}.
 */
@Generated
public class ChangePhoneNumController__BeanDefinitions {
  /**
   * Get the bean definition for 'changePhoneNumController'.
   */
  public static BeanDefinition getChangePhoneNumControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ChangePhoneNumController.class);
    InstanceSupplier<ChangePhoneNumController> instanceSupplier = InstanceSupplier.using(ChangePhoneNumController::new);
    instanceSupplier = instanceSupplier.andThen(ChangePhoneNumController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
