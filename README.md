# UtilityBox

**UtilityBox** is a beginner-friendly Java terminal app that bundles a few useful tools into a single command-line interface.

## ✨ Features

- ✅ **To-Do List**
  - Add, view, and delete tasks
  - Tasks are stored in a local file (`tasks.txt`)

- 🔐 **Password Generator**
  - Generates strong random passwords using letters, digits, and symbols

- 🎲 **Passphrase Generator**
  - Generates Diceware-style passphrases from a local wordlist (`eff_large_wordlist.txt`)
  - Useful for memorable and secure passphrases

---

## 🚀 Getting Started

### Requirements

- Java 11 or higher
- A terminal

### Compile

```bash
javac -d out src/utilitybox/*.java
jar --create --file UtilityBox.jar -e utilitybox.Main -C out .
# Custom manifest
# jar cfm UtilityBox.jar manifest.txt -C out .
```

### Run

```bash
java -jar UtilityBox.jar
```
