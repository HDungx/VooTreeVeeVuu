package com.VooTreeVeeVuu.usecase.UserUseCase.GetUser;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetUserImpl}.
 */
@Generated
public class GetUserImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getUserImpl'.
   */
  public static BeanDefinition getGetUserImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetUserImpl.class);
    InstanceSupplier<GetUserImpl> instanceSupplier = InstanceSupplier.using(GetUserImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetUserImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
