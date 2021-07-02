# Auto-hotkey-noun-replacer
This project was created out of necessity: 
I was writing my master thesis in LaTeX, and I was constantly misspelling words.
Most importantly, I accidentally wrote nouns (which always start with an uppercase letter in German) lowercase.
Hence, I started using [AutoHotkey](https://www.autohotkey.com/) to automatically fix words that I misspelled very often.

But then I remembered that the [Nanyang Technological University Singapore](http://compling.hss.ntu.edu.sg/omw/summx.html) created a giant word database which is freely accessible (see their license).
So, I thought, I could basically download the list of german words and use it to automatically generate an AutoHotkey-script that fixes the spelling of all nouns.
Turns out: It's not that simple, because there are many nouns in German which can also be used as verbs (cf. "essen" = "to eat" and "Essen" = "food").
Hence, I created this small tool which does some smart filtering and then creates said AutoHotkey-script.

## Features
- Reads one of the word list files from [here](http://compling.hss.ntu.edu.sg/omw/summx.html)
- Filters out any words which are not nouns (i.e. start with a lowercase letter)
- Filters out any words which are also valid when used lowercase (cf. "Essen" vs. "essen") using the spell-checker [languagetool.org](https://languagetool.org/)
- Outputs the results as an AutoHotkey-script so-that the spelling of those nouns is fixed as you type.

## Supported languages
For a language to be supported, 2 criteria must be met:
- A word list file must exist for that language
- [Languagetool needs to support the language](https://dev.languagetool.org/languages)

Also, there are some languages, for which the above filtering does not make much sense, e.g., in English nouns are typically spelled with a lowercase letter.

I used this tool to write my thesis in German, hence, I know that it works at least in German :)

## Download and compiling and usage
Because this is just a small tool for which I already wasted too much time, I will not provide a compiled download.
Instead, you will need to clone the repo and compile the tool yourself, but here are all the steps you need for that:

1. Clone or download this repository using the big green button in the upper right corner.
2. If you downloaded the repo, unzip it somewhere.
3. Open a terminal and use the `cd` command to navigate to the project folder (See [here](https://www.minitool.com/news/how-to-change-directory-in-cmd.html) if you need more help with that)
4. Run this command: `mvnw package`

This will download a bunch of stuff and then compile the tool.
Once it's done it will say `Build succeeded` and you will  find that a new folder called `target` was created with the compiled tool in it.

Now stay in that terminal window that you used for compiling and run the following command:

```
java -jar target\autoHotkeyNounReplacer-1.0.0-SNAPSHOT-jar-with-dependencies.jar --inputFile wordLists/wikt/wn-wikt-deu.tab --outputFile target/FixGermanNouns.ahk --language GermanyGerman
```

This will read the word list `wn-wikt-deu.tab` (German words), filter it and write the AutoHotkey-script to `target/FixGermanNouns.ahk`.

If you choose to use the tool for a different language than German, you need to...
1. Pick a different word list file (e.g. `wn-wikt-pol.tab`) for Polish
2. Change the language after `--language` sothat the spell checker knows the language to check against (in this example, that would be `--language Polish`)

## License
This tool is licensed under the Apache License v2 (see the [License](/LICENSE.txt) file).
The word lists, which I downloaded from the [Nanyang Technological University Singapore](http://compling.hss.ntu.edu.sg/omw/summx.html), are licensed under the [CC by SA 3.0 Licence](https://creativecommons.org/licenses/by-sa/3.0/) (Wiktionary word lists) and the [ Unicode, Inc. Licence Agreement](http://www.unicode.org/copyright.html) (CLDR word lists). 
