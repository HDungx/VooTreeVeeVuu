package com.VooTreeVeeVuu.usecase.RatingUsecase.GetAllRating;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAllRatingImpl}.
 */
@Generated
public class GetAllRatingImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAllRatingImpl'.
   */
  public static BeanDefinition getGetAllRatingImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAllRatingImpl.class);
    InstanceSupplier<GetAllRatingImpl> instanceSupplier = InstanceSupplier.using(GetAllRatingImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAllRatingImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
