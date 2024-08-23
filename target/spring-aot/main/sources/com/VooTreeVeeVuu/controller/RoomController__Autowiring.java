package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link RoomController}.
 */
@Generated
public class RoomController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static RoomController apply(RegisteredBean registeredBean, RoomController instance) {
    AutowiredFieldValueResolver.forRequiredField("deleteRoomUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getAllRoomUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getRoomUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("roomService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("createRoom").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("updateRoomStatus").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
