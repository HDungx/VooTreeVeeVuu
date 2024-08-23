package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ResetPasswordController}.
 */
@Generated
public class ResetPasswordController__BeanDefinitions {
  /**
   * Get the bean definition for 'resetPasswordController'.
   */
  public static BeanDefinition getResetPasswordControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ResetPasswordController.class);
    InstanceSupplier<ResetPasswordController> instanceSupplier = InstanceSupplier.using(ResetPasswordController::new);
    instanceSupplier = instanceSupplier.andThen(ResetPasswordController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
