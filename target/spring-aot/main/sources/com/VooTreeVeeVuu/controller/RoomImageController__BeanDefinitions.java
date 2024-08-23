package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RoomImageController}.
 */
@Generated
public class RoomImageController__BeanDefinitions {
  /**
   * Get the bean definition for 'roomImageController'.
   */
  public static BeanDefinition getRoomImageControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RoomImageController.class);
    InstanceSupplier<RoomImageController> instanceSupplier = InstanceSupplier.using(RoomImageController::new);
    instanceSupplier = instanceSupplier.andThen(RoomImageController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
