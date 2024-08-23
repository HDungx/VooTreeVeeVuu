package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link RoomTypeController}.
 */
@Generated
public class RoomTypeController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static RoomTypeController apply(RegisteredBean registeredBean,
      RoomTypeController instance) {
    AutowiredFieldValueResolver.forRequiredField("createRoomTypeUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("updateRoomTypeUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("deleteRoomTypeUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getAllRoomTypeUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getRoomTypeUseCase").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
