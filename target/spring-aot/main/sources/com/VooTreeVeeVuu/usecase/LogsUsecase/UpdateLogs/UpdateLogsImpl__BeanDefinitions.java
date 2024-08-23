package com.VooTreeVeeVuu.usecase.LogsUsecase.UpdateLogs;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UpdateLogsImpl}.
 */
@Generated
public class UpdateLogsImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'updateLogsImpl'.
   */
  public static BeanDefinition getUpdateLogsImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UpdateLogsImpl.class);
    InstanceSupplier<UpdateLogsImpl> instanceSupplier = InstanceSupplier.using(UpdateLogsImpl::new);
    instanceSupplier = instanceSupplier.andThen(UpdateLogsImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
