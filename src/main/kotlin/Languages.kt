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

import org.languagetool.Language

// Important: Supported languages must also be added to the language-module.properties
enum class Languages(val languageToolLanguage: () -> Language) {
    Arabic({ org.languagetool.language.Arabic() }),
    Asturian({ org.languagetool.language.Asturian() }),
    Belarusian({ org.languagetool.language.Belarusian() }),
    Breton({ org.languagetool.language.Breton() }),
    Catalan({ org.languagetool.language.Catalan() }),
    ValencianCatalan({ org.languagetool.language.ValencianCatalan() }),
    Chinese({ org.languagetool.language.Chinese() }),
    Danish({ org.languagetool.language.Danish() }),
    Dutch({ org.languagetool.language.Dutch() }),
    BelgianDutch({ org.languagetool.language.BelgianDutch() }),
    English({ org.languagetool.language.English() }),
    AustralianEnglish({ org.languagetool.language.AustralianEnglish() }),
    CanadianEnglish({ org.languagetool.language.CanadianEnglish() }),
    BritishEnglish({ org.languagetool.language.BritishEnglish() }),
    NewZealandEnglish({ org.languagetool.language.NewZealandEnglish() }),
    SouthAfricanEnglish({ org.languagetool.language.SouthAfricanEnglish() }),
    AmericanEnglish({ org.languagetool.language.AmericanEnglish() }),
    Esperanto({ org.languagetool.language.Esperanto() }),
    French({ org.languagetool.language.French() }),
    Galician({ org.languagetool.language.Galician() }),
    German({ org.languagetool.language.German() }),
    AustrianGerman({ org.languagetool.language.AustrianGerman() }),
    GermanyGerman({ org.languagetool.language.GermanyGerman() }),
    SwissGerman({ org.languagetool.language.SwissGerman() }),
    Greek({ org.languagetool.language.Greek() }),
    Irish({ org.languagetool.language.Irish() }),
    Italian({ org.languagetool.language.Italian() }),
    Japanese({ org.languagetool.language.Japanese() }),
    Khmer({ org.languagetool.language.Khmer() }),
    Persian({ org.languagetool.language.Persian() }),
    Polish({ org.languagetool.language.Polish() }),
    Portuguese({ org.languagetool.language.Portuguese() }),
    AngolaPortuguese({ org.languagetool.language.AngolaPortuguese() }),
    BrazilianPortuguese({ org.languagetool.language.BrazilianPortuguese() }),
    MozambiquePortuguese({ org.languagetool.language.MozambiquePortuguese() }),
    PortugalPortuguese({ org.languagetool.language.PortugalPortuguese() }),
    Romanian({ org.languagetool.language.Romanian() }),
    Russian({ org.languagetool.language.Russian() }),
    Slovak({ org.languagetool.language.Slovak() }),
    Slovenian({ org.languagetool.language.Slovenian() }),
    Spanish({ org.languagetool.language.Spanish() }),
    SpanishVoseo({ org.languagetool.language.SpanishVoseo() }),
    Swedish({ org.languagetool.language.Swedish() }),
    Tagalog({ org.languagetool.language.Tagalog() }),
    Tamil({ org.languagetool.language.Tamil() }),
    Ukrainian({ org.languagetool.language.Ukrainian() }),
}
