package com.VooTreeVeeVuu.usecase.RatingUsecase.GetRatingForHotel;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetRatingForHotelImpl}.
 */
@Generated
public class GetRatingForHotelImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getRatingForHotelImpl'.
   */
  public static BeanDefinition getGetRatingForHotelImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetRatingForHotelImpl.class);
    InstanceSupplier<GetRatingForHotelImpl> instanceSupplier = InstanceSupplier.using(GetRatingForHotelImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetRatingForHotelImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
