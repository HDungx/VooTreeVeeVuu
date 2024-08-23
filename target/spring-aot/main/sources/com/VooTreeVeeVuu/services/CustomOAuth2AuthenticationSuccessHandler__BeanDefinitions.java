package com.VooTreeVeeVuu.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CustomOAuth2AuthenticationSuccessHandler}.
 */
@Generated
public class CustomOAuth2AuthenticationSuccessHandler__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'customOAuth2AuthenticationSuccessHandler'.
   */
  private static BeanInstanceSupplier<CustomOAuth2AuthenticationSuccessHandler> getCustomOAuthAuthenticationSuccessHandlerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CustomOAuth2AuthenticationSuccessHandler>forConstructor(JwtUtils.class)
            .withGenerator((registeredBean, args) -> new CustomOAuth2AuthenticationSuccessHandler(args.get(0)));
  }

  /**
   * Get the bean definition for 'customOAuth2AuthenticationSuccessHandler'.
   */
  public static BeanDefinition getCustomOAuthAuthenticationSuccessHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CustomOAuth2AuthenticationSuccessHandler.class);
    InstanceSupplier<CustomOAuth2AuthenticationSuccessHandler> instanceSupplier = getCustomOAuthAuthenticationSuccessHandlerInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(CustomOAuth2AuthenticationSuccessHandler__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
