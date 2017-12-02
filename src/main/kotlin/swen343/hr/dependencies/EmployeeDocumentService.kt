package swen343.hr.dependencies

import com.google.inject.ImplementedBy
import swen343.hr.models.Employee
import java.nio.file.Path

@ImplementedBy(EmployeeDocs::class)
interface EmployeeDocumentService {

    /**
     * Get all the [Document]s.
     *
     * @return all the [Document]s
     */
    fun getDocuments(username: String): List<String>

    /**
     * Get a document [Document]s.
     *
     * @return a document [Document]s
     */
    fun getDocument(username: String, fileName: String): Path


    /**
     * Uploads a new [Document]. The ID of the provided [Document]
     * will be disregarded, and a new ID will be created.
     *
     * @param document the [Document] to add
     * @return the added [Document]
     */
    fun uploadDocument(username: String): String
//    TODO

    fun deleteDocument(username: String, fileName: String): String


}