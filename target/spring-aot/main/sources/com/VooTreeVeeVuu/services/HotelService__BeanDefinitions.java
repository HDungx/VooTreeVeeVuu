package com.VooTreeVeeVuu.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link HotelService}.
 */
@Generated
public class HotelService__BeanDefinitions {
  /**
   * Get the bean definition for 'hotelService'.
   */
  public static BeanDefinition getHotelServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HotelService.class);
    InstanceSupplier<HotelService> instanceSupplier = InstanceSupplier.using(HotelService::new);
    instanceSupplier = instanceSupplier.andThen(HotelService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
