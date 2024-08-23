package com.VooTreeVeeVuu.usecase.LogsUsecase.GetLogs;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetLogsImpl}.
 */
@Generated
public class GetLogsImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getLogsImpl'.
   */
  public static BeanDefinition getGetLogsImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetLogsImpl.class);
    InstanceSupplier<GetLogsImpl> instanceSupplier = InstanceSupplier.using(GetLogsImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetLogsImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
