package com.VooTreeVeeVuu.usecase.RoomTypeUsecase.GetAllRoomType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetAllRoomTypeImpl}.
 */
@Generated
public class GetAllRoomTypeImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getAllRoomTypeImpl'.
   */
  public static BeanDefinition getGetAllRoomTypeImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetAllRoomTypeImpl.class);
    InstanceSupplier<GetAllRoomTypeImpl> instanceSupplier = InstanceSupplier.using(GetAllRoomTypeImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetAllRoomTypeImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
