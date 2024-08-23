package com.VooTreeVeeVuu.usecase.LogsUsecase.CreateLogs;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CreateLogsImpl}.
 */
@Generated
public class CreateLogsImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'createLogsImpl'.
   */
  public static BeanDefinition getCreateLogsImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CreateLogsImpl.class);
    InstanceSupplier<CreateLogsImpl> instanceSupplier = InstanceSupplier.using(CreateLogsImpl::new);
    instanceSupplier = instanceSupplier.andThen(CreateLogsImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
