import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Todolist } from '../model/todolist';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
//      Authorization: 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private http: HttpClient) { }

  url : string = "http://localhost:8080/todo";

  fetchTodoList(): Observable<Todolist[]> {
    return this.http.get<Todolist[]>(this.url);
  }

  createTodo(todo: Todolist): Observable<Todolist> {
    return this.http.post<Todolist>(this.url, todo, httpOptions);
  }

  deleteTodo(todo: Todolist) {
    return this.http.delete(this.url+"/"+todo.id);
  }
  

}
