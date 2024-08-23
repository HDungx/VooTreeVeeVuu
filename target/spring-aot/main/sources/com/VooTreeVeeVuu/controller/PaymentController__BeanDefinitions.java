package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PaymentController}.
 */
@Generated
public class PaymentController__BeanDefinitions {
  /**
   * Get the bean definition for 'paymentController'.
   */
  public static BeanDefinition getPaymentControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PaymentController.class);
    InstanceSupplier<PaymentController> instanceSupplier = InstanceSupplier.using(PaymentController::new);
    instanceSupplier = instanceSupplier.andThen(PaymentController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
