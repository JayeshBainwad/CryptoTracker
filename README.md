# CryptoTracker

**A modern cryptocurrency tracking app built using Kotlin, Jetpack Compose, and Clean Architecture.**

---

## About

**CryptoTracker** is a sleek and modular cryptocurrency monitoring app that provides users with current market data, detailed coin information, and historical charts. The app follows **Clean Architecture** principles with an **MVI pattern**, ensuring maintainability, testability, and separation of concerns. **Live market updates** are currently under development and will be available soon.

---

## Features

| Category | Description |
| --- | --- |
| Home Dashboard | View top trending cryptocurrencies with price, percent change, and market cap |
| Detailed View | Tap any coin to view high/low, volume, market dominance, supply, etc. |
| Search Functionality | Instantly search for any coin using a search bar |
| Historical Charts | View price trends over time using interactive charts |
| Modern UI | Built with Jetpack Compose and Material 3 for clean dark/light theme support |
| Live Market Updates | *[In Progress]* Real-time coin price updates via WebSockets or polling |

---

## Architecture & Tech Stack

| Layer / Purpose | Technology / Library |
| --- | --- |
| Language | Kotlin |
| Architecture | MVI + Clean Architecture |
| UI Framework | Jetpack Compose |
| Dependency Injection | Hilt |
| Data Source | REST API via Ktor Client |
| Charts | MPAndroidChart |
| IDE | Android Studio Narwhal (2025.1.1) |
| API Provider | [CoinGecko API](https://www.coingecko.com/en/api) |

---

## Dependencies & Versions

| Library | Version |
| --- | --- |
| Kotlin | 1.9.x |
| Jetpack Compose | 1.5.x – 1.6.x |
| Navigation Compose | 2.7.x |
| Hilt | 2.48+ |
| Lifecycle / ViewModel | 2.6.x |
| MPAndroidChart | 3.1.0 |
| Ktor Client | 2.3.5 |
| Material 3 | 1.2.0+ |

*Refer to [`gradle/libs.versions.toml`](https://github.com/JayeshBainwad/CryptoTracker/blob/master/gradle/libs.versions.toml) for full dependency versions.*

---

## Project Structure (Clean Code Architecture)

```
cryptotracker/
│
├── java/com/jsb/cryptotracker/
│   │
│   ├── di/                             # Hilt dependency injection modules
│   │
│   ├── feature_core/                  # Shared components, base classes, utils
│   │
│   ├── feature_crypto/                # Main feature: Cryptocurrency domain
│   │   ├── data/                      # Data layer (API, DTOs, mappers, repos)
│   │   │   ├── mappers/              # Maps DTOs to domain models
│   │   │   └── networking/           # API definitions & DTOs
│   │   │       └── dto/              # Data Transfer Objects from CoinPaprika
│   │   │
│   │   ├── domain/                   # Domain layer (models, use cases, repos)
│   │   │
│   │   └── presentation/             # UI layer for Coin List and Coin Detail
│   │       ├── coin_list/            # Coin List screen (UI + ViewModel)
│   │       │   └── components/       # Reusable list components
│   │       └── coin_detail/          # Coin Detail screen (UI + ViewModel)
│   │           └── components/       # Reusable detail components
│   │       └── models/               # UI-specific models
│   │
│   ├── ui/theme/                     # Compose theming, colors, typography
│   │
│   ├── CryptoTrackerApp.kt          # Application class + Navigation graph
│   └── MainActivity.kt              # App launcher activity
│
├── res/                              # Resources (colors.xml, themes, etc.)
└── AndroidManifest.xml

```

---

## Learning Outcomes

This project showcases my ability to:

- Build reactive UI using **Jetpack Compose** and **Material 3**
- Consume REST APIs using **Ktor Client** and display data in an MVI architecture
- Apply **Clean Architecture** for scalable app development
- Use **Hilt** for dependency injection across multiple feature modules
- Integrate **MPAndroidChart** for historical data visualization
- Implement advanced **search, navigation, and charting** patterns
- Work on **live data update integration** (WebSocket/polling) [In Progress]

---

## Screenshots / Demo

> 📸 Coming soon: Dashboard, Coin Detail View, and Light/Dark mode UI previews.

---

## Getting Started

### Prerequisites

- Android Studio Narwhal 2025.1.1
- Android SDK 24+

### Installation

1. **Clone the repository**
    
    ```bash
    git clone https://github.com/JayeshBainwad/CryptoTracker.git
    cd CryptoTracker
    
    ```
    
2. **Open in Android Studio**
    - Sync Gradle
    - Run on emulator or physical device
3. **API Configuration**
    - CoinGecko's public API is used (no key required)
    - No backend setup needed for this version

---

## Contact

Looking to collaborate or hire?

| Type | Link |
| --- | --- |
| LinkedIn | [LinkedIn Profile](https://www.linkedin.com/in/jayesh-bainwad-a09b93250) |
| Email | [jbainwad@gmail.com](mailto:jbainwad@gmail.com) |

---

## Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss.

1. Fork the Project
2. Create a Feature Branch (`git checkout -b feature/MyFeature`)
3. Commit your Changes (`git commit -m 'Add MyFeature'`)
4. Push to Branch (`git push origin feature/MyFeature`)
5. Open a Pull Request

---

## License

This project is licensed under the MIT License – see the [LICENSE](https://github.com/JayeshBainwad/CryptoTracker/blob/master/LICENSE) file.

---

## Acknowledgments

- [CoinGecko](https://www.coingecko.com/) for free crypto market data
- [Jetpack Compose](https://developer.android.com/jetpack/compose) for modern Android UI
- [Ktor](https://ktor.io/) for robust API consumption
- [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart) for charting
- Special thanks to [Philipp Lackner (PlCoding)](https://www.youtube.com/@PhilippLackner) for his excellent free course on building a Crypto Tracker app using Clean Architecture, MVI, and Compose. This project is inspired by that course and built with additional improvements for learning purposes.

---
