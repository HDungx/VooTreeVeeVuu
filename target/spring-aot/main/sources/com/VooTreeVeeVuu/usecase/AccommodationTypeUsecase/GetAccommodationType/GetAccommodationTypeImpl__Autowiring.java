package com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase.GetAccommodationType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAccommodationTypeImpl}.
 */
@Generated
public class GetAccommodationTypeImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAccommodationTypeImpl apply(RegisteredBean registeredBean,
      GetAccommodationTypeImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("accommodationTypeRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
