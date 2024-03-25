![version](https://img.shields.io/badge/version-1.0.4-blue)

## How to use?
in your project
```gradle
dependencyResolutionManagement {
    ...
    repositories {
        ...
        maven("https://jitpack.io")
    }
}
```

module
```gradle
dependencies {
  implementation("com.github.Team-B1ND:dds-android:{version}")
}
