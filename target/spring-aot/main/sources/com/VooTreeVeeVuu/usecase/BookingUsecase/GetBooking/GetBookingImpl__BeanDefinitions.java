package com.VooTreeVeeVuu.usecase.BookingUsecase.GetBooking;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetBookingImpl}.
 */
@Generated
public class GetBookingImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getBookingImpl'.
   */
  public static BeanDefinition getGetBookingImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetBookingImpl.class);
    InstanceSupplier<GetBookingImpl> instanceSupplier = InstanceSupplier.using(GetBookingImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetBookingImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
