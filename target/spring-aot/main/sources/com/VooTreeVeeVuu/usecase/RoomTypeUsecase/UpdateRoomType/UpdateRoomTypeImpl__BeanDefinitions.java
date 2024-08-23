package com.VooTreeVeeVuu.usecase.RoomTypeUsecase.UpdateRoomType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UpdateRoomTypeImpl}.
 */
@Generated
public class UpdateRoomTypeImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'updateRoomTypeImpl'.
   */
  public static BeanDefinition getUpdateRoomTypeImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UpdateRoomTypeImpl.class);
    InstanceSupplier<UpdateRoomTypeImpl> instanceSupplier = InstanceSupplier.using(UpdateRoomTypeImpl::new);
    instanceSupplier = instanceSupplier.andThen(UpdateRoomTypeImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
