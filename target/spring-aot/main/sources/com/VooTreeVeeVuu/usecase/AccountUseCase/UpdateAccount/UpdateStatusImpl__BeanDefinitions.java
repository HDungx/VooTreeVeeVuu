package com.VooTreeVeeVuu.usecase.AccountUseCase.UpdateAccount;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UpdateStatusImpl}.
 */
@Generated
public class UpdateStatusImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'updateStatusImpl'.
   */
  public static BeanDefinition getUpdateStatusImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UpdateStatusImpl.class);
    InstanceSupplier<UpdateStatusImpl> instanceSupplier = InstanceSupplier.using(UpdateStatusImpl::new);
    instanceSupplier = instanceSupplier.andThen(UpdateStatusImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
