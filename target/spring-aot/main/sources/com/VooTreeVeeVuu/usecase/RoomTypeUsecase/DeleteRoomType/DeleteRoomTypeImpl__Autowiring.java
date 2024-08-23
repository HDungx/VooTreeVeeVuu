package com.VooTreeVeeVuu.usecase.RoomTypeUsecase.DeleteRoomType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DeleteRoomTypeImpl}.
 */
@Generated
public class DeleteRoomTypeImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DeleteRoomTypeImpl apply(RegisteredBean registeredBean,
      DeleteRoomTypeImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roomTypeRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
