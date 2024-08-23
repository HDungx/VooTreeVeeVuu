package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RatingController}.
 */
@Generated
public class RatingController__BeanDefinitions {
  /**
   * Get the bean definition for 'ratingController'.
   */
  public static BeanDefinition getRatingControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RatingController.class);
    InstanceSupplier<RatingController> instanceSupplier = InstanceSupplier.using(RatingController::new);
    instanceSupplier = instanceSupplier.andThen(RatingController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
