// package cafe.shop.testing.cafe.shop.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import cafe.shop.testing.cafe.shop.entities.Status;
// import cafe.shop.testing.cafe.shop.entities.Tables;
// import cafe.shop.testing.cafe.shop.services.TableService;

// import java.util.List;

// @RestController
// public class TableController {
//     @Autowired 
//     TableService tableService; 

    

//     @GetMapping("/getTables")
//     public List<Tables> getTables(){
//         return tableService.getTables(); 
//     }

//     @GetMapping("/getTableById/{id}")
//     public Tables getTableById(@PathVariable("id") Long id){
//         return tableService.getTableById(id); 
//     }
    
//     @PostMapping("/addNewTable")
//     public Tables addNewTables(){
//         Tables table = new Tables(Status.available); 
//         return tableService.addNewTable(table); 
//     }

    

//     @PostMapping("/updateTableById/{id}")
//     public Tables updateTableById(@PathVariable("id") Long id){
//         Tables table = tableService.getTableById(id);
//         if (table.getStatus().equals(Status.available)){
//             table.setStatus(Status.unavailable);
//         }else{
//             table.setStatus(Status.available);
//         }
//         return tableService.updateTable(table);
//     }

// }
