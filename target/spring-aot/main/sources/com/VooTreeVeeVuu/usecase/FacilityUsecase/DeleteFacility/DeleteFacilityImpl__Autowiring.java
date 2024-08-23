package com.VooTreeVeeVuu.usecase.FacilityUsecase.DeleteFacility;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DeleteFacilityImpl}.
 */
@Generated
public class DeleteFacilityImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DeleteFacilityImpl apply(RegisteredBean registeredBean,
      DeleteFacilityImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("facilityRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
