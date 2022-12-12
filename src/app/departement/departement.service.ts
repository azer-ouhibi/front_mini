import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Departement } from 'src/Models/Departement';

@Injectable({
  providedIn: 'root'
})
export class DepartementService {



  constructor(private http:HttpClient,private router:Router) 
  { }
  baseurl=environment.url;
  
  fetchDepartements():Observable<Departement[]>
  {
    return this.http.get<Departement[]>(this.baseurl+"servlet/retrieveAllDepartement");
  }
  fetchDepartementById(id:any):Observable<Departement>
  {
    return this.http.get<Departement>(this.baseurl+"servlet/retrieveDepartement/"+id);
  }
  
  addDepartement(data:Departement)
  {
    return this.http.post(this.baseurl+"servlet/addDepartement",data);
  }
  
  
  deleteDepartement(id:any){
  
    return this.http.delete(this.baseurl+"servlet/deleteDepartement/"+id);
  
  }
  UpdateDepartement(data:Departement):Observable<Departement>
  {
    return this.http.put<Departement>(this.baseurl+"servlet/updateDepartement/",data);
  
  }
  
   
   
  }