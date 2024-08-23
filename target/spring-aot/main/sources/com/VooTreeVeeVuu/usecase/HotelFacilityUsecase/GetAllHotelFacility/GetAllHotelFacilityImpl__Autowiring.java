package com.VooTreeVeeVuu.usecase.HotelFacilityUsecase.GetAllHotelFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAllHotelFacilityImpl}.
 */
@Generated
public class GetAllHotelFacilityImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAllHotelFacilityImpl apply(RegisteredBean registeredBean,
      GetAllHotelFacilityImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("hotelFacilityRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
