[![📦 Build Status](https://github.com/rafaelfelipeac/replyradar/actions/workflows/build-and-lint.yml/badge.svg)](https://github.com/rafaelfelipeac/replyradar/actions/workflows/build-and-lint.yml)
[![🚀 Release Status](https://github.com/rafaelfelipeac/replyradar/actions/workflows/release.yml/badge.svg)](https://github.com/rafaelfelipeac/replyradar/actions/workflows/release.yml)

---

# 📡 Reply Radar

**Reply Radar** is a playful, personal project built to help people keep track of the messages they still need to reply to — because we all know how easy it is to read something, get distracted and then forget to respond for days (or... weeks 👀).

This app exists for anyone who's ever said, “Oops, I meant to reply to that!” and wants to stay on top of conversations without guilt or chaos. No more ghosting your friends by accident. No more losing important messages in the middle of your busy day.

With Reply Radar, your forgotten replies are finally on the radar.  
A gentle nudge. A little order. A friendlier inbox — on your terms.


<a href="https://play.google.com/store/apps/details?id=com.rafaelfelipeac.replyradar">
    <img 
        alt="Get it on Google Play" 
        src="https://user-images.githubusercontent.com/9745110/89697876-99ab9480-d8f4-11ea-869d-32131a31ab96.png" 
        width="200">
</a>  

> Don’t leave your replies floating in space — keep them on the radar.

---

## 🤹 Why Kotlin Multiplatform?

Even though I’m an Android developer by trade, I decided to build **Reply Radar** using **Kotlin Multiplatform** as a learning experiment.  
The idea was to explore modern shared code strategies while keeping things familiar with an Android-first mindset.

This project uses common architectural patterns and tools you’d expect in an Android codebase — like Jetpack Compose, Room, Coroutines and MVI — but wrapped in a multiplatform structure ready to evolve across Android, iOS and even Desktop.

It’s a playground, but also a showcase of how Kotlin can unify experiences across platforms with elegance (and fewer bugs 🤞).

---

## ✨ What it does (for now)

- Add, edit, resolve, archive, and delete replies/messages
- Organize replies into three states:
  - **Active** – Messages still pending a reply
  - **Resolved** – Messages you've replied to and marked as done
  - **Archived** – Soft delete feature to hide messages you no longer want to see
- Clean and focused UI to help you stay on top of conversations
- Light **gamification** through action history (laying the groundwork for future features)
- **Offline-first experience** – no account, no server

> ⚠️ **Reminders (and other cool features) aren't here yet** — but they're definitely on the radar. Stay tuned!

---

## 🛠️ Tech Stack

- **Kotlin Multiplatform (KMP)** – Shared logic across platforms (Android, iOS, Desktop)
- **Jetpack Compose / Compose Multiplatform** – UI with modern declarative components
- **Room** – Local database for structured data
- **DataStore** – Key-value storage for lightweight preferences and settings
- **Koin** – Lightweight dependency injection
- **MVI Architecture** – Unidirectional data flow for maintainable state handling
- **Coroutines + Flow + StateFlow** – Reactive and asynchronous operations
- **GitHub Actions** – CI for build, lint and releases

---

## 🧪 Current Status

This is still a work-in-progress — a personal playground to explore architecture patterns, Kotlin Multiplatform and UI ideas. It’s not production-ready, but it’s growing feature by feature.

---

## 🚫 Contributing

Currently a solo mission, but who knows? Contributions might be welcome in the future.

---

## 📬 Stay in touch (just like the app wants you to 😄)

If this project resonates with you, feel free to star it, follow updates or fork it to build your own version.

---

## 📄 License

This project is licensed under the [Apache 2.0 License](LICENSE).
