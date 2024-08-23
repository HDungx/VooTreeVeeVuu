package com.VooTreeVeeVuu.usecase.HotelUsecase.AcceptHotel;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AcceptHotelRequestImpl}.
 */
@Generated
public class AcceptHotelRequestImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'acceptHotelRequestImpl'.
   */
  public static BeanDefinition getAcceptHotelRequestImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AcceptHotelRequestImpl.class);
    InstanceSupplier<AcceptHotelRequestImpl> instanceSupplier = InstanceSupplier.using(AcceptHotelRequestImpl::new);
    instanceSupplier = instanceSupplier.andThen(AcceptHotelRequestImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
