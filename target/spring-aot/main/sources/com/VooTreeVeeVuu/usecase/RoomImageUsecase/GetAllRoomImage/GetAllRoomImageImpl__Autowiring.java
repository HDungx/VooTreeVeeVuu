package com.VooTreeVeeVuu.usecase.RoomImageUsecase.GetAllRoomImage;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAllRoomImageImpl}.
 */
@Generated
public class GetAllRoomImageImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAllRoomImageImpl apply(RegisteredBean registeredBean,
      GetAllRoomImageImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roomImageRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
