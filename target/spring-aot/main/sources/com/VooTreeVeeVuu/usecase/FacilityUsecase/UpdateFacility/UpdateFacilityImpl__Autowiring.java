package com.VooTreeVeeVuu.usecase.FacilityUsecase.UpdateFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link UpdateFacilityImpl}.
 */
@Generated
public class UpdateFacilityImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static UpdateFacilityImpl apply(RegisteredBean registeredBean,
      UpdateFacilityImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("facilityRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
