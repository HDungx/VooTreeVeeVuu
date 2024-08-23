package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link LogsController}.
 */
@Generated
public class LogsController__BeanDefinitions {
  /**
   * Get the bean definition for 'logsController'.
   */
  public static BeanDefinition getLogsControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LogsController.class);
    InstanceSupplier<LogsController> instanceSupplier = InstanceSupplier.using(LogsController::new);
    instanceSupplier = instanceSupplier.andThen(LogsController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
