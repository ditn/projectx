package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AndroidLibraryAccessors laccForAndroidLibraryAccessors = new AndroidLibraryAccessors(owner);
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final GradleLibraryAccessors laccForGradleLibraryAccessors = new GradleLibraryAccessors(owner);
    private final KotlinLibraryAccessors laccForKotlinLibraryAccessors = new KotlinLibraryAccessors(owner);
    private final TestingLibraryAccessors laccForTestingLibraryAccessors = new TestingLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(providers, config);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers) {
        super(config, providers);
    }

        /**
         * Creates a dependency provider for jlleitschuhKtlint (org.jlleitschuh.gradle:ktlint-gradle)
         * This dependency was declared in catalog libs.toml
         */
        public Provider<MinimalExternalModuleDependency> getJlleitschuhKtlint() { return create("jlleitschuhKtlint"); }

        /**
         * Creates a dependency provider for material (com.google.android.material:material)
         * This dependency was declared in catalog libs.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial() { return create("material"); }

    /**
     * Returns the group of libraries at android
     */
    public AndroidLibraryAccessors getAndroid() { return laccForAndroidLibraryAccessors; }

    /**
     * Returns the group of libraries at androidx
     */
    public AndroidxLibraryAccessors getAndroidx() { return laccForAndroidxLibraryAccessors; }

    /**
     * Returns the group of libraries at gradle
     */
    public GradleLibraryAccessors getGradle() { return laccForGradleLibraryAccessors; }

    /**
     * Returns the group of libraries at kotlin
     */
    public KotlinLibraryAccessors getKotlin() { return laccForKotlinLibraryAccessors; }

    /**
     * Returns the group of libraries at testing
     */
    public TestingLibraryAccessors getTesting() { return laccForTestingLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class AndroidLibraryAccessors extends SubDependencyFactory {

        public AndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for gradle (com.android.tools.build:gradle)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getGradle() { return create("android.gradle"); }

            /**
             * Creates a dependency provider for gradleApi (com.android.tools.build:gradle-api)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getGradleApi() { return create("android.gradleApi"); }

    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxCoreLibraryAccessors laccForAndroidxCoreLibraryAccessors = new AndroidxCoreLibraryAccessors(owner);
        private final AndroidxLifecycleLibraryAccessors laccForAndroidxLifecycleLibraryAccessors = new AndroidxLifecycleLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for activity (androidx.activity:activity-compose)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getActivity() { return create("androidx.activity"); }

            /**
             * Creates a dependency provider for appcompat (androidx.appcompat:appcompat)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getAppcompat() { return create("androidx.appcompat"); }

            /**
             * Creates a dependency provider for composeMaterial (androidx.compose.material:material)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getComposeMaterial() { return create("androidx.composeMaterial"); }

            /**
             * Creates a dependency provider for composeUi (androidx.compose.ui:ui)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getComposeUi() { return create("androidx.composeUi"); }

            /**
             * Creates a dependency provider for composeUiTooling (androidx.compose.ui:ui-tooling)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getComposeUiTooling() { return create("androidx.composeUiTooling"); }

        /**
         * Returns the group of libraries at androidx.core
         */
        public AndroidxCoreLibraryAccessors getCore() { return laccForAndroidxCoreLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.lifecycle
         */
        public AndroidxLifecycleLibraryAccessors getLifecycle() { return laccForAndroidxLifecycleLibraryAccessors; }

    }

    public static class AndroidxCoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.core:core-ktx)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.core.ktx"); }

    }

    public static class AndroidxLifecycleLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for runtime (androidx.lifecycle:lifecycle-runtime-ktx)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getRuntime() { return create("androidx.lifecycle.runtime"); }

    }

    public static class GradleLibraryAccessors extends SubDependencyFactory {

        public GradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for experimental (com.android.tools.build:gradle-experimental)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getExperimental() { return create("gradle.experimental"); }

    }

    public static class KotlinLibraryAccessors extends SubDependencyFactory {

        public KotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for gradle (org.jetbrains.kotlin:kotlin-gradle-plugin)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getGradle() { return create("kotlin.gradle"); }

    }

    public static class TestingLibraryAccessors extends SubDependencyFactory {
        private final TestingAndroidxLibraryAccessors laccForTestingAndroidxLibraryAccessors = new TestingAndroidxLibraryAccessors(owner);
        private final TestingComposeLibraryAccessors laccForTestingComposeLibraryAccessors = new TestingComposeLibraryAccessors(owner);
        private final TestingEspressoLibraryAccessors laccForTestingEspressoLibraryAccessors = new TestingEspressoLibraryAccessors(owner);

        public TestingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit (junit:junit)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit() { return create("testing.junit"); }

        /**
         * Returns the group of libraries at testing.androidx
         */
        public TestingAndroidxLibraryAccessors getAndroidx() { return laccForTestingAndroidxLibraryAccessors; }

        /**
         * Returns the group of libraries at testing.compose
         */
        public TestingComposeLibraryAccessors getCompose() { return laccForTestingComposeLibraryAccessors; }

        /**
         * Returns the group of libraries at testing.espresso
         */
        public TestingEspressoLibraryAccessors getEspresso() { return laccForTestingEspressoLibraryAccessors; }

    }

    public static class TestingAndroidxLibraryAccessors extends SubDependencyFactory {

        public TestingAndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit (androidx.test.ext:junit)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit() { return create("testing.androidx.junit"); }

    }

    public static class TestingComposeLibraryAccessors extends SubDependencyFactory {

        public TestingComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for manifest (androidx.compose.ui:ui-test-manifest)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getManifest() { return create("testing.compose.manifest"); }

            /**
             * Creates a dependency provider for ui (androidx.compose.ui:ui-test-junit4)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getUi() { return create("testing.compose.ui"); }

    }

    public static class TestingEspressoLibraryAccessors extends SubDependencyFactory {

        public TestingEspressoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (androidx.test.espresso:espresso-core)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("testing.espresso.core"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final AndroidxVersionAccessors vaccForAndroidxVersionAccessors = new AndroidxVersionAccessors(providers, config);
        private final TestingVersionAccessors vaccForTestingVersionAccessors = new TestingVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidBuildTools (7.1.0-alpha06)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getAndroidBuildTools() { return getVersion("androidBuildTools"); }

            /**
             * Returns the version associated to this alias: compose (1.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getCompose() { return getVersion("compose"); }

            /**
             * Returns the version associated to this alias: gradleExperimental (0.11.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getGradleExperimental() { return getVersion("gradleExperimental"); }

            /**
             * Returns the version associated to this alias: jlleitschuhKtlint (10.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getJlleitschuhKtlint() { return getVersion("jlleitschuhKtlint"); }

            /**
             * Returns the version associated to this alias: kotlin (1.5.21)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getKotlin() { return getVersion("kotlin"); }

            /**
             * Returns the version associated to this alias: ktlint (0.42.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getKtlint() { return getVersion("ktlint"); }

            /**
             * Returns the version associated to this alias: material (1.4.0-beta01)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getMaterial() { return getVersion("material"); }

        /**
         * Returns the group of versions at versions.androidx
         */
        public AndroidxVersionAccessors getAndroidx() { return vaccForAndroidxVersionAccessors; }

        /**
         * Returns the group of versions at versions.testing
         */
        public TestingVersionAccessors getTesting() { return vaccForTestingVersionAccessors; }

    }

    public static class AndroidxVersionAccessors extends VersionFactory  {

        private final AndroidxLifecycleVersionAccessors vaccForAndroidxLifecycleVersionAccessors = new AndroidxLifecycleVersionAccessors(providers, config);
        public AndroidxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.activity (1.3.0-alpha08)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getActivity() { return getVersion("androidx.activity"); }

            /**
             * Returns the version associated to this alias: androidx.appcompat (1.4.0-alpha01)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getAppcompat() { return getVersion("androidx.appcompat"); }

            /**
             * Returns the version associated to this alias: androidx.core (1.6.0-beta01)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getCore() { return getVersion("androidx.core"); }

        /**
         * Returns the group of versions at versions.androidx.lifecycle
         */
        public AndroidxLifecycleVersionAccessors getLifecycle() { return vaccForAndroidxLifecycleVersionAccessors; }

    }

    public static class AndroidxLifecycleVersionAccessors extends VersionFactory  {

        public AndroidxLifecycleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.lifecycle.runtime (2.4.0-alpha01)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getRuntime() { return getVersion("androidx.lifecycle.runtime"); }

    }

    public static class TestingVersionAccessors extends VersionFactory  {

        private final TestingAndroidxVersionAccessors vaccForTestingAndroidxVersionAccessors = new TestingAndroidxVersionAccessors(providers, config);
        private final TestingEspressoVersionAccessors vaccForTestingEspressoVersionAccessors = new TestingEspressoVersionAccessors(providers, config);
        public TestingVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: testing.junit (4.13.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getJunit() { return getVersion("testing.junit"); }

        /**
         * Returns the group of versions at versions.testing.androidx
         */
        public TestingAndroidxVersionAccessors getAndroidx() { return vaccForTestingAndroidxVersionAccessors; }

        /**
         * Returns the group of versions at versions.testing.espresso
         */
        public TestingEspressoVersionAccessors getEspresso() { return vaccForTestingEspressoVersionAccessors; }

    }

    public static class TestingAndroidxVersionAccessors extends VersionFactory  {

        public TestingAndroidxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: testing.androidx.junit (1.1.3-beta01)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getJunit() { return getVersion("testing.androidx.junit"); }

    }

    public static class TestingEspressoVersionAccessors extends VersionFactory  {

        public TestingEspressoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: testing.espresso.core (3.4.0-beta01)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getCore() { return getVersion("testing.espresso.core"); }

    }

    public static class BundleAccessors extends BundleFactory {
        private final AndroidxBundleAccessors baccForAndroidxBundleAccessors = new AndroidxBundleAccessors(providers, config);

        public BundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of bundles at bundles.androidx
         */
        public AndroidxBundleAccessors getAndroidx() { return baccForAndroidxBundleAccessors; }

    }

    public static class AndroidxBundleAccessors extends BundleFactory {

        public AndroidxBundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a dependency bundle provider for androidx.compose which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.compose.ui:ui</li>
             *    <li>androidx.compose.material:material</li>
             *    <li>androidx.compose.ui:ui-tooling</li>
             * </ul>
             * This bundle was declared in catalog libs.toml
             */
            public Provider<ExternalModuleDependencyBundle> getCompose() { return createBundle("androidx.compose"); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
