package com.VooTreeVeeVuu.usecase.HotelUsecase.UpdateStatusHotel;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UpdateStatusHotelImpl}.
 */
@Generated
public class UpdateStatusHotelImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'updateStatusHotelImpl'.
   */
  public static BeanDefinition getUpdateStatusHotelImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UpdateStatusHotelImpl.class);
    InstanceSupplier<UpdateStatusHotelImpl> instanceSupplier = InstanceSupplier.using(UpdateStatusHotelImpl::new);
    instanceSupplier = instanceSupplier.andThen(UpdateStatusHotelImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
