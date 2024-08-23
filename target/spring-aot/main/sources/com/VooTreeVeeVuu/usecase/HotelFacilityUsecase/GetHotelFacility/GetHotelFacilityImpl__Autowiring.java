package com.VooTreeVeeVuu.usecase.HotelFacilityUsecase.GetHotelFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetHotelFacilityImpl}.
 */
@Generated
public class GetHotelFacilityImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetHotelFacilityImpl apply(RegisteredBean registeredBean,
      GetHotelFacilityImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("hotelFacilityRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
