package com.Siddhesh.hemoedge.ui.screens.history;

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
public final class HistoryViewModel_Factory implements Factory<HistoryViewModel> {
  private final Provider<ScanDao> scanDaoProvider;

  private HistoryViewModel_Factory(Provider<ScanDao> scanDaoProvider) {
    this.scanDaoProvider = scanDaoProvider;
  }

  @Override
  public HistoryViewModel get() {
    return newInstance(scanDaoProvider.get());
  }

  public static HistoryViewModel_Factory create(Provider<ScanDao> scanDaoProvider) {
    return new HistoryViewModel_Factory(scanDaoProvider);
  }

  public static HistoryViewModel newInstance(ScanDao scanDao) {
    return new HistoryViewModel(scanDao);
  }
}
