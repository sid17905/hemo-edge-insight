package com.Siddhesh.hemoedge.ui.screens.dashboard;

import com.Siddhesh.hemoedge.data.local.ScanDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
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
public final class DashboardViewModel_Factory implements Factory<DashboardViewModel> {
  private final Provider<ScanDao> scanDaoProvider;

  private DashboardViewModel_Factory(Provider<ScanDao> scanDaoProvider) {
    this.scanDaoProvider = scanDaoProvider;
  }

  @Override
  public DashboardViewModel get() {
    return newInstance(scanDaoProvider.get());
  }

  public static DashboardViewModel_Factory create(Provider<ScanDao> scanDaoProvider) {
    return new DashboardViewModel_Factory(scanDaoProvider);
  }

  public static DashboardViewModel newInstance(ScanDao scanDao) {
    return new DashboardViewModel(scanDao);
  }
}
