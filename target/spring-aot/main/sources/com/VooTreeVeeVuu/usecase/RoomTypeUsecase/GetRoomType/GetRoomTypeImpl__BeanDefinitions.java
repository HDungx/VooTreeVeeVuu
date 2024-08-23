package com.VooTreeVeeVuu.usecase.RoomTypeUsecase.GetRoomType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetRoomTypeImpl}.
 */
@Generated
public class GetRoomTypeImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'getRoomTypeImpl'.
   */
  public static BeanDefinition getGetRoomTypeImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetRoomTypeImpl.class);
    InstanceSupplier<GetRoomTypeImpl> instanceSupplier = InstanceSupplier.using(GetRoomTypeImpl::new);
    instanceSupplier = instanceSupplier.andThen(GetRoomTypeImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
