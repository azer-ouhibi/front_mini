import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Departement } from 'src/Models/Departement';
import { DepartementService } from '../departement.service';

@Component({
  selector: 'app-get-parent',
  templateUrl: './get-parent.component.html',
  styleUrls: ['./get-parent.component.css']
})
export class GetParentComponent implements OnInit {

  constructor(private service:DepartementService,private router:Router) { }

  ListDepartement !: Departement[];
 
 
  ngOnInit(): void {
    this.GetAllDepartement();
  }
  GetAllDepartement()
  {
    this.service.fetchDepartements().subscribe(
      (t)=>{
        
        this.ListDepartement=t;
      },
      (error)=>{
        console.log(error.status)
      }
    );
  }


  executes(i:any){
    this.service.deleteDepartement(i.id).subscribe(()=>{},(error)=>{console.log(error)});
    this.GetAllDepartement();
  }

}
