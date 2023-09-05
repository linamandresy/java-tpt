import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SignalementService {

  constructor(
    private http:HttpClient
  ) { }

  createSignalement(title:string,subtitle:string,description:string,images:Array<string>){
    let data = {
      title:title,
      subtitle:subtitle,
      description:description,
      images:images
    };
    return this.http.post(`${environment.url_node}/signalement`,data);
  }

  getPaginateSignalement(page:number=0){
    return this.http.get(`${environment.url_node}/signalement?page=${page}`);
  }
}
