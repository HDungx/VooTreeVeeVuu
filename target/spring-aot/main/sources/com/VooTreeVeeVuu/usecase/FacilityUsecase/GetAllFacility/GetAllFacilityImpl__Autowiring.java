package com.VooTreeVeeVuu.usecase.FacilityUsecase.GetAllFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAllFacilityImpl}.
 */
@Generated
public class GetAllFacilityImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAllFacilityImpl apply(RegisteredBean registeredBean,
      GetAllFacilityImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("facilityRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
