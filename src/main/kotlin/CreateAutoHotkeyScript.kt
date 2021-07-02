/*-
 * #%L
 * AutoHotkey Noun replacer
 * %%
 * Copyright (C) 2016 - 2021 Frederik Kammel
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.github.vatbub.autoHotkeyNounReplacer

import com.beust.jcommander.JCommander
import com.beust.jcommander.ParameterException
import org.languagetool.JLanguageTool
import org.languagetool.Language
import java.io.File
import java.io.FileReader
import java.io.PrintStream
import java.nio.charset.Charset
import java.util.*
import kotlin.system.exitProcess

private const val jarName = "autoHotkeyNounReplacer-1.0.0-SNAPSHOT-jar-with-dependencies.jar"

fun main(vararg args: String) {
    val commandLineParameters = CommandLineParameters()
    val jCommander = JCommander(commandLineParameters)
    try {
        jCommander.parse(*args)
    } catch (e: ParameterException) {
        println("Parameter error: ${e.message}")
        e.jCommander.printUsageWithExample()
        exitProcess(1)
    }

    if (commandLineParameters.help) {
        jCommander.printUsageWithExample()
        exitProcess(1)
    }

    createAutoHotkeyScript(
        inputFile = commandLineParameters.inputFile,
        outputFile = commandLineParameters.outputFile,
        language = commandLineParameters.language.languageToolLanguage()
    )
}

private fun JCommander.printUsageWithExample() {
    this.usage()
    println(
        """
            Example:
            java -jar $jarName --inputFile wordLists/wikt/wn-wikt-deu.tab --outputFile target/FixGermanNouns.ahk --language GermanyGerman
        """.trimIndent()
    )
}

private fun createAutoHotkeyScript(inputFile: File, outputFile: File, language: Language) {
    val languageTool = JLanguageTool(language)

    println("Input file: ${inputFile.absolutePath}")
    println("Output file: ${outputFile.absolutePath}")

    println("Reading word list...")
    val lines = FileReader(inputFile, Charset.forName("UTF-8")).buffered().use { it.readLines() }

    println("Preprocessing word list...")
    val preprocessedLines = lines
        .drop(1)
        .map { it.split("\t")[2] }
        .map { it.removeSuffix("-") }


    println("Filtering words that can be upper- and lowercase...")
    val processedLines = preprocessedLines
        .filter { it[0].isUpperCase() }
        .filterNot { languageTool.check(it.lowercase(Locale.getDefault())).isEmpty() }
        .filter { it.length <= 40 }
        .map { "::${it.lowercase(Locale.getDefault())}::$it" }

    println("Generating auto-hotkey-script...")
    PrintStream(outputFile, Charset.forName("UTF-8")).use { outputWriter ->
        outputWriter.println("#NoEnv")
        outputWriter.println("SendMode Input")
        outputWriter.println("#SingleInstance, force")

        processedLines.forEach { line ->
            outputWriter.println(line)
        }
    }
    println("Done!")
}
