package com.VooTreeVeeVuu.usecase.RoomTypeUsecase.GetAllRoomType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAllRoomTypeImpl}.
 */
@Generated
public class GetAllRoomTypeImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAllRoomTypeImpl apply(RegisteredBean registeredBean,
      GetAllRoomTypeImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roomTypeRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
