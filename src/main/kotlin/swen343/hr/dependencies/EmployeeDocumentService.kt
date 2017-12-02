package swen343.hr.dependencies

import com.google.inject.ImplementedBy
import swen343.hr.models.Employee

@ImplementedBy(EmployeeDocs::class)
interface EmployeeDocumentService {

    /**
     * Get all the [Document]s.
     *
     * @return all the [Document]s
     */
    fun getDocuments(employee: Employee): List<String>


    /**
     * Uploads a new [Document]. The ID of the provided [Document]
     * will be disregarded, and a new ID will be created.
     *
     * @param document the [Document] to add
     * @return the added [Document]
     */
    fun uploadDocument(fileName: String): String


}