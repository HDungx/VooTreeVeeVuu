package com.VooTreeVeeVuu.usecase.LogsUsecase.DeleteLogs;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DeleteLogsImpl}.
 */
@Generated
public class DeleteLogsImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'deleteLogsImpl'.
   */
  public static BeanDefinition getDeleteLogsImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DeleteLogsImpl.class);
    InstanceSupplier<DeleteLogsImpl> instanceSupplier = InstanceSupplier.using(DeleteLogsImpl::new);
    instanceSupplier = instanceSupplier.andThen(DeleteLogsImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
