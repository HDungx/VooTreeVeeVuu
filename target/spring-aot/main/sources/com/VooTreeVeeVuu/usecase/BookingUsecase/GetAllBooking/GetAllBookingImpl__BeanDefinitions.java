package com.VooTreeVeeVuu.usecase.BookingUsecase.GetAllBooking;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAllBookingImpl}.
 */
@Generated
public class GetAllBookingImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAllBookingImpl'.
   */
  public static BeanDefinition getGetAllBookingImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAllBookingImpl.class);
    InstanceSupplier<GetAllBookingImpl> instanceSupplier = InstanceSupplier.using(GetAllBookingImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAllBookingImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
