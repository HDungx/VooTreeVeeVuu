package com.VooTreeVeeVuu.usecase.UserUseCase.UpdateUser;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UpdateUserImpl}.
 */
@Generated
public class UpdateUserImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'updateUserImpl'.
   */
  public static BeanDefinition getUpdateUserImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UpdateUserImpl.class);
    InstanceSupplier<UpdateUserImpl> instanceSupplier = InstanceSupplier.using(UpdateUserImpl::new);
    instanceSupplier = instanceSupplier.andThen(UpdateUserImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
