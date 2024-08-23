package com.VooTreeVeeVuu.usecase.RoomUsecase.UpdateRoomStatus;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UpdateRoomStatusImpl}.
 */
@Generated
public class UpdateRoomStatusImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'updateRoomStatusImpl'.
   */
  public static BeanDefinition getUpdateRoomStatusImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UpdateRoomStatusImpl.class);
    InstanceSupplier<UpdateRoomStatusImpl> instanceSupplier = InstanceSupplier.using(UpdateRoomStatusImpl::new);
    instanceSupplier = instanceSupplier.andThen(UpdateRoomStatusImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
