package swen343.hr.dependencies

import com.google.inject.ImplementedBy
import java.io.InputStream
import java.nio.file.Path

@ImplementedBy(EmployeeDocumentServiceFilesystem::class)
interface EmployeeDocumentService {

    /**
     * Get all the documents for an employee.
     *
     * @return paths to the employee's documents
     */
    fun getDocuments(username: String): List<Path>

    /**
     * Get an employee's document.
     *
     * @return a the path to the employee's document
     */
    fun getDocument(username: String, fileName: String): Path?

    /**
     * Uploads a new document.
     *
     * @return the added [Document]
     */
    fun uploadDocument(username: String, fileName: String, stream: InputStream)

    fun deleteDocument(username: String, fileName: String)
}