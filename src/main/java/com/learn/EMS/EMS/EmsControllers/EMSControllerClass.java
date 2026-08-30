package com.learn.EMS.EMS.EmsControllers;

import com.learn.EMS.EMS.EmsDTO.Expense;
import com.learn.EMS.EMS.Entity.ExpenseEntity;
import com.learn.EMS.EMS.Repository.ExpenceRepository;
import com.learn.EMS.EMS.Services.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Expense getExpenseById(@PathVariable Long id){

    return service.getById(id);
    }
   @GetMapping("/Expense")
   public List<Expense> getAllExpenses(){
    return service.getAllExpense();
   }
    @PostMapping("/Expenses")
    public Expense addExpenses(@RequestBody Expense expenseDTO){
         // return expences.save(entity);
        return service.addExpense(expenseDTO);
    }

    @DeleteMapping("/Expense/{id}")
    public boolean deleteExpenses(@PathVariable Long id){
        return service.delete(id);
    }

    @PutMapping("/Expense/{id}")
    public Expense updateById(@RequestBody Expense expenseDTO,@PathVariable Long id){
       return service.update(expenseDTO,id);
    }
}
