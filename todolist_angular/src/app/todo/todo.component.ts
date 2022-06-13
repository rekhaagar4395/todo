import { Component, OnInit } from '@angular/core';
import { Todolist } from '../model/todolist';
import { TodoService } from '../service/todo.service';

@Component({
    selector: 'app-todo',
    templateUrl: './todo.component.html',
    styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

    public items: Todolist[] = [];

    public todo : Todolist = new Todolist();
    public todoList: Todolist[] = [];


    constructor(private todoService : TodoService) { }

    ngOnInit(): void {
        this.todoService.fetchTodoList()
            .subscribe((data: Todolist[]) => {
                this.items = [];
                data.forEach(d => {
                    this.items.push(d);
                })
            });

    }

    public addToList() {
        console.log(this.todo.todo);
        if (this.todo.todo == '' || this.todo.todo == undefined) {
        }
        else {
            this.todoService.createTodo(this.todo).subscribe(data =>  {
                console.log(data);
                this.items.push(data);
                this.todo = new Todolist();
            });            
        }
    }

    public deleteTask(todo: Todolist) {
        this.todoService.deleteTodo(todo)
        .subscribe(data =>
            this.ngOnInit()
        );

    }

    public taskCompleted(isDone: boolean,todo: Todolist) {
        todo.taskCompleted = isDone;
        this.todoService.createTodo(todo)
        .subscribe(data =>
            this.ngOnInit()
        );

       // console.log(event);
        console.log(todo);

    }

    

}
