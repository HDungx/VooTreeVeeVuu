package com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase.GetAllAccommodationType;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link GetAllAccommodationTypeImpl}.
 */
@Generated
public class GetAllAccommodationTypeImpl__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static GetAllAccommodationTypeImpl apply(RegisteredBean registeredBean,
      GetAllAccommodationTypeImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("accommodationTypeRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
