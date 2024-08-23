package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link EmailSenderController}.
 */
@Generated
public class EmailSenderController__BeanDefinitions {
  /**
   * Get the bean definition for 'emailSenderController'.
   */
  public static BeanDefinition getEmailSenderControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EmailSenderController.class);
    InstanceSupplier<EmailSenderController> instanceSupplier = InstanceSupplier.using(EmailSenderController::new);
    instanceSupplier = instanceSupplier.andThen(EmailSenderController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
