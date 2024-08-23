package com.VooTreeVeeVuu.usecase.RoomTypeUsecase.UpdateRoomType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link UpdateRoomTypeImpl}.
 */
@Generated
public class UpdateRoomTypeImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static UpdateRoomTypeImpl apply(RegisteredBean registeredBean,
      UpdateRoomTypeImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roomTypeRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
