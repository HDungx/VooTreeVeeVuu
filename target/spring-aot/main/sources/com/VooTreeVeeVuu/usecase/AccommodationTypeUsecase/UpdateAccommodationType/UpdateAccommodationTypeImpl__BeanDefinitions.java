package com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase.UpdateAccommodationType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UpdateAccommodationTypeImpl}.
 */
@Generated
public class UpdateAccommodationTypeImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'updateAccommodationTypeImpl'.
   */
  public static BeanDefinition getUpdateAccommodationTypeImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UpdateAccommodationTypeImpl.class);
    InstanceSupplier<UpdateAccommodationTypeImpl> instanceSupplier = InstanceSupplier.using(UpdateAccommodationTypeImpl::new);
    instanceSupplier = instanceSupplier.andThen(UpdateAccommodationTypeImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
