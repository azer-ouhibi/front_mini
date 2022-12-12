import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Departement } from 'src/Models/Departement';
import { DepartementService } from '../departement.service';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {

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

  Delete(id:number)
  {
    this.service.deleteDepartement(id).subscribe(()=>{},(error)=>{console.log(error)});
    this.GetAllDepartement();
  }
  Update(id:number)
  {
    this.router.navigate(['/departement/DepartementHome/update/',id])
  }

}
