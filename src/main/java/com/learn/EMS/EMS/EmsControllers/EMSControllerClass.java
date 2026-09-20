package com.learn.EMS.EMS.EmsControllers;

import com.learn.EMS.EMS.EmsDTO.Expense;
import com.learn.EMS.EMS.Entity.ExpenseEntity;
import com.learn.EMS.EMS.Repository.ExpenceRepository;
import com.learn.EMS.EMS.Services.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

@RestController
public class EMSControllerClass {
ExpenseService service;
public EMSControllerClass(ExpenseService service){
    this.service=service;
}
    @GetMapping("/home")
    public String getHome(){

    return "Welcome to the Home Page";
    }

    @GetMapping("/Expense/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id){
        Optional<Expense> expense= Optional.ofNullable(service.getById(id));
       return expense.map(expense1 -> ResponseEntity.ok(expense1)).orElse(ResponseEntity.notFound().build());

    }

   @GetMapping("/Expense")
   public ResponseEntity<List<Expense>> getAllExpenses(){
    return ResponseEntity.ok(service.getAllExpense());
   }

    @PostMapping("/Expenses")
    public ResponseEntity<Expense> addExpenses(@RequestBody Expense expenseDTO){
         // return expences.save(entity);
        Expense saved=service.addExpense(expenseDTO);
        URI location= ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/Expense/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @DeleteMapping("/Expense/{id}")
    public ResponseEntity<Boolean> deleteExpenses(@PathVariable Long id){
        boolean isDeleted= service.delete(id);
        if (isDeleted)
            ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/Expense/{id}")
    public ResponseEntity<Expense> updateById(@RequestBody Expense expenseDTO,@PathVariable Long id){
       return ResponseEntity.ok(service.update(expenseDTO,id));
    }
    //S01 ADDING PATCH MAPPING TO THE CODE
    @PatchMapping("/Expense/{id}")
    public ResponseEntity<Expense> updatePartialById(@RequestBody Map<String,Object> entity,@PathVariable Long id){
    return ResponseEntity.ok(service.updatePatch(entity,id));
    }
}
