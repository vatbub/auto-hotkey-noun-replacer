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

import com.beust.jcommander.Parameter
import java.io.File

class CommandLineParameters {
    @Parameter(names = ["--inputFile"], description = "The location of the word list to process.", required = true)
    lateinit var inputFile: File

    @Parameter(
        names = ["--outputFile"],
        description = "Location of the AutoHotkey script that shall be generated.",
        required = true
    )
    lateinit var outputFile: File

    @Parameter(
        names = ["--language"],
        description = "The language of the word list. Important as a spell checker is used to filter the word list"
    )
    var language: Languages = Languages.GermanyGerman

    @Parameter(names = ["-h", "--help", "/?", "help"], description = "Prints this help.", help = true)
    var help: Boolean = false
}
