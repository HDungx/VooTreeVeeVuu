package com.VooTreeVeeVuu.usecase.FacilityUsecase.CreateFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CreateFacilityImpl}.
 */
@Generated
public class CreateFacilityImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CreateFacilityImpl apply(RegisteredBean registeredBean,
      CreateFacilityImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("facilityRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
