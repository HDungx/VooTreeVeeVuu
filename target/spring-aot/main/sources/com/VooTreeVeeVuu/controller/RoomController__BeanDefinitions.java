package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RoomController}.
 */
@Generated
public class RoomController__BeanDefinitions {
  /**
   * Get the bean definition for 'roomController'.
   */
  public static BeanDefinition getRoomControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RoomController.class);
    InstanceSupplier<RoomController> instanceSupplier = InstanceSupplier.using(RoomController::new);
    instanceSupplier = instanceSupplier.andThen(RoomController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
