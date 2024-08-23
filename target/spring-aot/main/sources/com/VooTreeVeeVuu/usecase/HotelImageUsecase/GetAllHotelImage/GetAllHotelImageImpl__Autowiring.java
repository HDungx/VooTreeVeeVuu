package com.VooTreeVeeVuu.usecase.HotelImageUsecase.GetAllHotelImage;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAllHotelImageImpl}.
 */
@Generated
public class GetAllHotelImageImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAllHotelImageImpl apply(RegisteredBean registeredBean,
      GetAllHotelImageImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("hotelImageRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
