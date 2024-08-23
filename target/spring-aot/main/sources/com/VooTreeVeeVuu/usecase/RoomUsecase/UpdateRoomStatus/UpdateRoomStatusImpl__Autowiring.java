package com.VooTreeVeeVuu.usecase.RoomUsecase.UpdateRoomStatus;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link UpdateRoomStatusImpl}.
 */
@Generated
public class UpdateRoomStatusImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static UpdateRoomStatusImpl apply(RegisteredBean registeredBean,
      UpdateRoomStatusImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roomRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
