package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link HotelImageController}.
 */
@Generated
public class HotelImageController__BeanDefinitions {
  /**
   * Get the bean definition for 'hotelImageController'.
   */
  public static BeanDefinition getHotelImageControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HotelImageController.class);
    InstanceSupplier<HotelImageController> instanceSupplier = InstanceSupplier.using(HotelImageController::new);
    instanceSupplier = instanceSupplier.andThen(HotelImageController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
