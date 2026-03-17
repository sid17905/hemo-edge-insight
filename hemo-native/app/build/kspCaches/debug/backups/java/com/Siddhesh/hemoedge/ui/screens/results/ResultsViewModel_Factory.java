package com.Siddhesh.hemoedge.ui.screens.results;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class ResultsViewModel_Factory implements Factory<ResultsViewModel> {
  @Override
  public ResultsViewModel get() {
    return newInstance();
  }

  public static ResultsViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ResultsViewModel newInstance() {
    return new ResultsViewModel();
  }

  private static final class InstanceHolder {
    static final ResultsViewModel_Factory INSTANCE = new ResultsViewModel_Factory();
  }
}
