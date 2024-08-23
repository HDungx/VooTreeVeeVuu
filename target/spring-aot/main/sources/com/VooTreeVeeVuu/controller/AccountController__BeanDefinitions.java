package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AccountController}.
 */
@Generated
public class AccountController__BeanDefinitions {
  /**
   * Get the bean definition for 'accountController'.
   */
  public static BeanDefinition getAccountControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AccountController.class);
    InstanceSupplier<AccountController> instanceSupplier = InstanceSupplier.using(AccountController::new);
    instanceSupplier = instanceSupplier.andThen(AccountController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
