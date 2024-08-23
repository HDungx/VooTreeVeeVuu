package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AccommodationTypeController}.
 */
@Generated
public class AccommodationTypeController__BeanDefinitions {
  /**
   * Get the bean definition for 'accommodationTypeController'.
   */
  public static BeanDefinition getAccommodationTypeControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AccommodationTypeController.class);
    InstanceSupplier<AccommodationTypeController> instanceSupplier = InstanceSupplier.using(AccommodationTypeController::new);
    instanceSupplier = instanceSupplier.andThen(AccommodationTypeController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
