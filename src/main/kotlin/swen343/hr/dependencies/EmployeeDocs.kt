package swen343.hr.dependencies

import com.google.inject.Inject
import com.google.inject.Singleton
//import swen343.hr.viewmodels.ViewModelDocuments
import swen343.hr.models.Employee
import java.nio.file.Path

@Singleton
class EmployeeDocs: EmployeeDocumentService {

    private val documents = mutableListOf<String>()

    override fun getDocuments(employee: Employee): List<String> {
        return documents
                .toList()
    }

    override fun uploadDocument(fileName: String): String {


        return ""

    }
}