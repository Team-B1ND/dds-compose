![version](https://img.shields.io/badge/version-1.5.0-blue)

## How to use?
in your project
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
    }
}
```

module
```gradle
dependencies {
  implementation("com.b1nd.dodam:dodam-design-system:{version}")
}
