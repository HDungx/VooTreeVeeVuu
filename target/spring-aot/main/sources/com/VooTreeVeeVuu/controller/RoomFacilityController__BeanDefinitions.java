package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RoomFacilityController}.
 */
@Generated
public class RoomFacilityController__BeanDefinitions {
  /**
   * Get the bean definition for 'roomFacilityController'.
   */
  public static BeanDefinition getRoomFacilityControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RoomFacilityController.class);
    InstanceSupplier<RoomFacilityController> instanceSupplier = InstanceSupplier.using(RoomFacilityController::new);
    instanceSupplier = instanceSupplier.andThen(RoomFacilityController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
