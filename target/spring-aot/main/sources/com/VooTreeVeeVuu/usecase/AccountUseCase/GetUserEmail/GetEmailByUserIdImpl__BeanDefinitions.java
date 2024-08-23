package com.VooTreeVeeVuu.usecase.AccountUseCase.GetUserEmail;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetEmailByUserIdImpl}.
 */
@Generated
public class GetEmailByUserIdImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getEmailByUserIdImpl'.
   */
  public static BeanDefinition getGetEmailByUserIdImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetEmailByUserIdImpl.class);
    InstanceSupplier<GetEmailByUserIdImpl> instanceSupplier = InstanceSupplier.using(GetEmailByUserIdImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetEmailByUserIdImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
