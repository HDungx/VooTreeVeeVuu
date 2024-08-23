package com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase.DeleteAccommodationType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DeleteAccommodationTypeImpl}.
 */
@Generated
public class DeleteAccommodationTypeImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'deleteAccommodationTypeImpl'.
   */
  public static BeanDefinition getDeleteAccommodationTypeImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DeleteAccommodationTypeImpl.class);
    InstanceSupplier<DeleteAccommodationTypeImpl> instanceSupplier = InstanceSupplier.using(DeleteAccommodationTypeImpl::new);
    instanceSupplier = instanceSupplier.andThen(DeleteAccommodationTypeImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
