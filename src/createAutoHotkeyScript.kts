import org.languagetool.JLanguageTool
import org.languagetool.language.GermanyGerman
import java.io.File
import java.io.FileReader
import java.io.PrintStream
import java.nio.charset.Charset

val inputFile = File("wordLists/wikt/wn-wikt-deu.tab")
val outputFile = File("src/FixGermanNouns.ahk")
val languageTool = JLanguageTool(GermanyGerman())

println("Input file: ${inputFile.absolutePath}")
println("Output file: ${outputFile.absolutePath}")

val lines = FileReader(inputFile, Charset.forName("UTF-8")).buffered().use { it.readLines() }
val preprocessedLines = lines
    .drop(1)
    .map { it.split("\t")[2] }
    .map { it.removeSuffix("-") }


val processedLines = preprocessedLines
    .filter { it[0].isUpperCase() }
    .filterNot { languageTool.check(it.toLowerCase()).isEmpty() }
    .filter { it.length <= 40 }
    .map { "::${it.toLowerCase()}::$it" }

PrintStream(outputFile, Charset.forName("UTF-8")).use { outputWriter ->
    outputWriter.println("#NoEnv")
    outputWriter.println("SendMode Input")
    outputWriter.println("#SingleInstance, force")

    processedLines.forEach { line ->
        outputWriter.println(line)
    }
}
