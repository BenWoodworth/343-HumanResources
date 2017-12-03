package swen343.hr.dependencies

import com.google.inject.Inject
import com.google.inject.Singleton
import java.io.InputStream
import java.nio.file.*

@Singleton
class EmployeeDocumentServiceFilesystem @Inject constructor(
        private val employeeService: EmployeeService
) : EmployeeDocumentService {

    override fun getDocuments(username: String): List<Path> {
        val dir = getEmployeeDir(username)

        return Files.newDirectoryStream(dir)
                .use { it.toList() }
                .filter { !Files.isDirectory(it) }
    }

    override fun getDocument(username: String, fileName: String): Path? {
        return getDocuments(username)
                .firstOrNull { it.fileName.toString() == fileName }
    }

    override fun uploadDocument(username: String, fileName: String, stream: InputStream) {
        val dir = getEmployeeDir(username)

        val file = dir.resolve(Paths.get(fileName).fileName)

        Files.copy(stream, file, StandardCopyOption.REPLACE_EXISTING)
    }

    override fun deleteDocument(username: String, fileName: String) {
        getDocument(username, fileName)?.run {
            Files.deleteIfExists(this)
        }
    }

    private fun getEmployeeDir(username: String): Path {
        val employee = employeeService.getEmployee(username)

        employee ?: throw Exception("Invalid employee username: $username")

        return Paths.get("./data/employees/${employee.id}/documents/").apply {
            Files.createDirectories(this)
        }
    }
}
