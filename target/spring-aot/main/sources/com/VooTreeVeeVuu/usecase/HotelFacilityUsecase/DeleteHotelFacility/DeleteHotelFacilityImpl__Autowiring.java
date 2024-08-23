package com.VooTreeVeeVuu.usecase.HotelFacilityUsecase.DeleteHotelFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DeleteHotelFacilityImpl}.
 */
@Generated
public class DeleteHotelFacilityImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DeleteHotelFacilityImpl apply(RegisteredBean registeredBean,
      DeleteHotelFacilityImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("hotelFacilityRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
