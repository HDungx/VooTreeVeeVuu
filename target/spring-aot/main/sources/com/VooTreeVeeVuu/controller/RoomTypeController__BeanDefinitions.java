package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RoomTypeController}.
 */
@Generated
public class RoomTypeController__BeanDefinitions {
  /**
   * Get the bean definition for 'roomTypeController'.
   */
  public static BeanDefinition getRoomTypeControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RoomTypeController.class);
    InstanceSupplier<RoomTypeController> instanceSupplier = InstanceSupplier.using(RoomTypeController::new);
    instanceSupplier = instanceSupplier.andThen(RoomTypeController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
