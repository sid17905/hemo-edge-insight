package com.Siddhesh.hemoedge.data.remote;

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
public final class ReportRepository_Factory implements Factory<ReportRepository> {
  @Override
  public ReportRepository get() {
    return newInstance();
  }

  public static ReportRepository_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ReportRepository newInstance() {
    return new ReportRepository();
  }

  private static final class InstanceHolder {
    static final ReportRepository_Factory INSTANCE = new ReportRepository_Factory();
  }
}
