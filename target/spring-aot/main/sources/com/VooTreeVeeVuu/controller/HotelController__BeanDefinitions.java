package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link HotelController}.
 */
@Generated
public class HotelController__BeanDefinitions {
  /**
   * Get the bean definition for 'hotelController'.
   */
  public static BeanDefinition getHotelControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HotelController.class);
    InstanceSupplier<HotelController> instanceSupplier = InstanceSupplier.using(HotelController::new);
    instanceSupplier = instanceSupplier.andThen(HotelController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
