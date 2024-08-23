package com.VooTreeVeeVuu.config;

import com.VooTreeVeeVuu.domain.repository.AccountRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Bean definitions for {@link ApplicationConfig}.
 */
@Generated
public class ApplicationConfig__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'applicationConfig'.
   */
  private static BeanInstanceSupplier<ApplicationConfig> getApplicationConfigInstanceSupplier() {
    return BeanInstanceSupplier.<ApplicationConfig>forConstructor(AccountRepository.class)
            .withGenerator((registeredBean, args) -> new ApplicationConfig$$SpringCGLIB$$0(args.get(0)));
  }

  /**
   * Get the bean definition for 'applicationConfig'.
   */
  public static BeanDefinition getApplicationConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ApplicationConfig.class);
    beanDefinition.setTargetType(ApplicationConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(ApplicationConfig.class);
    InstanceSupplier<ApplicationConfig> instanceSupplier = getApplicationConfigInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(ApplicationConfig__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'userDetailsService'.
   */
  private static BeanInstanceSupplier<UserDetailsService> getUserDetailsServiceInstanceSupplier() {
    return BeanInstanceSupplier.<UserDetailsService>forFactoryMethod(ApplicationConfig.class, "userDetailsService")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(ApplicationConfig.class).userDetailsService());
  }

  /**
   * Get the bean definition for 'userDetailsService'.
   */
  public static BeanDefinition getUserDetailsServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserDetailsService.class);
    beanDefinition.setInstanceSupplier(getUserDetailsServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'authenticationProvider'.
   */
  private static BeanInstanceSupplier<AuthenticationProvider> getAuthenticationProviderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AuthenticationProvider>forFactoryMethod(ApplicationConfig.class, "authenticationProvider")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(ApplicationConfig.class).authenticationProvider());
  }

  /**
   * Get the bean definition for 'authenticationProvider'.
   */
  public static BeanDefinition getAuthenticationProviderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthenticationProvider.class);
    beanDefinition.setInstanceSupplier(getAuthenticationProviderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'authenticationManager'.
   */
  private static BeanInstanceSupplier<AuthenticationManager> getAuthenticationManagerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AuthenticationManager>forFactoryMethod(ApplicationConfig.class, "authenticationManager", AuthenticationConfiguration.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ApplicationConfig.class).authenticationManager(args.get(0)));
  }

  /**
   * Get the bean definition for 'authenticationManager'.
   */
  public static BeanDefinition getAuthenticationManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthenticationManager.class);
    beanDefinition.setInstanceSupplier(getAuthenticationManagerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'passwordEncoder'.
   */
  private static BeanInstanceSupplier<PasswordEncoder> getPasswordEncoderInstanceSupplier() {
    return BeanInstanceSupplier.<PasswordEncoder>forFactoryMethod(ApplicationConfig.class, "passwordEncoder")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(ApplicationConfig.class).passwordEncoder());
  }

  /**
   * Get the bean definition for 'passwordEncoder'.
   */
  public static BeanDefinition getPasswordEncoderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PasswordEncoder.class);
    beanDefinition.setInstanceSupplier(getPasswordEncoderInstanceSupplier());
    return beanDefinition;
  }
}
