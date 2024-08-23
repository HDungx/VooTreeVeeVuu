package com.VooTreeVeeVuu.usecase.AccountUseCase.GetAccount;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAccountImpl}.
 */
@Generated
public class GetAccountImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAccountImpl'.
   */
  public static BeanDefinition getGetAccountImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAccountImpl.class);
    InstanceSupplier<GetAccountImpl> instanceSupplier = InstanceSupplier.using(GetAccountImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAccountImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
