package com.Siddhesh.hemoedge;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.Siddhesh.hemoedge.data.local.AppDatabase;
import com.Siddhesh.hemoedge.data.local.ChatDao;
import com.Siddhesh.hemoedge.data.local.PreferencesManager;
import com.Siddhesh.hemoedge.data.local.ScanDao;
import com.Siddhesh.hemoedge.data.remote.ChatRepository;
import com.Siddhesh.hemoedge.data.remote.LLMRepository;
import com.Siddhesh.hemoedge.data.remote.LlmApi;
import com.Siddhesh.hemoedge.data.remote.UserRepository;
import com.Siddhesh.hemoedge.di.AppModule_ProvideChatDaoFactory;
import com.Siddhesh.hemoedge.di.AppModule_ProvideDbFactory;
import com.Siddhesh.hemoedge.di.AppModule_ProvideLlmApiFactory;
import com.Siddhesh.hemoedge.di.AppModule_ProvideOkHttpFactory;
import com.Siddhesh.hemoedge.di.AppModule_ProvidePreferencesFactory;
import com.Siddhesh.hemoedge.di.AppModule_ProvideRetrofitFactory;
import com.Siddhesh.hemoedge.di.AppModule_ProvideScanDaoFactory;
import com.Siddhesh.hemoedge.di.FirebaseModule_ProvideAuthFactory;
import com.Siddhesh.hemoedge.di.FirebaseModule_ProvideFirestoreFactory;
import com.Siddhesh.hemoedge.domain.repository.IChatRepository;
import com.Siddhesh.hemoedge.domain.repository.IUserRepository;
import com.Siddhesh.hemoedge.ui.screens.auth.LoginViewModel;
import com.Siddhesh.hemoedge.ui.screens.auth.LoginViewModel_HiltModules;
import com.Siddhesh.hemoedge.ui.screens.auth.LoginViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.Siddhesh.hemoedge.ui.screens.auth.LoginViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.Siddhesh.hemoedge.ui.screens.auth.RegisterViewModel;
import com.Siddhesh.hemoedge.ui.screens.auth.RegisterViewModel_HiltModules;
import com.Siddhesh.hemoedge.ui.screens.auth.RegisterViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.Siddhesh.hemoedge.ui.screens.auth.RegisterViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.Siddhesh.hemoedge.ui.screens.chatbot.ChatbotViewModel;
import com.Siddhesh.hemoedge.ui.screens.chatbot.ChatbotViewModel_HiltModules;
import com.Siddhesh.hemoedge.ui.screens.chatbot.ChatbotViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.Siddhesh.hemoedge.ui.screens.chatbot.ChatbotViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.Siddhesh.hemoedge.ui.screens.dashboard.DashboardViewModel;
import com.Siddhesh.hemoedge.ui.screens.dashboard.DashboardViewModel_HiltModules;
import com.Siddhesh.hemoedge.ui.screens.dashboard.DashboardViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.Siddhesh.hemoedge.ui.screens.dashboard.DashboardViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.Siddhesh.hemoedge.ui.screens.history.HistoryViewModel;
import com.Siddhesh.hemoedge.ui.screens.history.HistoryViewModel_HiltModules;
import com.Siddhesh.hemoedge.ui.screens.history.HistoryViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.Siddhesh.hemoedge.ui.screens.history.HistoryViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.Siddhesh.hemoedge.ui.screens.profile.ProfileViewModel;
import com.Siddhesh.hemoedge.ui.screens.profile.ProfileViewModel_HiltModules;
import com.Siddhesh.hemoedge.ui.screens.profile.ProfileViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.Siddhesh.hemoedge.ui.screens.profile.ProfileViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.Siddhesh.hemoedge.ui.screens.reports.ReportsViewModel;
import com.Siddhesh.hemoedge.ui.screens.reports.ReportsViewModel_HiltModules;
import com.Siddhesh.hemoedge.ui.screens.reports.ReportsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.Siddhesh.hemoedge.ui.screens.reports.ReportsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.Siddhesh.hemoedge.ui.screens.results.ResultsViewModel;
import com.Siddhesh.hemoedge.ui.screens.results.ResultsViewModel_HiltModules;
import com.Siddhesh.hemoedge.ui.screens.results.ResultsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.Siddhesh.hemoedge.ui.screens.results.ResultsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.Siddhesh.hemoedge.ui.viewmodel.SettingsViewModel;
import com.Siddhesh.hemoedge.ui.viewmodel.SettingsViewModel_HiltModules;
import com.Siddhesh.hemoedge.ui.viewmodel.SettingsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.Siddhesh.hemoedge.ui.viewmodel.SettingsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class DaggerHemoEdgeApplication_HiltComponents_SingletonC {
  private DaggerHemoEdgeApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public HemoEdgeApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements HemoEdgeApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public HemoEdgeApplication_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements HemoEdgeApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public HemoEdgeApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements HemoEdgeApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public HemoEdgeApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements HemoEdgeApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public HemoEdgeApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements HemoEdgeApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public HemoEdgeApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements HemoEdgeApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public HemoEdgeApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements HemoEdgeApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public HemoEdgeApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends HemoEdgeApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends HemoEdgeApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    FragmentCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends HemoEdgeApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends HemoEdgeApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    ActivityCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    ImmutableMap keySetMapOfClassOfAndBooleanBuilder() {
      ImmutableMap.Builder mapBuilder = ImmutableMap.<String, Boolean>builderWithExpectedSize(9);
      mapBuilder.put(ChatbotViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, ChatbotViewModel_HiltModules.KeyModule.provide());
      mapBuilder.put(DashboardViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, DashboardViewModel_HiltModules.KeyModule.provide());
      mapBuilder.put(HistoryViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, HistoryViewModel_HiltModules.KeyModule.provide());
      mapBuilder.put(LoginViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, LoginViewModel_HiltModules.KeyModule.provide());
      mapBuilder.put(ProfileViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, ProfileViewModel_HiltModules.KeyModule.provide());
      mapBuilder.put(RegisterViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, RegisterViewModel_HiltModules.KeyModule.provide());
      mapBuilder.put(ReportsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, ReportsViewModel_HiltModules.KeyModule.provide());
      mapBuilder.put(ResultsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, ResultsViewModel_HiltModules.KeyModule.provide());
      mapBuilder.put(SettingsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, SettingsViewModel_HiltModules.KeyModule.provide());
      return mapBuilder.build();
    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(keySetMapOfClassOfAndBooleanBuilder());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }
  }

  private static final class ViewModelCImpl extends HemoEdgeApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    Provider<ChatbotViewModel> chatbotViewModelProvider;

    Provider<DashboardViewModel> dashboardViewModelProvider;

    Provider<HistoryViewModel> historyViewModelProvider;

    Provider<LoginViewModel> loginViewModelProvider;

    Provider<ProfileViewModel> profileViewModelProvider;

    Provider<RegisterViewModel> registerViewModelProvider;

    Provider<ReportsViewModel> reportsViewModelProvider;

    Provider<ResultsViewModel> resultsViewModelProvider;

    Provider<SettingsViewModel> settingsViewModelProvider;

    ViewModelCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        SavedStateHandle savedStateHandleParam, ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    ImmutableMap hiltViewModelMapMapOfClassOfAndProviderOfViewModelBuilder() {
      ImmutableMap.Builder mapBuilder = ImmutableMap.<String, javax.inject.Provider<ViewModel>>builderWithExpectedSize(9);
      mapBuilder.put(ChatbotViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (chatbotViewModelProvider)));
      mapBuilder.put(DashboardViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (dashboardViewModelProvider)));
      mapBuilder.put(HistoryViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (historyViewModelProvider)));
      mapBuilder.put(LoginViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (loginViewModelProvider)));
      mapBuilder.put(ProfileViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (profileViewModelProvider)));
      mapBuilder.put(RegisterViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (registerViewModelProvider)));
      mapBuilder.put(ReportsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (reportsViewModelProvider)));
      mapBuilder.put(ResultsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (resultsViewModelProvider)));
      mapBuilder.put(SettingsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (settingsViewModelProvider)));
      return mapBuilder.build();
    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.chatbotViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.dashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.historyViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.loginViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.profileViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.registerViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.reportsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.resultsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
      this.settingsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(hiltViewModelMapMapOfClassOfAndProviderOfViewModelBuilder());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return ImmutableMap.<Class<?>, Object>of();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T get() {
        switch (id) {
          case 0: // com.Siddhesh.hemoedge.ui.screens.chatbot.ChatbotViewModel
          return (T) new ChatbotViewModel(singletonCImpl.bindChatRepositoryProvider.get());

          case 1: // com.Siddhesh.hemoedge.ui.screens.dashboard.DashboardViewModel
          return (T) new DashboardViewModel(singletonCImpl.scanDao());

          case 2: // com.Siddhesh.hemoedge.ui.screens.history.HistoryViewModel
          return (T) new HistoryViewModel(singletonCImpl.scanDao());

          case 3: // com.Siddhesh.hemoedge.ui.screens.auth.LoginViewModel
          return (T) new LoginViewModel(singletonCImpl.bindUserRepositoryProvider.get(), singletonCImpl.providePreferencesProvider.get());

          case 4: // com.Siddhesh.hemoedge.ui.screens.profile.ProfileViewModel
          return (T) new ProfileViewModel(singletonCImpl.bindUserRepositoryProvider.get(), singletonCImpl.providePreferencesProvider.get());

          case 5: // com.Siddhesh.hemoedge.ui.screens.auth.RegisterViewModel
          return (T) new RegisterViewModel(singletonCImpl.bindUserRepositoryProvider.get(), singletonCImpl.provideFirestoreProvider.get());

          case 6: // com.Siddhesh.hemoedge.ui.screens.reports.ReportsViewModel
          return (T) new ReportsViewModel();

          case 7: // com.Siddhesh.hemoedge.ui.screens.results.ResultsViewModel
          return (T) new ResultsViewModel();

          case 8: // com.Siddhesh.hemoedge.ui.viewmodel.SettingsViewModel
          return (T) new SettingsViewModel(singletonCImpl.providePreferencesProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends HemoEdgeApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends HemoEdgeApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends HemoEdgeApplication_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    Provider<AppDatabase> provideDbProvider;

    Provider<OkHttpClient> provideOkHttpProvider;

    Provider<Retrofit> provideRetrofitProvider;

    Provider<LlmApi> provideLlmApiProvider;

    Provider<ChatRepository> chatRepositoryProvider;

    Provider<IChatRepository> bindChatRepositoryProvider;

    Provider<FirebaseAuth> provideAuthProvider;

    Provider<UserRepository> userRepositoryProvider;

    Provider<IUserRepository> bindUserRepositoryProvider;

    Provider<PreferencesManager> providePreferencesProvider;

    Provider<FirebaseFirestore> provideFirestoreProvider;

    SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    ChatDao chatDao() {
      return AppModule_ProvideChatDaoFactory.provideChatDao(provideDbProvider.get());
    }

    LLMRepository lLMRepository() {
      return new LLMRepository(provideLlmApiProvider.get());
    }

    ScanDao scanDao() {
      return AppModule_ProvideScanDaoFactory.provideScanDao(provideDbProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideDbProvider = DoubleCheck.provider(new SwitchingProvider<AppDatabase>(singletonCImpl, 1));
      this.provideOkHttpProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 4));
      this.provideRetrofitProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 3));
      this.provideLlmApiProvider = DoubleCheck.provider(new SwitchingProvider<LlmApi>(singletonCImpl, 2));
      this.chatRepositoryProvider = new SwitchingProvider<>(singletonCImpl, 0);
      this.bindChatRepositoryProvider = DoubleCheck.provider((Provider) (chatRepositoryProvider));
      this.provideAuthProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseAuth>(singletonCImpl, 6));
      this.userRepositoryProvider = new SwitchingProvider<>(singletonCImpl, 5);
      this.bindUserRepositoryProvider = DoubleCheck.provider((Provider) (userRepositoryProvider));
      this.providePreferencesProvider = DoubleCheck.provider(new SwitchingProvider<PreferencesManager>(singletonCImpl, 7));
      this.provideFirestoreProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseFirestore>(singletonCImpl, 8));
    }

    @Override
    public void injectHemoEdgeApplication(HemoEdgeApplication hemoEdgeApplication) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T get() {
        switch (id) {
          case 0: // com.Siddhesh.hemoedge.data.remote.ChatRepository
          return (T) new ChatRepository(singletonCImpl.chatDao(), singletonCImpl.lLMRepository(), ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 1: // com.Siddhesh.hemoedge.data.local.AppDatabase
          return (T) AppModule_ProvideDbFactory.provideDb(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 2: // com.Siddhesh.hemoedge.data.remote.LlmApi
          return (T) AppModule_ProvideLlmApiFactory.provideLlmApi(singletonCImpl.provideRetrofitProvider.get());

          case 3: // retrofit2.Retrofit
          return (T) AppModule_ProvideRetrofitFactory.provideRetrofit(singletonCImpl.provideOkHttpProvider.get());

          case 4: // okhttp3.OkHttpClient
          return (T) AppModule_ProvideOkHttpFactory.provideOkHttp();

          case 5: // com.Siddhesh.hemoedge.data.remote.UserRepository
          return (T) new UserRepository(singletonCImpl.provideAuthProvider.get());

          case 6: // com.google.firebase.auth.FirebaseAuth
          return (T) FirebaseModule_ProvideAuthFactory.provideAuth();

          case 7: // com.Siddhesh.hemoedge.data.local.PreferencesManager
          return (T) AppModule_ProvidePreferencesFactory.providePreferences(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 8: // com.google.firebase.firestore.FirebaseFirestore
          return (T) FirebaseModule_ProvideFirestoreFactory.provideFirestore();

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
