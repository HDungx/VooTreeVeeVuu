package com.VooTreeVeeVuu.usecase.RoomUsecase.DeleteRoom;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DeleteRoomImpl}.
 */
@Generated
public class DeleteRoomImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DeleteRoomImpl apply(RegisteredBean registeredBean, DeleteRoomImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roomRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
