package com.VooTreeVeeVuu.usecase.RatingUsecase.CreateRating;

import com.VooTreeVeeVuu.domain.repository.BookingRepository;
import com.VooTreeVeeVuu.domain.repository.HotelRepository;
import com.VooTreeVeeVuu.domain.repository.RatingRepository;
import com.VooTreeVeeVuu.domain.repository.UserRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CreateRatingImpl}.
 */
@Generated
public class CreateRatingImpl__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'createRatingImpl'.
   */
  private static BeanInstanceSupplier<CreateRatingImpl> getCreateRatingImplInstanceSupplier() {
    return BeanInstanceSupplier.<CreateRatingImpl>forConstructor(HotelRepository.class, UserRepository.class, RatingRepository.class, BookingRepository.class)
            .withGenerator((registeredBean, args) -> new CreateRatingImpl(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'createRatingImpl'.
   */
  public static BeanDefinition getCreateRatingImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CreateRatingImpl.class);
    beanDefinition.setInstanceSupplier(getCreateRatingImplInstanceSupplier());
    return beanDefinition;
  }
}
