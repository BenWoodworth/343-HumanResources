package swen343.hr.viewmodels

import swen343.hr.models.User
import java.nio.file.Files
import java.nio.file.Path

class ViewModelDocuments(
        override val sessionUser: User?,
        documentPaths: List<Path>
) : ViewModel {

    val documents: List<Document> = documentPaths.map {
        Document(
            it.fileName.toString(),
            getFileSize(it)
        )
    }

    private fun getFileSize(path: Path): String {
        val fileSize = Files.size(path)
        val magnitude = Math.floor(Math.log10(fileSize.toDouble()))
        val scalar = (fileSize / Math.pow(10.0, magnitude)).toInt()

        val units = listOf("B", "KB", "MB", "GB", "TB")
        val unit = units[minOf(magnitude.toInt(), units.size)]

        return "$scalar $unit"
    }

    class Document constructor(
            val name: String,
            val size: String
    )
}