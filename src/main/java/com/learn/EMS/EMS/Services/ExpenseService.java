package com.learn.EMS.EMS.Services;

import com.learn.EMS.EMS.EmsDTO.Expense;
import com.learn.EMS.EMS.Entity.ExpenseEntity;
import com.learn.EMS.EMS.Repository.ExpenceRepository;
import org.apache.el.util.ReflectionUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ExpenseService {
    private final ModelMapper modelMapper;
    private final ExpenceRepository repository;
    public ExpenseService(ExpenceRepository repository,ModelMapper modelMapper){
        this.repository=repository;
        this.modelMapper=modelMapper;
    }
    public Expense getById(Long id) {
       ExpenseEntity entity= repository.findById(id).orElse(null);
        Expense expenseDTO=modelMapper.map(entity,Expense.class);
        return expenseDTO;
    }

    public List<Expense> getAllExpense() {
       List<Expense> expenseList= repository.findAll().stream().map(entity->modelMapper.map(entity,Expense.class)).toList();
       return expenseList;
    }

    public Expense addExpense(Expense expenseDTO) {
        ExpenseEntity enitity1=modelMapper.map(expenseDTO,ExpenseEntity.class);
        ExpenseEntity entity2=repository.save(enitity1);
        return modelMapper.map(entity2,Expense.class);
    }

    public boolean delete(Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Expense update(Expense expenseDTO,Long id) {
        ExpenseEntity entity=modelMapper.map(expenseDTO,ExpenseEntity.class);
        entity.setId(id);
        ExpenseEntity savedEntity=repository.save(entity);
        return modelMapper.map(savedEntity,Expense.class);

    }
    public boolean existByIds(Long id){
        return repository.existsById(id);
    }
    public Expense updatePatch(Map<String, Object> entity, Long id) {
        if(!existByIds(id))
            return null;
        ExpenseEntity entitytoUpdate = repository.findById(id).get();
        entity.forEach((field,value)-> {
            Field fieldtoUpdate= ReflectionUtils.getRequiredField(ExpenseEntity.class, field);
            fieldtoUpdate.setAccessible(true);
            ReflectionUtils.setField(fieldtoUpdate,entitytoUpdate,value);
        });

        return modelMapper.map(repository.save(entitytoUpdate),Expense.class);
    }
}
