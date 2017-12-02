package swen343.hr.dependencies

import com.google.inject.Inject
import com.google.inject.Singleton
import swen343.hr.viewmodels.ViewModelDocuments
import swen343.hr.models.Employee
import java.nio.file.Path

@Singleton
class EmployeeDocs: EmployeeDocumentService {

    private val documents = mutableListOf<String>()

    override fun getDocuments(username: String): List<String> {
        return documents
                .toList()
    }

    override fun getDocument(username: String, fileName: String): Path {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun uploadDocument(username: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteDocument(username: String, fileName: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}