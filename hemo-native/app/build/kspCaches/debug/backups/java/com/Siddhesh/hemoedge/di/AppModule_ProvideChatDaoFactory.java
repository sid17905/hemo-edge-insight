package com.Siddhesh.hemoedge.di;

import com.Siddhesh.hemoedge.data.local.AppDatabase;
import com.Siddhesh.hemoedge.data.local.ChatDao;
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
public final class AppModule_ProvideChatDaoFactory implements Factory<ChatDao> {
  private final Provider<AppDatabase> dbProvider;

  private AppModule_ProvideChatDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public ChatDao get() {
    return provideChatDao(dbProvider.get());
  }

  public static AppModule_ProvideChatDaoFactory create(Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideChatDaoFactory(dbProvider);
  }

  public static ChatDao provideChatDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideChatDao(db));
  }
}
