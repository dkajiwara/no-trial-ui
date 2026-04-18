# no-trial-ui

<img src="docs/launch.gif" width="600px" />

no-trial-ui is a small IntelliJ IDEA plugin that hides the trial widget from the main toolbar.

It is intended for users who want a cleaner toolbar while using IntelliJ IDEA. The plugin keeps the IDE UI focused by removing the trial promotion entry from the toolbar area.

## Target

- IntelliJ IDEA 2026.1 or later
- Tested with `IU-261.22158.277`

## Build

```bash
./gradlew verifyPluginStructure buildPlugin
```

The plugin ZIP is generated at:

```text
build/distributions/no-trial-ui-1.0.0.zip
```

## Install

In IntelliJ IDEA:

1. Open `Settings | Plugins`.
2. Click the gear icon.
3. Select `Install Plugin from Disk...`.
4. Choose `build/distributions/no-trial-ui-1.0.0.zip`.
5. Restart the IDE.

## Debug Logs

Plugin logs are written to `idea.log`.

On macOS:

```text
~/Library/Logs/JetBrains/IntelliJIdea2026.1/idea.log
```

To confirm that the toolbar item was removed, search for:

```text
Hid trial widget in toolbar
```

Example:

```bash
rg "Hid trial widget in toolbar|Trial toolbar action not registered" ~/Library/Logs/JetBrains/IntelliJIdea2026.1/idea.log
```

The success log includes the lifecycle phase, for example:

```text
Hid trial widget in toolbar, phase=appFrameCreated
```

For more verbose logging, add this category in `Help | Diagnostic Tools | Debug Log Settings...`:

```text
com.dkajiwara.plugin
```

## License

MIT License. See [LICENSE](LICENSE).
