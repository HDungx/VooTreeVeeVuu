package com.VooTreeVeeVuu.usecase.RoomUsecase.GetAllRoom;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAllRoomImpl}.
 */
@Generated
public class GetAllRoomImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAllRoomImpl apply(RegisteredBean registeredBean, GetAllRoomImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roomRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
