package com.VooTreeVeeVuu.usecase.RoomFacilityUsecase.DeleteRoomFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DeleteRoomFacilityImpl}.
 */
@Generated
public class DeleteRoomFacilityImpl__BeanDefinitions {
  /**
   * Get the bean definition for 'deleteRoomFacilityImpl'.
   */
  public static BeanDefinition getDeleteRoomFacilityImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DeleteRoomFacilityImpl.class);
    InstanceSupplier<DeleteRoomFacilityImpl> instanceSupplier = InstanceSupplier.using(DeleteRoomFacilityImpl::new);
    instanceSupplier = instanceSupplier.andThen(DeleteRoomFacilityImpl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
