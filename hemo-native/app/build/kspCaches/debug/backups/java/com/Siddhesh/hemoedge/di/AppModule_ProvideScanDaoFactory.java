package com.Siddhesh.hemoedge.di;

import com.Siddhesh.hemoedge.data.local.AppDatabase;
import com.Siddhesh.hemoedge.data.local.ScanDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideScanDaoFactory implements Factory<ScanDao> {
  private final Provider<AppDatabase> dbProvider;

  private AppModule_ProvideScanDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public ScanDao get() {
    return provideScanDao(dbProvider.get());
  }

  public static AppModule_ProvideScanDaoFactory create(Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideScanDaoFactory(dbProvider);
  }

  public static ScanDao provideScanDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideScanDao(db));
  }
}
