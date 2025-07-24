package com.example.tasks.Service;

import com.example.tasks.Entity.Task;
import com.example.tasks.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Obtener todas las tareas
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    // Agregar tareas
    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    // Actualizar tarea
    public Task updateTask(long id ,Task newTask){
        return taskRepository.findById(id).map(propietario -> {
            propietario.setTitle(newTask.getTitle());
            propietario.setStarted_at(newTask.getStarted_at());
            propietario.setDescription(newTask.getDescription());
            propietario.setFinished(newTask.isFinished());
            propietario.setPriority(newTask.getPriority());
            propietario.setCategory(newTask.getCategory());
            propietario.setUser(newTask.getUser());
            return taskRepository.save(propietario);
        }).orElseThrow(() -> new RuntimeException("No se encontro la tarea a actualizar"));
    }

    // Eliminar tarea por id
    public void deleteTask(long id){
        //Se crea una variable Optional, que almacenara o no el objeto que se busco (findById devuelve Optional, por eso creamos la variable y le asignamos el findById)
        Optional<Task> task = taskRepository.findById(id);

        //Si el objeto esta presente en la variable se elimina, si no, lanza una excepción
        if(task.isPresent()){
            taskRepository.deleteById(id);
        }else{
            throw new RuntimeException("No se encontro la tarea a eliminar");
        }
    }
}
