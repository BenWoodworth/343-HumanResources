//package swen343.hr.viewmodels
//
//import java.nio.file.Files
//import java.nio.file.Path
//import java.text.NumberFormat
//import java.util.*
//
//data class ViewModelDocuments(
//       val fileName: String,
//       val size: String
//) : ViewModel {
//
//    constructor(path:Path):this(
//            fileName = path.fileName.toString(),
//            size = Files.size(path).toString()
//    )
//
//}