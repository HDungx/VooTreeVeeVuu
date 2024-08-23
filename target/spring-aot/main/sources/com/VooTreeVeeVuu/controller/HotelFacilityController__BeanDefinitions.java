package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link HotelFacilityController}.
 */
@Generated
public class HotelFacilityController__BeanDefinitions {
  /**
   * Get the bean definition for 'hotelFacilityController'.
   */
  public static BeanDefinition getHotelFacilityControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HotelFacilityController.class);
    InstanceSupplier<HotelFacilityController> instanceSupplier = InstanceSupplier.using(HotelFacilityController::new);
    instanceSupplier = instanceSupplier.andThen(HotelFacilityController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
