package com.VooTreeVeeVuu.usecase.FacilityUsecase.GetFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetFacilityImpl}.
 */
@Generated
public class GetFacilityImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetFacilityImpl apply(RegisteredBean registeredBean, GetFacilityImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("facilityRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
