package com.VooTreeVeeVuu.usecase.RoomTypeUsecase.GetRoomType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetRoomTypeImpl}.
 */
@Generated
public class GetRoomTypeImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetRoomTypeImpl apply(RegisteredBean registeredBean, GetRoomTypeImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("roomTypeRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
