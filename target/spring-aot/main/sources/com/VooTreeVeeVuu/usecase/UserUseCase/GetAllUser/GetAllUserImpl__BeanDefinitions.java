package com.VooTreeVeeVuu.usecase.UserUseCase.GetAllUser;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAllUserImpl}.
 */
@Generated
public class GetAllUserImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAllUserImpl'.
   */
  public static BeanDefinition getGetAllUserImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAllUserImpl.class);
    InstanceSupplier<GetAllUserImpl> instanceSupplier = InstanceSupplier.using(GetAllUserImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAllUserImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
