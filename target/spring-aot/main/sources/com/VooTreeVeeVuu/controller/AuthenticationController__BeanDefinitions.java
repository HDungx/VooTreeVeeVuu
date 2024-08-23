package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.services.AuthenticationService;
import com.VooTreeVeeVuu.services.CustomOAuth2AuthenticationSuccessHandler;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AuthenticationController}.
 */
@Generated
public class AuthenticationController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'authenticationController'.
   */
  private static BeanInstanceSupplier<AuthenticationController> getAuthenticationControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AuthenticationController>forConstructor(AuthenticationService.class, CustomOAuth2AuthenticationSuccessHandler.class)
            .withGenerator((registeredBean, args) -> new AuthenticationController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'authenticationController'.
   */
  public static BeanDefinition getAuthenticationControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthenticationController.class);
    beanDefinition.setInstanceSupplier(getAuthenticationControllerInstanceSupplier());
    return beanDefinition;
  }
}
