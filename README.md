
# ⭐ JB Animated RatingBar

A smooth, animated, customizable RatingBar library for Android — built with Kotlin, clean XML, and simple integration.

![JitPack](https://jitpack.io/v/YOUR_GITHUB_USERNAME/JbRatingBar.svg)

---

## ✨ Features
- Smooth scale animation
- Custom icons (filled & unfilled stars)
- Supports fractional ratings (0.5, 1.5, etc.)
- Easy integration with XML & Kotlin
- Lightweight & dependency-free except standard Android libraries

---

## 📦 Installation

### 1️⃣ Step 1: Add JitPack repository to your root `settings.gradle`:
```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
```

### 2️⃣ Step 2: Add the library dependency in your app-level `build.gradle`:
```kotlin
implementation("com.github.YOUR_GITHUB_USERNAME:JbRatingBar:1.0.0")
```

---

## 🛠️ Usage

### XML Example:
```xml
<com.jb.ratingbar.AnimatedRatingBar
    android:id="@+id/customRatingBar"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:numStars="5"
    app:rating="4"
    app:stepSize="0.5"
    app:isIndicator="false"/>
```

### Kotlin Example:
```kotlin
binding.customRatingBar.setOnRatingChangeListener { rating ->
    Toast.makeText(this, "Rating: $rating", Toast.LENGTH_SHORT).show()
}
```

---

## 🖼️ Customization
| Attribute | Description |
|------------|-------------|
| `app:numStars` | Total number of stars |
| `app:rating` | Default rating |
| `app:stepSize` | Step size (e.g., 0.5, 1) |
| `app:isIndicator` | Make it read-only if `true` |
| `app:drawableFilled` | Custom filled star icon |
| `app:drawableEmpty` | Custom empty star icon |

---

## 📝 License
```
MIT License

Copyright (c) 2025 JB

Permission is hereby granted, free of charge, to any person obtaining a copy...
```

---

### 💡 Contributions are Welcome!
Feel free to submit pull requests or open issues to improve this library.

---
