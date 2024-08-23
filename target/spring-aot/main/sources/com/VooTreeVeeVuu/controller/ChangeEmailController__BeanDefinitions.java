package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ChangeEmailController}.
 */
@Generated
public class ChangeEmailController__BeanDefinitions {
  /**
   * Get the bean definition for 'changeEmailController'.
   */
  public static BeanDefinition getChangeEmailControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ChangeEmailController.class);
    InstanceSupplier<ChangeEmailController> instanceSupplier = InstanceSupplier.using(ChangeEmailController::new);
    instanceSupplier = instanceSupplier.andThen(ChangeEmailController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
