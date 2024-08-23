package com.VooTreeVeeVuu.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link FacilityController}.
 */
@Generated
public class FacilityController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static FacilityController apply(RegisteredBean registeredBean,
      FacilityController instance) {
    AutowiredFieldValueResolver.forRequiredField("createFacilityUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("updateFacilityUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("deleteFacilityUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getAllFacilityUseCase").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("getFacilityUseCase").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
