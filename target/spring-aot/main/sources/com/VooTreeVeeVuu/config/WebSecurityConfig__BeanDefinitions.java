package com.VooTreeVeeVuu.config;

import com.VooTreeVeeVuu.domain.repository.AccountRepository;
import com.VooTreeVeeVuu.services.CustomOAuth2UserService;
import com.VooTreeVeeVuu.services.JwtUtils;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Bean definitions for {@link WebSecurityConfig}.
 */
@Generated
public class WebSecurityConfig__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'webSecurityConfig'.
   */
  private static BeanInstanceSupplier<WebSecurityConfig> getWebSecurityConfigInstanceSupplier() {
    return BeanInstanceSupplier.<WebSecurityConfig>forConstructor(JwtAuthenticationFilter.class, AuthenticationProvider.class, AccountRepository.class, CustomOAuth2UserService.class, JwtUtils.class)
            .withGenerator((registeredBean, args) -> new WebSecurityConfig$$SpringCGLIB$$0(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'webSecurityConfig'.
   */
  public static BeanDefinition getWebSecurityConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSecurityConfig.class);
    beanDefinition.setTargetType(WebSecurityConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(WebSecurityConfig.class);
    beanDefinition.setInstanceSupplier(getWebSecurityConfigInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'securityFilterChain'.
   */
  private static BeanInstanceSupplier<SecurityFilterChain> getSecurityFilterChainInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SecurityFilterChain>forFactoryMethod(WebSecurityConfig.class, "securityFilterChain", HttpSecurity.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebSecurityConfig.class).securityFilterChain(args.get(0)));
  }

  /**
   * Get the bean definition for 'securityFilterChain'.
   */
  public static BeanDefinition getSecurityFilterChainBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SecurityFilterChain.class);
    beanDefinition.setInstanceSupplier(getSecurityFilterChainInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'oAuth2AuthenticationSuccessHandler'.
   */
  private static BeanInstanceSupplier<AuthenticationSuccessHandler> getOAuthAuthenticationSuccessHandlerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AuthenticationSuccessHandler>forFactoryMethod(WebSecurityConfig.class, "oAuth2AuthenticationSuccessHandler")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebSecurityConfig.class).oAuth2AuthenticationSuccessHandler());
  }

  /**
   * Get the bean definition for 'oAuth2AuthenticationSuccessHandler'.
   */
  public static BeanDefinition getOAuthAuthenticationSuccessHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthenticationSuccessHandler.class);
    beanDefinition.setInstanceSupplier(getOAuthAuthenticationSuccessHandlerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'clientRegistrationRepository'.
   */
  private static BeanInstanceSupplier<ClientRegistrationRepository> getClientRegistrationRepositoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ClientRegistrationRepository>forFactoryMethod(WebSecurityConfig.class, "clientRegistrationRepository")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebSecurityConfig.class).clientRegistrationRepository());
  }

  /**
   * Get the bean definition for 'clientRegistrationRepository'.
   */
  public static BeanDefinition getClientRegistrationRepositoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ClientRegistrationRepository.class);
    beanDefinition.setInstanceSupplier(getClientRegistrationRepositoryInstanceSupplier());
    return beanDefinition;
  }
}
