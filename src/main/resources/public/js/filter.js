// function filter() {
//     $(document).ready(function (e) {
//         $('.search-panel .dropdown-menu').find('a').click(function (e) {
//             e.preventDefault();
//             var param = $(this).attr("href").replace("#", "");
//             var concept = $(this).text();
//             $('.search-panel span#search_concept').text(concept);
//             $('.input-group #search_param').val(param);
//         });
//         $(document).getElementById(employee.$(this).attr("href")).addEventListener("click", organize)
//     });
// }
//
// function organize() {
//     $(document).sort(employee.$(this).attr("href"))
// }
//
// //
// // function filter() {
// //     var input, filter, ul, li, a, i;
// //     input = $(document).getElementById("myInput");
// //     filter = input.value.toUpperCase();
// //     ul = $(document).getElementById("myUL");
// //     li = ul.getElementsByTagName("li");
// //     for (i = 0; i < li.length; i++) {
// //         a = li[i].getElementsByTagName("a")[0];
// //         if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
// //             li[i].style.display = "";
// //         } else {
// //             li[i].style.display = "none";
// //
// //         }
// //     }
// // }