package com.VooTreeVeeVuu.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RoomService}.
 */
@Generated
public class RoomService__BeanDefinitions {
  /**
   * Get the bean definition for 'roomService'.
   */
  public static BeanDefinition getRoomServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RoomService.class);
    InstanceSupplier<RoomService> instanceSupplier = InstanceSupplier.using(RoomService::new);
    instanceSupplier = instanceSupplier.andThen(RoomService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
