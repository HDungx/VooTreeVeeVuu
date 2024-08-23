package com.VooTreeVeeVuu.usecase.BookingUsecase.UpdateReviewStatus;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UpdateReviewStatusImpl}.
 */
@Generated
public class UpdateReviewStatusImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'updateReviewStatusImpl'.
   */
  public static BeanDefinition getUpdateReviewStatusImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UpdateReviewStatusImpl.class);
    InstanceSupplier<UpdateReviewStatusImpl> instanceSupplier = InstanceSupplier.using(UpdateReviewStatusImpl::new);
    instanceSupplier = instanceSupplier.andThen(UpdateReviewStatusImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
