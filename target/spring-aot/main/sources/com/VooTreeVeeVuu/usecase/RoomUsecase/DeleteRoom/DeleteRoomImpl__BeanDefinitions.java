package com.VooTreeVeeVuu.usecase.RoomUsecase.DeleteRoom;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DeleteRoomImpl}.
 */
@Generated
public class DeleteRoomImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'deleteRoomImpl'.
   */
  public static BeanDefinition getDeleteRoomImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DeleteRoomImpl.class);
    InstanceSupplier<DeleteRoomImpl> instanceSupplier = InstanceSupplier.using(DeleteRoomImpl::new);
    instanceSupplier = instanceSupplier.andThen(DeleteRoomImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
