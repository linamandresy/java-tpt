import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ActuService {

  constructor(
    private http:HttpClient
  ) { }

  getPaginatedActu(page:number=0){
    return this.http.get(`${environment.url_node}/actu?page=${page}`);
  }

  getActuById(id:string){
    return this.http.get(`${environment.url_node}/actu/${id}`);
  }
}
