package com.VooTreeVeeVuu.usecase.LogsUsecase.GetAllLogs;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAllLogsImpl}.
 */
@Generated
public class GetAllLogsImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAllLogsImpl'.
   */
  public static BeanDefinition getGetAllLogsImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAllLogsImpl.class);
    InstanceSupplier<GetAllLogsImpl> instanceSupplier = InstanceSupplier.using(GetAllLogsImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAllLogsImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
