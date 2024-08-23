package com.VooTreeVeeVuu.usecase.RoomUsecase.GetRoom;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetRoomImpl}.
 */
@Generated
public class GetRoomImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetRoomImpl apply(RegisteredBean registeredBean, GetRoomImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roomRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
