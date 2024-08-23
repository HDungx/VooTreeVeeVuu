package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link RoomImageController}.
 */
@Generated
public class RoomImageController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static RoomImageController apply(RegisteredBean registeredBean,
      RoomImageController instance) {
    AutowiredFieldValueResolver.forRequiredField("getAllRoomImageUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("roomImageRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("roomService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
