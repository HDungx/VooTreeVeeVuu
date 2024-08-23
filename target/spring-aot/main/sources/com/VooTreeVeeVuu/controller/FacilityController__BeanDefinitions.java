package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FacilityController}.
 */
@Generated
public class FacilityController__BeanDefinitions {
  /**
   * Get the bean definition for 'facilityController'.
   */
  public static BeanDefinition getFacilityControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FacilityController.class);
    InstanceSupplier<FacilityController> instanceSupplier = InstanceSupplier.using(FacilityController::new);
    instanceSupplier = instanceSupplier.andThen(FacilityController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
