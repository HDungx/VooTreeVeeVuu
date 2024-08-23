package com.VooTreeVeeVuu.usecase.HotelUsecase.DeleteHotel;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DeleteHotelImpl}.
 */
@Generated
public class DeleteHotelImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'deleteHotelImpl'.
   */
  public static BeanDefinition getDeleteHotelImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DeleteHotelImpl.class);
    InstanceSupplier<DeleteHotelImpl> instanceSupplier = InstanceSupplier.using(DeleteHotelImpl::new);
    instanceSupplier = instanceSupplier.andThen(DeleteHotelImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
