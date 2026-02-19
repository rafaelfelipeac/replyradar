# AGENTS.md

Project-level conventions for Codex and similar agents.

## Kotlin/Compose style
- Avoid wildcard imports in Kotlin files.
- Prefer explicit imports for MaterialTheme accessors in Compose files:
  - `import androidx.compose.material3.MaterialTheme.colorScheme`
  - `import androidx.compose.material3.MaterialTheme.typography`
  Then reference `colorScheme` and `typography` directly.
- Keep composables small and focused; extract sections once composables become hard to scan.

## Architecture & data flow
- Follow boundaries: UI -> ViewModel -> UseCase -> Repository -> Data source.
- UI should not access Room DAOs, DataStore, or platform services directly.
- ViewModels expose state via `StateFlow` and process changes through intents/actions.

## Dependency injection
- Use Koin modules for wiring (`di` packages in common/platform/features).
- Keep constructor injection style and bind interfaces to implementations in modules.
- Prefer platform-specific dependencies behind `expect/actual` or platform modules.

## Persistence
- Room is the source of truth for persisted feature entities.
- Keep entity-domain mapping in the data layer.
- DataStore preferences are for app settings (theme/language and lightweight flags), not relational feature data.

## Networking and integrations
- Centralize HTTP wiring (engine/client config) in DI; avoid ad-hoc client creation in features.
- External integrations must be wrapped in domain/data abstractions so UI is provider-agnostic.

## UI and strings
- Compose Multiplatform UI only; no XML additions.
- No hardcoded user-facing strings in UI; use `core/strings` abstractions.
- When adding a new `Strings` key, update every language file under `core/strings` in the same task.

## User actions
- For user-facing state changes, log actions using the existing user actions feature.
- If a new state-changing flow should not be logged, call that out explicitly in task notes.

## Testing
- Prefer fakes over mocks for unit tests.
- Follow existing test patterns under `composeApp/src/commonTest`.
- Cover new use cases/repositories with tests when behavior changes.

## Change safety
- Keep changes minimal and consistent with touched files.
- Avoid mass formatting-only diffs unless requested.
- If a task affects navigation, persistence schema, or cross-platform contracts, stop and ask before proceeding.

## Assumptions
- Do not infer missing requirements silently.
- State assumptions explicitly, and prefer TODOs over speculative behavior.

## Learning log
- Maintain `LEARNING.md` as a living document.
- Add short notes after meaningful implementation work explaining decisions, trade-offs, and outcomes.
