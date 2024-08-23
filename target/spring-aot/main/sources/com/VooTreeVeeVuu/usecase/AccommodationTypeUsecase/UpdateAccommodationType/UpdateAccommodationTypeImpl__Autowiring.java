package com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase.UpdateAccommodationType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link UpdateAccommodationTypeImpl}.
 */
@Generated
public class UpdateAccommodationTypeImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static UpdateAccommodationTypeImpl apply(RegisteredBean registeredBean,
      UpdateAccommodationTypeImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("accommodationTypeRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
