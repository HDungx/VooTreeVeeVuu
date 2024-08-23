package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.domain.repository.AccountRepository;
import com.VooTreeVeeVuu.domain.repository.RoleRepository;
import com.VooTreeVeeVuu.domain.repository.UserRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CustomOAuth2UserService}.
 */
@Generated
public class CustomOAuth2UserService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'customOAuth2UserService'.
   */
  private static BeanInstanceSupplier<CustomOAuth2UserService> getCustomOAuthUserServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CustomOAuth2UserService>forConstructor(AccountRepository.class, UserRepository.class, RoleRepository.class)
            .withGenerator((registeredBean, args) -> new CustomOAuth2UserService(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'customOAuth2UserService'.
   */
  public static BeanDefinition getCustomOAuthUserServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CustomOAuth2UserService.class);
    beanDefinition.setInstanceSupplier(getCustomOAuthUserServiceInstanceSupplier());
    return beanDefinition;
  }
}
