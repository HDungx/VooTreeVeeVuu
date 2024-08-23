package com.VooTreeVeeVuu.usecase.RoomTypeUsecase.CreateRoomType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CreateRoomTypeImpl}.
 */
@Generated
public class CreateRoomTypeImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CreateRoomTypeImpl apply(RegisteredBean registeredBean,
      CreateRoomTypeImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roomTypeRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
