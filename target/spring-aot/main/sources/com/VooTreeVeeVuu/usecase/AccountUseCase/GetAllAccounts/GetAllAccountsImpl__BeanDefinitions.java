package com.VooTreeVeeVuu.usecase.AccountUseCase.GetAllAccounts;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAllAccountsImpl}.
 */
@Generated
public class GetAllAccountsImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAllAccountsImpl'.
   */
  public static BeanDefinition getGetAllAccountsImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAllAccountsImpl.class);
    InstanceSupplier<GetAllAccountsImpl> instanceSupplier = InstanceSupplier.using(GetAllAccountsImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAllAccountsImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
