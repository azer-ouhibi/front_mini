import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Universite } from 'src/Models/Universite';

@Injectable({
  providedIn: 'root'
})
export class UniversiteService {



  constructor(private http:HttpClient,private router: Router) 
  { }
  baseurl=environment.url;
  
  fetchUniversite():Observable<Universite[]>
  {
    return this.http.get<Universite[]>(this.baseurl+"servlet/retrieveAllUniversite");
  }
  fetchUniversiteById(id:any):Observable<Universite>
  {
    return this.http.get<Universite>(this.baseurl+"servlet/retrieveUniversite/"+id);
  }
  
  addUniversite(data:Universite)
  {
    return this.http.post<Universite>(this.baseurl+"servlet/addUniversite/",data);

  }
  
  
  deleteUniversite(id:any){
  
    return this.http.delete(this.baseurl+"servlet/deleteUniversite/"+id);
  
  }
  UpdatUniversite(data:Universite):Observable<Universite>
  {
    return this.http.put<Universite>(this.baseurl+"servlet/updateUniversite/",data);
  
  }
  
   
   
  }